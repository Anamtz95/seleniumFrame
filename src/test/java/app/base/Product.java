package app.base;

public class Product {
	public String ProductID;
	public String Name;
	public double Price;
	
	public String getProductID() {
		return ProductID;
	}
	public void setProductID(String productID) {
		ProductID = productID;
	}
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}	
}
