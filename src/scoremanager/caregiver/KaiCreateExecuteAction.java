package scoremanager.caregiver;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.CaregiverDao;
import bean.Caregiver;
import tool.Action;

public class KaiCreateExecuteAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		// ローカル変数の指定
		HttpSession session = req.getSession(); // セッション
		Caregiver caregiver = (Caregiver)session.getAttribute("user");
		String ca_pw = "";
		String ca_name = "";
		String ca_id = "";
		String facility_pw = "";
		String isAdminStr = "";
		boolean isAdmin = false;
		Caregiver createCaregiver = new Caregiver();
		CaregiverDao caregiverDao = new CaregiverDao();
		Map<String, String> errors = new HashMap<>(); // エラーメッセージ

		//リクエストパラメーターの取得
		ca_pw = req.getParameter("pw");
		ca_name = req.getParameter("name");
		ca_id = req.getParameter("id");
		isAdminStr = req.getParameter("is_admin");

		if (isAdminStr != null) {
			isAdmin = true;
		}

		if (facility_pw == "01"){
			//介護士の新規登録ができる様になる
		}else{
			//施設パスワードが違うため，介護士の新規登録はできない
		}

		if (caregiverDao.get(ca_id)!= null) { // 教師が重複している場合
			errors.put("1", "職員番号が重複しています");
			// リクエストにエラーメッセージをセット
			req.setAttribute("errors", errors);
		} else {
			// subjectに科目情報をセット
			createCaregiver.setStaffid(ca_id);
			createCaregiver.setName(ca_name);
			createCaregiver.setPassword(ca_pw);
			createCaregiver.setAdmin(isAdmin);
			createCaregiver.setSchool(caregiver.getSchool());
			// saveメソッドで情報を登録
			caregiverDao.save(createCaregiver);
		}

		//リクエストに値をセット
		req.setAttribute("pw", ca_pw);
		req.setAttribute("name", ca_name);
		req.setAttribute("id", ca_id);
		req.setAttribute("is_admin", isAdmin);

		// JSPへフォワード
		if (errors.isEmpty()) { // エラーメッセージがない場合
			// 登録完了画面にフォワード
			req.getRequestDispatcher("Kai_menu.jsp").forward(req, res);
		} else { // エラーメッセージがある場合
			// 登録画面にフォワード
			req.getRequestDispatcher("書き直しする→TeacherCreate.action").forward(req, res);
		}
	}

}
