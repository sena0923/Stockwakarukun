package scoremanager.ECsite;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Cart;
import tool.Action;

public class SetNameAction extends Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        List<Cart> cartList = (List<Cart>) session.getAttribute("cartList");

        // 対象商品
        String goodsId = request.getParameter("goods_id");

        // 名入れ単価
        final int NAIRE_PRICE = 300;

        // チェックボックス状態
        boolean canName = request.getParameter("can_name") != null;

        for (Cart item : cartList) {

            if (item.getGoods_id().equals(goodsId)) {

                int quantity = item.getQuantity();

                // 名入れON（まだ未設定）
                if (canName && item.isCan_name() == 0) {
                    item.setPrice(item.getPrice() + NAIRE_PRICE);
                    item.setCan_name(1);
                }

                // 名入れOFF（すでに設定済み）
                if (!canName && item.isCan_name() == 1) {
                    item.setPrice(item.getPrice() - NAIRE_PRICE);
                    item.setCan_name(0);
                }
            }
        }

        // 合計金額を再計算
        int totalPrice = 0;
        for (Cart c : cartList) {
            totalPrice += c.getPrice() * c.getQuantity();
        }

        // セッション＆リクエスト更新
        session.setAttribute("cartList", cartList);
        request.setAttribute("totalPrice", totalPrice);

        // ★ Confirmには行かず、カート画面へ戻す
        request.getRequestDispatcher("/scoremanager/ecSite/ECcart.jsp")
               .forward(request, response);
    }
}
