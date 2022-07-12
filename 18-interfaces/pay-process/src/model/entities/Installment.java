package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Installment {
	
	private Date dueDate;
	private Double installmentValue;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Installment() {
	}
	
	public Installment(Date dueDate, Double installmentValue) {
		this.dueDate = dueDate;
		this.installmentValue = installmentValue;
	}
	
	public Date getDueDate() {
		return dueDate;
	}
	
	public Double getInstallmentValue() {
		return installmentValue;
	}
	
	@Override
	public String toString() {
		return sdf.format(dueDate) + " - " + String.format("%.2f", installmentValue);
	}
}
