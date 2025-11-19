package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Ingoodsinventory;

public class In_Goods_InventoryDao extends Dao {

    public static void main(String[] args) {
        // TODO 自動生成されたメソッド・スタブ
    }

    /** 入居者rd_idから，該当入居者のストックを取得
     * @param rd_Id
     * @return
     * @throws Exception
     */
    public List<Ingoodsinventory> get(String rd_Id) throws Exception {

    	List<Ingoodsinventory> list = new ArrayList<>();
    	Ingoodsinventory ingoodsinventory  = null;
        Connection connection = getConnection();
        PreparedStatement statement = null;

        try {
            // 商品1件取得SQL
            String sql = "SELECT * FROM in_goods_inventory WHERE rd_id = ?";

            statement = connection.prepareStatement(sql);
            statement.setString(1, rd_Id);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
            	ingoodsinventory = new Ingoodsinventory();
            	ingoodsinventory.setGoods_inve_id(resultSet.getString("goods_inve_id"));
            	ingoodsinventory.setGoods_id(resultSet.getString("goods_id"));
            	ingoodsinventory.setRd_id(resultSet.getString("rd_id"));
            	ingoodsinventory.setGoods_inve_count(resultSet.getInt("goods_inve_count"));
            	ingoodsinventory.setPurchase_date(resultSet.getTimestamp("purchase_date"));
            	list.add(ingoodsinventory);
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

        return list;
    }
}

