package bean;

import java.io.Serializable;

					/*** 入居者テーブル*/

public class Resident implements Serializable {

	/**入居者ID**/
	private String rd_id;

	/**氏名**/
	private String name;

	/**コースID**/
	private int course_id;

	/**性別**/
	private String gender;

	/**パスワード**/
	private String password;



	/**
	 * ゲッター・セッター
	 */

	public String getrd_id() {
		return rd_id;
	}

	public void setRd_id(String rd_id) {
		this.rd_id = rd_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	/**
	 * 認証済みフラグ:boolean true:認証済み
	 */
	private boolean isAuthenticated;

	/**
	 * ゲッター、セッター
	 */
	public boolean isAuthenticated() {
		return isAuthenticated;
	}

	public void setAuthenticated(boolean isAuthenticated) {
		this.isAuthenticated = isAuthenticated;
	}


}