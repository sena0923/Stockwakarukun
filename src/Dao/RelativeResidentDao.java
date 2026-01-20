package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Resident;

public class RelativeResidentDao extends Dao {

    // 親族IDに紐づく入居者一覧を取得（relatives テーブルを使用）
    public List<Resident> findByRelativeId(String relativeId) throws Exception {

        Connection con = getConnection();  // EC側DB

        // relatives テーブルに rd_id が入っている前提
        String sql =
            "SELECT r.* FROM resident r " +
            "JOIN relatives rel ON r.rd_id = rel.rd_id " +
            "WHERE rel.rt_id = ?";

        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, relativeId);

        ResultSet rs = st.executeQuery();

        List<Resident> list = new ArrayList<>();

        while (rs.next()) {
            Resident resident = new Resident();
            resident.setRd_id(rs.getString("rd_id"));
            resident.setName(rs.getString("name"));
            resident.setCourse_id(rs.getInt("course_id"));
            resident.setGender(rs.getString("gender"));
            resident.setPassword(rs.getString("password"));
            list.add(resident);
        }

        st.close();
        con.close();
        return list;
    }
}