import java.util.HashMap;
import java.util.Hashtable;
import java.util.Stack;


public class practiceCode {
    public static int[] twoSum(int[] nums, int target) {

        int[] array = new int[2];
        int[] index = new int[2];

        for (int i = 0; i < nums.length; i++) {
            array[0] = nums[i];
            index[0] = i;
            System.out.println(array[0] + " " + index[0]);
            for (int j = 0; j < nums.length; j++) {
                array[1] = nums[j];
                index[1] = j;
                System.out.println(array[1] + " " + index[1]);
                if (array[0] == array[1]) {
                    i++;
                } else if ((array[0] + array[1]) == target && array[0] != array[1] && i != j) {
                    System.out.println(target);
                    return index;
                }
            }
        }
        return index;
    }


    public static int findNumber(int x) {
        int remainder = 0;
        int i = 0;
        if (x > 10 && x % 10 == 0) {
            while (x % 10 == 0) {
                x = x / 10;
                i++;
                if (x <= 10) {
                    return i + 2;
                }
            }
        }
        if (x / 10 < 1) {
            return 1;
        } else {
            while (x % 10 <= 10) {
                i++;
                x = x / 10;
                if (x <= 10) {
                    return i + 1;
                }
            }
        }
        return remainder;
    }

    public static int reverse(int x) {

        int length = findNumber(Math.abs(x));
        int[] array = new int[length], reverseArray = new int[length];
        int reverseNumber = 0;
        if (length == 1) {
            return x;
        } else if (length > 1) {
            if (x < 0) {
                x = Math.abs(x);
                for (int i = 0; i < length; i++) {
                    array[i] = x % 10;
                    x = x / 10;
                }
                for (int i = 0; i < array.length; i++) {
                    reverseNumber = reverseNumber * 10 + array[i];
                }
                return -1 * reverseNumber;
            } else if (x > 0) {
                for (int i = 0; i < length; i++) {
                    array[i] = x % 10;
                    x = x / 10;
                }
                for (int i = 0; i < array.length; i++) {
                    reverseNumber = reverseNumber * 10 + array[i];
                }
                return reverseNumber;
            } else if (x == 0) {
                return 0;
            }
        }

        return 0;
    }


    public static int reverse2(int x) {

        int result = 0;

        while (x != 0) {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result) {
                return 0;
            }
            result = newResult;
            x = x / 10;
        }

