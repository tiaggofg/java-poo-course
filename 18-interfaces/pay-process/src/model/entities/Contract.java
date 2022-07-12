package model.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contract {
	
	private Date date;
	private Integer number;
	private Double totalValue;
	private List<Installment> installments = new ArrayList<>();
	
	public Contract() {
	}
	
	public Contract(Date date, Integer number, Double totalValue) {
		this.date = date;
		this.number = number;
		this.totalValue = totalValue;
	}
	
	public Date getDate() {
		return date;
	}
	
	public Integer getNumber() {
		return number;
	}
	
	public Double getTotalValue() {
		return totalValue;
	}
	
	public List<Installment> getInstallments(){
		return installments;
	}
	
}
