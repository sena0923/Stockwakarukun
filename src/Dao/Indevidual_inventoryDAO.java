package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Indevidualinventory;

public class Indevidual_inventoryDAO extends Dao {

    public static void main(String[] args) {
        // TODO 自動生成されたメソッド・スタブ
    }

    public Indevidualinventory get(String Inve_name) throws Exception {

    	Indevidualinventory indevidual = null;
        Connection connection = getConnection();
        PreparedStatement statement = null;

        try {
            // 個人在庫取得SQL
            String sql = "SELECT * FROM Indevidual_inventory WHERE goods_id = ?";

            statement = connection.prepareStatement(sql);
            statement.setString(1, Inve_name);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
            	indevidual = new Indevidualinventory();

            	indevidual.setInve_name(resultSet.getString("inve_name"));
            	indevidual.setInve_count(resultSet.getInt("inve_count"));
            	indevidual.setRegi_date(resultSet.getTimestamp("regi_date"));
            }

        } catch (SQLException e) {
            throw new Exception("データ取得エラー", e);
        } finally {
            if (statement != null) {
                try { statement.close(); } catch (SQLException ignored) {}
            }
            if (connection != null) {
                try { connection.close(); } catch (SQLException ignored) {}
            }
        }

        return indevidual;
    }
}
