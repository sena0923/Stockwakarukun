package scoremanager.caregiver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		String inve_countStr = "";
		int inve_count = 0;
		Map<String, String[]> paramMap = req.getParameterMap();
		ResidentDao residentDao = new ResidentDao();
		Resident resident = null;
		Indevidual_inventoryDAO iiDao = new Indevidual_inventoryDAO(); //個人で登録したストックDAO
		Indevidualinventory ii = null; //個人で登録したストックのbean

		//リクエストパラメーターの取得
		rd_id = req.getParameter("rd_id");

		//既存の個人ストック情報を取得
		List<Indevidualinventory> currentList = iiDao.get(rd_id);

		//上記の個人ストックをMap化して比較しやすくする
		Map<String, Integer> currentMap = new HashMap<>();
		for (Indevidualinventory item : currentList){
			currentMap.put(item.getInve_name(), item.getInve_count());
		}
		int updateCount = 0 ;

		//パラメーターをループして更新判定
	    for (String key : paramMap.keySet()) {
	        if (key.startsWith("count_")) {
	            String inveName = key.substring(6); // "count_"を除去
	            int inveCount = Integer.parseInt(paramMap.get(key)[0]);
	            int newCount = Integer.parseInt(paramMap.get(key)[0]);
	            int oldCount = currentMap.getOrDefault(inveName, -1);

	            //値が変わった場合のみ更新
	            if (oldCount != newCount){
	            	boolean updates = iiDao.update(rd_id, inveName, newCount);
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
		req.getRequestDispatcher("Kai_stock_done.jsp").forward(req, res);

	}
}
