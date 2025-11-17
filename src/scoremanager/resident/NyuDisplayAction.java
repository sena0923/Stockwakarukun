package scoremanager.resident;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Action;

public class NyuDisplayAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res)
			throws Exception{
		req.getRequestDispatcher("rdInfoDisplay.jsp").forward(req, res);
	}
}
