package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Paymentmethod;

public class Payment_mehodDao extends Dao {

    public static void main(String[] args) {
        // TODO 自動生成されたメソッド・スタブ
    }

    public Paymentmethod get(String payment_Id) throws Exception {

        Paymentmethod paymentmethod = null;
        Connection connection = getConnection();
        PreparedStatement statement = null;

        try {
            // 支払い方法1件取得SQL
            String sql = "SELECT * FROM paymentmethod WHERE payment_id = ?";

            statement = connection.prepareStatement(sql);
            statement.setString(1, payment_Id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                paymentmethod = new Paymentmethod();

                paymentmethod.setPayment_id(resultSet.getString("payment_id"));
                paymentmethod.setPayment(resultSet.getString("payment"));
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

        return paymentmethod;
    }
}
