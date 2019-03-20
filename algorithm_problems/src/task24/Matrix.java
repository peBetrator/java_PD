package task24;

public class Matrix {
    private int[][] arr;

    public Matrix(int length) {
        arr = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                arr[i][j] = (int) (Math.random() * 3);
            }
        }
    }

    public void String() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public int[][] toArray() {
        return arr;
    }
}
