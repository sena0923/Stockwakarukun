package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Resident;

public class ResidentDao extends Dao {

	public Resident get(String id) throws Exception {
		// 入居者インスタンスを初期化
		Resident resident = new Resident();
		// コネクションを確立
		Connection connection = getConnection();
		// プリペアードステートメント
		PreparedStatement statement = null;

		try {
			// プリペアードステートメントにSQL文をセット
			statement = connection.prepareStatement("select * from Resident where rd_id=?");
			// プリペアードステートメントに入居者IDをバインド
			statement.setString(1, id);
			// プリペアードステートメントを実行
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				// リザルトセットが存在する場合
				// 入居者インスタンスに検索結果をセット
				resident.setRd_id(resultSet.getString("rd_id"));
				resident.setPassword(resultSet.getString("password"));
				resident.setName(resultSet.getString("name"));
			} else {
				// リザルトセットが存在しない場合
				// 入居者インスタンスにnullをセット
				resident = null;
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

		return resident;
	}

	/**
	 * loginメソッド 入居者IDとパスワードで認証する
	 *
	 * @param id:String
	 *            入居者ID
	 * @param password:String
	 *            パスワード
	 * @return 認証成功:入居者クラスのインスタンス, 認証失敗:null
	 * @throws Exception
	 */
	public Resident login(String id, String password) throws Exception {
		// 入居者クラスのインスタンスを取得
		Resident resident = get(id);
		// 入居者がnullまたはパスワードが一致しない場合
		if (resident == null || !resident.getPassword().equals(password)) {
			return null;
		}
		return resident;

	}

	// save - 教師情報を登録または更新
	// 引数1 teacher - 登録したいデータの入った教師beanを指定 全てのデータ（ID, password, 名前, 学校, 管理者権限の有無）が揃っている必要がある
	public boolean save(Resident resident) throws Exception {
		// コネクションを確立
		Connection connection = getConnection();
		// プリペアードステートメント
		PreparedStatement statement = null;

		// 実行件数
		int count = 0;

		try {
			// データベースから教師を取得
			Resident old = get(resident.getrd_id());

			if (old == null) {
				// 教師が存在しなかった場合、教師を新規作成
				// プリペアードステートメントにINSERT文をセット
				statement = connection.prepareStatement("INSERT INTO RESIDENT(RD_ID, PASSWORD, NAME, SCHOOL_CD, ISADMIN) VALUES(?, ?, ?, ?, ?)");
				// プリペアードステートメントに値をバインド
				statement.setString(2, resident.getName());
				statement.setString(3,resident.getFname());
				statement.setString(4,resident.getGender());
				statement.setString(5, resident.getrd_id());
				statement.setString(6, resident.getPassword());


			} else {
				// 教師が存在した場合、情報を更新
				// プリペアードステートメントにUPDATE文をセット
				statement = connection.prepareStatement("UPDATE TEACHER SET PASSWORD = ?, NAME = ?, SCHOOL_CD = ?, ISADMIN = ? WHERE ID = ?");
				// プリペアードステートメントに値をバインド
				statement.setString(1, resident.getPassword());
				statement.setString(2, resident.getName());
				statement.setString(5, resident.getrd_id());
			}

			// プリペアードステートメントを実行
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
			// コネクションを閉じる
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException sqle) {
					throw sqle;
				}
			}
		}

		if (count == 1) {
			// 実行件数1件の場合
			return true;
		} else {
			// 実行件数がそれ以外の場合
			return false;
		}
	}


}



