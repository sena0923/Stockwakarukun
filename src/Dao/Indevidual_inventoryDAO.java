package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Indevidualinventory;

public class Indevidual_inventoryDAO extends Dao {

    public static void main(String[] args) {
        // TODO 自動生成されたメソッド・スタブ
    }

    /* 入居者IDから，個人で登録したストックを取得する */
    public List<Indevidualinventory> get(String RD_ID) throws Exception {

    	List<Indevidualinventory> list = new ArrayList<>();
    	Indevidualinventory indevidualinventory = null;
        Connection connection = getConnection();
        PreparedStatement statement = null;

        try {
            // 個人在庫取得SQL
            String sql = "SELECT * FROM INDEVIDUAL_INVENTORY  WHERE rd_id = ?";

            statement = connection.prepareStatement(sql);
            statement.setString(1, RD_ID);

            ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				indevidualinventory = new Indevidualinventory();
				indevidualinventory.setRd_id(resultSet.getString("rd_id"));
				indevidualinventory.setInve_name(resultSet.getString("inve_name"));
				indevidualinventory.setInve_count(resultSet.getInt("inve_count"));
				indevidualinventory.setRegi_date(resultSet.getTimestamp("regi_date"));
				list.add(indevidualinventory);
			}



            /*
            if (resultSet.next()) {
            	indevidualinventory = new Indevidualinventory();

            	indevidualinventory.setRd_id(resultSet.getString("rd_id"));
            	indevidualinventory.setInve_name(resultSet.getString("inve_name"));
            	indevidualinventory.setInve_count(resultSet.getInt("inve_count"));
            	indevidualinventory.setRegi_date(resultSet.getTimestamp("regi_date"));
            	list.add(indevidualinventory);
            }else{
            	indevidualinventory = null;
            }*/

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
