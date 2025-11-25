package scoremanager.relatives;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.CaregiverDao;
import Dao.ResidentDao;
import bean.Relatives;

public class Sin_conCreateExecuteAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

        HttpSession session = req.getSession();
        CaregiverDao caregiverDao = new CaregiverDao();
        ResidentDao residentDao = new ResidentDao();
        Map<String, String> errors = new HashMap<>();
        // Relatives のインスタンス生成
        Relatives relatives = new Relatives();

        // 入力値の取得
        String cg_num = req.getParameter("cg_num");
        String rt_id = req.getParameter("rt_id");
        String message = req.getParameter("message");
        String da_ti = req.getParameter("da_ti");
        String title = req.getParameter("title");

        //テストコード（消しても良し）
        System.out.println("debug:rd_id > " + cg_num);
        System.out.println("debug:rt_id > " + rt_id);
        System.out.println("debug:message > " + message);
        System.out.println("debug:da_ti > " + da_ti);
        System.out.println("debug:title > " + title);

        req.setAttribute("cg_num", cg_num);
        req.setAttribute("rt_id", rt_id);
        req.setAttribute("message", message);
        req.setAttribute("da_ti", da_ti);
        req.setAttribute("title", title);

        req.getRequestDispatcher("rt_contact_input_done.jsp").forward(req, res);
	}
}
