package scoremanager.caregiver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ResidentDao;
import bean.Resident;
import tool.Action;

public class Kai_stockAddAction extends Action{

	@Override
	public void execute (HttpServletRequest req, HttpServletResponse res) throws Exception {

		//ローカル変数の指定
		String rd_id = "";
		Resident resident = new Resident();
		ResidentDao residentDao = new ResidentDao();


		rd_id = req.getParameter("rd_id");
		resident = residentDao.get(rd_id);

		//レスポンス値をセット
		req.setAttribute("resident", resident);
		req.setAttribute("rd_id", rd_id);


		//JSPへフォワード
		req.getRequestDispatcher("stock_add.jsp").forward(req, res);


	}
}
