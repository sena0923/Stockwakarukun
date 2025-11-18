package scoremanager.resident;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.ResidentDao;
import bean.Resident;
import tool.Action;

public class NyuDisplayExecuteAction extends Action {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

        // ログイン済み前提なのでセッションからログインIDを取得
        HttpSession session = req.getSession();
        String rd_id = (String) session.getAttribute("rd_id");

        // DAOでその人の情報を取得（IDで検索）
        ResidentDao residentDao = new ResidentDao();
        Resident resident = ResidentDao.get(rd_id);

        // JSPに渡す
        req.setAttribute("resident", resident);

        // 詳細表示用JSPへフォワード
        req.getRequestDispatcher("rtInfoDisplay.jsp").forward(req, res);
    }
}