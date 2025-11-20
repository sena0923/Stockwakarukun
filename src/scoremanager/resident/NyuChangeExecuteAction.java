package scoremanager.resident;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.ResidentDao;
import bean.Resident;
import tool.Action;

public class NyuChangeExecuteAction extends Action {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

        HttpSession session = req.getSession();
        Resident resident = (Resident) session.getAttribute("resident");
        String rd_id = resident.getRd_id();

        String course_id = req.getParameter("course");
        String password = req.getParameter("password");
        String passwordConfirm = req.getParameter("passwordConfirm");

        if (password == null || !password.equals(passwordConfirm)) {
            req.setAttribute("message", "パスワードが一致しません。");
            req.getRequestDispatcher("rdInfoChange.jsp").forward(req, res);
            return;
        }

        String courseParam = req.getParameter("course");
        int Course_id = 0;
        try {
            Course_id = Integer.parseInt(courseParam);
        } catch (NumberFormatException e) {
            req.setAttribute("message", "コースの値が不正です。");
            req.getRequestDispatcher("rdInfoChange.jsp").forward(req, res);
            return;
        }


        // デバッグ出力
        System.out.println("debug:rd_id > " + rd_id);
        System.out.println("debug:course_id > " + course_id);
        System.out.println("debug:password > " + password);
        System.out.println("debug:passwordConfirm > " + passwordConfirm);

        ResidentDao residentDao = new ResidentDao();

        if (resident != null) {
            // パスワード更新
            resident.setPassword(password);

            // コース更新（Resident Bean に course フィールドがある前提）
            resident.setCourse_id(Course_id);

            // DB保存
            residentDao.save(resident);

            req.setAttribute("message", "情報を更新しました。");
        } else {
            req.setAttribute("message", "対象の入居者が見つかりません。");
        }

        req.setAttribute("resident", resident);
        req.getRequestDispatcher("rdInfoChangeComplete.jsp").forward(req, res);
    }
}