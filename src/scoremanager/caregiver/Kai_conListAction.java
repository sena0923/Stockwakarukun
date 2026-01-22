package scoremanager.caregiver;

import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.MessageDao;
import Dao.Message_choiceDao;
import Dao.RelativesDao;
import Dao.ResidentDao;
import bean.Caregiver;
import bean.Message;
import bean.Message_choice;
import bean.Relatives;
import bean.Resident;
import tool.Action;

public class Kai_conListAction extends Action{

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
		MessageDao messageDao = new MessageDao();
		Message message = new Message();
		Message_choiceDao me_chDao = new Message_choiceDao();
		Message_choice me_ch = new Message_choice();

		rd_id = req.getParameter("rd_id");
		rd = rdDao.get(rd_id);
		rt = rtDao.get2(rd_id);//入居者IDから親族Beanを取得するDAOを作る

		//入居者に対応する親族が存在しない場合
        if (rt == null) {
            req.setAttribute("resident", rd);
            req.getRequestDispatcher("not_rt.jsp").forward(req, res);
            return;
        }


		List<Message> list = messageDao.get(rt.getRt_id());


		for (Message m : list) {
			String meId = m.getMe_id();

			me_ch= me_chDao.getOneByMeId(meId);

			m.setMessage_choice(me_ch);
		}


		System.out.println(rd_id);

		System.out.println("取得件数: " + list.size());
		for (Message r : list) {
			System.out.println(r.getTitle());
		}


		// 日付の降順にソート
		list.sort(Comparator.comparing(Message::getDa_ti).reversed());


		req.setAttribute("resident", rd);
		req.setAttribute("relatives", rt);
		req.setAttribute("list", list);

		//JSPへフォワード
		req.getRequestDispatcher("cg_contactList.jsp").forward(req, res);


	}
}
