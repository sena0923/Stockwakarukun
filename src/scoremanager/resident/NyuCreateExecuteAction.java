package scoremanager.resident;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.ResidentDao;
import bean.Resident;
import tool.Action;

public class NyuCreateExecuteAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {


		HttpSession session = req.getSession(); // セッション
		Resident resident = (Resident)session.getAttribute("user");


	    // ローカル変数の指定・取得
	    String rd_id = req.getParameter("rd_id");
	    String name = req.getParameter("name");
	    String courseIdStr = req.getParameter("course_id");
	    String gender = req.getParameter("gender"); // JSP と一致させる
	    String password = req.getParameter("password");
	    String password2 = req.getParameter("password2");
	    //DAO,Bean
	    ResidentDao residentDao = new ResidentDao();
	    Resident createResident = new Resident();
	    Map<String, String> errors = new HashMap<>();

	    int course_id = 0;
	    course_id = Integer.parseInt(courseIdStr.trim());


		if (residentDao.get(rd_id)!= null) { // 入居者のログインIDが重複している場合
			errors.put("1", "入力されたログインIDは，すでに使用されています");
			// リクエストにエラーメッセージをセット
			System.out.println(errors.values());

		}else if (!password.equals(password2)) {
			errors.put("2", "パスワードとパスワード(確認)が一致しません");

		} else {
		    createResident.setRd_id(rd_id);
		    createResident.setName(name);
		    createResident.setCourse_id(course_id); // int を渡す（ここでエラーが出なくなる）
		    createResident.setGender(gender);
		    createResident.setPassword(password);
		    residentDao.save(createResident);
		}

		System.out.println(errors.values());
		//リクエストに値をセット
		req.setAttribute("errors", errors);


		// JSPへフォワード
		if (errors.isEmpty()) { // エラーメッセージがない場合

			// 登録完了画面にフォワード
			req.getRequestDispatcher("rdSignUpComplete.jsp").forward(req, res);
		} else { // エラーメッセージがある場合
			req.setAttribute("errors", errors);
			// 登録画面にフォワード
			req.getRequestDispatcher("NyuCreate.action").forward(req, res);
		}
	}
}
