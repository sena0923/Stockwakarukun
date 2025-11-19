package scoremanager.resident;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import Dao.GoodsDao;
import bean.Goods;

public class NyuECExecuteAction {

    public String execute(HttpServletRequest request) {

        try {
            // パラメータ category を取得（null → "all"）
            String category = request.getParameter("category");
            if (category == null || category.isEmpty()) {
                category = "all";
            }

            GoodsDao dao = new GoodsDao();
            List<Goods> goodsList;

            // カテゴリーで分岐
            if (category.equals("all")) {
                goodsList = dao.getAllGoods();
            } else {
                goodsList = dao.getGoodsByCategory(category);
            }

            // JSP に渡す
            request.setAttribute("goodsList", goodsList);
            request.setAttribute("selectedCategory", category);

            return "EClist.jsp";   // ←表示する JSP に変更

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "商品情報の取得中にエラーが発生しました。");
            return "error.jsp";
        }
    }
}