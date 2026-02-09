package scoremanager.ECsite;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.GoodsDao;
import bean.Goods;
import tool.Action;

public class WashExecuteAction extends Action {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        GoodsDao goodsDao = new GoodsDao();

        List<Goods> goodsList = goodsDao.getGoodsByCategory("001");

        /* debug print */
        System.out.println("---------------------");
        System.out.println("WashinExcecuteAction");
        for(Goods g: goodsList) {
        	System.out.println("Category_id" + g.getCategory_id());
        	System.out.println("Goods_id" + g.getGoods_id());
        	System.out.println("Goods_name" + g.getGoods_name());
        }
        System.out.println("---------------------");

        req.setAttribute("goodsList", goodsList);
        req.getRequestDispatcher("../ecSite/EClist.jsp")
        	.forward(req, res);
    }
}