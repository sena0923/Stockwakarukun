/** ECサイトのストック表示 **/
package scoremanager.caregiver;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.GoodsDao;
import Dao.In_Goods_InventoryDao;
import Dao.ResidentDao;
import bean.Goods;
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
		GoodsDao goodsDao = new GoodsDao();
		String goods_id = "";
		Goods goods = new Goods();


		//リクエストパラメーターの取得
		rd_id = req.getParameter("rd_id");

		//DBから入居者Beanを，rd_idを用いて取得
		resident = residentDao.get(rd_id);

		//いったんEC連携個人在庫のリストを取得
		List<Ingoodsinventory> list = igDao.get(rd_id);

		/**取得したEC連携個人在庫の商品IDからEC商品IDと紐づけして
		 * それぞれの商品名を改めて取得する
		 */
		for (Ingoodsinventory r : list){
			goods_id = r.getGoods_id(); // 個人在庫Beanから商品IDを取得
			goods = goodsDao.get(goods_id); // 商品情報をDBから取得
			r.setGoods(goods); // IngoodsinventoryにGoodsをセット
		}



		System.out.println(resident.getName());

		for (Ingoodsinventory r : list) {
			System.out.println(r.getGoods().getGoods_name() + " / " + r.getGoods_inve_count());
		}


		//レスポンス値をセット
		req.setAttribute("rd_id", rd_id);
		req.setAttribute("resident", resident);
		req.setAttribute("iiList", list);

		//JSPへフォワード
		req.getRequestDispatcher("Kai_stockList_ec.jsp").forward(req, res);


	}
}
