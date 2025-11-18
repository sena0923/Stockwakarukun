package scoremanager.relatives;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.RelativesDao;
import Dao.ResidentDao;
import bean.Relatives;
import tool.Action;

public class SinCreateExecuteAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		System.out.println("debug:SinCreateExecuteAction");

		// セッションとDAOの準備
        HttpSession session = req.getSession();
        RelativesDao relativesDao = new RelativesDao();
        ResidentDao residentDao = new ResidentDao();
        Map<String, String> errors = new HashMap<>();
        // Relatives のインスタンス生成
        Relatives relatives = new Relatives();

        // 入力値の取得
        String rt_id = req.getParameter("rt_id");
        String rd_id = req.getParameter("rd_id");
        String name = req.getParameter("name");
        String e_mail = req.getParameter("e_mail");
        String password = req.getParameter("password");


        // ユーザーIDの重複チェック
        if (relativesDao.get(rt_id) != null) {
            errors.put("rt_id", "この親族IDは既に登録されています");
        } else if (residentDao.get(rd_id) == null) {
            errors.put("rd_id", "この入居者IDは存在していません");

        }else{
        	relatives.setRt_id(rt_id);
            relatives.setRd_id(rd_id);
            relatives.setName(name);
            relatives.setE_mail(e_mail);
            relatives.setPassword(password);
            relativesDao.save(relatives);
        }


        req.setAttribute("rt_id", rt_id);
        req.setAttribute("rd_id", rd_id);
        req.setAttribute("name", name);
        req.setAttribute("e_mail", e_mail);
        req.setAttribute("password", password);

        // 登録処理
        if (errors.isEmpty()) {

            // 完了画面へ
            req.getRequestDispatcher("rtSignUpComplete.jsp").forward(req, res);
        } else {
            // エラーをセットして再入力画面へ
            req.setAttribute("errors", errors);

            req.getRequestDispatcher("SinCreate.action").forward(req, res);
        }
    }
}



