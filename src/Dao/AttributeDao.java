package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Attribute;

public class AttributeDao extends Dao {

    public static void main(String[] args) {
        // TODO 自動生成されたメソッド・スタブ
    }

    public Attribute get(String attribute_Id) throws Exception {

        Attribute attribute = null;
        Connection connection = getConnection();
        PreparedStatement statement = null;

        try {
            // 商品1件取得SQL
            String sql = "SELECT * FROM attribute WHERE atteribute_id = ?";

            statement = connection.prepareStatement(sql);
            statement.setString(1, attribute_Id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                attribute = new Attribute();

                attribute.setAttribute_id(resultSet.getString("attribute_id"));
                attribute.setAttribute_name(resultSet.getString("attribute_name"));
                attribute.setAttribute_type(resultSet.getString("attribute_type"));
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

        return attribute;
    }
}
