package task24;
/*
Given a matrix of size n*n, with elements having values 0, 1 and 2 with the following meaning:
0 - free space and you can move over that cell
1 - occupied space and movement is not allowed over that cell
2 - cell containing a cherry
Assuming we are located in the top left corner of the matrix and that we want to reach the bottom
right corner, and considering that movement is only allowed top to bottom or left to right,
determine the path that should be followed so that we reach the bottom right corner by
walking through a maximum amount of cell with cherries
*/

public class Main {
    public static void main(String[] args) {
        int size = 10;
        Matrix arr = new Matrix(size);
        int[][] constArr = {
                {0, 0, 0, 2, 2},
                {2, 1, 0, 1, 0},
                {0, 1, 0, 0, 1},
                {0, 1, 1, 0, 0},
                {0, 0, 1, 2, 0}};
//        arr.String();
//        System.out.println(new Solution().moreCherries(arr.toArray()) + " cherries");
        System.out.println(new Solution().moreCherries(constArr) + " cherries");
    }
}
