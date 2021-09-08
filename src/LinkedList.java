import java.util.*;
import java.util.Scanner;
public class LinkedList {
    public Node head = null;
    public Node tail = null;

    //Scanner input = new Scanner(System.in);
    public void addNode (int data)
    {
        Node newNode = new Node(data);
        if (head==null)
        {
            head=tail=newNode;
        }
        else
        {
            tail.next=newNode;
            newNode.back=tail;
            tail=newNode;
        }
    }
    public void display ()//display data in input order
    {
        Node current =head;
        if (current==null)
        {
            System.out.println("Linked list is empty");
        }
        else
        {
            while (current!=null)
            {
                System.out.print(current.data+" ");
                current=current.next;
            }
        }
    }
}
