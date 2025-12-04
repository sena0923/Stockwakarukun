package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Message;


public class MessageDao extends Dao {

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
	public List<Message> get(String rt_id) throws Exception {

    	Message message = null;
        Connection connection = getConnection();
        PreparedStatement statement = null;
        List<Message> list = new ArrayList<>();

        try {
            // メッセージ取得SQL
            String sql = "SELECT * FROM message WHERE rt_id = ?";

            statement = connection.prepareStatement(sql);
            statement.setString(1, rt_id);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                message = new Message();

                message.setMessage_id(resultSet.getString("me_id"));
                message.setCg_id(resultSet.getString("cg_num"));
                message.setRt_id(resultSet.getString("rt_id"));
                message.setMessage(resultSet.getString("message"));
                message.setDa_ti(resultSet.getTimestamp("da_ti"));
                message.setTitle(resultSet.getString("title"));
                //リストに追加
                list.add(message);
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

	public Message getone(String me_id) throws Exception {

    	Message message = new Message();
        Connection connection = getConnection();
        PreparedStatement statement = null;

        try {
            // メッセージ取得SQL
            String sql = "SELECT * FROM message WHERE me_id = ?";

            statement = connection.prepareStatement(sql);
            statement.setString(1, me_id);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                message = new Message();

                message.setMessage_id(resultSet.getString("me_id"));
                message.setCg_id(resultSet.getString("cg_num"));
                message.setRt_id(resultSet.getString("rt_id"));
                message.setMessage(resultSet.getString("message"));
                message.setDa_ti(resultSet.getTimestamp("da_ti"));
                message.setTitle(resultSet.getString("title"));
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



	public int save(Message message) throws Exception {
	    String sql = "INSERT INTO MESSAGE (cg_num, rt_id, message, da_ti, title) VALUES ( ?, ?, ?, ?, ?)";

	    try (Connection connection = getConnection();
	         PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

	        statement.setString(1, message.getCg_id());
	        statement.setString(2, message.getRt_id());
	        statement.setString(3, message.getMessage());
	        statement.setTimestamp(4, new java.sql.Timestamp(message.getDa_ti().getTime()));
	        statement.setString(5, message.getTitle());

	        int count = statement.executeUpdate();
	        if (count != 1) {
	            throw new Exception("Message の INSERT に失敗しました。");
	        }

	        ResultSet keys = statement.getGeneratedKeys();
	        if (keys.next()) {
	            return keys.getInt(1); // ← これが me_id !!
	        } else {
	            throw new Exception("自動採番された me_id を取得できませんでした。");
	        }

	    } catch (SQLException e) {
	        throw new Exception("メッセージ保存エラー", e);
	    }
	}


}
