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
		String ca_pw2 = "";
		String ca_name = "";
		String ca_id = "";
		String facility_pw = "";
		Caregiver createCaregiver = new Caregiver();
		CaregiverDao caregiverDao = new CaregiverDao();
		Map<String, String> errors = new HashMap<>(); // エラーメッセージ

		//リクエストパラメーターの取得
		ca_pw = req.getParameter("pw");
		ca_pw2 = req.getParameter("pw_2");
		ca_name = req.getParameter("name");
		ca_id = req.getParameter("id");
		facility_pw = req.getParameter("facility_id");



		if ("01".equals(facility_pw)){
			//介護士の新規登録ができる様になる


			if (caregiverDao.get(ca_id)!= null) { // 職員番号が重複している場合
				errors.put("1", "職員番号が重複しています");
				// リクエストにエラーメッセージをセット
				System.out.println(errors.values());

			}else if (!ca_pw.equals(req.getParameter("pw_2"))) {
				errors.put("2", "パスワードが一致しません");

			} else {
				// 介護士beanに科目情報をセット
				createCaregiver.setStaffid(ca_id);
				createCaregiver.setName(ca_name);
				createCaregiver.setPassword(ca_pw);
				// saveメソッドで情報を登録
				caregiverDao.save(createCaregiver);
			}

			System.out.println(errors.values());
			//リクエストに値をセット
			req.setAttribute("pw", ca_pw);
			req.setAttribute("name", ca_name);
			req.setAttribute("id", ca_id);
			req.setAttribute("errors", errors);


			// JSPへフォワード
			if (errors.isEmpty()) { // エラーメッセージがない場合

				// 登録完了画面にフォワード
				req.getRequestDispatcher("KaiLogin.action").forward(req, res);
			} else { // エラーメッセージがある場合
				req.setAttribute("errors", errors);
				// 登録画面にフォワード
				req.getRequestDispatcher("KaiCreate.action").forward(req, res);
			}
		}else{
			//施設パスワードが違うため，介護士の新規登録はできない
			errors.put("3", "施設パスワードが一致しません");
			// 登録画面にフォワード
			req.setAttribute("errors", errors);
			req.getRequestDispatcher("KaiCreate.action").forward(req, res);
		}
	}

}
