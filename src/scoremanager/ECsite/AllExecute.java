package scoremanager.ECsite;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.GoodsDao;
import bean.Goods;
import tool.Action;

public class AllExecute extends Action {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

        GoodsDao goodsDao = new GoodsDao();
        List<Goods> goodsList = goodsDao.getAllGoods(); // 全商品取得

        req.setAttribute("goodsList", goodsList);

        // 商品一覧JSPへフォワード
        req.getRequestDispatcher("../ecSite/EClist.jsp")
           .forward(req, res);
    }
}
