package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Goodsattribute;

public class Goods_AttributeDao extends Dao {

    public static void main(String[] args) {
        // TODO 自動生成されたメソッド・スタブ
    }

    public Goodsattribute get(String attribute_Id) throws Exception {

        Goodsattribute goodsattribute = null;
        Connection connection = getConnection();
        PreparedStatement statement = null;

        try {
            // 商品1件取得SQL
            String sql = "SELECT * FROM goods_atteribute WHERE goods_ateribute = ?";

            statement = connection.prepareStatement(sql);
            statement.setString(1, attribute_Id); // ★修正：引数を使用

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                goodsattribute = new Goodsattribute();


                goodsattribute.setCourse_id(resultSet.getString("course_id"));
                goodsattribute.setCourse_name(resultSet.getString("course_name"));
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

        return goodsattribute;
    }
}
