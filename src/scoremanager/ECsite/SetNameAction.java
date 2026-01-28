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

        String goodsId = request.getParameter("goods_id");
        String naireText = request.getParameter("naire_text");

        for (Cart item : cartList) {
            if (item.getGoods_id().equals(goodsId)) {


                // 名入れ文字を保存





                /*
                 * 1.テーブルNAIREからidで一件データを抽出
                 * 2.CAN_NAMEの値をitem.setNaireFlgに代入する
                 *
                 */

                // 文字が入っていれば名入れON
                //２．にif文を持ってくる
//                if (naireText != null && !naireText.isEmpty()) {
//                    item.setNaireFlg(true);
//                } else {
//                    item.setNaireFlg(false);
//                }
////
                break;
            }
        }

        session.setAttribute("cartList", cartList);

        request.getRequestDispatcher("ECcart.jsp").forward(request, response);
    }
}
