package scoremanager.caregiver;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ResidentDao;
import bean.Resident;
import tool.Action;

public class RdListAction extends Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		// ローカル変数の指定 1
		ResidentDao residentDao = new ResidentDao(); //入居者DAO

		// getAllを使って入居者一覧を取得
		List<Resident> list = residentDao.getAll();


		// リクエストパラメーターの取得 2


		System.out.println("取得件数: " + list.size());
		for (Resident r : list) {
			System.out.println(r.getRd_id() + " / " + r.getName());
		}





		// DBからデータ取得 3

		// レスポンス値をセット 6
		// リクエストに入居者リストをセット
		req.setAttribute("list", list);


		// JSPへフォワード 7
		req.getRequestDispatcher("kai_rdList.jsp").forward(req, res);
	}

}


