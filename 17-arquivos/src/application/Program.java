package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Stream;

import entities.Product;

public class Program {
	
	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc 	= new Scanner(System.in);		
		
		System.out.println("Enter the file path:");
		File saleOrder = new File(sc.nextLine());
		File filePath = new File(saleOrder.getParent() + "/out");
		
		if (!filePath.exists()) {
			filePath.mkdir();
		}	
			
		File summary = new File(filePath + "/summary.csv");
		
		try (BufferedReader br = new BufferedReader(new FileReader(saleOrder)); BufferedWriter bw = new BufferedWriter(new FileWriter(summary))) {
			
			Stream<String> lines = br.lines();
			List<Product> products = new ArrayList<>();
			
			lines.forEach(k -> {
				String[] aux = k.split(",");
				String name = aux[0];
				double unitPrice = Double.parseDouble(aux[1]);
				int quantity = Integer.parseInt(aux[2]);
				products.add(new Product(name, unitPrice, quantity));
			});
			
			try {
				for (Product item : products) {
					bw.write(item.getName() + "," + String.format("%.2f", item.getTotalPrice()) + "\n");
				}
				
			} catch (IOException e) {
				System.out.println("error: " + e.getMessage());
			}
			
			System.out.print("\ncreated " + summary.getName());
			
		} catch (IOException e) {
			System.out.print("\nerror: " + e.getMessage());
		}
		
		sc.close();
		
	}

}
