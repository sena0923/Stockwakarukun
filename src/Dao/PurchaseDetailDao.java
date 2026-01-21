package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Cart;
import bean.PurchaseDetail;

public class PurchaseDetailDao extends Dao {

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

	    Connection con = getConnectionEc();
	    PreparedStatement st = con.prepareStatement(sql);
	    st.setString(1, rdId);

	    ResultSet rs = st.executeQuery();

	    while (rs.next()) {
	        Cart c = new Cart();
	        c.setGoods_id(rs.getString("goods_id"));
	        c.setGoods_name(rs.getString("goods_name"));
	        c.setQuantity(rs.getInt("quantity"));
	        c.setPrice(rs.getInt("price"));
	        c.setCan_name(rs.getBoolean("can_name"));
	        list.add(c);
	    }

	    rs.close();
	    st.close();
	    con.close();

	    return list;
	}

	public List<PurchaseDetail> findByPurchaseId(String purchaseId) throws Exception {

	    List<PurchaseDetail> list = new ArrayList<>();

	    String sql = "SELECT d.quantity, d.price, i.item_name "
	               + "FROM purchase_detail d "
	               + "JOIN item i ON d.item_id = i.item_id "
	               + "WHERE d.purchase_id = ?";

	    Connection con = getConnectionEc();
	    PreparedStatement st = con.prepareStatement(sql);
	    st.setString(1, purchaseId);   // ← String のまま渡す

	    ResultSet rs = st.executeQuery();

	    while (rs.next()) {
	        PurchaseDetail detail = new PurchaseDetail();
	        detail.setItemName(rs.getString("item_name"));
	        detail.setQuantity(rs.getInt("quantity"));
	        detail.setPrice(rs.getInt("price"));
	        list.add(detail);
	    }

	    return list;
	}

}