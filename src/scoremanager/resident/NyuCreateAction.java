package scoremanager.resident;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Resident;
import tool.Action;

public class NyuCreateAction extends Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		HttpSession session = req.getSession(); // セッション
		Resident resident = (Resident)session.getAttribute("user");


		// JSPへフォワード
		req.getRequestDispatcher("rdSignUp.jsp").forward(req, res);
	}
}
