package scoremanager.ECsite;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Cart;
import tool.Action;

public class ConfirmAction extends Action {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

        HttpSession session = req.getSession();
        List<Cart> cartList = (List<Cart>) session.getAttribute("cartList");

        // カート空チェック
        if (cartList == null || cartList.isEmpty()) {
            req.setAttribute("error", "カートが空です");
            req.getRequestDispatcher("ECcart.jsp").forward(req, res);
            return;
        }

        // ★ 合計金額を再計算（名入れ込み）
        int totalPrice = 0;
        for (Cart c : cartList) {
            totalPrice += c.getPrice() * c.getQuantity();
        }

        // JSPへ渡す
        req.setAttribute("totalPrice", totalPrice);

        // 確認画面へ
        req.getRequestDispatcher("../ecSite/Confirm.jsp")
           .forward(req, res);
    }
}
