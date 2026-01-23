package scoremanager.resident;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.ResidentDao;
import bean.Resident;
import tool.Action;

public class NyuChangeExecuteAction extends Action {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

        HttpSession session = req.getSession();
        Resident resident = (Resident) session.getAttribute("resident");
        String rd_id = resident.getRd_id();

        String course_id = req.getParameter("course");
        String password = req.getParameter("password");
        String passwordConfirm = req.getParameter("passwordConfirm");
		Map<String, String> errors = new HashMap<>(); // エラーメッセージ

		ResidentDao residentDao = new ResidentDao();


        int course_idInt = Integer.parseInt(course_id);

		if (!password.equals(passwordConfirm)) {
			errors.put("1", "パスワードが一致しません");
		} else {
			// 入居者beanに情報をセット
			resident.setPassword(password);;
			resident.setCourse_id(course_idInt);
			// saveメソッドで情報を登録
			residentDao.save(resident);
		}

		// JSPへフォワード
		if (errors.isEmpty()) { // エラーメッセージがない場合
			// 登録完了画面にフォワード
			req.getRequestDispatcher("NyuChange.action").forward(req, res);
		} else { // エラーメッセージがある場合
			req.setAttribute("errors", errors);
			// 登録画面にフォワード
			req.getRequestDispatcher("rdInfoChange.jsp").forward(req, res);
		}
    }
}