package scoremanager.ECsite;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.GoodsDao;
import bean.Goods;
import tool.Action;

public class ClotsinExecuteAction extends Action {

	@Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        GoodsDao goodsDao = new GoodsDao();

        // 洗濯カテゴリのIDを指定
        List<Goods> goodsList = goodsDao.getGoodsByCategory("003");

        req.setAttribute("goodsList", goodsList);
        req.getRequestDispatcher("../ecSite/EClistsin.jsp").forward(req, res);
    }
}