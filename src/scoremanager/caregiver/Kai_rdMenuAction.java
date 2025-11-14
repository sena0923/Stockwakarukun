package scoremanager.caregiver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ResidentDao;
import bean.Resident;
import tool.Action;

public class Kai_rdMenuAction extends Action{

	@Override
	public void execute (HttpServletRequest req, HttpServletResponse res) throws Exception {

		//ローカル変数の指定
		String rd_id ="";
		ResidentDao residentDao = new ResidentDao();
		Resident resident = null;


		//リクエストパラメーターの取得
		rd_id = req.getParameter("rd_id");

		//DBから入居者Beanを，rd_idを用いて取得
		resident = residentDao.get(rd_id);

		System.out.println(resident.getName());

		//レスポンス値をセット
		req.setAttribute("rd_id", rd_id);
		req.setAttribute("resident", resident);

		//JSPへフォワード
		req.getRequestDispatcher("rd_Details.jsp").forward(req, res);


	}
}
