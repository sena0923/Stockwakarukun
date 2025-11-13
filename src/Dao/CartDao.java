package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Cart;

public class CartDao extends Dao {

    public static void main(String[] args) {
        // TODO 自動生成されたメソッド・スタブ
    }

    public Cart get(String course_Id) throws Exception {

        Cart Cart = null;
        Connection connection = getConnection();
        PreparedStatement statement = null;

        try {
            // 商品1件取得SQL
            String sql = "SELECT * FROM crat WHERE goods_id = ?";

            statement = connection.prepareStatement(sql);
            statement.setString(1, course_Id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Cart = new Cart();

                Cart.setCourse_id(resultSet.getString("course_id"));
                Cart.setRd_id(resultSet.getString("rd_id"));
                Cart.setGoods_id(resultSet.getString("goods_id"));
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

        return Cart;
    }
}
