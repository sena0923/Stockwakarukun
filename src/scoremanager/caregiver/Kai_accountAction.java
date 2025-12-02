package scoremanager.caregiver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.CaregiverDao;
import bean.Caregiver;
import tool.Action;

public class Kai_accountAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		// ローカル変数の指定
		String cg_num = "";
		Caregiver caregiver = new Caregiver();
		CaregiverDao caregiverDao = new CaregiverDao();

		//リクエストパラメーターの取得
		cg_num = req.getParameter("cg_num");

		caregiver = caregiverDao.get(cg_num);

		req.setAttribute("caregiver", caregiver);


		// JSPへフォワード
		req.getRequestDispatcher("cg_infoDisplay.jsp").forward(req, res);
	}
}
