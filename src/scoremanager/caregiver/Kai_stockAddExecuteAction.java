package scoremanager.caregiver;

import java.util.ArrayList;
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
		Resident resident = new Resident();
		ResidentDao residentDao = new ResidentDao();
		Indevidualinventory ii = new Indevidualinventory();
		Indevidual_inventoryDAO iiDao = new Indevidual_inventoryDAO(); //個人で登録したストックDAO

		//入居者beanをgetする
		resident = residentDao.get(rd_id);


	    // 既存ストックを取得
		List<Indevidualinventory> existingList = iiDao.get(rd_id);

		// 重複チェック
		boolean exists = existingList.stream()
			.anyMatch(item -> item.getInve_name().equals(inve_name));



		if (exists) { // すでに登録済みの場合
			List<String> errors = new ArrayList<>();
			errors.add("このストックは，すでに登録されています");
			req.setAttribute("errors", errors);
			req.setAttribute("resident", resident);

			//もう一度ストック登録画面へフォワード
			req.getRequestDispatcher("Kai_stockAdd.action").forward(req, res);

		}else{
			//ビジネスロジック
			inve_count = Integer.parseInt(inve_countStr);

			ii.setRd_id(rd_id);
			ii.setInve_name(inve_name);
			ii.setInve_count(inve_count);
			ii.setRegi_date(new java.util.Date()); // ←必須


			List<Indevidualinventory> newList = new ArrayList<>();
			newList.add(ii);

			iiDao.save(newList);

			//個人で登録したストックのリスト
			List<Indevidualinventory> list = iiDao.get(rd_id);

			//レスポンス値をセット
			req.setAttribute("resident", resident);
			req.setAttribute("iiList", list);


			//ストック一覧へフォワード
			req.getRequestDispatcher("Kai_stockList.action").forward(req, res);
		}
	}
}
