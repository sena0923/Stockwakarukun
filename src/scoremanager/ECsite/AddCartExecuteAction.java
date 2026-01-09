package scoremanager.ECsite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.CartDao;
import bean.Cart;
import tool.Action;

public class AddCartExecuteAction extends Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        // パラメータ取得
        String courseId = request.getParameter("course_id");
        String rdId = request.getParameter("rd_id");
        String goodsId = request.getParameter("goods_id");
        String goodsName = request.getParameter("goods_name");
        int price = Integer.parseInt(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        // Cartオブジェクトに詰める
        Cart cart = new Cart();
        cart.setCourse_id(courseId);
        cart.setRd_id(rdId);
        cart.setGoods_id(goodsId);
        cart.setGoods_name(goodsName);
        cart.setPrice(price);
        cart.setQuantity(quantity);

        // DB接続とDAO呼び出し
        try (Connection conn = DriverManager.getConnection(
                "jdbc:h2:~/ecdb", "sa", "")) {

            CartDao dao = new CartDao(conn);
            dao.addItem(cart);

        } catch (SQLException e) {
            throw new Exception(e);
        }

        // リダイレクト
        response.sendRedirect("CartListExecute.action");
    }
}