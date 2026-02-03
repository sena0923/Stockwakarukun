package scoremanager.ECsite;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Cart;
import tool.Action;

public class ConfirmAction extends Action {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

        HttpSession session = req.getSession();
        List<Cart> cartList = (List<Cart>) session.getAttribute("cartList");

        int totalPrice = 0;
        final int NAIRE_PRICE = 300;

        for (Cart c : cartList) {
            int itemTotal = c.getPrice() * c.getQuantity();

            if (c.getCan_name() == 1) {
                itemTotal += NAIRE_PRICE * c.getQuantity();
            }

            totalPrice += itemTotal;
        }

        req.setAttribute("totalPrice", totalPrice);

        req.setAttribute("totalPrice", totalPrice);

        req.getRequestDispatcher("../ecSite/Confirm.jsp").forward(req, res);
    }
}
