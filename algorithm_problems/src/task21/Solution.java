package task21;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution {
    void findWall(int[][] arr, int _x_, int _y_) {
        Maze maze = new Maze(arr);
        maze.SetPosition(_x_,_y_);

        int arrSize = arr.length;
        int steps = 0;

        String wall = maze.decideWhereToGo();

        LinkedList<Integer> storePosX = new LinkedList<>();
        LinkedList<Integer> storePosY = new LinkedList<>(); //stored moves

        ArrayList<Integer> waysToGo = new ArrayList<>();
    }
}
