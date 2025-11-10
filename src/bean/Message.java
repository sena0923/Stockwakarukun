package bean;

import java.io.Serializable;


					/*** メッセージテーブル＋介護士テーブル+親族テーブル*/


public class Message implements Serializable {
	/**
	 * メッセージID:String
	 */
	private String message_id;

	/**
	 * 介護士ID:String
	 */
	private String cg_num ;

	/**
	 * 親族ID:String
	 */
	private String rt_id;

	/**
	 * メッセージ:String
	 */
	private String message;

	/**
	 * 送信日時:date
	 */
	private int da_ti;


	/**
	 * ゲッター・セッター
	 */
	public String getMessage_id() {
		return message_id;
	}

	public void setMessage_id(String message_id) {
		this.message_id = message_id;
	}

	public String getCg_num() {
		return cg_num;
	}

	public void setCg_num(String cg_num) {
		this.cg_num = cg_num;
	}

	public String getRt_id() {
		return rt_id;
	}

	public void setRt_id(String rt_id) {
		this.rt_id = rt_id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getDa_ti() {
		return da_ti;
	}

	public void setDa_ti(int da_ti) {
		this.da_ti = da_ti;
	}
}