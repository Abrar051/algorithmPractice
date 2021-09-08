import java.util.Arrays;
import java.util.*;



public class UniqueLinkedList {

    public Node head = null;
    public Node tail = null;
    LinkedList obj = new LinkedList();

    public int removeDuplicateArray (int[] arr){

        int[] array = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];

            for(int j =0; j< arr.length; j++){

                if(arr[j] == temp && i!= j &&  j < i){
                    break;
                }
                /*if(arr[j] ==temp && i!=j){
                    System.out.println("duplicate:" +arr[j]);
                    break;
                }*/
                //for main array
                 if (arr[j]==temp)
                 {
                   //System.out.println (arr[j]);
                   obj.addNode(arr[j]);
                   //array[i]=arr[j];
                   break;
                 }
            }
        }
        obj.display();
        return obj.head.data;
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

    public void main(String[] args) {

        int[] arr = {10,7,8,8,8,8,8,8,8,8,8,9,7,7,7,7,1,5};
        //System.out.println(Arrays.toString(removeDuplicateArray(arr)));
    }

}
