package scoremanager.ECsite;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.GoodsDao;
import bean.Cart;
import bean.Goods;
import tool.Action;

public class CartExecuteAction extends Action {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String goodsId = req.getParameter("goods_id");

        // 商品情報を取得
        GoodsDao goodsDao = new GoodsDao();
        Goods goods = goodsDao.get(goodsId);

        HttpSession session = req.getSession();
        List<Cart> cartList = (List<Cart>) session.getAttribute("cartList");

        if (cartList == null) {
            cartList = new ArrayList<>();
        }

        if (goods == null) {
            // 商品が存在しない場合の処理
            req.setAttribute("errorMessage", "商品が見つかりません: " + goodsId);
            req.getRequestDispatcher("../../scoremanager/ecSite/error.jsp").forward(req, res);
            return;
        }

        // Goods → Cart に詰め替え
        Cart cart = new Cart();
        cart.setGoods_id(goods.getGoods_id());
        cart.setGoods_name(goods.getGoods_name()); // CartにgoodsNameフィールドを追加済み
        cart.setPrice(goods.getPrice());
        cart.setQuantity(1); // 初期数量は1

        cartList.add(cart);
        session.setAttribute("cartList", cartList);

        // 合計金額計算
        int totalPrice = 0;
        for (Cart c : cartList) {
            totalPrice += c.getPrice() * c.getQuantity();
        }
        req.setAttribute("cartList", cartList);
        req.setAttribute("totalPrice", totalPrice);

        // カート画面へフォワード
        req.getRequestDispatcher("../../scoremanager/ecSite/ECcart.jsp").forward(req, res);
    }
}