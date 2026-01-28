package scoremanager.ECsite;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Cart;
import tool.Action;

public class CartExecuteAction extends Action {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

        HttpSession session = req.getSession();
        List<Cart> cartList = (List<Cart>) session.getAttribute("cartList");

        /*
         * debug
         */
        System.out.println("-----------------------------------------");
        System.out.println("debug-CartExecuteAction-cartList:");
        for(Cart c: cartList) {
        	System.out.println("  goods-id:" + c.getGoods_id());
        	System.out.println("  naireFlg:" + c.isNaireFlg());
        }
        System.out.println("-----------------------------------------");

        if (cartList == null) {
            cartList = new ArrayList<>();
        }

        // 合計金額計算
        int totalPrice = 0;
        for (Cart c : cartList) {
            totalPrice += c.getPrice() * c.getQuantity();
        }

        req.setAttribute("cartList", cartList);
        req.setAttribute("totalPrice", totalPrice);

        req.getRequestDispatcher("/scoremanager/ecSite/ECcart.jsp").forward(req, res);
    }
}