package bean;

import java.util.Date;

public class Shopping {
	private int shopid;
	private int bookid;
	private String username;
	private Date shoptime;
	public Shopping() {
		super();
	}
	public Shopping(int bookid,String username) {
		super();
		this.bookid=bookid;
		this.username=username;
	}
	public int getShopid() {
		return shopid;
	}
	public void setShopid(int shopid) {
		this.shopid = shopid;
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
	public Date getShoptime() {
		return shoptime;
	}
	public void setShoptime(Date shoptime) {
		this.shoptime = shoptime;
	}
	

}


