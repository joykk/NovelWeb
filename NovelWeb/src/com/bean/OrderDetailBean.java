package com.bean;

public class OrderDetailBean {
	private int readerOrderDetailID;
	private int readerOrderID;
	private int novelID;
	private String novelName;
	private String novelAuthor;
	private float price;
	
	public String getNovelName() {
		return novelName;
	}
	public void setNovelName(String novelName) {
		this.novelName = novelName;
	}
	public int getReaderOrderDetailID() {
		return readerOrderDetailID;
	}
	public void setReaderOrderDetailID(int readerOrderDetailID) {
		this.readerOrderDetailID = readerOrderDetailID;
	}
	public int getReaderOrderID() {
		return readerOrderID;
	}
	public void setReaderOrderID(int readerOrderID) {
		this.readerOrderID = readerOrderID;
	}
	public int getNovelID() {
		return novelID;
	}
	public void setNovelID(int novelID) {
		this.novelID = novelID;
	}
	public String getNovelAuthor() {
		return novelAuthor;
	}
	public void setNovelAuthor(String novelAuthor) {
		this.novelAuthor = novelAuthor;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
}
