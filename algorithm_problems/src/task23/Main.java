package task23;

/*
Given an array of n integers, determine the minimum amount of integers
to be removed from the array so that the remaining array forms an ascending sequence
of numbers - the output should be the remaining ascending sequence as shown in example:
Given input array:
2 5 3 4 2 2 2 4 8 2 5 3 3 3 7
The following output should be displayed:
2 2 2 2 2 3 3 3 7
*/
public class Main {
    public static void main(String[] args) {
        int[] a = {2, 5, 3, 4, 2, 2, 2, 7, 8, 2, 3, 3, 3, 7};
        int[] b = {1, 1, 2, 1, 2, 2, 3, 5, 3, 1, 4, 4, 4};
        int[] res = new int[0];
        try {
            res = new Solution().removeIt(a);
        } catch (CustomExceptions customExceptions) {
            customExceptions.printStackTrace();
        }
        for (int i : res) System.out.print(i + "\t");
    }
}
