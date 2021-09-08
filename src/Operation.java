import java.util.Arrays;

public class Operation {
    static void swap (int[] array , int i,int j)
    {
        int temp = array[i];
        array[i]=array[j];
        array[j]=temp;
    }

    static void compare (int[] array , int i,int j)
    {
        int temp = array[i];
        array[i]=array[j];
        array[j]=0;
    }



    static int[] formArray (int[] arr)
    {
        int[] array = {};
        int n = arr.length;
        for (int i=0;i<n;i++)
        {
            if (i==(n-1))
            {
                break;
            }
            else if (arr[i]==arr[i+1])
            {
                array=Arrays.copyOf(array,array.length+1);
                array[i]=arr[i];
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = {2,3,3,4,4,5,5,6,6,7,7,8,8,9};
        //formArray(array);
        System.out.println(Arrays.toString(formArray(array)));
    }
}
