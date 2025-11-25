package scoremanager.ECsite;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.GoodsDao;
import bean.Goods;
import tool.Action;

public class AllExecuteAction extends Action {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
    	System.out.println("AllExecuteAction開始");  // デバッグ用
        GoodsDao goodsDao = new GoodsDao();
        List<Goods> goodsList = goodsDao.getAllGoods();  // 全件取得

        System.out.println("取得件数: " + goodsList.size());

        req.setAttribute("goodsList", goodsList);  // JSPに渡す

        req.getRequestDispatcher("../ecSite/EClist.jsp").forward(req, res);
    }
}