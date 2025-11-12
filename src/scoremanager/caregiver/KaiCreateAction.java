package scoremanager.caregiver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Caregiver;
import tool.Action;

public class KaiCreateAction extends Action {

		@Override
		public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

			HttpSession session = req.getSession(); // セッション
			Caregiver caregiver = (Caregiver)session.getAttribute("user");


			// JSPへフォワード
			req.getRequestDispatcher("介護士新規登録.jsp").forward(req, res);
		}
	}
