package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		Map<String, Integer> votes = new LinkedHashMap<>();

		// election-votes/in.txt
		System.out.print("Enter the file full path: ");
		var path = sc.next();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
					
			br.lines().forEach(l -> {
				
				String[] fields = l.split(",");
				var name = fields[0];
				var quantityVotes = Integer.parseInt(fields[1]);
				
				if (votes.containsKey(name)) {
					var quantityOldVotes = votes.get(name);
					votes.put(name, quantityOldVotes + quantityVotes);
				} else {
					votes.put(name, quantityVotes);
				}
				
			});
			
			votes.forEach((candidate, qVotes) -> System.out.println(candidate + ": " + qVotes));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		sc.close();
		
	}
	
}
