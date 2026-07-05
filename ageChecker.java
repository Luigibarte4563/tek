import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int currentYear;
		int birthYear;
		int age;
		
		System.out.print("enter your birth year: ");
		birthYear = s.nextInt();
		
		System.out.print("enter the current year: ");
		currentYear = s.nextInt();
		
		age = birthYear - currentYear;
		
		System.out.println();
		System.out.println("your age: " + age);
		
		
	}
}