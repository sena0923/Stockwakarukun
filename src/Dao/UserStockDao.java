package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Goods;
import bean.UserStock;

public class UserStockDao extends Dao {

    /** rd_id の ECストック一覧を取得 */
    public List<UserStock> get(String rdId) throws Exception {

        List<UserStock> list = new ArrayList<>();

        String sql =
            "SELECT us.id, us.rd_id, us.goods_id, us.quantity, g.goods_name " +
            "FROM user_stock us " +
            "JOIN goods g ON us.goods_id = g.goods_id " +
            "WHERE us.rd_id = ?";

        try (Connection con = getConnectionEc();
             PreparedStatement st = con.prepareStatement(sql)) {

            st.setString(1, rdId);

            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {

                    UserStock us = new UserStock();
                    us.setId(rs.getInt("id"));
                    us.setRd_id(rs.getString("rd_id"));
                    us.setGoods_id(rs.getString("goods_id"));
                    us.setQuantity(rs.getInt("quantity"));

                    Goods goods = new Goods();
                    goods.setGoods_id(rs.getString("goods_id"));
                    goods.setGoods_name(rs.getString("goods_name"));

                    us.setGoods(goods);

                    list.add(us);
                }
            }
        }

        return list;
    }

    /** 既存チェック */
    public UserStock find(String rdId, String goodsId) throws Exception {

        String sql =
            "SELECT * FROM user_stock WHERE rd_id = ? AND goods_id = ?";

        try (Connection con = getConnectionEc();
             PreparedStatement st = con.prepareStatement(sql)) {

            st.setString(1, rdId);
            st.setString(2, goodsId);

            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    UserStock us = new UserStock();
                    us.setId(rs.getInt("id"));
                    us.setRd_id(rs.getString("rd_id"));
                    us.setGoods_id(rs.getString("goods_id"));
                    us.setQuantity(rs.getInt("quantity"));
                    return us;
                }
            }
        }
        return null;
    }

    /** 新規追加 */
    public void insert(String rdId, String goodsId, int quantity) throws Exception {

        String sql =
            "INSERT INTO user_stock (rd_id, goods_id, quantity) VALUES (?, ?, ?)";

        try (Connection con = getConnectionEc();
             PreparedStatement st = con.prepareStatement(sql)) {

            st.setString(1, rdId);
            st.setString(2, goodsId);
            st.setInt(3, quantity);

            st.executeUpdate();
        }
    }

    /** 更新 */
    public void update(String rdId, String goodsId, int quantity) throws Exception {

        String sql =
            "UPDATE user_stock SET quantity = ? WHERE rd_id = ? AND goods_id = ?";

        try (Connection con = getConnectionEc();
             PreparedStatement st = con.prepareStatement(sql)) {

            st.setInt(1, quantity);
            st.setString(2, rdId);
            st.setString(3, goodsId);

            st.executeUpdate();
        }
    }
}