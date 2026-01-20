package scoremanager.ECsite;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.GoodsDao;
import bean.Goods;
import bean.Resident;
import tool.Action;

public class AllExecuteAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

	    // ★ 入居者本人なら自動で selectedResident をセット
	    Resident r = (Resident) req.getSession().getAttribute("resident");
	    if (r != null) {
	        req.getSession().setAttribute("selectedResident", r);
	    }

	    // ここから先は商品一覧表示（入居者 or 親族どちらでもOK）
	    GoodsDao goodsDao = new GoodsDao();
	    List<Goods> goodsList = goodsDao.getAllGoods();

	    req.setAttribute("goodsList", goodsList);

	    req.getRequestDispatcher("../ecSite/EClist.jsp")
	       .forward(req, res);
	}
}