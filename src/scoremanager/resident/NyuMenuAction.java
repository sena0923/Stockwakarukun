package scoremanager.resident;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Resident;
import tool.Action;

public class NyuMenuAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {



		// セッションからログイン情報を取得
		HttpSession session = req.getSession(false); // falseで新規作成しない
		Resident resident = new Resident();

		if (session != null) {
			resident = (Resident) session.getAttribute("resident");
		}


		// JSPに渡すためにリクエスト属性にセット
		req.setAttribute("resident", resident);

		//JSPへフォワード 7
		req.getRequestDispatcher("rdHome.jsp").forward(req, res);
	}
}
