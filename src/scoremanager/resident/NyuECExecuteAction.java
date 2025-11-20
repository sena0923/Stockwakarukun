package scoremanager.resident;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import Dao.GoodsDao;
import bean.Goods;

public class NyuECExecuteAction {

    private List<Goods> goodsList;      // JSP で表示する商品一覧
    private String category;            // 選択されたカテゴリー
    private String selectedCategory;    // タブ判定用

    public String execute() throws Exception {

        // DAO から商品取得
        GoodsDao dao = new GoodsDao();

        if (category == null || category.equals("all")) {
            goodsList = dao.getAllGoods();  // すべての商品
            selectedCategory = "all";
        } else {
            goodsList = dao.getGoodsByCategory(category); // カテゴリ別
            selectedCategory = category;
        }

        // JSP に渡す
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("goodsList", goodsList);
        request.setAttribute("selectedCategory", selectedCategory);

        return "success"; // SUCCESS ではなく "success" 文字列を返す
    }

    // getter / setter
    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSelectedCategory() {
        return selectedCategory;
    }

    public void setSelectedCategory(String selectedCategory) {
        this.selectedCategory = selectedCategory;
    }
}