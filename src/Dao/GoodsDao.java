package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Goods;

public class GoodsDao extends Dao {

    /**
     * 商品IDから商品情報を1件取得
     */
    public Goods get(String goods_Id) throws Exception {

        Goods goods = null;
        Connection connection = getConnectionEc();
        PreparedStatement statement = null;

        try {
            String sql = "SELECT goods.goods_id , goods.goods_name , goods.PRICE  , GOODS_CATEGORY.CATEGORY_NAME , goods.stock FROM goods join GOODS_CATEGORY on GOODS.CATEGORY_ID = GOODS_CATEGORY.CATEGORY_ID  WHERE goods_id = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, goods_Id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                goods = new Goods();
                goods.setGoods_id(resultSet.getString("goods_id"));
                goods.setGoods_name(resultSet.getString("goods_name"));
                goods.setPrice(resultSet.getInt("price"));
                goods.setCategory_name(resultSet.getString("category_name"));
                goods.setStock(resultSet.getInt("stock"));
            }

        } catch (SQLException e) {
            throw new Exception("データ取得エラー", e);
        } finally {
            if (statement != null) try { statement.close(); } catch (SQLException ignored) {}
            if (connection != null) try { connection.close(); } catch (SQLException ignored) {}
        }

        return goods;
    }

    /**
     * 商品を全件取得
     */
    public List<Goods> getAllGoods() throws Exception {

        List<Goods> list = new ArrayList<>();
        Connection connection = getConnectionEc();
        PreparedStatement statement = null;

        try {
            String sql = "SELECT * FROM goods ORDER BY goods_id";
            statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Goods goods = new Goods();
                goods.setGoods_name(resultSet.getString("goods_name"));
                goods.setPrice(resultSet.getInt("price"));
                goods.setStock(resultSet.getInt("stock"));
                goods.setImage_path(resultSet.getString("goods_imagepath"));
//                System.out.println("GoodsDao:goods_imagepath:" + resultSet.getString("goods_imagepath"));
                list.add(goods);
            }

        } catch (SQLException e) {
            throw new Exception("全件データ取得エラー", e);
        } finally {
            if (statement != null) try { statement.close(); } catch (SQLException ignored) {}
            if (connection != null) try { connection.close(); } catch (SQLException ignored) {}
        }

        return list;
    }


    /**
     * カテゴリーIDで商品一覧を取得
     */
    public List<Goods> getGoodsByCategory(String categoryId) throws Exception {
        List<Goods> list = new ArrayList<>();
        Connection connection = getConnectionEc();
        PreparedStatement statement = null;

        try {
            String sql = "SELECT g.goods_id, g.goods_name, g.price, g.stock, g.goods_imagepath, c.category_name " +
                         "FROM goods g JOIN goods_category c ON g.category_id = c.category_id " +
                         "WHERE g.category_id = ? ORDER BY g.goods_id";

            statement = connection.prepareStatement(sql);
            statement.setString(1, categoryId);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Goods goods = new Goods();
                goods.setGoods_name(resultSet.getString("goods_name"));
                goods.setPrice(resultSet.getInt("price"));
                goods.setStock(resultSet.getInt("stock"));

                list.add(goods);
            }

        } finally {
            if (statement != null) try { statement.close(); } catch (SQLException ignored) {}
            if (connection != null) try { connection.close(); } catch (SQLException ignored) {}
        }

        return list;
    }

}
