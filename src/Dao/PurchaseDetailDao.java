package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import bean.Cart;

public class PurchaseDetailDao extends Dao {

    public void insert(int purchaseId, Cart cart) throws Exception {
        Connection con = getConnection();

        String sql = "INSERT INTO purchase_detail (purchase_id, goods_id, quantity, price) VALUES (?, ?, ?, ?)";
        PreparedStatement st = con.prepareStatement(sql);

        st.setInt(1, purchaseId);
        st.setString(2, cart.getGoods_id());
        st.setInt(3, cart.getQuantity());
        st.setInt(4, cart.getPrice());

        st.executeUpdate();

        st.close();
        con.close();
    }
}