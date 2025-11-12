package bean;

import java.io.Serializable;

					/*** 商品個人在庫テーブル*/

public class Goodsinve implements Serializable {

	/**商品在庫ID**/
	private String goods_inve_id;

	/**商品ID**/
	private String goods_id;

	/**入居者ID**/
	private String rd_id;

	/**個数**/
	private int goods_inve_count;

	/**購入日**/
	private int purchase_date;
	/**
	 * ゲッター・セッター
	 */

	public String getGoods_inve_id() {
		return goods_inve_id;
	}

	public void setGoods_inve_id(String goods_inve_id) {
		this.goods_inve_id = goods_inve_id;
	}

	public String getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(String goods_id) {
		this.goods_id = goods_id;
	}

	public String getRd_id() {
		return rd_id;
	}

	public void setRd_id(String rd_id) {
		this.rd_id = rd_id;
	}

	public int getGoods_inve_count() {
		return goods_inve_count;
	}

	public void setGoods_inve_count(int goods_inve_count) {
		this.goods_inve_count = goods_inve_count;
	}

	public int getPurchase_date() {
		return purchase_date;
	}

	public void setPurchase_date(int purchase_date) {
		this.purchase_date = purchase_date;
	}
}