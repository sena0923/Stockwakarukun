package scoremanager.ECsite;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.GoodsDao;
import bean.Goods;
import tool.Action;

public class AllsinExecuteAction extends Action {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

    	// ★ 親族で、まだ入居者を選んでいない場合
    	if (req.getSession().getAttribute("relatives") != null &&
    	    req.getSession().getAttribute("selectedResident") == null) {

    	    req.getRequestDispatcher("RelativeResidentList.action")
    	       .forward(req, res);
    	    return;
    	}


        GoodsDao goodsDao = new GoodsDao();
        List<Goods> goodsList = goodsDao.getAllGoods(); // 全商品取得

        req.setAttribute("goodsList", goodsList);

        // 商品一覧JSPへフォワード
        req.getRequestDispatcher("../ecSite/EClistsin.jsp")
           .forward(req, res);
    }
}
