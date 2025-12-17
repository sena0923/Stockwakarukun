package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Cart;

public class CartDao {

    private Connection conn;

    public CartDao(Connection conn) {
        this.conn = conn;
    }

    /** カートに商品を追加 */
    public void addItem(Cart cart) throws SQLException {
        String sql = "INSERT INTO cart(course_id, rd_id, goods_id, quantity, price) VALUES(?,?,?,?,?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, cart.getCourse_id());
            ps.setString(2, cart.getRd_id());
            ps.setString(3, cart.getGoods_id());
            ps.setString(4, cart.getGoods_name());
            ps.setInt(5, cart.getQuantity());
            ps.setInt(6, cart.getPrice());
            ps.executeUpdate();
        }
    }

    /** 数量更新 */
    public void updateQuantity(String courseId, int quantity) throws SQLException {
        String sql = "UPDATE cart SET quantity = ? WHERE course_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, quantity);
            ps.setString(2, courseId);
            ps.executeUpdate();
        }
    }

    /** 商品削除 */
    public void removeItem(String courseId) throws SQLException {
        String sql = "DELETE FROM cart WHERE course_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, courseId);
            ps.executeUpdate();
        }
    }

    /** カート一覧取得（入居者IDごと） */
    public List<Cart> getCartList(String rdId) throws SQLException {
        List<Cart> list = new ArrayList<>();
        String sql = "SELECT * FROM cart WHERE rd_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, rdId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Cart cart = new Cart();
                    cart.setCourse_id(rs.getString("course_id"));
                    cart.setRd_id(rs.getString("rd_id"));
                    cart.setGoods_id(rs.getString("goods_id"));
                    cart.setGoods_name(rs.getString("goods_name"));
                    cart.setQuantity(rs.getInt("quantity"));
                    cart.setPrice(rs.getInt("price"));
                    list.add(cart);
                }
            }
        }
        return list;
    }

    /** 合計金額計算 */
    public int getTotalPrice(String rdId) throws SQLException {
        int total = 0;
        String sql = "SELECT SUM(quantity * price) AS total FROM cart WHERE rd_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, rdId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    total = rs.getInt("total");
                }
            }
        }
        return total;
    }
}