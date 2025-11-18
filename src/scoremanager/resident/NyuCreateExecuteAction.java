package scoremanager.resident;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.ResidentDao;
import bean.Resident;
import tool.Action;

public class NyuCreateExecuteAction extends Action {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

        HttpSession session = req.getSession();
        ResidentDao residentDao = new ResidentDao();
        Map<String, String> errors = new HashMap<>();

        // 入力値取得
        String rd_id = req.getParameter("rd_id");
        String name = req.getParameter("name");
        String course_id = req.getParameter("course_id");
        String gender = req.getParameter("gender");
        String password = req.getParameter("password");
        String password2 = req.getParameter("password2");

        // ===== バリデーション =====

        // ID 重複チェック
        if (residentDao.get(rd_id) != null) {
            errors.put("id", "IDが重複しています");
        }

        // パスワード一致チェック
        if (password == null || !password.equals(password2)) {
            errors.put("password", "パスワードが一致していません");
        }

        // ===== ここから新規作成処理 =====
        if (errors.isEmpty()) {

            Resident createResident = new Resident();
            createResident.setRd_id(rd_id);
            createResident.setName(name);
            createResident.setCourse_id(course_id);
            createResident.setGender(gender);
            createResident.setPassword(password);

            // DB 登録
            residentDao.save(createResident);

            // 完了画面へ
            req.getRequestDispatcher("NyuMenu.action").forward(req, res);
            return;
        }

        // ===== エラー時：入力値を戻す =====
        req.setAttribute("rd_id", rd_id);
        req.setAttribute("name", name);
        req.setAttribute("course_id", course_id);
        req.setAttribute("gender", gender);
        req.setAttribute("password", password);
        req.setAttribute("errors", errors);

        req.getRequestDispatcher("NyuCreate.action").forward(req, res);
    }
}
