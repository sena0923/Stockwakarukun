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

public class AddCartExecuteAction extends Action {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

        System.out.println("AddCartExecuteAction が呼ばれた");

        String goodsId = req.getParameter("goods_id");
        System.out.println("goodsId = " + goodsId);

        GoodsDao goodsDao = new GoodsDao();
        Goods goods = goodsDao.get(goodsId);

        HttpSession session = req.getSession();
        List<Cart> cartList = (List<Cart>) session.getAttribute("cartList");

        if (cartList == null) {
            cartList = new ArrayList<>();
        }

        // ★ goodsId または goods が null の場合は処理中断
        if (goodsId == null || goods == null) {
            session.setAttribute("cartAdded", false);
            res.sendRedirect("AllExecute.action");
            return;
        }

        // 既にカートにあるかチェック（goodsId を使う）
        boolean exists = false;
        for (Cart c : cartList) {
            if (c.getGoods_id().equals(goodsId)) {
                c.setQuantity(c.getQuantity() + 1);
                exists = true;
                break;
            }
        }

        if (!exists) {
            Cart cart = new Cart();
            cart.setGoods_id(goods.getGoods_id());
            cart.setGoods_name(goods.getGoods_name());
            cart.setPrice(goods.getPrice());
            cart.setQuantity(1);
            cartList.add(cart);
        }

        session.setAttribute("cartList", cartList);

        // ポップアップ用フラグ
        session.setAttribute("cartAdded", true);

        System.out.println("cartList size after add = " + cartList.size());
        // 商品一覧に戻る
        res.sendRedirect(req.getContextPath() + "/scoremanager/ECsite/AllExecute.action");
    }
}