package bean;

import java.io.Serializable;

					/*** 介護士テーブル*/

public class Caregiver implements Serializable {

	/**職員番号**/
	private String staffid;

	/**氏名**/
	private String name;

	/**パスワード**/
	private String password;

	/**施設パスワード**/
	private String FacilityPassword;

	/**
	 * ゲッター・セッター
	 */

	public String getStaffid() {
		return staffid;
	}

	public void setStaffid(String staffid) {
		this.staffid = staffid;
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

	public String getFacilityPassword() {
		return FacilityPassword;
	}

	public void setFacilityPassword(String facilityPassword) {
		FacilityPassword = facilityPassword;
	}

}