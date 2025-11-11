package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Caregiver;
public class CaregiverDao extends Dao {

    /**
     * 介護士情報をIDで取得
     *
     * @param id 介護士ID
     * @return 介護士情報:存在しない場合はnull
     * @throws Exception
     */
    public Caregiver get(String staffId) throws Exception {

    	Caregiver caregiver = new Caregiver();

    	Connection connection = getConnection();

    	PreparedStatement statement = null;


        try {
        	statement = connection.prepareStatement("#");

            statement.setString(1, staffId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                caregiver.setName(resultSet.getString("name"));
                caregiver.setStaffid(resultSet.getString("staffid"));
                caregiver.setFacilityPassword(resultSet.getString("facilitypassword"));
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
}
