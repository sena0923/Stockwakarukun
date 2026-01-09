package scoremanager.relatives;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.RelativesDao;
import Dao.ResidentDao;
import bean.Relatives;
import bean.Resident;
import tool.Action;

public class SinDisplayExecuteAction extends Action {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

        // ログイン済み前提なのでセッションからログインIDを取得
        //HttpSession session = req.getSession();
        //String rt_id = (String) session.getAttribute("rt_id");

    	String rt_id = "";
		String rd_id = "";
		ResidentDao residentDao = new ResidentDao();
		Resident resident = new Resident();
		RelativesDao relativesDao = new RelativesDao();
		Relatives relatives = new Relatives();

		rt_id = req.getParameter("rt_id");

        // DAOでその人の情報を取得（IDで検索）
        relatives = relativesDao.get(rt_id);



		//入居者IDを取得
		rd_id = relatives.getRd_id();
		resident = residentDao.get(rd_id);




        // JSPに渡す
        req.setAttribute("relatives", relatives);
        req.setAttribute("resident", resident);

        // 詳細表示用JSPへフォワード
        req.getRequestDispatcher("rtInfoDisplay.jsp").forward(req, res);
    }
}