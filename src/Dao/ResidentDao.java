package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Resident;

public class ResidentDao extends Dao {

	public Resident get(String rd_id) throws Exception {
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
			statement.setString(1, rd_id);
			// プリペアードステートメントを実行
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				// リザルトセットが存在する場合
				// 入居者インスタンスに検索結果をセット
				resident.setName(resultSet.getString("name"));
				resident.setRd_id(resultSet.getString("rd_id"));
				resident.setPassword(resultSet.getString("password"));
				resident.setCourse_id(resultSet.getInt("course_id"));
				resident.setGender(resultSet.getString("gender"));

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
	 * 入居者の名前から，入居者情報を一件取得
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public List<Resident>  get2(String name) throws Exception {
		// リストを初期化
		List<Resident> list = new ArrayList<>();
		// コネクションを確立
		Connection connection = getConnection();
		// プリペアードステートメント
		PreparedStatement statement = null;

		try {
			// プリペアードステートメントにSQL文をセット
			statement = connection.prepareStatement("select * from Resident where name = ?");
			// プリペアードステートメントに入居者IDをバインド
			statement.setString(1, name);
			// プリペアードステートメントを実行
			ResultSet resultSet = statement.executeQuery();

			// リザルトセットを全権走査
			while (resultSet.next()) {
				// 学生インスタンスを初期化
				Resident resident = new Resident();
				// 学生インスタンスに検索結果をセット
				resident.setRd_id(resultSet.getString("rd_id"));
				resident.setName(resultSet.getString("name"));
				resident.setPassword(resultSet.getString("password"));
				resident.setCourse_id(resultSet.getInt("course_id"));
				resident.setGender(resultSet.getString("gender"));
				// リストに追加
				list.add(resident);
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

		return list;
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
	public Resident login(String rd_id, String password) throws Exception {
		// 入居者クラスのインスタンスを取得
		Resident resident = get(rd_id);
		// 入居者がnullまたはパスワードが一致しない場合
		if (resident == null || !resident.getPassword().equals(password)) {
			return null;
		}
		return resident;

	}


	private List<Resident> postFilter(ResultSet resultSet) throws Exception {

		// リストを初期化
		List<Resident> list = new ArrayList<>();
		try {
			// リザルトセットを全権走査
			while (resultSet.next()) {
				// 学生インスタンスを初期化
				Resident resident = new Resident();
				// 学生インスタンスに検索結果をセット
				resident.setRd_id(resultSet.getString("rd_id"));
				resident.setName(resultSet.getString("name"));
				resident.setPassword(resultSet.getString("password"));
				resident.setCourse_id(resultSet.getInt("course_id"));
				resident.setGender(resultSet.getString("gender"));
				// リストに追加
				list.add(resident);
			}
		} catch (SQLException | NullPointerException e) {
			e.printStackTrace();
		}

		return list;
	}

	//すべての入居者を，入居者インスタンスに保存。
	//すべての入居者を一括で表示したいときなどに利用。

	public List<Resident> getAll() throws Exception {
		List<Resident> list = new ArrayList<>();

		// データベースへのコネクションを確立
		Connection connection = getConnection();
		// プリペアードステートメント
		PreparedStatement statement = null;


		String sql = "SELECT * FROM resident";

		try {
			statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();

				while(resultSet.next()) {
					Resident resident = new Resident();
					resident.setRd_id(resultSet.getString("rd_id"));
					resident.setName(resultSet.getString("name"));
					resident.setPassword(resultSet.getString("password"));
					resident.setCourse_id(resultSet.getInt("course_id"));
					resident.setGender(resultSet.getString("gender"));
					list.add(resident);
				}
		} catch (Exception e) {
			e.printStackTrace(); // ログ出力
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

		return list;
	}


	// save - 入居者情報を登録または更新
	// 引数1 teacher - 登録したいデータの入った入居者beanを指定 全てのデータ（ID, password, 名前, 学校, 管理者権限の有無）が揃っている必要がある
	public boolean save(Resident resident) throws Exception {
		// コネクションを確立
		Connection connection = getConnection();
		// プリペアードステートメント
		PreparedStatement statement = null;

		// 実行件数
		int count = 0;

		try {
			// データベースから入居者を取得
			Resident old = get(resident.getRd_id());

			if (old == null) {
				// 入居者が存在しなかった場合、入居者を新規作成
				// プリペアードステートメントにINSERT文をセット
				statement = connection.prepareStatement("INSERT INTO RESIDENT(COURSE_ID, NAME, GENDER, RD_ID, PASSWORD) VALUES(?, ?, ?, ?, ?)");
				// プリペアードステートメントに値をバインド
				statement.setInt(1,resident.getCourse_id());
				statement.setString(2, resident.getName());
				statement.setString(3,resident.getGender());
				statement.setString(4, resident.getRd_id());
				statement.setString(5, resident.getPassword());



			} else {
				// 入居者が存在した場合、情報を更新
				// プリペアードステートメントにUPDATE文をセット
				statement = connection.prepareStatement("UPDATE RESIDENT SET COURSE_ID = ?, PASSWORD = ? WHERE RD_ID = ?");
				// プリペアードステートメントに値をバインド
				statement.setInt(1,resident.getCourse_id());
				statement.setString(2, resident.getPassword());
				statement.setString(3, resident.getRd_id());
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




