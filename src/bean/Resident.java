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

	/**氏名(フリガナ)**/
	private String fname;


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

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}


}