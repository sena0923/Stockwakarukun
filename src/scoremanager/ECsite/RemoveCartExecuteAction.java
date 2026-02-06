package scoremanager.ECsite;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.CartDao;
import bean.Cart;
import bean.Resident;
import tool.Action;

public class RemoveCartExecuteAction extends Action {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

        String goodsId = req.getParameter("goods_id");

        HttpSession session = req.getSession();
        Resident r = (Resident) req.getSession().getAttribute("selectedResident");
        List<Cart> cartList = (List<Cart>) session.getAttribute("cartList");

        if (cartList != null) {
            cartList.removeIf(c -> c.getGoods_id().equals(goodsId));
            CartDao cartdao = new CartDao();
            cartdao.removeItem(goodsId, r.getRd_id());
        }

        session.setAttribute("cartList", cartList);

        // カート画面へ戻る
        res.sendRedirect(req.getContextPath() + "/scoremanager/ECsite/CartExecute.action");
    }
}