        return result;
    }


    //day 3 palindrome problem
    public static boolean isPalindrome(int x) {
        Hashtable<Integer, Integer> hm = new Hashtable<Integer, Integer>();
        if (x < 0) //special case
        {
            return false;
        } else if (x == 0) // special case
        {
            return true;
        } else if (x % 10 == 0) {
            return false;
        } else //normal case
        {
            //steps
            //at first keep them in array
            int i = 0;
            while (x != 0) {
                hm.put(i, x % 10);
                i++;
                x = x / 10;
            }
            if (i % 2 == 1) {
                for (int k = 0; k < (i - 1) / 2; k++) {
                    if (hm.get(k) != hm.get(i - k - 1)) {
                        return false;
                    } else {
                        continue;
                    }
                }
            } else if (i % 2 == 0) {
                for (int k = 0; k < ((i - 1) / 2) + 1; k++) {
                    if (hm.get(k) != hm.get(i - k - 1)) {
                        return false;
                    } else {
                        continue;
                    }
                }
            }
            System.out.println(hm);
            System.out.println(i);
            return true;
        }
    }

    public static void longestCommonPrefix(String[] strs) {
        String s = new String();
        System.out.println(strs[0].charAt(0));
    }

    public static int characterAscii(char a) {
        int ascii = (int) a;
        return ascii;
    }

    public static char intToChar(int a) {
        return (char) a;
    }

    public static boolean isValid(String s) {
        HashMap<Integer, Character> stack1 = new HashMap<Integer, Character>();
        HashMap<Integer, Character> stack2 = new HashMap<Integer, Character>();
        HashMap<Integer, Character> stack3 = new HashMap<Integer, Character>();
        //check string length
        //if string length is odd then it's false else if it's even return true
        char firstBrc = '(';
        char firstBrcRvl = ')';
        char secondBrc = '{';
        char secondBrcRvl = '}';
        char thirdBrc = '[';
        char thirdBrcRvl = ']';
        if (s.length() % 2 != 0) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        } else if (s.length() % 2 == 0) {
            //push to stack1 if (,{ or [ else push to stack2
            int counter = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == firstBrc | s.charAt(j) == secondBrc | s.charAt(j) == thirdBrc) {
                    stack1.put(counter, s.charAt(j));
                    counter++;
                }
            }
            counter = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == firstBrcRvl | s.charAt(j) == secondBrcRvl | s.charAt(j) == thirdBrcRvl) {
                    stack2.put(counter, s.charAt(j));
                    counter++;
                }
            }
            counter = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == firstBrcRvl | s.charAt(j) == secondBrcRvl | s.charAt(j) == thirdBrcRvl) {
                    if (characterAscii(s.charAt(j)) == ')') {
                        char temp = (char) (characterAscii(s.charAt(j)) - 1);
                        stack3.put(counter, temp);
                        counter++;
                    } else if (characterAscii(s.charAt(j)) == '}' | characterAscii(s.charAt(j)) == ']') {
                        char temp = (char) (characterAscii(s.charAt(j)) - 2);
                        stack3.put(counter, temp);
                        counter++;
                    }
                }
            }
            if (stack1.equals(stack3) | stack1.equals(stack3)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }


    ///system 2
    //pop push method

    public static boolean isReciprocal(char a, char b) {
        if (a == '(' && b == ')' | a == '{' && b == '}' | a == '[' && b == ']') {
            return true;
        } else {
            return false;
        }
    }

   /* public static boolean checkValid (String s)
    {
        HashMap<Integer,Character> stack = new HashMap<Integer,Character>();
        for (int i=0;i<s.length();i++)
        {
            int counter=0;
            if (s.charAt(i)=='(' | s.charAt(i)=='{' | s.charAt(i)=='[')
            {
                stack.put(counter,s.charAt(i));
                counter++;
            }
            else
            {
                boolean check = isReciprocal();
            }
        }
    }*/

    public static boolean isValid1(String s) {
        if (s.isEmpty()) return true;
        if (s.length() == 1) return false;

        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else if (stack.isEmpty()) {
                return false;
            } else {
                Character left = stack.pop();
                if (map.get(left) != s.charAt(i)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] nums = {3, 3};
        int target = 6;
        //System.out.println(Arrays.toString(twoSum(nums,target)));
        //System.out.println(findNumber(100));
        //System.out.println(reverse(100));
        //System.out.println(reverse2(100));
        //System.out.println(isPalindrome(1000030001));
        //String[] str = new String[]{"fdegerg", "gdeger", "egergr"};
        //longestCommonPrefix(str);
        //isValid("[](){}[]");
        /*System.out.println(isValid("[{()}]"));
        System.out.println();
        System.out.println(isValid("[](){}{}{}{}[]"));
        System.out.println();
        System.out.println(isValid("[](}[]"));
        System.out.println(isReciprocal('[', ']'));
        System.out.println(isValid1("[](){}{}{}{}[]"));*/
        //System.out.println(mergeTwoLists(([1, 2, 4]),([1, 3, 4]));
        System.out.println(strStr("uuuoollll","lll"));
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        // Create a new linked list of type ListNode named headNode that will go through both the L.L and combine them in sorted order
        ListNode headNode;

        // Here if the first value of L.L l1 is less than or equal to l2 then point headNode to l1 and l1 to the next address and vicevera with l2.
        if (l1.val <= l2.val) {
            headNode = l1;
            l1 = l1.next;
        } else {
            headNode = l2;
            l2 = l2.next;
        }
        ListNode ans = headNode;
        while (l1 != null && l2 != null) {

            if (l1.val <= l2.val) {
                headNode.next = l1;
                l1 = l1.next;
            } else {
                headNode.next = l2;
                l2 = l2.next;
            }
            // update the headNode to its next node
            headNode = headNode.next;
        }

        if (l1 == null) headNode.next = l2;
            // else to l1 node
        else headNode.next = l1;

        return ans;
    }

    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        } else {
            for (int i=0;i<haystack.length();i++)
            {
                //int index=1;

                if (haystack.charAt(i)==needle.charAt(0))
                {
                    if ((haystack.length()-i)!=needle.length())
                    {
                        System.out.println(haystack.length()-i+1);
                        return -1;
                    }
                    else
                    {
                        String subString = haystack.substring(i, i+needle.length());
                        System.out.println(subString);
                        System.out.println(needle);
                        if (needle.equals(subString)) {
                            return i + 1;
                        }
                        break;
                    }
                }

            }
        }

        return -1;
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int result = 1;
        int i = 1;
        while (i < nums.length) {
            if (nums[i] != nums[i - 1]) {
                nums[result++] = nums[i];
            }
            i++;
        }
        return result;
    }

    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[count] = nums[i];
                count++;
            }
        }
        return count;
    }
}
