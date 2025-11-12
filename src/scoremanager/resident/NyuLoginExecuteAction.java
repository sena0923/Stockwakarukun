package scoremanager.resident;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.ResidentDao;
import bean.Resident;
import tool.Action;

public class NyuLoginExecuteAction extends Action {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res)
			throws Exception {

		//ローカル変数の宣言
			String url = "";
			String rd_id = "";
			String name = "";
			String password = "";
			ResidentDao residentDao = new ResidentDao();
			Resident resident = null;

			//リクエストパラメーターの取得
			rd_id = req.getParameter("rd_id");//入居者番号
			password = req.getParameter("password");

			//DBからデータ取得
			resident = residentDao.login(rd_id, password);//入居者IDとパスワードから入居者情報を取得

			//ビジネスロジック１
			//DBへデータ保存２
			//レスポンス値をセット３
			//フォワード４
				//条件で上記１～４の内容が分岐する
			if(resident != null){ //認証成功の場合
				//セッション情報を取得
				HttpSession session = req.getSession(true);
				//認証済みフラグを立てる
				resident.setAuthenticated(true);
				//セッションにログイン情報を保存
				session.setAttribute("user", resident);

				//リダイレクト
				url = "入居者/Mene.action";
				res.sendRedirect(url);
			}else{ //認証失敗の場合
				//エラーメッセージをセット
				List<String> errors = new ArrayList<>();
				errors.add("IDまたはパスワードが確認できませんでした");
				req.setAttribute("errors" , errors);
				//入力された職員番号をセット
				req.setAttribute("rd_id" , rd_id);

				//フォワード
				url = "rdLogin.jsp";
				req.getRequestDispatcher(url).forward(req,res);
			}
	}

}
