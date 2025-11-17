package scoremanager.relatives;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.RelativesDao;
import Dao.ResidentDao;
import bean.Relatives;
import tool.Action;

public class SinCreateExecuteAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {


		// セッションとDAOの準備
        HttpSession session = req.getSession();
        RelativesDao relativesDao = new RelativesDao();
        ResidentDao residentDao = new ResidentDao();
        Map<String, String> errors = new HashMap<>();

        // 入力値の取得
        String rt_id = req.getParameter("user_id");
        String rd_id = req.getParameter("rd_id");
        String name = req.getParameter("name");
        String e_mail = req.getParameter("email");
        String password = req.getParameter("password");

        // 入力チェック
        if (rt_id == null || rt_id.isEmpty()) {
            errors.put("rt_id", "ユーザーIDを入力してください");
        }
        if (rd_id == null || rd_id.isEmpty()) {
            errors.put("rd_id", "ユーザーIDを入力してください");
        }
        if (name == null || name.isEmpty()) {
            errors.put("name", "名前を入力してください");
        }
        if (e_mail == null || e_mail.isEmpty()) {
            errors.put("e_mail", "メールアドレスを入力してください");
        }
        if (password == null || password.isEmpty()) {
            errors.put("password", "パスワードを入力してください");
        }

        // ユーザーIDの重複チェック
        if (relativesDao.get(rt_id) != null) {
        	errors.put("duplicate_rt", "この親族IDは既に登録されています");
        }
        if (residentDao.get(rd_id) == null) {
            errors.put("invalid_rd", "この入居者IDは存在していません");
        }

        // 登録処理
        if (errors.isEmpty()) {
            Relatives relatives = new Relatives();
            relatives.setRt_id(rt_id);
            relatives.setName(name);
            relatives.setE_mail(e_mail);
            relatives.setPassword(password);
            relativesDao.save(relatives);

            // 完了画面へ
            req.getRequestDispatcher("rtSignUpComplete.jsp").forward(req, res);
        } else {
            // エラーをセットして再入力画面へ
            req.setAttribute("errors", errors);
            req.setAttribute("rt_id", rt_id);
            req.setAttribute("rd_id", rd_id);
            req.setAttribute("name", name);
            req.setAttribute("e_mail", e_mail);
            req.setAttribute("password", password);
            req.getRequestDispatcher("SinCreate.action").forward(req, res);
        }
    }
}





		/*
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
		password = req.getParameter("password");


		if ("01".equals(password)){
			//親族の新規登録ができるようになる

			if (relativesDao.get(rt_id)!=null) {//親族が重複している場合
				errors.put("1", "ログインIDが重複しています");
				//リクエストにエラーメッセージをセット
				System.out.println(errors.values());

			}else if (!)


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
				req.getRequestDispatcher("SinCreate.action").forward(req, res);
			}

	}

}
*/

