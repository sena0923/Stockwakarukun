package scoremanager.relatives;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.RelativesDao;
import bean.Relatives;
import tool.Action;

public class SinInformationChangeExecuteAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		HttpSession session = req.getSession(false);

        String rt_id = (String) session.getAttribute("rt_id");

        // フォームから送信された値を取得（e-mail と password のみ）
        String e_mail = req.getParameter("e_mail");
        String password = req.getParameter("password");

        // Beanに詰める
        Relatives relatives = new Relatives();
        relatives.setRt_id(rt_id);
		relatives.setE_mail(e_mail);
        relatives.setPassword(password);

        // DAOで更新
        RelativesDao relativesDao = new RelativesDao();
        boolean updated = relativesDao.save(relatives);

        if (updated) {
            // 更新成功 → 詳細表示へ
            req.setAttribute("relatives", relatives);
            req.setAttribute("message", "情報を変更しました。");
            req.getRequestDispatcher("rtInfoChangeComplete.jsp").forward(req, res);
        } else {
            // 更新失敗 → エラーページへ
            req.setAttribute("error", "変更に失敗しました。");
            req.getRequestDispatcher("rtInfoChange.jsp").forward(req, res);
        }
    }
}


