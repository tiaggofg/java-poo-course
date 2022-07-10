package model.services;

import model.entities.CarRental;
import model.entities.Invoice;

public class RentalService {
	
	private TaxService taxService;
	private Double pricePerHour;
	private Double pricePerDay;
	
	public RentalService() {
	}
	
	public RentalService(Double pricePerHour, Double pricePerDay, TaxService taxService) {
		this.pricePerHour = pricePerHour;
		this.pricePerDay = pricePerDay;
		this.taxService = taxService;
	}
	
	public TaxService getTaxService() {
		return taxService;
	}
	
	public Double getPricePerHour() {
		return pricePerHour;
	}
	
	public Double getPricePerDay () {
		return pricePerDay;
	}
	
	public void processesInvoice(CarRental carRental) {
		long t1 = carRental.getStart().getTime();
		long t2 = carRental.getFinish().getTime();
		double totalTime = (double) (t2 - t1) / 1000 / 3600;
		
		double basicPayment;
		
		if (totalTime <= 12.0) {
			basicPayment = pricePerHour * Math.ceil(totalTime);
		} else {
			basicPayment = pricePerDay * Math.ceil(totalTime / 24);
		}
		
		carRental.setInvoice(new Invoice(basicPayment, taxService.tax(basicPayment)));
	}
}
