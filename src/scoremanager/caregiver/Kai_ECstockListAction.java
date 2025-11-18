/** ECサイトのストック表示 **/
package scoremanager.caregiver;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.In_Goods_InventoryDao;
import Dao.ResidentDao;
import bean.Ingoodsinventory;
import bean.Resident;
import tool.Action;

public class Kai_ECstockListAction extends Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		//ローカル変数の指定
		String rd_id = "";
		ResidentDao residentDao = new ResidentDao();
		Resident resident = new Resident();
		In_Goods_InventoryDao igDao = new In_Goods_InventoryDao(); //ECサイトで登録したストックDAO
		Ingoodsinventory ig = new Ingoodsinventory(); //ECサイトで登録したストックのbean



		//リクエストパラメーターの取得
		rd_id = req.getParameter("rd_id");

		//DBから入居者Beanを，rd_idを用いて取得
		resident = residentDao.get(rd_id);

		List<Ingoodsinventory> list = igDao.get(rd_id);




		System.out.println(resident.getName());

		for (Ingoodsinventory r : list) {
			System.out.println(r.getGoods_inve_id() + " / " + r.getGoods_inve_count());
		}


		//レスポンス値をセット
		req.setAttribute("rd_id", rd_id);
		req.setAttribute("resident", resident);
		req.setAttribute("iiList", list);

		//JSPへフォワード
		req.getRequestDispatcher("Kai_stockList_ec.jsp").forward(req, res);


	}
}
