package bean;

import java.io.Serializable;
					/***商品属性***/
					/*** コーステーブル+商品テーブル*/

public class Goodsattri implements Serializable {

	/**商品ID**/
	private String course_id;

	/**商品名**/
	private String course_name;

	/**
	 * ゲッター・セッター
	 */

	public String getCourse_id() {
		return course_id;
	}

	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

}