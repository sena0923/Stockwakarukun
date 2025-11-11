package bean;

import java.io.Serializable;

					/*** 支払方法テーブル*/

public class Paymentmethod implements Serializable {

	/**支払方法ID**/
	private String payment_id;

	/**支払い方法**/
	private String payment;

	/**
	 * ゲッター・セッター
	 */

	public String getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(String payment_id) {
		this.payment_id = payment_id;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

}