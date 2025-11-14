package scoremanager.caregiver;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.Indevidual_inventoryDAO;
import Dao.ResidentDao;
import bean.Indevidualinventory;
import bean.Resident;
import tool.Action;

public class Kai_stockListAction extends Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		//ローカル変数の指定
		String rd_id = "";
		ResidentDao residentDao = new ResidentDao();
		Resident resident = null;
		Indevidual_inventoryDAO iiDao = new Indevidual_inventoryDAO(); //個人で登録したストックDAO
		Indevidualinventory ii = null; //個人で登録したストックのbean


		//リクエストパラメーターの取得
		rd_id = req.getParameter("rd_id");

		//DBから入居者Beanを，rd_idを用いて取得
		resident = residentDao.get(rd_id);

		List<Indevidualinventory> list = iiDao.get(rd_id);


		System.out.println(resident.getName());

		for (Indevidualinventory r : list) {
			System.out.println(r.getInve_name() + " / " + r.getInve_count());
		}


		//レスポンス値をセット
		req.setAttribute("rd_id", rd_id);
		req.setAttribute("resident", resident);
		req.setAttribute("iiList", list);

		//JSPへフォワード
		req.getRequestDispatcher("Kai_stockList.jsp").forward(req, res);


	}
}
