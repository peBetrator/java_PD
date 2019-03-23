package task21;

import task24.Matrix;

import static task21.Helpers.decideWhereToGo;

public class Main {
    public static void main(String[] args) {
        Matrix m = new Matrix(6);
        m.String();
        System.out.println(decideWhereToGo(m.toArray(),2,6));

    }
}
