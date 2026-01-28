package scoremanager.ECsite;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

        HttpSession session = req.getSession();
        List<Cart> cartList = (List<Cart>) session.getAttribute("cartList");

        GoodsDao goodsDao = new GoodsDao();
        PurchaseDao purchaseDao = new PurchaseDao();
        PurchaseDetailDao detailDao = new PurchaseDetailDao();
        UserStockDao stockDao = new UserStockDao();

        // 購入対象の入居者
        Resident selected = (Resident) session.getAttribute("selectedResident");

        if (selected == null) {
            req.setAttribute("error", "購入対象の入居者が選択されていません");
            req.getRequestDispatcher("../ecSite/selectResident.jsp").forward(req, res);
            return;
        }

        // 入居者ID
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

        // 合計金額
        int totalPrice = 0;
        for (Cart c : cartList) {
            totalPrice += c.getPrice() * c.getQuantity();
        }

        // 購入情報を保存
        int purchaseId = purchaseDao.insert(buyerId, totalPrice);

        // 購入詳細を保存
        for (Cart c : cartList) {
            detailDao.insert(purchaseId, c);
        }

        // 全体在庫を減らす
        for (Cart c : cartList) {
            goodsDao.updateStock(c.getGoods_id(), c.getQuantity());
        }

        // ★ 入居者ストック（user_stock）に反映

        for (Cart c : cartList) {

            UserStock stock = stockDao.find(buyerId, c.getGoods_id());

            if (stock == null) {
                stockDao.insert(buyerId, c.getGoods_id(), c.getQuantity());
            } else {
                int newCount = stock.getQuantity() + c.getQuantity();
                stockDao.update(buyerId, c.getGoods_id(), newCount);
            }
        }


        // カート削除
        session.removeAttribute("cartList");

        // 完了画面へ
        req.getRequestDispatcher("../ecSite/Complete.jsp").forward(req, res);
    }
}