package scoremanager.relatives;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.RelativesDao;
import bean.Relatives;
import tool.Action;

public class SinMenuAction extends Action {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

        // セッション取得（なければログインへ）
        HttpSession session = req.getSession(false);
        if (session == null) {
            res.sendRedirect("login.jsp");
            return;
        }

        Relatives relatives = (Relatives) session.getAttribute("relatives");
        if (relatives == null) {
            res.sendRedirect("login.jsp");
            return;
        }

        // 親族ID取得
        String rtId = relatives.getRt_id();

        RelativesDao relativesDao = new RelativesDao();

        // 8か月経過商品があるか？
        boolean hasExpiredProduct = relativesDao.existsOver8Months(rtId);

        System.out.println("ログイン親族の rd_id = " + relatives.getRd_id());


        // JSPに渡す
        req.setAttribute("hasExpiredProduct", hasExpiredProduct);
        req.setAttribute("relatives", relatives);

        // ★ forward は1回だけ
        req.getRequestDispatcher("rtHome.jsp").forward(req, res);
    }
}
