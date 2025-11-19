package scoremanager.relatives;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Relatives;
import tool.Action;

public class SinInformationChangeAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		HttpSession session = req.getSession(); // セッション
		Relatives relatives = (Relatives)session.getAttribute("rt_id");

		req.getRequestDispatcher("rtInfoChange.jsp").forward(req, res);

	}

}
