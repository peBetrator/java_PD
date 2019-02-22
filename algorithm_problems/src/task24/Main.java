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
        int[][] arr = new int[size][size];
        int[][] constArr = {
                {0, 0, 0, 2, 2},
                {2, 1, 0, 1, 0},
                {0, 1, 0, 0, 1},
                {0, 1, 1, 0, 0},
                {0, 0, 1, 2, 0}};
        populateArr(arr);
//        showArr(arr);
//        System.out.println(new Solution().moreCherries(arr) + " cherries");
        showArr(constArr);
        System.out.println(new Solution().moreCherries(constArr) + " cherries");
    }

    public static void populateArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = (int) (Math.random() * 3);
            }
        }
    }

    public static void showArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
