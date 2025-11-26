package scoremanager.resident;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.Indevidual_inventoryDAO;
import Dao.ResidentDao;
import bean.Resident;
import tool.Action;

public class Nyu_stockUpdateAction extends Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		//ローカル変数の指定
		String rd_id ="";
		String inve_name = "";
		Map<String, String[]> paramMap = req.getParameterMap();
		ResidentDao residentDao = new ResidentDao();
		Resident resident = null;
		Indevidual_inventoryDAO iiDao = new Indevidual_inventoryDAO(); //個人で登録したストックDAO


		//リクエストパラメーターの取得
		rd_id = req.getParameter("rd_id");


	    for (String key : paramMap.keySet()) {
	        if (key.startsWith("count_")) {
	            String inveName = key.substring(6); // "count_"を除去
	            int inveCount = Integer.parseInt(paramMap.get(key)[0]);
	            iiDao.update(rd_id, inveName, inveCount);
	        }
	    }

	    resident = residentDao.get(rd_id);

		System.out.println(rd_id);
		System.out.println(inve_name);

		// レスポンス値をセット 6
		// リクエストに入居者リストをセット
		req.setAttribute("resident", resident);

		//フォワード先
		req.getRequestDispatcher("rd_stock_done.jsp").forward(req, res);

	}
}
