package scoremanager.ECsite;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Cart;
import tool.Action;

public class ConfirmAction extends Action {

    /*private static final int NAIRE_PRICE = 300;*/

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

        HttpSession session = req.getSession();
        List<Cart> cartList = (List<Cart>) session.getAttribute("cartList");

        if (cartList == null || cartList.isEmpty()) {
            req.setAttribute("error", "カートが空です");
            req.getRequestDispatcher("ECcart.jsp").forward(req, res);
            return;
        }

        int totalPrice = 0;

        for (Cart c : cartList) {
            int itemTotal = c.getPrice() * c.getQuantity();

            // ★ 名入れ加算
            /*if (c.getCan_name() == 1) {
                itemTotal += NAIRE_PRICE * c.getQuantity();
            }*/

            totalPrice += itemTotal;
        }

        req.setAttribute("totalPrice", totalPrice);
        req.getRequestDispatcher("../ecSite/Confirm.jsp").forward(req, res);
    }
}
