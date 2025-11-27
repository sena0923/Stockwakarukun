package scoremanager.relatives;

import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.CaregiverDao;
import Dao.MessageDao;
import Dao.RelativesDao;
import bean.Caregiver;
import bean.Message;
import bean.Relatives;
import tool.Action;

public class Sin_conListAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		HttpSession session = req.getSession();
		Relatives relatives = (Relatives)session.getAttribute("relatives");

		//ローカル変数の指定
		String cg_num = "";//介護士ID
		String rt_id = "";//親族ID
		CaregiverDao cgDao = new CaregiverDao();//介護士Bean
		Caregiver cg = new Caregiver();//介護士DAO
		RelativesDao rtDao = new RelativesDao();//親族DAO
		Relatives rt = new Relatives();//親族Bean
		MessageDao messageDao = new MessageDao();
		Message message = new Message();

//		cg_num = req.getParameter("cg_num");
		cg_num = relatives.getRt_id();
		cg = cgDao.get(cg_num);
		rt = rtDao.get2(cg_num);//介護士IDから親族Beanを取得するDAOを作る


		System.out.println("debug-Sin_conListAction-cgnum:" + cg_num);
		System.out.println("debug-Sin_conListAction-rt:" + Objects.isNull(rt));
		List<Message> list = messageDao.get(rt.getRt_id());

		System.out.println(cg_num);

		System.out.println("取得件数: " + list.size());
		for (Message r : list) {
			System.out.println(r.getTitle());
		}

		req.setAttribute("resident", cg);
		req.setAttribute("relatives", rt);
		req.setAttribute("list", list);

		//JSPへフォワード
		req.getRequestDispatcher("rt_contactlist.jsp").forward(req, res);


	}
}