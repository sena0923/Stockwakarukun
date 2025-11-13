package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Ingoodsinventory;

public class In_Goods_InventoryDao extends Dao {

    public static void main(String[] args) {
        // TODO 自動生成されたメソッド・スタブ
    }

    public Ingoodsinventory get(String goods_Id) throws Exception {

    	Ingoodsinventory ingoodsinventory  = null;
        Connection connection = getConnection();
        PreparedStatement statement = null;

        try {
            // 商品1件取得SQL
            String sql = "SELECT * FROM goods WHERE goods_id = ?";

            statement = connection.prepareStatement(sql);
            statement.setString(1, goods_Id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
            	ingoodsinventory = new Ingoodsinventory();
            	ingoodsinventory.setGoods_inve_id(resultSet.getString("goods_inve_id"));
            	ingoodsinventory.setGoods_id(resultSet.getString("goods_id"));
            	ingoodsinventory.setRd_id(resultSet.getString("rd_id"));
            	ingoodsinventory.setGoods_inve_count(resultSet.getInt("goods_inve_cose_id"));
            	ingoodsinventory.setPurchase_date(resultSet.getTimestamp("purchase_date"));
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

        return ingoodsinventory;
    }
}

