package scoremanager.ECsite;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Action;

public class ClotExecuteAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		// 介護施設向け持ち物リスト（カテゴリ別）
		Map<String, List<String>> ClotList = new HashMap<>();

		ClotList.put("衣類", Arrays.asList(
			"下着（肌着・パンツ）",
			"靴下",
			"パジャマ",
			"普段着（上下）"
		));

		req.setAttribute("clotList", ClotList);
		req.setAttribute("selectedCategory", "Clot"); // 「衣類」が選ばれたとき
	}
}