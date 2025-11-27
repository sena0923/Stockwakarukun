package scoremanager.ECsite;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Cart;
import tool.Action;

public class UpdateCartExecuteAction extends Action {

	@Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String goodsId = req.getParameter("goods_id");
        int quantity = Integer.parseInt(req.getParameter("quantity"));

        HttpSession session = req.getSession();
        List<Cart> cartList = (List<Cart>) session.getAttribute("cartList");

        if (cartList != null) {
            for (Cart c : cartList) {
                if (c.getGoods_id().equals(goodsId)) {
                    c.setQuantity(quantity);
                    break;
                }
            }
        }

        // 合計金額再計算して JSP へ
        int totalPrice = 0;
        for (Cart c : cartList) {
            totalPrice += c.getPrice() * c.getQuantity();
        }
        req.setAttribute("cartList", cartList);
        req.setAttribute("totalPrice", totalPrice);
        req.getRequestDispatcher("../ecSite/cart.jsp").forward(req, res);
    }
}


