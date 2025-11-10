package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.CaregiverLogin;

public class CaregiverLoginDao extends Dao {

    /**
     * 介護士情報をIDで取得
     *
     * @param id 介護士ID
     * @return 介護士情報:存在しない場合はnull
     * @throws Exception
     */
    public CaregiverLogin get(String staffId) throws Exception {
        CaregiverLogin caregiver = null;

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT * FROM caregiverlogin WHERE staffid = ?")) {

            statement.setString(1, staffId);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    caregiver = new CaregiverLogin();
                    caregiver.setName(resultSet.getString("name"));
                    caregiver.setStaffId(resultSet.getString("staffid"));
                    caregiver.setFacilityPassword(resultSet.getString("facilitypassword"));
                    caregiver.setPassword(resultSet.getString("password"));
                }
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
    public CaregiverLogin login(String staffId, String password) throws Exception {
        CaregiverLogin caregiver = get(staffId);

        if (caregiver == null || !caregiver.getPassword().equals(password)) {
            return null;
        }

        return caregiver;
    }
}
