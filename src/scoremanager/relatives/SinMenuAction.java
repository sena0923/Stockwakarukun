package scoremanager.relatives;

import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.RelativesDao;
import bean.Relatives;
import tool.Action;

public class SinMenuAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

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

	    String rtId = relatives.getRt_id();

	    RelativesDao relativesDao = new RelativesDao();
	    boolean hasExpiredProduct = relativesDao.existsOver8Months(rtId);

	    // ★ 1日1回判定
	    LocalDate today = LocalDate.now();
	    LocalDate lastShownDate = (LocalDate) session.getAttribute("warningShownDate");

	    boolean showWarningToday =
	            hasExpiredProduct &&
	            (lastShownDate == null || !lastShownDate.equals(today));

	    if (showWarningToday) {
	        session.setAttribute("warningShownDate", today);
	    }

	    req.setAttribute("showWarningToday", showWarningToday);
	    req.setAttribute("hasExpiredProduct", hasExpiredProduct);
	    req.setAttribute("relatives", relatives);

	    req.getRequestDispatcher("rtHome.jsp").forward(req, res);
	}

}
