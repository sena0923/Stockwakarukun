package scoremanager.ECsite;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.CartDao;
import Dao.GoodsDao;
import bean.Cart;
import bean.Goods;
import tool.Action;

public class CartExecuteAction extends Action {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        // DBコネクションの取得（環境に合わせて書き換え）
        Connection conn = (Connection) req.getServletContext().getAttribute("conn");
        CartDao cartDao = new CartDao(conn);
        GoodsDao goodsDao = new GoodsDao();

        String action = req.getParameter("action");   // "add", "update", "remove"
        String rdId   = req.getParameter("rd_id");    // 入居者ID（ユーザー識別用）
        String goodsId = req.getParameter("goods_id");

        if ("add".equals(action)) {
            int quantity = Integer.parseInt(req.getParameter("quantity"));
            Goods goods = goodsDao.getGoodsById(goodsId);

            Cart cart = new Cart();
            cart.setCourse_id(goodsId);   // 本来はcart_idなど専用キーが望ましい
            cart.setRd_id(rdId);
            cart.setGoods_id(goodsId);
            cart.setQuantity(quantity);
            cart.setPrice(goods.getPrice());

            cartDao.addItem(cart);

        } else if ("update".equals(action)) {
            int quantity = Integer.parseInt(req.getParameter("quantity"));
            String courseId = req.getParameter("course_id");
            cartDao.updateQuantity(courseId, quantity);

        } else if ("remove".equals(action)) {
            String courseId = req.getParameter("course_id");
            cartDao.removeItem(courseId);
        }

        // カート一覧と合計金額を再取得
        List<Cart> cartList = cartDao.getCartList(rdId);
        int totalPrice = cartDao.getTotalPrice(rdId);

        req.setAttribute("cartList", cartList);
        req.setAttribute("totalPrice", totalPrice);

        // カート画面へフォワード
        req.getRequestDispatcher("../ecSite/cart.jsp").forward(req, res);
    }
}