package model.services;

import java.util.Calendar;
import java.util.Date;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {
	
	private OnlinePaymentService onlinePaymentService;
	
	public ContractService(OnlinePaymentService onlinePaymetService) {
		this.onlinePaymentService = onlinePaymetService;
	}
	
	public OnlinePaymentService getOnlinePaymentService() {
		return onlinePaymentService;
	}
	
	public void processInstallment(Contract contract, Integer months) {
		Date dueDate;
		double installmentValue;
		double amount = contract.getTotalValue() / months;
		
		for (int i = 1; i <= months; i++) {
			dueDate = addMonths(contract.getDate(), i);
			installmentValue = onlinePaymentService.paymentFee(onlinePaymentService.interestValue(amount, i));
			contract.getInstallments().add(new Installment(dueDate, installmentValue));
		}
	}
	
	private Date addMonths(Date date, int n) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, n);
		return calendar.getTime();
	}
}
