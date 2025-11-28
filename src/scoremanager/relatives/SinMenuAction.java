package scoremanager.relatives;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Relatives;
import tool.Action;

public class SinMenuAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		// セッションからログイン情報を取得
		HttpSession session = req.getSession(false); // falseで新規作成しない
		Relatives relatives = new Relatives();

		if (session != null) {
			relatives = (Relatives) session.getAttribute("relatives");
		}


		// JSPに渡すためにリクエスト属性にセット
		req.setAttribute("relatives", relatives);


		//JSPへフォワード 7
		req.getRequestDispatcher("rtHome.jsp").forward(req, res);
	}
}

