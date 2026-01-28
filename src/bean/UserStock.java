package bean;

public class UserStock {

    private int id;             // 主キー
    private String rd_id;       // 入居者ID
    private String goods_id;    // 商品ID
    private int quantity;       // 在庫数
    private Goods goods;        // JOINで取得する商品情報

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }
}