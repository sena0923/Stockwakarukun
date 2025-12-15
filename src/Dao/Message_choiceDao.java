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

    /**
     * 返信の単一取得
     *
     * @param meId
     * @return
     * @throws Exception
     */

	public Message_choice getOneByMeId(int meId) throws Exception {
		String sql = "SELECT me_id, choise_num, choise FROM message_choice WHERE me_id = ?";
		try (Connection connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(sql)) {

			ps.setInt(1, meId);

			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					Message_choice mc = new Message_choice();
					mc.setMe_id(rs.getInt("me_id"));
					mc.setChoise_num(rs.getInt("choise_num"));

					Object choiseObj = rs.getObject("choise");
					mc.setChoise(choiseObj == null ? null : rs.getBoolean("choise"));

					return mc;
				}
				return null;
			}
		} catch (SQLException e) {
			throw new Exception("メッセージチョイス取得エラー", e);
		}
	}


    /**
     * メッセージが作成されたとき，自動で作成する
     * メッセージ作成時は返信はされていない為，choiceはnullになる
     *
     *
     *
     * @param message_choice
     * @return
     * @throws Exception
     */
    public boolean save(Message_choice message_choice) throws Exception {

        String sql = "INSERT INTO MESSAGE_CHOICE (me_id, choise_num, choise) VALUES (?, ?, ?)";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            // me_id
            statement.setInt(1, message_choice.getMe_id());

            // choise_num（1 or 2）
            int choiceNum = message_choice.getChoise_num();
            statement.setInt(2, choiceNum);

            // ★ 作成時は必ず NULL を入れる（返信時に更新）
            statement.setNull(3, java.sql.Types.BOOLEAN);

            int count = statement.executeUpdate();
            return count == 1;

        } catch (SQLException e) {
            throw new Exception("メッセージ保存エラー", e);
        }
    }


    /**
     * 親族が返信するときに，choiceをupdateする
     * １[Yes or No] => yesを選択=true  /  noを選択=false
     * ２[確認しました] => チェックボタンをクリック=true
     *
     * ===★親族が返信して始めて，メッセージチョイスデータテーブルのchoiceにデータが入る★===
     *
     * @param meId
     * @param choiceValue
     * @return
     * @throws Exception
     */
	public boolean updateChoiceValue(int meId, Boolean choiceValue) throws Exception {
		String sql = "UPDATE MESSAGE_CHOICE SET choise = ? WHERE me_id = ?";

		try (Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(sql)) {

			if (choiceValue == null) {
				statement.setNull(1, java.sql.Types.BOOLEAN);
			} else {
				statement.setBoolean(1, choiceValue);
			}
			statement.setInt(2, meId);

			int count = statement.executeUpdate();
			return count == 1;

		} catch (SQLException e) {
			throw new Exception("メッセージチョイス更新エラー", e);
		}
	}

}
