package scoremanager.caregiver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Action;

public class KaiLoginAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res)
			throws Exception{
		req.getRequestDispatcher("cg_login.jsp").forward(req, res);
	}
}
