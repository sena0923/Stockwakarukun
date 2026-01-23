package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Cart;
import bean.PurchaseDetail;

public class PurchaseDetailDao extends Dao {

    /** カート画面用：購入履歴表示（use_name追加） */
    public List<Cart> getPurchaseDetailList(String rdId) throws Exception {

        List<Cart> list = new ArrayList<>();

        String sql =
            "SELECT " +
            " pd.goods_id, pd.quantity, pd.price, " +
            " g.goods_name, g.can_name " +
            "FROM purchase_detail pd " +
            "JOIN goods g ON pd.goods_id = g.goods_id " +
            "JOIN purchase p ON pd.purchase_id = p.purchase_id " +
            "WHERE p.rd_id = ?";

        try (Connection con = getConnectionEc();
             PreparedStatement st = con.prepareStatement(sql)) {

            st.setString(1, rdId);
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    Cart c = new Cart();
                    c.setGoods_id(rs.getString("goods_id"));
                    c.setGoods_name(rs.getString("goods_name"));
                    c.setQuantity(rs.getInt("quantity"));
                    c.setPrice(rs.getInt("price"));
                    c.setCan_name(rs.getBoolean("can_name"));
                    list.add(c);
                }
            }
        }

        return list;
    }

    /** 購入確定時に purchase_detail に登録 */
    public void insert(int purchaseId, Cart cart) throws Exception {

        String sql = "INSERT INTO purchase_detail " +
                     "(purchase_id, goods_id, quantity, price) " +
                     "VALUES (?, ?, ?, ?)";

        try (Connection con = getConnectionEc();
             PreparedStatement st = con.prepareStatement(sql)) {

            st.setInt(1, purchaseId);
            st.setString(2, cart.getGoods_id());
            st.setInt(3, cart.getQuantity());
            st.setInt(4, cart.getPrice());

            st.executeUpdate();
        }
    }

    /** 過去購入履歴用（変更なし） */
    public List<PurchaseDetail> findByPurchaseId(int purchaseId) throws Exception {

        List<PurchaseDetail> list = new ArrayList<>();

        String sql = "SELECT d.QUANTITY, d.PRICE, g.GOODS_NAME "
                   + "FROM purchase_detail d "
                   + "JOIN goods g ON d.GOODS_ID = CAST(g.GOODS_ID AS INTEGER) "
                   + "WHERE d.PURCHASE_ID = ?";

        try (Connection con = getConnectionEc();
             PreparedStatement st = con.prepareStatement(sql)) {

            st.setInt(1, purchaseId);

            try (ResultSet rs = st.executeQuery()) {

                while (rs.next()) {
                    PurchaseDetail detail = new PurchaseDetail();
                    detail.setItemName(rs.getString("GOODS_NAME"));
                    detail.setQuantity(rs.getInt("QUANTITY"));
                    detail.setPrice(rs.getInt("PRICE"));
                    list.add(detail);
                }
            }
        }

        System.out.println("PurchaseDetailDao: purchaseId=" + purchaseId
                           + " / detail size=" + list.size());

        return list;
    }


}
