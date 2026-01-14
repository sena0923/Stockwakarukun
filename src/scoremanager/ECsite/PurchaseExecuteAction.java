import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.GoodsDao;
import bean.Cart;
import bean.Goods;
import tool.Action;

public class PurchaseExecuteAction extends Action {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

        HttpSession session = req.getSession();
        List<Cart> cartList = (List<Cart>) session.getAttribute("cartList");

        if (cartList == null || cartList.isEmpty()) {
            req.setAttribute("error", "カートが空です");
            req.getRequestDispatcher("ECcart.jsp").forward(req, res);
            return;
        }

        GoodsDao goodsDao = new GoodsDao();

        // ★ 在庫チェック（最終確認）
        for (Cart c : cartList) {
            Goods goods = goodsDao.get(c.getGoods_id());

            if (c.getQuantity() > goods.getStock()) {
                req.setAttribute("error", goods.getGoods_name() + " の在庫が不足しています");
                req.getRequestDispatcher("ECcart.jsp").forward(req, res);
                return;
            }
        }

        // ★ 在庫を減らす
        for (Cart c : cartList) {
            goodsDao.updateStock(c.getGoods_id(), c.getQuantity());
        }


        // ★ カートを空にする
        session.removeAttribute("cartList");

        // 完了画面へ
        req.getRequestDispatcher("Complete.jsp").forward(req, res);
    }
}