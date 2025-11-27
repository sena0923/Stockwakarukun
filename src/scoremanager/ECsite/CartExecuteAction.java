package scoremanager.ECsite;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.GoodsDao;
import bean.Goods;
import tool.Action;

public class CartExecuteAction extends Action {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String goodsId = req.getParameter("goods_id");

        // 商品情報を取得（DAOなどから）
        GoodsDao goodsDao = new GoodsDao();
        Goods goods = goodsDao.get(goodsId);

        HttpSession session = req.getSession();
        List<Goods> cartList = (List<Goods>) session.getAttribute("cartList");

        if (cartList == null) {
            cartList = new ArrayList<>();
        }

        cartList.add(goods);  // カートに商品追加
        session.setAttribute("cartList", cartList);

        // カート画面へフォワード
        req.getRequestDispatcher("../../scoremanager/ecSite/ECcart.jsp").forward(req, res);
    }
}