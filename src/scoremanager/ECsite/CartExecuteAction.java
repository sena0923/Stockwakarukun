package scoremanager.ECsite;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.GoodsDao;
import bean.Goods;
import tool.Action;

public class CartExecuteAction extends Action {

	 @Override
	    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
	        String goodsId = req.getParameter("goods_id");

	        GoodsDao dao = new GoodsDao();
	        Goods goods = dao.get(goodsId);

	        HttpSession session = req.getSession();
	        List<Goods> cart = (List<Goods>) session.getAttribute("cart");
	        if (cart == null) {
	            cart = new ArrayList<>();
	        }
	        cart.add(goods);
	        session.setAttribute("cart", cart);

	        // 一覧画面に戻る（AllExecuteActionを呼び出す）
	        res.sendRedirect("allExecute?msg=added");
	    }
	}


