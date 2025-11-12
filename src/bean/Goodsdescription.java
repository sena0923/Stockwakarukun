package bean;

import java.io.Serializable;

					/*** 商品説明テーブル+商品テーブル*/

public class Goodsdescription implements Serializable {

	/**商品ID**/
	private String goods_id;

	/**商品説明**/
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