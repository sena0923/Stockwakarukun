package scoremanager.caregiver;

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

public class Kai_conCreateExecuteAction extends Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		HttpSession session = req.getSession();
		Caregiver caregiver = (Caregiver)session.getAttribute("caregiver");

		//ローカル変数の指定
		String rd_id = "";//入居者ID
		String rt_id = "";//親族ID
		String title = "";//タイトル
		String content = "";//内容
		String cheakSt = "";//解答選択
		Integer cheak = 0;//解答選択をInt型に変換

		//beanとDaoの取得
		ResidentDao rdDao = new ResidentDao();//入居者Dao
		Resident rd = new Resident();//入居者Bean
		RelativesDao rtDao = new RelativesDao();//親族DAO
		Relatives rt = new Relatives();//親族Bean
		MessageDao messageDao = new MessageDao();//メッセージDAO
		Message Message = new Message();//メッセージBean

		//入居者IDと親族IDの取得
		rd_id = req.getParameter("rd_id");
		rt_id = req.getParameter("rt_id");

		//入居者Beanと親族Beanの取得
		rd = rdDao.get(rd_id);
		rt = rtDao.get2(rd_id);

		req.setAttribute("resident", rd);
		req.setAttribute("relatives", rt);

		//フォワード
		//送信完了ページへ
		req.getRequestDispatcher("contact_input_done.jsp").forward(req, res);


	}
}
