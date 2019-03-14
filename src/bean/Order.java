package bean;

import java.util.Date;

public class Order {
private int orderid;
private int bookid;
private String username;
private Date purchtime;
public Order() {
	super();
}
public Order(int bookid,String username) {
	super();
	this.bookid=bookid;
	this.username=username;
}
public int getOrderid() {
	return orderid;
}
public void setOrderid(int orderid) {
	this.orderid = orderid;
}
public int getBookid() {
	return bookid;
}
public void setBookid(int bookid) {
	this.bookid = bookid;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public Date getPurchtime() {
	return purchtime;
}
public void setPurchtime(Date purchtime) {
	this.purchtime = purchtime;
}

}
