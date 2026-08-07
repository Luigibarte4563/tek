import java.util.Scanner;

class Node {	
	String task;
	Node next;
	
	public Node(String task){
		this.task = task;
		this.next = null;
	}
}

public class LinkedList{
	
	private Node head;
	
	public void addTask(String task) {
		Node newNode = new Node(task);
		
		if(head == null){
			head = newNode;
		} else {
			Node current = head;
			while(current.next != null){
				current = current.next;
			}
			current.next = newNode;
		}
	}
	
	public void display(){
		if(head == null) {
			System.out.println("Your To-Do List is empty");
		}
		
		Node current = head;
		int index = 1;
		while(current != null) {
			System.out.println(index + ". " + current.task);
			current = current.next;
			index++;	
		}
	}
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		Scanner s = new Scanner(System.in);
		
		System.out.print("Enter a number of list");
		int n = s.nextInt();
		s.nextLine();
		
		for(int a = 1; a <= n; a++){
			System.out.print("enter a to do: ");
			String task = s.nextLine();
			list.addTask(task);
		}
		
		System.out.println();
		System.out.println("To Do");
		list.display();
	}
}