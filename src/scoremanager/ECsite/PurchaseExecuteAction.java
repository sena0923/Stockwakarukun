package scoremanager.ECsite;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.CartDao;
import Dao.GoodsDao;
import Dao.PurchaseDao;
import Dao.PurchaseDetailDao;
import Dao.UserStockDao;
import bean.Cart;
import bean.Goods;
import bean.Resident;
import bean.UserStock;
import tool.Action;

public class PurchaseExecuteAction extends Action {

    private static final int NAIRE_PRICE = 300; // ★ 名入れ料金

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

        HttpSession session = req.getSession();
        List<Cart> cartList = (List<Cart>) session.getAttribute("cartList");

        GoodsDao goodsDao = new GoodsDao();
        PurchaseDao purchaseDao = new PurchaseDao();
        PurchaseDetailDao detailDao = new PurchaseDetailDao();
        UserStockDao stockDao = new UserStockDao();
        CartDao cartDao = new CartDao();

        // 購入対象の入居者
        Resident selected = (Resident) session.getAttribute("selectedResident");

        if (selected == null) {
            req.setAttribute("error", "購入対象の入居者が選択されていません");
            req.getRequestDispatcher("../ecSite/selectResident.jsp").forward(req, res);
            return;
        }

        String buyerId = selected.getRd_id();

        // 在庫チェック
        for (Cart c : cartList) {
            Goods goods = goodsDao.get(c.getGoods_id());
            if (c.getQuantity() > goods.getStock()) {
                req.setAttribute("error", goods.getGoods_name() + " の在庫が不足しています");
                req.getRequestDispatcher("ECcart.jsp").forward(req, res);
                return;
            }
        }

        // ★ 合計金額（名入れ・数量込み）
        int totalPrice = 0;
        for (Cart c : cartList) {

            int itemTotal = c.getPrice() * c.getQuantity();

            // ★ 名入れあり
            if (c.getCan_name() == 1) {
                itemTotal += NAIRE_PRICE * c.getQuantity();
            }

            totalPrice += itemTotal;
        }

        // 購入情報保存
        int purchaseId = purchaseDao.insert(buyerId, totalPrice);

        // 購入詳細保存
        for (Cart c : cartList) {
            detailDao.insert(purchaseId, c);
        }

        // 在庫更新
        for (Cart c : cartList) {
            goodsDao.updateStock(c.getGoods_id(), c.getQuantity());
        }

        // 入居者ストック更新
        for (Cart c : cartList) {
            UserStock stock = stockDao.find(buyerId, c.getGoods_id());

            if (stock == null) {
                stockDao.insert(buyerId, c.getGoods_id(), c.getQuantity());
            } else {
                int newCount = stock.getQuantity() + c.getQuantity();
                stockDao.update(buyerId, c.getGoods_id(), newCount);
            }
        }

        // ★ DBカート削除
        for (Cart c : cartList) {
            cartDao.removeItem(c.getGoods_id(), buyerId);
        }

        // sessionカート削除
        session.removeAttribute("cartList");

        // 完了画面
        req.getRequestDispatcher("../ecSite/Complete.jsp").forward(req, res);
    }
}
