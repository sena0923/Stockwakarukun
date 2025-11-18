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


	public boolean update(String rd_id , String inve_name , int inve_count) throws Exception {


		// プリペアードステートメント
		PreparedStatement statement = null;
	    int count = 0;

	    try {Connection connection = getConnection();
	    	/**
	        * 既存データの確認
	    	*Indevidualinventory existing = get(indevidualinventory.getRd_id(), indevidualinventory.getInve_name(), indevidualinventory.getInve_count(), indevidualinventory.getRegi_date());
	    	**/
			// UPDATE
			statement = connection.prepareStatement(
				"UPDATE INDEVIDUAL_INVENTORY SET INVE_COUNT = ? , REGI_DATE = ?  WHERE rd_id = ? and INVE_NAME  = ? ;"
			);
			statement.setInt(1, inve_count);
			// 現在日付をセット
			java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());
			statement.setDate(2, currentDate);
			statement.setString(3, rd_id);
			statement.setString(4, inve_name);
			count = statement.executeUpdate();
	    } catch (Exception e) {
			throw e;
		} finally {
			// プリペアードステートメントを閉じる
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException sqle) {
					throw sqle;
				}
			}
			/*
			// コネクションを閉じる
			if (connection != null) {
				try {
					connection.close();

				} catch (SQLException sqle) {
					throw sqle;
				}
			}
			*/
		}

		if (count > 0) {
			// 実行件数が1件以上ある場合
			return true;
		} else {
			// 実行件数が0件の場合
			return false;
		}
	}

	public boolean save(List<Indevidualinventory> list)throws Exception{
		// コネクションを確立
		Connection connection = getConnection();
		// プリペアードステートメント
		PreparedStatement statement = null;
		// 実行件数
		int count = 0;

		try{
			//プリペアードステートメントにinsert文をセット
			statement = connection.prepareStatement
				( "insert into INDEVIDUAL_INVENTORY (RD_ID , INVE_NAME , INVE_COUNT , REGI_DATE) values (? , ? , ? , ? )");


			for (Indevidualinventory indevidualinventory : list) {
				statement.setString(1, indevidualinventory.getRd_id());
				statement.setString(2, indevidualinventory.getInve_name());
				statement.setInt(3, indevidualinventory.getInve_count());
				// 現在日付をセット
				java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());
				statement.setDate(4, currentDate);
				count += statement.executeUpdate(); // ←これが必須
			}
		} catch (Exception e) {
			throw e;
		} finally {
			// プリペアードステートメントを閉じる
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException sqle) {
					throw sqle;
				}
			}
			// コネクションを閉じる
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException sqle) {
					throw sqle;
				}
			}
		}

		if (count > 0) {
			// 実行件数が1件以上ある場合
			return true;
		} else {
			// 実行件数が0件の場合
			return false;
		}
	}

}
