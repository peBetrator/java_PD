package task21;

public class Helpers {
    static String decideWhereToGo(int[][] arr, int x, int y) {
        int size = arr.length / 2;

        if (x < size) if (y < size) return x < y ? "up" : "left";
        else if (y >= size) return size - x < arr.length - y ? "left" : "down";

        if (x >= size) if (y >= size) return x > y ? "right" : "down";
        else if (y < size) return size - y < arr.length - x ? "up" : "right";
        return "";
    }
}
