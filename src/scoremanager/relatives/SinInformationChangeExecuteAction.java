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

		HttpSession session = req.getSession();
        Relatives relatives = (Relatives) session.getAttribute("relatives");
        String rt_id = relatives.getRt_id();

        String e_mail = req.getParameter("e_mail");
        String password = req.getParameter("password");
        String passwordConfirm = req.getParameter("passwordConfirm");

        if (password == null || !password.equals(passwordConfirm)) {
            req.setAttribute("message", "パスワードが一致しません。");
            req.getRequestDispatcher("rtInfoChange.jsp").forward(req, res);
            return;
        }



        // デバッグ出力
        System.out.println("debug:rt_id > " + rt_id);
        System.out.println("debug:e_mail > " + e_mail);
        System.out.println("debug:password > " + password);
        System.out.println("debug:passwordConfirm > " + passwordConfirm);

        RelativesDao relativesDao = new RelativesDao();

        if (relatives != null) {
            // パスワード更新
        	relatives.setE_mail(e_mail);
            relatives.setPassword(password);

			// DB保存
            relativesDao.save(relatives);

            req.setAttribute("message", "情報を更新しました。");
        } else {
            req.setAttribute("message", "対象の入居者が見つかりません。");
        }

        req.setAttribute("relatives", relatives);
        req.getRequestDispatcher("rtInfoChangeComplete.jsp").forward(req, res);
    }
}


