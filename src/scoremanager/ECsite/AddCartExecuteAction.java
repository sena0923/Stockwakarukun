package scoremanager.ECsite;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.CartDao;
import Dao.GoodsDao;
import bean.Cart;
import bean.Goods;
import bean.Resident;
import tool.Action;

public class AddCartExecuteAction extends Action {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

        String goodsId = req.getParameter("goods_id");
        System.out.println("goodsId = " + goodsId);

        GoodsDao goodsDao = new GoodsDao();
        Goods goods = goodsDao.get(goodsId);

        HttpSession session = req.getSession();
        List<Cart> cartList = (List<Cart>) session.getAttribute("cartList");
	    // ★ 入居者本人なら自動で selectedResident をセット
        Resident r = (Resident) req.getSession().getAttribute("selectedResident");
	    if (r != null) {
	        req.getSession().setAttribute("selectedResident", r);
	    }


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

                // ★ 在庫チェック（数量 + 1 が在庫を超えるか）
                if (c.getQuantity() + 1 > goods.getStock()) {
                    session.setAttribute("error", "在庫数を超えています（在庫: " + goods.getStock() + "）");
                    res.sendRedirect(req.getContextPath() + "/scoremanager/ECsite/AllExecute.action");
                    return;
                }

                c.setQuantity(c.getQuantity() + 1);
                exists = true;
                break;
            }
        }

        if (!exists) {

            // ★ 新規追加時も在庫チェック
            if (1 > goods.getStock()) {
                session.setAttribute("error", "在庫がありません");
                res.sendRedirect(req.getContextPath() + "/scoremanager/ECsite/AllExecute.action");
                return;
            }
        }

            /*
             * CartListを生成する
             * >>> CartDaoを使ってDBに書き込む
             * >>> CartDaoを使ってCartテーブルの情報をbeanに書き込む
             */


        Cart cart = new Cart();
        cart.setRd_id(r.getRd_id());
        cart.setGoods_id(goods.getGoods_id());
        cart.setGoods_name(goods.getGoods_name());
        cart.setPrice(goods.getPrice());
        cart.setQuantity(1);
        cartList.add(cart);

        //↑の項目が足りないのでエラーでるはず
        CartDao cd = new CartDao();
        cd.addItem(cart);



        //cartListを最新に更新
        cartList = cd.getCartList(r.getRd_id());

//        CartDao cartlist = new CartDao();
//        cartlist.setCart_id(cart.getCart_id());
//        cartlist.setRd_id(cart.getRd_id());
//        cartlist.setGoods_id(cart.getGoods_id());
//        cartlist.setGoods_name(cart.getGoods_name());
//        cartlist.setCourse_id(cart.getCourse_id());
//        cartlist.setQuantity(cart.getQuantity());
//        cartlist.setPrice(cart.getPrice());
//        cartlist.setDo_name(cart.getDo_name());
//



        // 削除
        session.removeAttribute("cartList");

        session.setAttribute("cartList", cartList);

        // ポップアップ用フラグ
        session.setAttribute("cartAdded", true);


        // 商品一覧に戻る
        res.sendRedirect(req.getContextPath() + "/scoremanager/ECsite/AllExecute.action");
    }
}