package scoremanager.resident;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.In_Goods_InventoryDao;
import Dao.ResidentDao;
import bean.Ingoodsinventory;
import bean.Resident;
import tool.Action;

public class Nyu_ECstockUpdateAction extends Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		//ローカル変数の指定
		String rd_id ="";
		String inve_name = "";
		String goods_countStr = "";
		int goods_count = 0;
		Map<String, String[]> paramMap = req.getParameterMap();
		ResidentDao residentDao = new ResidentDao();
		Resident resident = new Resident();
		In_Goods_InventoryDao igDao = new In_Goods_InventoryDao(); //ECサイト連携のストックDAO
		Ingoodsinventory ig = new Ingoodsinventory(); //ECサイトと連携したストックのbean

		//リクエストパラメーターの取得
		rd_id = req.getParameter("rd_id");
		//既存のEC連携ストック情報を取得
		List<Ingoodsinventory> currentList = igDao.get(rd_id);

		//上記のEC連携ストックをMap化して比較しやすくする
		Map<String, Integer> currentMap = new HashMap<>();
		for (Ingoodsinventory item : currentList){
			currentMap.put(item.getGoods_id(), item.getGoods_inve_count());
		}
		int updateCount = 0 ;

		//パラメーターをループして更新判定
		for (String key : paramMap.keySet()) {
			if (key.startsWith("count_")) {
				String goodsId = key.substring(6); // "count_"を除去
				int goodsCount = Integer.parseInt(paramMap.get(key)[0]);
				int newCount = Integer.parseInt(paramMap.get(key)[0]);
				int oldCount = currentMap.getOrDefault(goodsId, -1);

				//値が変わった場合のみ更新
				if (oldCount != newCount){
					boolean updates = igDao.update(rd_id, goodsId, newCount);
					if(updates){
						updateCount++;
					}
				}
			}
		}



	    resident = residentDao.get(rd_id);
	    // レスポンス値をセット 6
		// リクエストに入居者リストをセット
		req.setAttribute("resident", resident);

		//フォワード先
		req.getRequestDispatcher("rd_stock_done.jsp").forward(req, res);

	}
}
