package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Purchasehistory;

public class Purchase_HistoryDao extends Dao {

    public static void main(String[] args) {
        // TODO 自動生成されたメソッド・スタブ
    }

    public Purchasehistory get(String payment_Id) throws Exception {

    	Purchasehistory purchasehistory = null;
        Connection connection = getConnection();
        PreparedStatement statement = null;

        try {
            // 支払い方法1件取得SQL
            String sql = "SELECT * FROM paymentmethod WHERE payment_id = ?";

            statement = connection.prepareStatement(sql);
            statement.setString(1, payment_Id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
            	purchasehistory = new Purchasehistory();

            	purchasehistory.setPayment_id(resultSet.getString("payment_id"));
            	purchasehistory.setRd_id(resultSet.getString("rd_id"));
            	purchasehistory.setGoods_id(resultSet.getString("goods_id"));
            	purchasehistory.setPurchase_date(resultSet.getInt("puchase_id"));
            	purchasehistory.setGoods_inve_count(resultSet.getInt("goods_inve_count"));
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

        return purchasehistory;
    }
}
