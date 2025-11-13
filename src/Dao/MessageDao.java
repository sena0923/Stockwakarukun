package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Message;

public class MessageDao extends Dao {

    public static void main(String[] args) {
        // TODO 自動生成されたメソッド・スタブ
    }

    public Message get(String message_id) throws Exception {

    	Message message = null;
        Connection connection = getConnection();
        PreparedStatement statement = null;

        try {
            // メッセージ取得SQL
            String sql = "SELECT * FROM message WHERE me_id";

            statement = connection.prepareStatement(sql);
            statement.setString(1, message_id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                message = new Message();

                message.setMessage_id(resultSet.getString("me_id"));
                message.setMessage(resultSet.getString("message"));
                message.setDa_ti(resultSet.getTimestamp("da_ti"));


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

        return message;
    }
}
