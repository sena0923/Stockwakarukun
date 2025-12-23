package scoremanager.caregiver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.CaregiverDao;
import bean.Caregiver;
import tool.Action;

public class Kai_infoChangeAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		//ローカル変数の宣言 1
		String cg_num = "";
		CaregiverDao cgDao = new CaregiverDao();
		Caregiver cg = new Caregiver();

		//リクエストパラメータ―の取得 2
		cg_num = req.getParameter("cg_num");

		//ビジネスロジック 4
		cg = cgDao.get(cg_num);
		//DBへデータ保存 5
		//なし

		//レスポンス値をセット 6
		req.setAttribute("cg", cg);

		//JSPへフォワード 7
		req.getRequestDispatcher("cg_infoChange.jsp").forward(req, res);
	}
}
