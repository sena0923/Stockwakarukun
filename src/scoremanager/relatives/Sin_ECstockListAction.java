/** ECサイトのストック表示 **/
package scoremanager.relatives;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.GoodsDao;
import Dao.In_Goods_InventoryDao;
import Dao.RelativesDao;
import Dao.ResidentDao;
import bean.Goods;
import bean.Ingoodsinventory;
import bean.Relatives;
import bean.Resident;
import tool.Action;

public class Sin_ECstockListAction extends Action{

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
		RelativesDao rtDao = new RelativesDao();
		Relatives relatives = new Relatives();
		String rt_id = "";


		//リクエストパラメーターの取得
		rt_id = req.getParameter("rt_id");

		relatives = rtDao.get(rt_id);


		//入居者IDを取得
		rd_id = relatives.getRd_id();

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



		//レスポンス値をセット
		req.setAttribute("rd_id", rd_id);
		req.setAttribute("resident", resident);
		req.setAttribute("iiList", list);

		//JSPへフォワード
		req.getRequestDispatcher("rt_stockList_ec.jsp").forward(req, res);


	}
}
