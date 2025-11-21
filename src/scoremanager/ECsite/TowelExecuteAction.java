package scoremanager.ECsite;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Action;

public class TowelExecuteAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		// 介護施設向け持ち物リスト（カテゴリ別）
		Map<String, List<String>> TowelList = new HashMap<>();

		TowelList.put("タオル", Arrays.asList(
			"バスタオル",
			"フェイスタオル",
			"ハンドタオル"
		));

		req.setAttribute("TowelList", TowelList);
		req.setAttribute("selectedCategory", "Towel"); // 「タオル」が選ばれたとき
	}
}