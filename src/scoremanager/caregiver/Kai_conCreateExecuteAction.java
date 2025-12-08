package scoremanager.caregiver;

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

public class Kai_conCreateExecuteAction extends Action{

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

        HttpSession session = req.getSession();
        Caregiver caregiver = (Caregiver)session.getAttribute("caregiver");

        // 入力値の取得
        String rd_id = req.getParameter("rd_id");   // 入居者ID
        String rt_id = req.getParameter("rt_id");   // 親族ID
        String title = req.getParameter("title");   // タイトル
        String content = req.getParameter("content"); // 内容

        // ----------------------------------------
        // ★ JSP の name="cheak" を正しく取得
        // ----------------------------------------
        String choiseNumParam = req.getParameter("cheak");

        // 1 or 2 を整数に変換
        int choise_num = (choiseNumParam != null) ? Integer.parseInt(choiseNumParam) : 0;

        // 1 → true、2 → false
        boolean choise = (choise_num == 1);

        // Dao などの準備
        ResidentDao rdDao = new ResidentDao();
        Resident rd = rdDao.get(rd_id);

        RelativesDao rtDao = new RelativesDao();
        Relatives rt = rtDao.get2(rd_id);

        MessageDao messageDao = new MessageDao();
        Message msg = new Message();

        Message_choiceDao message_choiceDao = new Message_choiceDao();
        Message_choice choice = new Message_choice();

        // メッセージBeanに値をセット
        msg.setCg_id(caregiver.getStaffid());
        msg.setRt_id(rt_id);
        msg.setMessage(content);
        msg.setDa_ti(new java.util.Date());
        msg.setTitle(title);

        // DBに保存して自動採番された me_id を取得
        int meId = messageDao.save(msg);

        // メッセージチョイスを保存
        choice.setMe_id(meId);
        choice.setChoise_num(choise_num);  // ← 1 or 2 が入る
        choice.setChoise(choise);          // ← true / false

        boolean savedChoice = message_choiceDao.save(choice);

        // 保存結果をセット
        req.setAttribute("savedChoice", savedChoice);
        req.setAttribute("resident", rd);
        req.setAttribute("relatives", rt);

        // 完了ページへ
        req.getRequestDispatcher("contact_input_done.jsp").forward(req, res);
    }

}
