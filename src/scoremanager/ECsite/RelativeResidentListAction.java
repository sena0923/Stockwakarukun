package scoremanager.ECsite;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.RelativeResidentDao;
import bean.Relatives;
import bean.Resident;
import tool.Action;

public class RelativeResidentListAction extends Action {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

        // 親族情報を取得（ログイン時に session に入っている）
        Relatives relatives = (Relatives) req.getSession().getAttribute("relatives");

        // 念のためチェック
        if (relatives == null) {
            req.setAttribute("error", "親族としてログインしてください");
            req.getRequestDispatcher("../login/rtLogin.jsp").forward(req, res);
            return;
        }

        String relativeId = relatives.getRt_id();

        // 親族に紐づく入居者一覧を取得
        RelativeResidentDao dao = new RelativeResidentDao();
        List<Resident> residentList = dao.findByRelativeId(relativeId);

        // JSP に渡す
        req.setAttribute("residentList", residentList);

        // 入居者選択画面へ
        req.getRequestDispatcher("../ecSite/selectResident.jsp").forward(req, res);
    }
}