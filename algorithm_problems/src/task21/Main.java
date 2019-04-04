package task21;

import task24.Matrix;

public class Main {
    public static void main(String[] args) {
        Matrix m = new Matrix(6);

        new Solution().findWall(m.toArray(),3,6);
    }
}
