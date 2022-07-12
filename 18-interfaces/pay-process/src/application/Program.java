package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypalService;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter contract data\nNumber: ");
		int numberContract = sc.nextInt();
		System.out.print("Date (dd/MM/yyyy): ");
		Date dateContract = sdf.parse(sc.next());;
		System.out.print("Contract value: ");
		double totalValue =  sc.nextDouble();
		System.out.print("Enter number of installments: ");
		int numberOfInstallments = sc.nextInt();
		
		Contract contract = new Contract(dateContract, numberContract, totalValue);
		ContractService contractService = new ContractService(new PaypalService());
		
		contractService.processInstallment(contract, numberOfInstallments);
		
		System.out.print("\nINSTALLMENTS:\n");
		for (Installment k : contract.getInstallments()) {
			System.out.println(k.toString());
		}
		
		sc.close();
	}

}
