package scoremanager.ECsite;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Action;

public class AllAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		// 介護施設向け持ち物リスト（カテゴリ別）
		Map<String, List<String>> AllList = new HashMap<>();

		AllList.put("すべて", Arrays.asList(
			"歯ブラシ・歯磨き粉",
			"入れ歯ケース・洗浄剤",
			"コップ",
			"ヘアブラシ・くし",
			"洗顔フォーム・石けん",
			"シャンプー・リンス",
			"バスタオル",
			"フェイスタオル",
			"ハンドタオル",
			"おしぼり",
			"下着（肌着・パンツ）",
			"靴下",
			"パジャマ",
			"普段着（上下）",
			"カーディガン・羽織もの",
			"室内履き（滑りにくいもの）",
			"膝掛け",
			"防寒ベスト",
			"手袋・マフラー",
			"厚手の靴下",
			"湯たんぽ（施設が許可する場合）",
			"ティッシュペーパー",
			"ウェットティッシュ",
			"爪切り",
			"綿棒",
			"本・雑誌",
			"塗り絵・パズル",
			"トランプ",
			"囲碁"
		));

		req.setAttribute("allList", AllList);
		req.setAttribute("selectedCategory", "All"); // 「すべて」が選ばれたとき
	}
}