package bean;

import java.io.Serializable;

/*** カートテーブル */
public class Cart implements Serializable {

    /** カートID */
    private String course_id;

    /** 入居者ID */
    private String rd_id;

    /** 商品ID */
    private String goods_id;

    /** 数量 */
    private int quantity;

    /** 価格 */
    private int price;

    // --- Getter / Setter ---
    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getRd_id() {
        return rd_id;
    }

    public void setRd_id(String rd_id) {
        this.rd_id = rd_id;
    }

    public String getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(String goods_id) {
        this.goods_id = goods_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}