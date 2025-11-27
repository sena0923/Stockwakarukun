package scoremanager.relatives;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.Indevidual_inventoryDAO;
import Dao.RelativesDao;
import Dao.ResidentDao;
import bean.Indevidualinventory;
import bean.Relatives;
import bean.Resident;
import tool.Action;

public class Sin_stockListAction extends Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		//ローカル変数の指定
		String rt_id = "";
		String rd_id = "";
		ResidentDao residentDao = new ResidentDao();
		Resident resident = new Resident();
		RelativesDao rtDao = new RelativesDao();
		Relatives rt = new Relatives();
		Indevidual_inventoryDAO iiDao = new Indevidual_inventoryDAO(); //個人で登録したストックDAO

		//リクエストパラメーターの取得
		rt_id = req.getParameter("rt_id");

		relatives = relatives.get1(rt_id);

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
