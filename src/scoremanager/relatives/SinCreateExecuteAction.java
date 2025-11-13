package scoremanager.relatives;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.RelativesDao;
import bean.Relatives;
import tool.Action;

public class SinCreateExecuteAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		//ローカル変数の指定
		HttpSession session = req.getSession();
		Relatives relatives = (Relatives)session.getAttribute("user");
		String rt_id = "";
		String rd_id = "";
		String name = "";
		String e_mail = "";
		String password = "";
		Relatives createRelatives = new Relatives();
		RelativesDao relativesDao = new RelativesDao();
		Map<String, String> errors = new HashMap<>();

		//リクエストパラメーターの取得
		rt_id = req.getParameter("rt_id");
		rd_id = req.getParameter("rd_id");
		name = req.getParameter("name");
		e_mail = req.getParameter("e_mail");
		password = req.getParameter("passowrd");


		if (password == "01"){
			//親族の新規登録ができるようになる
		} else{
			//ログインID(入居者)が存在しないため、親族の新規登録ができない
		}

		if (relativesDao.get(rt_id)!=null) {//親族が重複している場合
			errors.put("1", "ログインIDが重複しています");
			//リクエストにエラーメッセージをセット
			req.setAttribute("errors", errors);
		} else {
			createRelatives.setRt_id(rt_id);
			createRelatives.setRd_id(rd_id);
			createRelatives.setName(name);
			createRelatives.setE_mail(e_mail);
			createRelatives.setPassword(password);
			// saveメソッドで情報を登録
			relativesDao.save(createRelatives);
		}

		//リクエストに値をセット
		req.setAttribute("rt_id", rt_id);
		req.setAttribute("rd_id", rd_id);
		req.setAttribute("name", name);
		req.setAttribute("e_mail", e_mail);
		req.setAttribute("password", password);

		//JSPへフォワード
		if (errors.isEmpty()) { //エラーメッセージがない場合
			//登録完了画面にフォワード
			req.getRequestDispatcher("rtSignUpComplete.jsp").forward(req, res);
		} else { //エラーメッセージがある場合
			//登録画面にフォワード
			req.getRequestDispatcher("rtSignUp.jsp").forward(req, res);
		}

	}

}

