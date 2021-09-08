import java.util.Arrays;

public class practiceCode {
    public static int[] twoSum (int[] nums, int target) {

        int[] array = new int[2];
        int[] index = new int[2];

        for (int i=0;i<nums.length;i++)
        {
            array[0]=nums[i];
            index[0]=i;
            System.out.println(array[0]+" "+index[0]);
            for (int j=0;j<nums.length;j++)
            {
                array[1]=nums[j];
                index[1]=j;
                System.out.println(array[1]+" "+index[1]);
                if (array[0]==array[1])
                {
                    i++;
                }
                else if ((array[0]+array[1])==target && array[0]!=array[1] && i!=j)
                {
                    System.out.println(target);
                    return index;
                }
            }
        }
        return index;
    }


    public static int findNumber (int x)
    {
        int remainder=0;
        int i=0;
        if (x/10<1)
        {
            return 1;
        }
        else
        {
            while (x%10 <= 10)
            {
                i++;
                x=x/10;
                if (x<=10)
                {
                    return i+1;
                }
            }
        }
        return remainder;
    }

    public static int reverse(int x) {

        int length=findNumber(Math.abs(x));
        int[] array = new int[length],reverseArray = new int[length];
        int reverseNumber=0;
        if (length==1)
        {
            return x;
        }
        else if (length>1){
            if (x<0)
            {
                x=Math.abs(x);
                for (int i=0;i<length;i++)
                {
                    array[i]= x%10;
                    x=x/10;
                }
                for (int i=0;i<array.length;i++)
                {
                    reverseNumber=reverseNumber*10+array[i];
                }
                return -1*reverseNumber;
            }
            else if (x>0)
            {
                for (int i=0;i<length;i++)
                {
                    array[i]= x%10;
                    x=x/10;
                }
                for (int i=0;i<array.length;i++)
                {
                    reverseNumber=reverseNumber*10+array[i];
                }
                return reverseNumber;
            }
            else if (x==0)
            {
                return 0;
            }
        }

        return 0;
    }
    public static void main(String[] args) {
        int[] nums= {3,3};
        int target=6;
        //System.out.println(Arrays.toString(twoSum(nums,target)));
        System.out.println(findNumber(123));
        System.out.println(reverse(100));
    }
}
