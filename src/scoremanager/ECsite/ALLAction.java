package scoremanager.ECsite;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.GoodsDao;
import bean.Goods;
import bean.Resident;
import tool.Action;

public class ALLAction extends Action {

	@Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

        HttpSession session = req.getSession();
        Resident resident = (Resident) session.getAttribute("rd_id");

        // 商品一覧を取得
        GoodsDao goodsDao = new GoodsDao();
        List<Goods> goodsList = goodsDao.getAllGoods();

        // デバッグ出力
        System.out.println("取得件数: " + goodsList.size());

        // JSPに渡す
        req.setAttribute("goodsList", goodsList);

        // 商品一覧表示用JSPへフォワード
        req.getRequestDispatcher("EClist.jsp").forward(req, res);
    }
}

