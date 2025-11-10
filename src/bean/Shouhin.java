package bean;

import java.io.Serializable;


					/*** 商品テーブル＋カテゴリーテーブル*/


public class Shouhin implements Serializable {
	/**
	 * 商品ID:char
	 */
	private char goods_id;

	/**
	 * 商品名:String
	 */
	private String goods_name;

	/**
	 * 値段:int
	 */
	private int price;

	/**
	 * カテゴリーID:char
	 */
	private char category_id;

	/**
	 * カテゴリー名:String
	 */
	private String category_name;

	/**
	 * 在庫数:int
	 */
	private int stock;


	/**
	 * ゲッター・セッター
	 */
	public char getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(char goods_id) {
		this.goods_id = goods_id;
	}

	public String getGoods_name() {
		return goods_name;
	}

	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}

	public int get() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public char getCategory_id() {
		return category_id;
	}

	public void setCategory_id(char category_id) {
		this.category_id = category_id;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
}