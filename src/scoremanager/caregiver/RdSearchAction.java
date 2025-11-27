package scoremanager.caregiver;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.CourseDao;
import Dao.ResidentDao;
import bean.Course;
import bean.Resident;
import tool.Action;

public class RdSearchAction extends Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		// ローカル変数の指定 1
		ResidentDao residentDao = new ResidentDao(); //入居者DAO
		CourseDao courseDao = new CourseDao();//コースDAO
		Course course = new Course();//コースBean
		int course_id = 0;
		String name = "";//検索したい入居者名
		Resident resident = new Resident();//検索した入居者の情報を格納するBean
		List<Resident> list = new ArrayList<>();

		name = req.getParameter("name");

		// getAllを使って入居者一覧を取得

		list = residentDao.get2(name);


		/**取得した入居者一覧のコースIDから
		 * コース名を取得する
		 */
		for (Resident r : list){
			course_id = r.getCourse_id();
			course = courseDao.get(course_id);
			r.setCourse(course);
		}

		// レスポンス値をセット 6
		// リクエストに入居者リストをセット
		req.setAttribute("list", list);


		// JSPへフォワード 7
		req.getRequestDispatcher("kai_rdSearch.jsp").forward(req, res);
	}

}


