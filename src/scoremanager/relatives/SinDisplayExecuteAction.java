package scoremanager.relatives;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.RelativesDao;
import bean.Relatives;
import tool.Action;

public class SinDisplayExecuteAction extends Action {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

        // ログイン済み前提なのでセッションからログインIDを取得
        HttpSession session = req.getSession();
        String rt_id = (String) session.getAttribute("rt_id");

        // DAOでその人の情報を取得（IDで検索）
        RelativesDao relativesDao = new RelativesDao();
        Relatives relatives = relativesDao.get(rt_id);

        // JSPに渡す
        req.setAttribute("relatives", relatives);

        // 詳細表示用JSPへフォワード
        req.getRequestDispatcher("rtInfoDisplay.jsp").forward(req, res);
    }
}