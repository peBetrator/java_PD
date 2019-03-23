package task21;

import java.util.LinkedList;

import static task21.Helpers.*;

public class Solution {
    void findWall(int[][] arr, int x, int y) {
        int arrSize = arr.length;
        String wall = decideWhereToGo(arr, x, y);

        int steps = 0;
        LinkedList<Integer> storePosX = new LinkedList<>();
        LinkedList<Integer> storePosY = new LinkedList<>(); //stored moves
        switch (wall) {
            case "up":
                for (int i = x; i > 0; --i) {
                    for (int j = y; j < arrSize; ) {
                        storePosX.add(x);
                        storePosY.add(y);
                        if (arr[i][j] == 1) {
                            if (arr[i][j + 1] == 1) {

                            }
                        }
                    }
                }
        }
    }
}
