import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int sizeArr = 0;
		
		System.out.print("enter a range of array: ");
		sizeArr = s.nextInt();
		
		int[] numbers = new int[sizeArr];
		
		for(int a = 0; a < numbers.length; a++){
			System.out.print("Enter a number: ");
			numbers[a] = s.nextInt();
	    }
	    
	    for(int b = numbers.length - 1; b >= 0; b--){
	        if(numbers[b] % 2 == 0){
	        	System.out.println("Even numbers are: " + numbers[b]);
	        }else{
	        	System.out.println("Odd numbers are: " + numbers[b]);
	        }
	    }
	    
	}
}