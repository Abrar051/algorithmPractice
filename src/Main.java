import java.util.Arrays;

public class Main {
    public static void main(String[] args)
    {
        UniqueLinkedList filter = new UniqueLinkedList();
        LinkedList array = new LinkedList();
        int[] arr = {10,7,8,8,8,8,8,8,8,8,8,9,7,7,7,7,1,5};
        //filter.removeDuplicateArray(arr);
        System.out.println(filter.removeDuplicateArray(arr));
        //array.display();
    }
}
