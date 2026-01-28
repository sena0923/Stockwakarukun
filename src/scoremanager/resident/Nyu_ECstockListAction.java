package scoremanager.resident;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.GoodsDao;
import Dao.ResidentDao;
import Dao.UserStockDao;
import bean.Goods;
import bean.Resident;
import bean.UserStock;
import tool.Action;

public class Nyu_ECstockListAction extends Action {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

        // rd_id を取得
        String rd_id = req.getParameter("rd_id");

        // 入居者情報取得
        ResidentDao residentDao = new ResidentDao();
        Resident resident = residentDao.get(rd_id);

        // ECストック取得
        UserStockDao stockDao = new UserStockDao();
        List<UserStock> list = stockDao.get(rd_id);

        // 商品名をセット
        GoodsDao goodsDao = new GoodsDao();
        for (UserStock us : list) {
            Goods goods = goodsDao.get(us.getGoods_id());
            us.setGoods(goods);
        }

        // JSP に渡す
        req.setAttribute("rd_id", rd_id);
        req.setAttribute("resident", resident);
        req.setAttribute("iiList", list);  // JSP 側は iiList を参照している

        // ECストック表示 JSP へ
        req.getRequestDispatcher("rd_stockList_ec.jsp").forward(req, res);
    }
}