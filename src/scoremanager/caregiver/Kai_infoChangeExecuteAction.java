package scoremanager.caregiver;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.CaregiverDao;
import bean.Caregiver;
import tool.Action;

public class Kai_infoChangeExecuteAction extends Action {


	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		// ローカル変数の指定
		String cg_pw = "";
		String cg_pw2 = "";
		String cg_name = "";
		String cg_id = "";
		Caregiver caregiver = new Caregiver();
		CaregiverDao cgDao = new CaregiverDao();
		Map<String, String> errors = new HashMap<>(); // エラーメッセージ

		//リクエストパラメーターの取得
		cg_id = req.getParameter("cg_id");
		cg_pw = req.getParameter("pw");
		cg_pw2 = req.getParameter("pw_2");
		cg_name = req.getParameter("name");

		caregiver = cgDao.get(cg_id);


		if (!cg_pw.equals(req.getParameter("pw_2"))) {
				errors.put("1", "パスワードが一致しません");

		} else {
			// 介護士beanに科目情報をセット
			caregiver.setStaffid(cg_id);
			caregiver.setName(cg_name);
			caregiver.setPassword(cg_pw);
			// saveメソッドで情報を登録
			cgDao.save(caregiver);
		}


		// JSPへフォワード
		if (errors.isEmpty()) { // エラーメッセージがない場合
			caregiver = cgDao.get(cg_id);
			req.setAttribute("caregiver", caregiver);

			// 登録完了画面にフォワード
			req.getRequestDispatcher("Kai_account.action").forward(req, res);
		} else { // エラーメッセージがある場合
			req.setAttribute("errors", errors);
			// 登録画面にフォワード
			req.getRequestDispatcher("Kai_infoChange.action").forward(req, res);
		}
	}

}
