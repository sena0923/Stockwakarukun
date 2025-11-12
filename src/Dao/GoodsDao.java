package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Goods;

public class GoodsDao extends Dao {

    /**
     * 商品IDから商品情報を1件取得する
     */
    public Goods get(String goods_Id) throws Exception {

        Goods goods = null;
        Connection connection = getConnection();
        PreparedStatement statement = null;

        try {
            // 商品1件取得SQL
            String sql = "SELECT * FROM goods WHERE goods_id = ?";

            statement = connection.prepareStatement(sql);
            statement.setString(1, goods_Id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                goods = new Goods();

                goods.setGoods_id(resultSet.getString("goods_id"));
                goods.setGoods_name(resultSet.getString("goods_name"));
                goods.setPrice(resultSet.getInt("price"));
                goods.setCategory_id(resultSet.getString("category_id"));
                goods.setCategory_name(resultSet.getString("category_name"));
                goods.setStock(resultSet.getInt("stock"));
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

        return goods;
    }
}
