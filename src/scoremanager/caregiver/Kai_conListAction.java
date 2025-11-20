package scoremanager.caregiver;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.MessageDao;
import Dao.RelativesDao;
import Dao.ResidentDao;
import bean.Caregiver;
import bean.Message;
import bean.Relatives;
import bean.Resident;
import tool.Action;

public class Kai_conListAction extends Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		HttpSession session = req.getSession();
		Caregiver caregiver = (Caregiver)session.getAttribute("user");

		//ローカル変数の指定
		String rd_id = "";//入居者ID
		String rt_id = "";//親族ID
		ResidentDao rdDao = new ResidentDao();//入居者Bean
		Resident rd = new Resident();//入居者DAO
		RelativesDao rtDao = new RelativesDao();//親族DAO
		Relatives rt = new Relatives();//親族Bean
		MessageDao messageDao = new MessageDao();
		Message message = new Message();

		rd_id = req.getParameter("rd_id");
		rt = rtDao.get(rd_id);//DAOを作る


		List<Message> list = messageDao.get(rd.getRd_id());

		req.setAttribute("", arg1);

	}
}
