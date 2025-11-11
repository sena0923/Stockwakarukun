package scoremanager.relatives;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.RelativesDao;
import bean.Relatives;
import tool.Action;

public class SinLoginExecuteAction extends Action {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res)
			throws Exception {

		//ローカル変数の宣言
			String url = "";
			String rt_id = "";
			String name = "";
			String password = "";
			RelativesDao relativesDao = new RelativesDao();
			Relatives relatives = null;

			//リクエストパラメーターの取得
			rt_id = req.getParameter("rt_id");//親族ID番号
			password = req.getParameter("password");

			//DBからデータ取得
			relatives = relativesDao.login(rt_id, password);//親族IDとパスワードから親族情報を取得

			//ビジネスロジック１
			//DBへデータ保存２
			//レスポンス値をセット３
			//フォワード４
				//条件で上記１～４の内容が分岐する
			if(relatives != null){ //認証成功の場合
				//セッション情報を取得
				HttpSession session = req.getSession(true);
				//認証済みフラグを立てる
				relatives.setAuthenticated(true);
				//セッションにログイン情報を保存
				session.setAttribute("user", relatives);

				//リダイレクト
				url = "親族/Mene.action";
				res.sendRedirect(url);
			}else{ //認証失敗の場合
				//エラーメッセージをセット
				List<String> errors = new ArrayList<>();
				errors.add("IDまたはパスワードが確認できませんでした");
				req.setAttribute("errors" , errors);
				//入力された職員番号をセット
				req.setAttribute("rt_id" , rt_id);

				//フォワード
				url = "親族ログイン.jsp";
				req.getRequestDispatcher(url).forward(req,res);
			}
	}

}
