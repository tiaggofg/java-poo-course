package program;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Employee;

public class Application {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		List<Employee> employees = new ArrayList<>();
		
		System.out.print("Enter full file path: ");
		String path = sc.next();
		
		System.out.print("Enter salary: ");
		Double value = sc.nextDouble();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			br.lines().forEach(l -> {
				
				String[] fields = l.split(",");
				
				String name = fields[0];
				String email = fields[1];
				Double salary = Double.parseDouble(fields[2]);
				
				employees.add(new Employee(name, email, salary));
				
			});
			
			System.out.println("Email of people whose salary is more than 2000.00:");
			employees.stream().filter(e -> e.getSalary() > value).map(e -> e.getEmail()).forEach(System.out::println);
		
			var sum = employees.stream().filter(e -> e.getName().charAt(0) == 'M')
					.map(e -> e.getSalary()).reduce((x, y) -> x + y).get();
			
			System.out.println("Sum of salary of people whose name starts with 'M': " + sum);
			
		} catch (IOException e) {
			
			System.out.println("Error: " + e.getMessage());
		
		} 
		
		sc.close();

	}

}
