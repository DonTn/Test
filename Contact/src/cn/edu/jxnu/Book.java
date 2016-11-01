package cn.edu.jxnu;

public class Book {
	private double price;
	private String pulisher;
	private String author;
	private String title;
    
	public Book(double price, String pulisher, String author, String title) {
		super();
		this.price = price;
		this.pulisher = pulisher;
		this.author = author;
		this.title = title;
	}
	public Book(){
		
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getPulisher() {
		return pulisher;
	}
	public void setPulisher(String pulisher) {
		this.pulisher = pulisher;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	 
	
}
