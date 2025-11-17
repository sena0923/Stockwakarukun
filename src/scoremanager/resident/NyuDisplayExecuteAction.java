package scoremanager.resident;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ResidentDao;
import bean.Resident;
import tool.Action;


public class NyuDisplayExecuteAction extends Action {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res)
	        throws Exception {

	    String rd_id = req.getParameter("rd_id");

	    ResidentDao residentDao = new ResidentDao();
	    Resident resident = residentDao.getName(rd_id);
	    Resident resident = residentDao.getPassword(rd_id);

	    if (resident != null) {
	        req.setAttribute("rd_id", resident.getRd_id());
	        req.setAttribute("name", resident.getName());
	        req.setAttribute("password", resident.getPassword());
	    }
	}
}
