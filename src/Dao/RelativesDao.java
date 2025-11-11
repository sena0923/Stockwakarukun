package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Relatives;

public class RelativesDao extends Dao {

	public Relatives get(String id) throws Exception {
		// 親族インスタンスを初期化
		Relatives relatives = new Relatives();
		// コネクションを確立
		Connection connection = getConnection();
		// プリペアードステートメント
		PreparedStatement statement = null;

		try {
			// プリペアードステートメントにSQL文をセット
			statement = connection.prepareStatement("select * from Relatives where rt_id=?");
			// プリペアードステートメントに親族IDをバインド
			statement.setString(1, id);
			// プリペアードステートメントを実行
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				// リザルトセットが存在する場合
				// 親族インスタンスに検索結果をセット
				relatives.setRt_id(resultSet.getString("rt_id"));
				relatives.setPassword(resultSet.getString("password"));
				relatives.setName(resultSet.getString("name"));
			} else {
				// リザルトセットが存在しない場合
				// 親族インスタンスにnullをセット
				relatives = null;
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

		return relatives;
	}

	/**
	 * loginメソッド 親族IDとパスワードで認証する
	 *
	 * @param id:String
	 *            親族ID
	 * @param password:String
	 *            パスワード
	 * @return 認証成功:親族クラスのインスタンス, 認証失敗:null
	 * @throws Exception
	 */
	public Relatives login(String id, String password) throws Exception {
		// 親族クラスのインスタンスを取得
		Relatives relatives = get(id);
		// 親族がnullまたはパスワードが一致しない場合
		if (relatives == null || !relatives.getPassword().equals(password)) {
			return null;
		}
		return relatives;

	}

}
