package entities;

public class Product {
	
	private String name;
	private double unitPrice;
	private double totalPrice;
	private int quantity;
	
	public Product(String name, Double unitPrice, Integer quantity) {
		this.name = name;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		calculateTotalPrice(unitPrice, quantity);
	}
	
	public String getName() {
		return name;
	}
	
	public double getUnitPrice () {
		return unitPrice;
	}
	
	public double getTotalPrice () {
		return totalPrice;
	}
	
	private void calculateTotalPrice(double unitPrice, int quantity) {
		totalPrice = unitPrice * quantity;
	}

	public int getQuantity () {
		return quantity;
	}
}
