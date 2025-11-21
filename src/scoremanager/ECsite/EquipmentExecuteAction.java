package scoremanager.ECsite;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Action;

public class EquipmentExecuteAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		// 介護施設向け持ち物リスト（カテゴリ別）
		Map<String, List<String>> EquipmentList = new HashMap<>();

		EquipmentList.put("備品", Arrays.asList(
			"ティッシュペーパー",
			"ウェットティッシュ",
			"爪切り",
			"綿棒"
		));

		req.setAttribute("equipmentList", EquipmentList);
		req.setAttribute("selectedCategory", "Equipment"); // 「備品」が選ばれたとき
	}
}