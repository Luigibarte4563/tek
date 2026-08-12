import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.print("enter a word: ");
		String word = s.nextLine();
		
		String reverse = "";
		for(int a = word.length() - 1; a >= 0; a--) {
			reverse = reverse + word.charAt(a);	
		}
		
		if(word.equals(reverse)) {
			System.out.println("Yes, its palindrome");
		}else {
			System.out.println("No, its not Palindrome");
		}
	}
}