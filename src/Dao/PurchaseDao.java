package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class PurchaseDao extends Dao {

	public int insert(String rd_id, int totalPrice) throws Exception {
	    Connection con = getConnection();

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
}