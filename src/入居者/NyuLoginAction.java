package 入居者;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Action;

public class NyuLoginAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res)
			throws Exception{
		req.getRequestDispatcher("入居者ログイン.jsp").forward(req, res);
	}
}
