package scoremanager.ECsite;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.GoodsDao;
import bean.Goods;
import tool.Action;

public class AllExecuteAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		/*
		// 介護施設向け持ち物リスト（カテゴリ別）
		Map<String, List<String>> AllList = new HashMap<>();

		AllList.put("すべて", Arrays.asList(

		));
		*/
		String goods_id = req.getParameter("goods_id");

		GoodsDao goodsDao = new GoodsDao();
		Goods goods = goodsDao.get(goods_id);

		req.setAttribute("goods", goods);

		req.getRequestDispatcher("../../EClist.jsp").forward(req, res);
	}
}