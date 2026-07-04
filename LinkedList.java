import java.util.Scanner;

class Node {
    String task;
    Node next;

    public Node(String task) {
        this.task = task;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    public void addTask(String task) {
        Node newNode = new Node(task);

        if(head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while(current.next != null) {
            current = current.next;
        }   

        current.next = newNode;
    }

    public void display() {
        if(head == null) {
            System.out.println("Task is empty");
            return;
        }

        Node current = head;
        int index = 1;
        while(current != null) {
            System.out.println(index + ". task " + current.task);
            current = current.next;
            index++;
        }
    }

    public static void main(String[]args) {
        Scanner s = new Scanner(System.in);
        LinkedList list = new LinkedList();

        System.out.print("enter a number to add task: ");
        int size = s.nextInt();
        s.nextLine();

        for(int a = 1; a <= size; a++) {
            System.out.print("Enter a task: ");
            String task = s.nextLine();
            list.addTask(task);
        }

        System.out.println();
        System.out.println("tasks");
        list.display();

        s.close();
    }
}