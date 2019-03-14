package bean;

public class Book {
	private int id;
	private String bookname;
    private String bookauthor;
    private String bookprice;
    private String avatar;
    private String introduce;
    private int num;
    private int bv;
    public Book() {
    	super();
    }
    public Book(String bookname,String bookauthor, String bookprice, String introduce, String avatar,int num) {
    	super();
    	this.bookname = bookname;
    	this.bookauthor = bookauthor;
    	this.avatar = avatar;
    	this.bookprice = bookprice;
    	this.introduce = introduce;
    	this.num=num;
    }
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getBookauthor() {
		return bookauthor;
	}
	public void setBookauthor(String bookauthor) {
		this.bookauthor = bookauthor;
	}
	public String getBookprice() {
		return bookprice;
	}
	public void setBookprice(String bookprice) {
		this.bookprice = bookprice;
	}
	
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getBv() {
		return bv;
	}
	public void setBv(int bv) {
		this.bv = bv;
	}
    
}
