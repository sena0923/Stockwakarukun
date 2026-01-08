package scoremanager.ECsite;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.CartDao;
import bean.Cart;

@WebServlet("/CartList.action")
public class CartListExecuteAction extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // セッションからユーザーID（rd_id）を取得
        String rdId = (String) request.getSession().getAttribute("rd_id");


        try (Connection conn = DriverManager.getConnection(
                "jdbc:h2:~/ecdb", "sa", "")) {

            CartDao dao = new CartDao(conn);

            List<Cart> cartList = dao.getCartList(rdId);
            int totalPrice = dao.getTotalPrice(rdId);

            request.setAttribute("cartList", cartList);
            request.setAttribute("totalPrice", totalPrice);

            request.getRequestDispatcher("../ECsite/cart.jsp").forward(request, response);

        } catch (SQLException e) {
            throw new ServletException(e);
        }

    }
}