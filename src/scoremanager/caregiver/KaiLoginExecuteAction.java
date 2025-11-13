package scoremanager.caregiver;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.CaregiverDao;
import bean.Caregiver;
import tool.Action;

public class KaiLoginExecuteAction extends Action {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res)
			throws Exception {

		//ローカル変数の宣言
			String url = "";
			String staffnum = "";
			String name = "";
			String password = "";
			CaregiverDao caregiverDao = new CaregiverDao();
			Caregiver caregiver = null;

			//リクエストパラメーターの取得
			staffnum = req.getParameter("staffnum");//介護士職員番号
			password = req.getParameter("password");

			//DBからデータ取得
			caregiver = caregiverDao.login(staffnum, password);//職員番号とパスワードから介護士情報を取得

			//ビジネスロジック１
			//DBへデータ保存２
			//レスポンス値をセット３
			//フォワード４
				//条件で上記１～４の内容が分岐する
			if(caregiver != null){ //認証成功の場合
				//セッション情報を取得
				HttpSession session = req.getSession(true);
				//認証済みフラグを立てる
				caregiver.setAuthenticated(true);
				//セッションにログイン情報を保存
				session.setAttribute("user", caregiver);

				//リダイレクト
				url = "KaiMenu.action";
				res.sendRedirect(url);
			}else{ //認証失敗の場合
				//エラーメッセージをセット
				List<String> errors = new ArrayList<>();
				errors.add("IDまたはパスワードが確認できませんでした");
				req.setAttribute("errors" , errors);
				//入力された職員番号をセット
				req.setAttribute("staffnum" , staffnum);

				//フォワード
				url = "介護士ログイン.jsp";
				req.getRequestDispatcher(url).forward(req,res);
			}
	}

}
