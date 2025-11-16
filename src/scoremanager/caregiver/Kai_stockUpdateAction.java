package scoremanager.caregiver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.Indevidual_inventoryDAO;
import Dao.ResidentDao;
import bean.Indevidualinventory;
import bean.Resident;
import tool.Action;

public class Kai_stockUpdateAction extends Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		//ローカル変数の指定
		String rd_id ="";
		String inve_name = "";
		int inve_count = 0;
		ResidentDao residentDao = new ResidentDao();
		Resident resident = null;
		Indevidual_inventoryDAO iiDao = new Indevidual_inventoryDAO(); //個人で登録したストックDAO
		Indevidualinventory ii = null; //個人で登録したストックのbean

		//リクエストパラメーターの取得
		rd_id = req.getParameter("rd_id");
		inve_name = req.getParameter("inve_name");

		System.out.println("rd_id");
		System.out.println("inve_name");

	}
}
