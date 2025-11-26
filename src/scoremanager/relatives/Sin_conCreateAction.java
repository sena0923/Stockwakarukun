package scoremanager.relatives;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.RelativesDao;
import Dao.ResidentDao;
import bean.Caregiver;
import bean.Relatives;
import bean.Resident;
import tool.Action;

public class Sin_conCreateAction extends Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		HttpSession session = req.getSession();
		Caregiver caregiver = (Caregiver)session.getAttribute("caregiver");

		//ローカル変数の指定
		String rd_id = "";//入居者ID
		String rt_id = "";//親族ID
		ResidentDao rdDao = new ResidentDao();//入居者Bean
		Resident rd = new Resident();//入居者DAO
		RelativesDao rtDao = new RelativesDao();//親族DAO
		Relatives rt = new Relatives();//親族Bean

		rd_id = req.getParameter("rd_id");
		rt_id = req.getParameter("rt_id");

		rd = rdDao.get(rd_id);
		rt = rtDao.get2(rd_id);

		req.setAttribute("resident", rd);
		req.setAttribute("relatives", rt);

		//フォワード
		req.getRequestDispatcher("Contact_input.jsp").forward(req, res);


	}
}
