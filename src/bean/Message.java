package bean;

import java.io.Serializable;


					/*** メッセージテーブル＋介護士テーブル+親族テーブル*/


public class Message implements Serializable {
	/**
	 * メッセージID:String
	 */
	private String me_id;

	/**
	 * 介護士ID:String
	 */
	private String cg_id ;

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
	private java.util.Date da_ti;

	/**
	 * タイトル:String
	 */
	private String title;


	/**
	 * ゲッター・セッター
	 */
	public String getMe_id() {
		return me_id;
	}

	public void setMessage_id(String me_id) {
		this.me_id = me_id;
	}

	public String getCg_id() {
		return cg_id;
	}

	public void setCg_id(String cg_id) {
		this.cg_id = cg_id;
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

	public java.util.Date getDa_ti() {
		return da_ti;
	}

	public void setDa_ti(java.util.Date da_ti) {
		this.da_ti = da_ti;
	}

	//タイトル追加
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}