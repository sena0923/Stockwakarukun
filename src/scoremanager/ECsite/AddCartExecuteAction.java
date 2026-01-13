package scoremanager.ECsite;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.CartDao;
import bean.Cart;
import bean.Resident;
import tool.Action;

public class AddCartExecuteAction extends Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    	// セッション取得
        HttpSession session = request.getSession(false);

    	// セッションから resident を取得
        Resident resident = (Resident) session.getAttribute("resident");

        if (resident == null || !resident.isAuthenticated()) {
            response.sendRedirect("rdLogin.jsp");
            return;
        }

        // ★ セッションからログインIDを取得（ここが重要）
        String rdID = resident.getRd_id();

        // パラメータ取得
        String courseId = request.getParameter("course_id");
        String goodsId = request.getParameter("goods_id");
        String goodsName = request.getParameter("goods_name");
        int price = Integer.parseInt(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        // Cartオブジェクトに詰める
        Cart cart = new Cart();
        cart.setCourse_id(courseId);
        cart.setRd_id(rdID);  // ← ★ここがセッションからのID
        cart.setGoods_id(goodsId);
        cart.setGoods_name(goodsName);
        cart.setPrice(price);
        cart.setQuantity(quantity);


        CartDao dao = new CartDao();
        dao.addItem(cart);

        // リダイレクト
        response.sendRedirect("CartListExecute.action");
    }
}