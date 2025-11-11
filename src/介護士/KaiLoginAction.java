package 介護士;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Action;

public class KaiLoginAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res)
			throws Exception{
		req.getRequestDispatcher("介護士ログイン.jsp").forward(req, res);
	}
}
