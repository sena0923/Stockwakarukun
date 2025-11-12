package bean;

import java.io.Serializable;

					/*** 支払方法テーブル*/

public class Purchasehistory implements Serializable {

	/**購入履歴ID**/
	private String payment_id;

	/**入居者ID**/
	private String rd_id;

	/**商品ID**/
	private String goods_id;

	/**購入日**/
	private int purchase_date;

	/**個数**/
	private int goods_inve_count;
	/**
	 * ゲッター・セッター
	 */

	public String getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(String payment_id) {
		this.payment_id = payment_id;
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

	public int getPurchase_date() {
		return purchase_date;
	}

	public void setPurchase_date(int purchase_date) {
		this.purchase_date = purchase_date;
	}

	public int getGoods_inve_count() {
		return goods_inve_count;
	}

	public void setGoods_inve_count(int goods_inve_count) {
		this.goods_inve_count = goods_inve_count;
	}
}