package task23;

public class Main {
    public static void main(String[] args) {
        int[] a = {2, 5, 3, 4, 2, 2, 2, 4, 8, 2, 5, 3, 3, 3, 7};
        int[] b = {2, 2, 5, 4, 2, 5, 5, 5, 5, 5, 5};
        int[] res = new Solution().removeIt(b);
        for (int i : res) System.out.print(i + "\t");
    }
}
