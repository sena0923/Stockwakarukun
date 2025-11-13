package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Relatives;


public class RelativesDao extends Dao {

	public Relatives get(String rt_id) throws Exception {
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
			statement.setString(1, rt_id);
			// プリペアードステートメントを実行
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				// リザルトセットが存在する場合
				// 親族インスタンスに検索結果をセット
				relatives.setName(resultSet.getString("name"));
				relatives.setRt_id(resultSet.getString("rt_id"));
				relatives.setRd_id(resultSet.getString("rd_id"));
				relatives.setPassword(resultSet.getString("password"));

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
	public Relatives login(String rt_id, String password) throws Exception {
		// 親族クラスのインスタンスを取得
		Relatives relatives = get(rt_id);
		// 親族がnullまたはパスワードが一致しない場合
		if (relatives == null || !relatives.getPassword().equals(password)) {
			return null;
		}
		return relatives;
	}

	// save - 教師情報を登録または更新
	// 引数1 teacher - 登録したいデータの入った教師beanを指定 全てのデータ（ID, password, 名前, 学校, 管理者権限の有無）が揃っている必要がある
	public boolean save(Relatives relatives) throws Exception {
		// コネクションを確立
		Connection connection = getConnection();
		// プリペアードステートメント
		PreparedStatement statement = null;

		// 実行件数
		int count = 0;

		try {
			// データベースから教師を取得
			Relatives old = get(relatives.getRt_id());

			if (old == null) {
				// 教師が存在しなかった場合、教師を新規作成
				// プリペアードステートメントにINSERT文をセット
				statement = connection.prepareStatement("INSERT INTO RELATIVES(RT_ID, RD_ID, NAME, E_MAIL, PASSWORD) VALUES(?, ?, ?, ?, ?)");
				// プリペアードステートメントに値をバインド
				statement.setString(1, relatives.getRt_id());
				statement.setString(2, relatives.getRd_id());
				statement.setString(3, relatives.getName());
				statement.setString(4,relatives.getE_mail());
				statement.setString(5, relatives.getPassword());


			} else {
				// 教師が存在した場合、情報を更新
				// プリペアードステートメントにUPDATE文をセット
				statement = connection.prepareStatement("UPDATE RELATIVES SET E_MAIL = ?, PASSWORD = ?");
				// プリペアードステートメントに値をバインド
				statement.setString(1, relatives.getE_mail());
				statement.setString(2, relatives.getPassword());
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

