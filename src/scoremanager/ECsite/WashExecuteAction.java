package scoremanager.ECsite;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Action;

public class WashExecuteAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		// 介護施設向け持ち物リスト（カテゴリ別）
		Map<String, List<String>> WashList = new HashMap<>();

		WashList.put("洗面用具", Arrays.asList(
			"歯ブラシ・歯磨き粉",
			"入れ歯ケース・洗浄剤",
			"コップ",
			"ヘアブラシ・くし",
			"洗顔フォーム・石けん",
			"シャンプー・リンス"

		));

		req.setAttribute("washList", WashList);
		req.setAttribute("selectedCategory", "Wash"); // 「洗面用具」が選ばれたとき
	}
}