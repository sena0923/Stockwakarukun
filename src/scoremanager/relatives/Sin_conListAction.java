package scoremanager.relatives;

import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.MessageDao;
import Dao.Message_choiceDao;
import Dao.RelativesDao;
import Dao.ResidentDao;
import bean.Message;
import bean.Message_choice;
import bean.Relatives;
import bean.Resident;
import tool.Action;

public class Sin_conListAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		HttpSession session = req.getSession();
		Relatives relatives = (Relatives)session.getAttribute("relatives");

		//ローカル変数の指定
		String rd_id = "";//入居者ID
		String rt_id = "";//親族ID
		ResidentDao residentDao = new ResidentDao();//入居者Dao
		Resident resident = new Resident();//入居者bean
		RelativesDao rtDao = new RelativesDao();//親族DAO
		Relatives rt = new Relatives();//親族Bean
		MessageDao messageDao = new MessageDao();
		Message message = new Message();
		Message_choiceDao me_chDao = new Message_choiceDao();
		Message_choice me_ch = new Message_choice();


		rt_id = relatives.getRt_id();
		rt = rtDao.get(rt_id);
		rd_id = relatives.getRd_id();
		resident = residentDao.get(rd_id);



		List<Message> list = messageDao.get(rt.getRt_id());
		for (Message m : list) {
			String meId = m.getMe_id();

			me_ch= me_chDao.getOneByMeId(meId);

			m.setMessage_choice(me_ch);
		}


		System.out.println("取得件数: " + list.size());
		for (Message r : list) {
			System.out.println(r.getTitle());
		}

		// 日付の降順にソート
		list.sort(Comparator.comparing(Message::getDa_ti).reversed());


		req.setAttribute("resident", resident);
		req.setAttribute("relatives", rt);
		req.setAttribute("list", list);

		//JSPへフォワード
		req.getRequestDispatcher("rt_contactlist.jsp").forward(req, res);


	}
}