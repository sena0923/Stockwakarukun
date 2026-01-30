package scoremanager.ECsite;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.CartDao;
import bean.Cart;
import bean.Resident;
import tool.Action;

public class ConfirmAction extends Action {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {


        HttpSession session = req.getSession();
        List<Cart> cartList = (List<Cart>) session.getAttribute("cartList");

        Resident r = (Resident) req.getSession().getAttribute("resident");


        if (cartList == null || cartList.isEmpty()) {
            req.setAttribute("error", "カートが空です");
            req.getRequestDispatcher("ECcart.jsp").forward(req, res);

            return;

        }

        CartDao cartdao = new CartDao();
        for(Cart c:cartList) {

            cartdao.removeItem(c.getGoods_id(), r.getRd_id());


        }

        session.setAttribute("cartList", cartList);

        req.getRequestDispatcher("../ecSite/Confirm.jsp").forward(req, res);
    }
}