package scoremanager.resident;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.UserStockDao;
import tool.Action;

public class Nyu_ECstockUpdateAction extends Action {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

        req.setCharacterEncoding("UTF-8");

        String rd_id = req.getParameter("rd_id");
        UserStockDao stockDao = new UserStockDao();

        Enumeration<String> names = req.getParameterNames();

        while (names.hasMoreElements()) {
            String name = names.nextElement();

            if (name.startsWith("count_")) {

                String goodsId = name.substring(6);
                int newCount = Integer.parseInt(req.getParameter(name));

                // ★ 0 でも更新する
                stockDao.update(rd_id, goodsId, newCount);
            }
        }

        res.sendRedirect("Nyu_ECstockList.action?rd_id=" + rd_id);
    }
}