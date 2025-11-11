package bean;

import java.io.Serializable;

					/*** 属性テーブル*/

public class Attribute implements Serializable {

	/**属性ID**/
	private String attribute_id;

	/**属性名**/
	private String attribute_name;

	/**属性タイプ**/
	private int attribute_type;

	/**
	 * ゲッター・セッター
	 */

	public String getAttribute_id() {
		return attribute_id;
	}

	public void setAttribute_id(String attribute_id) {
		this.attribute_id = attribute_id;
	}

	public String getAttribute_name() {
		return attribute_name;
	}

	public void setAttribute_name(String attribute_name) {
		this.attribute_name = attribute_name;
	}

	public int getAttribute_type() {
		return attribute_type;
	}

	public void setAttribute_type(int attribute_type) {
		this.attribute_type = attribute_type;
	}


}