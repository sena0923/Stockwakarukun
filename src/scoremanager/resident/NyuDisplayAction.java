package scoremanager.resident;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Relatives;
import tool.Action;

public class NyuDisplayAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res)
			throws Exception{

		HttpSession session = req.getSession(); // セッション
		Relatives relatives = (Relatives)session.getAttribute("rt_id");

		req.getRequestDispatcher("rdInfoDisplay.jsp").forward(req, res);
	}

}
