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

@WebServlet("/UpdateCartExecute.action")
public class UpdateCartExecute extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String courseId = request.getParameter("course_id");
        String rdId = request.getParameter("rd_id");
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/yourdb", "user", "password")) {
            CartDao dao = new CartDao(conn);
            dao.updateQuantity(courseId, rdId, quantity);
        } catch (SQLException e) {
            throw new ServletException(e);
        }

        response.sendRedirect("CartList.action");
    }
}