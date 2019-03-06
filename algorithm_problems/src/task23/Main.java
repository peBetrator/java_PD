package task23;

import org.junit.Assert;
import org.junit.Test;

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
    @Test
    public static void main(String[] args) {
        int[] a = {2, 5, 3, 4, 2, 2, 2, 7, 8, 2, 3, 3, 3, 7};
        int[] b = {1, 1, 2, 1, 2, 2, 3, 5, 3, 1, 4, 4, 4};
        int[] resA = new int[0];
        int[] resB = new int[0];
        try {
            resA = new Solution().removeIt(a);
            resB = new Solution().removeIt(b);
        } catch (CustomExceptions customExceptions) {
            customExceptions.printStackTrace();
        }

        Assert.assertArrayEquals(new int[]{2, 2, 2, 2, 2, 3, 3, 3, 7}, resA);
        Assert.assertArrayEquals(new int[]{1, 1, 1, 2, 2, 3, 3, 4, 4, 4}, resB);

    }
}
