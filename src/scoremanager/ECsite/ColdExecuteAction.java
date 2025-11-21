package scoremanager.ECsite;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Action;

public class ColdExecuteAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		// 介護施設向け持ち物リスト（カテゴリ別）
		Map<String, List<String>> ColdList = new HashMap<>();

		ColdList.put("防寒", Arrays.asList(
			"カーディガン・羽織もの",
			"室内履き（滑りにくいもの）",
			"膝掛け",
			"防寒ベスト",
			"手袋・マフラー",
			"厚手の靴下",
			"湯たんぽ（施設が許可する場合）"
		));

		req.setAttribute("coldList", ColdList);
		req.setAttribute("selectedCategory", "Cold"); // 「防寒」が選ばれたとき
	}
}