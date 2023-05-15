package bai1;

public class Product {
	private String des;
	private String productID;
	private double price;
	public Product() {
		
	}
	public Product(String des, String productID, double price) {
		this.des = des;
		this.productID = productID;
		this.price = price;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [des=" + des + ", productID=" + productID + ", price=" + price + "]";
	}
	
}
