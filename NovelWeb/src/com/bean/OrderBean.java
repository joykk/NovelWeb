package com.bean;

import java.util.Date;

public class OrderBean {

	private int readerOrderID;
	private int readerID;
	private Date orderDatetime;
	private float orderTotalPrice;
	public int getReaderOrderID() {
		return readerOrderID;
	}
	public void setReaderOrderID(int readerOrderID) {
		this.readerOrderID = readerOrderID;
	}
	public int getReaderID() {
		return readerID;
	}
	public void setReaderID(int readerID) {
		this.readerID = readerID;
	}
	public Date getOrderDatetime() {
		return orderDatetime;
	}
	public void setOrderDatetime(Date orderDatetime) {
		this.orderDatetime = orderDatetime;
	}
	public float getOrderTotalPrice() {
		return orderTotalPrice;
	}
	public void setOrderTotalPrice(float orderTotalPrice) {
		this.orderTotalPrice = orderTotalPrice;
	}
	
	
}
