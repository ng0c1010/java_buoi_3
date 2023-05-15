package bai1;

public class OrderDetail {
	private int quantily;
	private Product product;
	
	public OrderDetail(int quantily, Product product) {
		super();
		this.quantily = quantily;
		this.product = product;
	}

	public int getQuantily() {
		return quantily;
	}

	public void setQuantily(int quantily) {
		this.quantily = quantily;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "OrderDetail [quantily=" + quantily + ", product=" + product + "]";
	}
	
	public double calcTotalPrice() {
		return quantily * product.getPrice();
		
	}

}
