package scoremanager.ECsite;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Action;

public class EntertainmentExecuteAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		// 介護施設向け持ち物リスト（カテゴリ別）
		Map<String, List<String>> EntertainmentList = new HashMap<>();

		EntertainmentList.put("娯楽", Arrays.asList(
			"本・雑誌",
			"塗り絵・パズル",
			"トランプ",
			"囲碁"
		));

		req.setAttribute("entertainmentList",EntertainmentList);
		req.setAttribute("selectedCategory", "Entertainment"); // 「娯楽」が選ばれたとき
	}
}