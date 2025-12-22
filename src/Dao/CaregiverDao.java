package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Caregiver;
public class CaregiverDao extends Dao {

    /**
     * 介護士情報をIDで取得
     * @param id 介護士ID
     * @return 介護士情報:存在しない場合はnull
     * @throws Exception
     */
    public Caregiver get(String CG_NUM) throws Exception {
    	Caregiver caregiver = new Caregiver();
    	Connection connection = getConnection();
    	PreparedStatement statement = null;
        try {

        	statement = connection.prepareStatement("SELECT * FROM caregiver WHERE CG_NUM = ? ");
            statement.setString(1, CG_NUM);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                caregiver.setName(resultSet.getString("name"));
                caregiver.setStaffid(resultSet.getString("cg_num"));
                caregiver.setPassword(resultSet.getString("password"));
            } else {
            	caregiver = null;
            }
        } catch (SQLException e) {
            throw new Exception("データ取得エラー", e);
        }

       return caregiver;
    }
    /**
     * ログイン認証
     *
     * @param staffId  介護士ID
     * @param password パスワード
     * @return 認証成功:介護士クラス, 失敗:null
     * @throws Exception
     */
    public Caregiver login(String staffId, String password) throws Exception {
        Caregiver caregiver = get(staffId);

        if (caregiver == null || !caregiver.getPassword().equals(password)) {
            return null;
        }

        return caregiver;
    }


		public boolean save(Caregiver caregiver) throws Exception {
			// コネクションを確立
			Connection connection = getConnection();
			// プリペアードステートメント
			PreparedStatement statement = null;

			// 実行件数
			int count = 0;

			try {
				// データベースから介護士を取得
				Caregiver old = get(caregiver.getStaffid());

				if (old == null) {
					// 介護士が存在しなかった場合、介護士を新規作成
					// プリペアードステートメントにINSERT文をセット
					statement = connection.prepareStatement("INSERT INTO CAREGIVER  (cg_num,  NAME, password) VALUES(?, ? ,?)");
					// プリペアードステートメントに値をバインド
					statement.setString(1, caregiver.getStaffid());
					statement.setString(2, caregiver.getName());
					statement.setString(3, caregiver.getPassword());


				} else {
					// 介護士が存在した場合、情報を更新
					// プリペアードステートメントにUPDATE文をセット
					statement = connection.prepareStatement("UPDATE CAREGIVER SET NAME = ? , password = ? where cg_num = ? ;");
					// プリペアードステートメントに値をバインド
					statement.setString(1, caregiver.getName());
					statement.setString(2, caregiver.getPassword());
					statement.setString(3, caregiver.getStaffid());
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