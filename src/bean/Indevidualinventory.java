package bean;

import java.io.Serializable;

					/*** 個人在庫テーブル*/

public class Indevidualinventory implements Serializable {

	/**入居者ID**/
	private String rd_id;

	/**商品名**/
	private String inve_name;

	/**個数**/
	private int inve_count;

	/**登録日**/
	private java.util.Date regi_date;

	public String getRd_id() {
		return rd_id;
	}

	public void setRd_id(String rd_id) {
		this.rd_id = rd_id;
	}

	public String getInve_name() {
		return inve_name;
	}

	public void setInve_name(String inve_name) {
		this.inve_name = inve_name;
	}

	public int getInve_count() {
		return inve_count;
	}

	public void setInve_count(int inve_count) {
		this.inve_count = inve_count;
	}

	public java.util.Date getRegi_date() {
		return regi_date;
	}

	public void setRegi_date(java.util.Date regi_date) {
		this.regi_date = regi_date;
	}

	/**
	 * ゲッター・セッター
	 */
}