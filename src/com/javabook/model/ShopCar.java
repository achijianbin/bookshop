package com.javabook.model;



public class ShopCar {
	
	 private String cuserid;
	 private String buyid;
	 private String bookname;
	 private Integer booknumber;
	 private String date;
	 private Float price;
	 private int bookid;
	public ShopCar() {
		super();
		// TODO 自动生成的构造函数存根
	}

	
	

	public ShopCar(String bookname, Integer booknumber, String date, Float price,String cuserid ,int bookid,String buyid) {
		super();
		this.bookname = bookname;
		this.booknumber = booknumber;
		this.date = date;
		this.price = price*booknumber;
		this.cuserid=cuserid;
		this.bookid=bookid;
		this.buyid=buyid;
	}




	



	public ShopCar(String cuserid) {
		super();
		this.cuserid = cuserid;
	}




	public ShopCar(String cuserid, int bookid) {
		super();
		this.cuserid = cuserid;
		this.bookid = bookid;
	}




	public String getCuserid() {
		return cuserid;
	}




	public void setCuserid(String cuserid) {
		this.cuserid = cuserid;
	}




	public String getBuyid() {
		return buyid;
	}




	public void setBuyid(String buyid) {
		this.buyid = buyid;
	}




	public String getBookname() {
		return bookname;
	}




	public void setBookname(String bookname) {
		this.bookname = bookname;
	}




	public Integer getBooknumber() {
		return booknumber;
	}




	public void setBooknumber(Integer booknumber) {
		this.booknumber = booknumber;
	}




	public String getDate() {
		return date;
	}




	public void setDate(String date) {
		this.date = date;
	}




	public Float getPrice() {
		return price;
	}




	public void setPrice(Float price) {
		this.price = price;
	}




	public int getBookid() {
		return bookid;
	}




	public void setBookid(int bookid) {
		this.bookid = bookid;
	}





	
	 
	 

}
