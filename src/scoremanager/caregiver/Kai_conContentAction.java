package scoremanager.caregiver;

import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.MessageDao;
import Dao.Message_choiceDao;
import Dao.RelativesDao;
import Dao.ResidentDao;
import bean.Message;
import bean.Message_choice;
import bean.Relatives;
import bean.Resident;
import tool.Action;

public class Kai_conContentAction extends Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		//ローカル変数の指定
		String rd_id = "";//入居者ID
		String rt_id = "";//親族ID
		String me_id = "";//メッセージID
		ResidentDao rdDao = new ResidentDao();//入居者Bean
		Resident resident = new Resident();//入居者DAO
		RelativesDao rtDao = new RelativesDao();//親族DAO
		Relatives relatives = new Relatives();//親族Bean
		MessageDao messageDao = new MessageDao();
		Message message = new Message();
		Message_choiceDao me_chDao = new Message_choiceDao();
		Message_choice me_ch = new Message_choice();


		rd_id = req.getParameter("rd_id");
		rt_id = req.getParameter("rt_id");
		me_id = req.getParameter("me_id");

		System.out.println(rd_id);
		System.out.println(rt_id);
		System.out.println(me_id);

		List<Message> list = messageDao.get(rt_id);

		for (Message m : list) {
			int meId = Integer.parseInt(m.getMe_id());

			me_ch= me_chDao.getOneByMeId(meId);

			m.setMessage_choice(me_ch);
		}

		// 日付の降順にソート
		list.sort(Comparator.comparing(Message::getDa_ti).reversed());



		resident = rdDao.get(rd_id);
		relatives = rtDao.get2(rd_id);

		message = messageDao.getone(me_id);

		req.setAttribute("resident", resident);
		req.setAttribute("relatives", relatives);
		req.setAttribute("message", message);
		req.setAttribute("list", list);


		//フォワード
		req.getRequestDispatcher("cg_conContent.jsp").forward(req, res);


	}
}