package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Sin_Message_choiceDao extends Dao {

	/**
	 * 返信が既に存在するか確認
	 */
	public boolean existsByMeId(int meId) throws Exception {

		Connection con = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql =
			"SELECT 1 FROM SIN_MESSAGE_CHOICE WHERE ME_ID = ?";

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, meId);
			rs = ps.executeQuery();
			return rs.next();

		} finally {
			if (rs != null) rs.close();
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}

	/**
	 * 新規返信（INSERT）
	 */
	public void insert(int meId, String reply) throws Exception {

		Connection con = getConnection();
		PreparedStatement ps = null;

		String sql =
			"INSERT INTO SIN_MESSAGE_CHOICE (ME_ID, SIN_CHOISE) " +
			"VALUES (?, ?)";

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, meId);
			ps.setString(2, reply);
			ps.executeUpdate();

		} finally {
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}

	/**
	 * 返信更新（UPDATE）
	 */
	public void update(int meId, String reply) throws Exception {

		Connection con = getConnection();
		PreparedStatement ps = null;

		String sql =
			"UPDATE SIN_MESSAGE_CHOICE " +
			"SET SIN_CHOISE = ? " +
			"WHERE ME_ID = ?";

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, reply);
			ps.setInt(2, meId);
			ps.executeUpdate();

		} finally {
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
}
