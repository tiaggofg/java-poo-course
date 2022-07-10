package model.entities;

public class Invoice {
	
	private Double basicPayment;
	private Double tax;
	private Double totalPayment;
	
	public Invoice () {
	}
	
	public Invoice (Double basicPayment, Double tax) {
		this.basicPayment = basicPayment;
		this.tax = tax;
		calculeTotalPayment();
	}
	
	public Double getBasicPayment () {
		return basicPayment;
	}
	
	public Double getTax() {
		return tax;
	}
	
	public Double getTotalPayment() {
		return totalPayment;
	}
	
	public void calculeTotalPayment() {
		totalPayment = basicPayment + tax;
	}
	
	@Override
	public String toString() {
		return "INVOICE\nBasic Payment: " + basicPayment + "\nTax: " + tax + "\nTotal Payment: " + totalPayment;
	}
}
