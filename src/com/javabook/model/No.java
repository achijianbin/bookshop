package com.javabook.model;

public class No {
	private String buyid;
	private String cuserid;
	private String bookname;
	private String date;
	private int booknumber;
	private float price;
	public No() {
		super();
		// TODO �Զ����ɵĹ��캯�����
	}
	
	
	
	public No(String bookname, String cuserid) {
		super();
		this.cuserid = cuserid;
		this.bookname = bookname;
	}



	public String getBuyid() {
		return buyid;
	}
	public void setBuyid(String buyid) {
		this.buyid = buyid;
	}
	public String getCuserid() {
		return cuserid;
	}
	public void setCuserid(String cuserid) {
		this.cuserid = cuserid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getBooknumber() {
		return booknumber;
	}
	public void setBooknumber(int booknumber) {
		this.booknumber = booknumber;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}

}
