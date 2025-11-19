package scoremanager.resident;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Resident;
import tool.Action;

public class NyuECAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		// TODO 自動生成されたメソッド・スタブ

		HttpSession session = req.getSession(); // セッション
		Resident resident = (Resident)session.getAttribute("user");


		// JSPへフォワード
		req.getRequestDispatcher("EClist.jsp").forward(req, res);
	}


}
