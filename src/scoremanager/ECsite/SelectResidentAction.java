package scoremanager.ECsite;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ResidentDao;
import bean.Resident;
import tool.Action;

public class SelectResidentAction extends Action {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

        // 親族が選んだ入居者IDを取得
        String rd_id = req.getParameter("rd_id");

        // 入居者情報を取得
        ResidentDao residentDao = new ResidentDao();
        Resident selected = residentDao.get(rd_id);

        // セッションに購入対象の入居者として保存
        req.getSession().setAttribute("selectedResident", selected);

        // ECサイトの商品一覧へ戻る
        res.sendRedirect("AllExecute.action");
    }
}