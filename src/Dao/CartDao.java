package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Cart;

public class CartDao extends Dao {



    /** カートに商品を追加 */
    public void addItem(Cart cart) throws Exception {

    	String sql = "INSERT INTO cart(rd_id, goods_id, goods_name, course_id, quantity, price, can_name) VALUES(?,?,?,?,?,?,?)";
        try (Connection conn = getConnectionEc();PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, cart.getRd_id());
            ps.setString(2, cart.getGoods_id());
            ps.setString(3, cart.getGoods_name());
            ps.setString(4, cart.getCourse_id());
            ps.setInt(5, cart.getQuantity());
            ps.setInt(6, cart.getPrice());
            ps.setInt(7, cart.isCan_name());  // ← 名入れフラグ
            ps.executeUpdate();
        }
    }

    /** 数量更新（ユーザーごとに安全に更新） */
    public void updateQuantity(String courseId, String rdId, int quantity) throws Exception {
        String sql = "UPDATE cart SET quantity = ? WHERE course_id = ? AND rd_id = ?";
        try (Connection conn = getConnectionEc();PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, quantity);
            ps.setString(2, courseId);
            ps.setString(3, rdId);
            ps.executeUpdate();
        }
    }

    /** 商品削除（ユーザーごとに安全に削除） */
    public void removeItem(String courseId, String rdId) throws Exception {
        String sql = "DELETE FROM cart WHERE course_id = ? AND rd_id = ?";
        try (Connection conn = getConnectionEc();PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, courseId);
            ps.setString(2, rdId);
            ps.executeUpdate();
        }
    }

    /** カート一覧取得（入居者IDごと） */
    public List<Cart> getCartList(String rdId) throws Exception {
        List<Cart> list = new ArrayList<>();
        String sql = "SELECT course_id, rd_id, goods_id, goods_name, quantity, price, can_name FROM cart WHERE rd_id = ?";
        try (Connection conn = getConnectionEc();PreparedStatement ps = conn.prepareStatement(sql)) {
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
                    cart.setCan_name(rs.getInt("can_name"));
                    /*
                     * 名入れできるかどうか
                     */
                    cart.setNaireFlg(canNameCheck(cart.getGoods_id()));

                    /* debug */
                    System.out.println("debug-CartDao-getCartList-goods_id:" + cart.getGoods_id());
                    System.out.println("debug-CartDao-getCartList-naire_flg:" + cart.isNaireFlg());

                    list.add(cart);
                }
            }
        }
        return list;
    }

    /** 合計金額計算 */
    public int getTotalPrice(String rdId) throws Exception {
        int total = 0;
        String sql = "SELECT SUM(quantity * price) AS total FROM cart WHERE rd_id = ?";
        try (Connection conn = getConnectionEc();PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, rdId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    total = rs.getInt("total");
                }
            }
        }
        return total;
    }

    /** 名入れデータ取得 */
    public boolean canNameCheck(String goodsId) throws Exception {

        boolean result = false;

        String sql = "SELECT CAN_NAME FROM NAIRE WHERE GOODS_ID = ?";

        try (
            Connection conn = getConnectionEc();
            PreparedStatement ps = conn.prepareStatement(sql);
        ) {

            ps.setString(1, goodsId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int canName = rs.getInt("CAN_NAME");

                // ★ 1 = 名入れ可
                if (canName == 1) {
                    result = true;
                }
            }
        }

        return result;
    }
}