package scoremanager.ECsite;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Cart;
import tool.Action;

public class SetNameAction extends Action {

    private static final int NAIRE_PRICE = 300;

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

        HttpSession session = req.getSession();
        List<Cart> cartList = (List<Cart>) session.getAttribute("cartList");

        String goodsId = req.getParameter("goods_id");
        boolean canName = req.getParameter("can_name") != null;

        for (Cart c : cartList) {
            if (c.getGoods_id().equals(goodsId)) {

                // 名入れON
                if (canName && c.getCan_name() == 0) {
                    c.setPrice(c.getPrice() + NAIRE_PRICE);
                    c.setCan_name(1);
                }

                // 名入れOFF
                if (!canName && c.getCan_name() == 1) {
                    c.setPrice(c.getPrice() - NAIRE_PRICE);
                    c.setCan_name(0);
                }
                break;
            }
        }

        session.setAttribute("cartList", cartList);
        res.sendRedirect(req.getContextPath() + "/scoremanager/ECsite/CartExecute.action");
    }
}
