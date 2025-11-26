package scoremanager.relatives;

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

public class Sin_conCreateExecuteAction extends Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

	    HttpSession session = req.getSession();
	    Caregiver caregiver = (Caregiver)session.getAttribute("caregiver");

	    // 入力値の取得
	    String rd_id = req.getParameter("rd_id");   // 入居者ID
	    String rt_id = req.getParameter("rt_id");   // 親族ID
	    String title = req.getParameter("title");   // タイトル
	    String content = req.getParameter("content"); // 内容

	    // BeanとDaoの準備
	    ResidentDao rdDao = new ResidentDao();
	    Resident rd = rdDao.get(rd_id);

	    RelativesDao rtDao = new RelativesDao();
	    Relatives rt = rtDao.get2(rd_id);

	    MessageDao messageDao = new MessageDao();
	    Message msg = new Message();

	    // メッセージBeanに値をセット
//	    msg.setMe_id(/* 主キーを生成するか自動採番に任せる */);
	    msg.setCg_id(caregiver.getStaffid()); // 介護士IDを紐づけ
	    msg.setRt_id(rt_id);                // 親族ID
	    msg.setMessage(content);            // 内容
	    msg.setDa_ti(new java.util.Date()); // 現在日時
	    msg.setTitle(title);                // タイトル

	    // DBに保存
	    boolean saved = messageDao.save(msg);

	    // 保存結果をリクエストスコープにセット（必要なら）
	    req.setAttribute("saved", saved);
	    req.setAttribute("resident", rd);
	    req.setAttribute("relatives", rt);

	    // 完了ページへフォワード
	    req.getRequestDispatcher("rt_contact_input_done.jsp").forward(req, res);
	}

}
