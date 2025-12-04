package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Message_choice;

public class Message_choiceDao extends Dao {

    public static void main(String[] args) {
        // TODO 自動生成されたメソッド・スタブ
    }

    /**
     * 親族IDからその親族に送信されたメッセージをリストで取得
     * @param cg_num
     * @param rd_id
     * @return
     * @throws Exception
     */
    public List<Message_choice> get(String me_id) throws Exception {

    	Message_choice message_choice = null;
        Connection connection = getConnection();
        PreparedStatement statement = null;
        List<Message_choice> list = new ArrayList<>();

        try {
            // メッセージ取得SQL
            String sql = "SELECT * FROM message_choice WHERE me_id = ?";

            statement = connection.prepareStatement(sql);
            statement.setString(1, me_id);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                message_choice = new Message_choice();

                message_choice.setMe_id(resultSet.getInt("me_id"));
                message_choice.setChoise_num(resultSet.getInt("choise_num"));
                message_choice.setChoise(resultSet.getBoolean("choise"));
                //リストに追加
                list.add(message_choice);
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

        return list;
    }

    public boolean save(Message_choice message_choice) throws Exception {
    	String sql = "INSERT INTO MESSAGE_CHOICE (me_id, choise_num, choise) VALUES ( ?, ?, ?)";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, message_choice.getMe_id());
            statement.setInt(2, message_choice.getChoise_num());
            statement.setBoolean(3, message_choice.getChoise());

            int count = statement.executeUpdate();
            return count == 1;
        } catch (SQLException e) {
            throw new Exception("メッセージ保存エラー", e);
        }
    }


}
