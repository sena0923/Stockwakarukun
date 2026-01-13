package scoremanager.ECsite;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.CartDao;
import bean.Cart;
import tool.Action;

public class CartListExecuteAction extends Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String rdId = (String) request.getSession().getAttribute("rd_id");

        CartDao dao = new CartDao();
        List<Cart> cartList = dao.getCartList(rdId);
        int totalPrice = dao.getTotalPrice(rdId);

        request.setAttribute("cartList", cartList);
        request.setAttribute("totalPrice", totalPrice);

        request.getRequestDispatcher("../ecSite/EClist.jsp").forward(request, response);
    }
}