package application;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Set<Integer> courseA = new HashSet<>();
		Set<Integer> courseB = new HashSet<>();
		Set<Integer> courseC = new HashSet<>();
		
		System.out.print("How many students for course A? ");
		var quantity = sc.nextInt();
		
		for (int i=0; i < quantity; i++) {
			courseA.add(sc.nextInt());
		}
		
		System.out.print("How many students for course B? ");
		quantity = sc.nextInt();		
		
		for (int i=0; i < quantity; i++) {
			courseB.add(sc.nextInt());
		}
		
		System.out.print("How many students for course C? ");
		quantity = sc.nextInt();
		
		for (int i=0; i < quantity; i++) {
			courseC.add(sc.nextInt());
		}
		
		Set<Integer> allStudents = new HashSet<>(courseA);
		allStudents.addAll(courseB);
		allStudents.addAll(courseC);
		
		System.out.println("Total students: " + allStudents.size());
		
		sc.close();
		
	}
	
}
