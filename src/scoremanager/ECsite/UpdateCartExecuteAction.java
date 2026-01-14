package scoremanager.ECsite;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.GoodsDao;
import bean.Cart;
import bean.Goods;
import tool.Action;

public class UpdateCartExecuteAction extends Action {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

        String goodsId = req.getParameter("goods_id");
        int quantity = Integer.parseInt(req.getParameter("quantity"));

        HttpSession session = req.getSession();
        List<Cart> cartList = (List<Cart>) session.getAttribute("cartList");

        // ★ 在庫チェックのために商品情報を取得
        GoodsDao goodsDao = new GoodsDao();
        Goods goods = goodsDao.get(goodsId);

        // ★ 在庫超過チェック
        if (quantity > goods.getStock()) {
            req.setAttribute("error", "在庫数を超えています（在庫: " + goods.getStock() + "）");
            req.getRequestDispatcher("/scoremanager/ECsite/CartExecute.action").forward(req, res);
            return;
        }

        // ★ 在庫OKなら数量更新
        if (cartList != null) {
            for (Cart c : cartList) {
                if (c.getGoods_id().equals(goodsId)) {
                    c.setQuantity(quantity);
                    break;
                }
            }
        }

        session.setAttribute("cartList", cartList);

        res.sendRedirect(req.getContextPath() + "/scoremanager/ECsite/CartExecute.action");
    }
}