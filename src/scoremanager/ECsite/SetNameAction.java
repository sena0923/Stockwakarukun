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

        HttpSession session = request.getSession();
        List<Cart> cartList = (List<Cart>) session.getAttribute("cartList");

        String goods_id = request.getParameter("goods_id");
        String can_name = request.getParameter("can_name"); // 入力文字

        for (Cart item : cartList) {
            if (item.getGoods_id().equals(goods_id)) {

                // 名入れ文字を保存
                item.setCan_name(can_name);

                // 文字が入っていれば true
                if (can_name != null && !can_name.isEmpty()) {
                    item.setNaireFlg(true);
                } else {
                    item.setNaireFlg(false);
                }

                break;
            }
        }


        session.setAttribute("cartList", cartList);

        request.getRequestDispatcher("ECcart.jsp").forward(request, response);
    }
}
