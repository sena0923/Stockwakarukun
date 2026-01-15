package scoremanager.ECsite;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Cart;
import tool.Action;

public class SetNameAction extends Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

	    HttpSession session = request.getSession();
	    List<Cart> cartList = (List<Cart>) session.getAttribute("cartList");

	    String goodsId = request.getParameter("goods_id");


	    for (Cart item : cartList) {
	        if (item.getGoods_id().equals(goodsId)) {
	            break;
	        }
	    }

	    session.setAttribute("cartList", cartList);

	    request.getRequestDispatcher("ECcart.jsp").forward(request, response);
	}
}