package bean;

import java.io.Serializable;

					/*** 介護士テーブル*/

public class Caregi implements Serializable {

	/**職員番号**/
	private String cg_num;

	/**氏名**/
	private String name;

	/**パスワード**/
	private String password;

	/**
	 * ゲッター・セッター
	 */

	public String getCg_num() {
		return cg_num;
	}

	public void setCg_num(String cg_num) {
		this.cg_num = cg_num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}