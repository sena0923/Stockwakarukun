package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Course;

public class CourseDao extends Dao {

    /**
     * コースIDからコース情報を1件取得
     */
    public Course get(int course_id) throws Exception {

        Course course = null;
        Connection connection = getConnection();
        PreparedStatement statement = null;

        try {
            String sql = "SELECT COURSE_ID , COURSE_NAME FROM COURSE  WHERE COURSE_ID = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, course_id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                course = new Course();
                course.setCourse_id(resultSet.getInt("course_id"));
                course.setCourse_name(resultSet.getString("course_name"));
            }

        } catch (SQLException e) {
            throw new Exception("データ取得エラー", e);
        } finally {
            if (statement != null) try { statement.close(); } catch (SQLException ignored) {}
            if (connection != null) try { connection.close(); } catch (SQLException ignored) {}
        }

        return course;
    }
}
