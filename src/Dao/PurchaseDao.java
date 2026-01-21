package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.Purchase;

public class PurchaseDao extends Dao {

	public int insert(String rd_id, int totalPrice) throws Exception {
	    Connection con = getConnectionEc();

	    String sql = "INSERT INTO purchase (rd_id, total_price) VALUES (?, ?)";
	    PreparedStatement st = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

	    st.setString(1, rd_id);
	    st.setInt(2, totalPrice);

	    st.executeUpdate();

	    ResultSet rs = st.getGeneratedKeys();
	    int purchaseId = 0;
	    if (rs.next()) {
	        purchaseId = rs.getInt(1);
	    }

	    st.close();
	    con.close();
	    return purchaseId;
	}

	public List<Purchase> findByResident(String residentId) throws Exception {

	    List<Purchase> list = new ArrayList<>();
	    Connection con = getConnectionEc();

	    String sql = "SELECT * FROM purchase WHERE rd_id = ? ORDER BY purchase_date DESC";

	    PreparedStatement st = con.prepareStatement(sql);
	    st.setString(1, residentId);   // ← String のまま渡す

	    ResultSet rs = st.executeQuery();

	    while (rs.next()) {
	        Purchase p = new Purchase();
	        p.setPurchaseId(rs.getString("purchase_id"));
	        p.setPurchaseDate(rs.getTimestamp("purchase_date"));
	        list.add(p);
	    }

	    return list;
	}
}