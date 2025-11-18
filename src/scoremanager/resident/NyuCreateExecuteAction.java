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
	    String courseIdStr = req.getParameter("course_id");
	    String gender = req.getParameter("gender"); // JSP と一致させる
	    String password = req.getParameter("password");
	    String password2 = req.getParameter("password2");

	    // バリデーション
	    if (rd_id == null || rd_id.trim().isEmpty()) {
	        errors.put("rd_id", "IDを入力してください");
	    }
	    if (name == null || name.trim().isEmpty()) {
	        errors.put("name", "名前を入力してください");
	    }

	    int course_id = -1;
	    if (courseIdStr == null || courseIdStr.trim().isEmpty()) {
	        errors.put("course_id", "コースを選択してください");
	    } else {
	        try {
	            course_id = Integer.parseInt(courseIdStr.trim());
	        } catch (NumberFormatException nfe) {
	            errors.put("course_id", "コースIDは数値で入力してください");
	        }
	    }

	    if (password == null || password.trim().isEmpty()) {
	        errors.put("password", "パスワードを入力してください");
	    } else if (!password.equals(password2)) {
	        errors.put("password2", "パスワードが一致しません");
	    }

	    // ID 重複チェック（rd_id が入力されていて重複チェックできる場合のみ）
	    if (!errors.containsKey("rd_id")) {
	        Resident existing = residentDao.get(rd_id);
	        if (existing != null) {
	            errors.put("rd_id", "IDが重複しています");
	        }
	    }

	    // エラーがあれば入力を戻して作成画面へフォワード
	    if (!errors.isEmpty()) {
	        req.setAttribute("errors", errors);
	        req.setAttribute("rd_id", rd_id);
	        req.setAttribute("name", name);
	        req.setAttribute("course_id", courseIdStr); // 表示用は文字列で戻す
	        req.setAttribute("gender", gender);
	        req.setAttribute("password", password);
	        req.getRequestDispatcher("NyuCreate.action").forward(req, res);
	        return;
	    }

	    // 問題なければ Resident を作って保存
	    Resident createResident = new Resident();
	    createResident.setRd_id(rd_id);
	    createResident.setName(name);
	    createResident.setCourse_id(course_id); // int を渡す（ここでエラーが出なくなる）
	    createResident.setGender(gender);
	    createResident.setPassword(password);

	    boolean saved = residentDao.save(createResident);
	    if (!saved) {
	        errors.put("save", "登録に失敗しました（DBエラーの可能性）");
	        req.setAttribute("errors", errors);
	        req.getRequestDispatcher("NyuCreate.action").forward(req, res);
	        return;
	    }

	    // 正常終了 -> メニュー等へフォワード
	    req.getRequestDispatcher("NyuMenu.action").forward(req, res);
	}
}
