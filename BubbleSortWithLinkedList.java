import java.util.Scanner;

class Node {
	int data;
	Node next;
	
	public Node(int data){
		this.data = data;
		this.next = null;
	}
}
public class LinkedList {
	
	Node head;
	
	public void addNumber(int data){
		Node newNode = new Node(data);
		
		if(head == null) {
			head = newNode;
		} else {
			Node current = head;
			while(current.next != null) {
				current = current.next;
			}
			
			current.next = newNode;
		}
	}
	
	public void display(){
		if(head == null){
			System.out.println("the list is empty");
		}
		
		Node current = head;
		int index = 1;
		while(current != null){
			System.out.println(index + ". " + current.data);
		}
	}
	public static void main(String[] args) {
		
	}
}