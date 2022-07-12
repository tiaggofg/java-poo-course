package model.services;

public class PaypalService implements OnlinePaymentService {
	
	public Double interestValue(Double amount, Integer months) {
		return amount + (amount * 0.01 * months);
	}
	
	public Double paymentFee(Double amount) {
		return amount + (amount * 0.02);
	}
}
