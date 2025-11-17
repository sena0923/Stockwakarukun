package scoremanager.caregiver;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.Indevidual_inventoryDAO;
import Dao.ResidentDao;
import bean.Indevidualinventory;
import bean.Resident;
import tool.Action;

public class Kai_stockAddExecuteAction extends Action{

	@Override
	public void execute (HttpServletRequest req, HttpServletResponse res) throws Exception {

		//ローカル変数の指定
		String rd_id = req.getParameter("rd_id");
		String inve_name = req.getParameter("inve_name");
		String inve_countStr = req.getParameter("inve_count");
		int inve_count = 0;
		Resident resident = null;
		ResidentDao residentDao = new ResidentDao();
		Indevidualinventory ii = null;
		Indevidual_inventoryDAO iiDao = new Indevidual_inventoryDAO(); //個人で登録したストックDAO

		resident = residentDao.get(rd_id);

		inve_count = Integer.parseInt(inve_countStr);//ビジネスロジック
		List<Indevidualinventory> list = iiDao.get(rd_id);//個人で登録したストックのリスト

		iiDao.save(list);

		/**
		*11月18日は，このページから作業する！！
		**/


		//レスポンス値をセット
		req.setAttribute("resident", resident);
		req.setAttribute("iiList", list);


		//ストック一覧へフォワード
		req.getRequestDispatcher("Kai_stockList.action").forward(req, res);

	}
}
