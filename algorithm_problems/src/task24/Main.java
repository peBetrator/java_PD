package task24;

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
