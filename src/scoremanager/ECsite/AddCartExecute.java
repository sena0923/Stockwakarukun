package scoremanager.ECsite;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.CartDao;
import bean.Cart;

@WebServlet("/AddCartExecute.action")
public class AddCartExecute extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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
            throw new ServletException(e);
        }

        // カート一覧ページへリダイレクト
        response.sendRedirect("CartList.action");
    }
}