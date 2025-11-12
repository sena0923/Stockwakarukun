package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Goodsdescription;

public class Goods_DescriptionDao extends Dao {

    public static void main(String[] args) {
        // TODO 自動生成されたメソッド・スタブ
    }

    public Goodsdescription get(String goods_Id) throws Exception {

        Goodsdescription goodsdescri = null;
        Connection connection = getConnection();
        PreparedStatement statement = null;

        try {
            // 商品1件取得SQL
            String sql = "SELECT * FROM goods WHERE goods_id = ?";

            statement = connection.prepareStatement(sql);
            statement.setString(1, goods_Id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                goodsdescri = new Goodsdescription();

                goodsdescri.setGoods_id(resultSet.getString("goods_id"));
                goodsdescri.setGoods_dp(resultSet.getString("goods_dp"));
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

        return goodsdescri;
    }
}
