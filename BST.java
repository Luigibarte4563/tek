import java.util.Scanner;

class Node {
	int data;
	Node left, right;
	
	Node(int data) {
		this.data = data;
		left = right = null;
	}
}

public class Main {
	
	static boolean search(Node root, int data) {
		if(root == null) return false;
		if(root.data == data) return true;
		if(data < root.data) return search(root.left, data);
		return search(root.right, data);
	}
	
	static Node insert(Node root, int data) {
		if(root == null) return new Node(data);
		if(data < root.data) root.left = insert(root.left, data);
		else root.right = insert(root.right, data);
		return root;
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Node root = null;
		
		boolean isLooping = true;
		
		while(isLooping) {
			System.out.print("Enter number to insert(0 to stop): ");
		int num = s.nextInt();
		
			if (num == 0) {
				isLooping = false;
			} else {
				root = insert(root, num);
			}
		}
		
		System.out.print("Enter a number to search: ");
		int number = s.nextInt();
		
		if(search(root, number)) {
			System.out.println(number + " Found!");
		} else {
			System.out.println(number + " Not Found!");
		}
	}
}