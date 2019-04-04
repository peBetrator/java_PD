package task21;

public class Maze {
    private int[][] arr;
    private int x;
    private int y;


    public Maze(int[][] arr) {
        this.arr = arr;
    }

    public void SetPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String decideWhereToGo() {
        int size = arr.length / 2;

        if (x < size) if (y < size) return x < y ? "up" : "left";
        else if (y >= size) return size - x < arr.length - y ? "left" : "down";

        if (x >= size) if (y >= size) return x > y ? "right" : "down";
        else if (y < size) return size - y < arr.length - x ? "up" : "right";
        return "";
    }
}
