package bean;

import java.io.Serializable;

					/*** カテゴリーテーブル*/

public class Goodscategory implements Serializable {

	/**カテゴリーID**/
	private String goods_id;

	/**カテゴリー名**/
	private String goods_dp;

	/**
	 * ゲッター・セッター
	 */

	public String getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(String goods_id) {
		this.goods_id = goods_id;
	}

	public String getGoods_dp() {
		return goods_dp;
	}

	public void setGoods_dp(String goods_dp) {
		this.goods_dp = goods_dp;
	}

}