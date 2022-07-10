package model.entities;

import java.util.Date;

public class CarRental {

	private Date start;
	private Date finish;
	private Vehicle vehicle;
	private Invoice invoice;
	
	public CarRental () {
	}
	
	public CarRental (Date start, Date finish, String model) {
		this.start = start;
		this.finish = finish;
		vehicle = new Vehicle(model);
	}
	
	public Date getStart () {
		return start;
	}
	
	public Date getFinish () {
		return finish;
	}
	
	public Vehicle getVehicle () {
		return vehicle;
	}
	
	public Invoice getInvoice () {
		return invoice;
	}
	
	public void setInvoice (Invoice invoice) {
		this.invoice = invoice;
	}
}
