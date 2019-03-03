package task24;

import java.util.LinkedList;

//TODO NEED IMPROVEMENTS
// to check all existing cherries and to store them in arrays for rows/columns for gathering maximum amount of cherries

public class Solution {
    public int moreCherries(int[][] arr) {
        int cherries = 0;
        int steps = 0;
        LinkedList<Integer> storePosX = new LinkedList<>();
        LinkedList<Integer> storePosY = new LinkedList<>(); //stored moves
        for (int i = 0; i < arr.length; ) {
            for (int j = 0; j < arr.length; ) {
                steps++;
                System.out.println("[" + i + "]; [" + j + "]");
                storePosX.add(i);
                storePosY.add(j);
                if (arr[i][j] == 2) {//if cherry
                    cherries++;
                    arr[i][j] = -1;
                }
                if (i == arr.length - 1 && j == arr.length - 1) {//if right bottom corner AKA finish
                    System.out.println(steps + " steps");
                    return cherries;
                }
                if (j == arr.length - 1) {//if faced right wall
                    if (arr[i + 1][j] != 1) {
                        i++;
                        continue;
                    } else { //if dead end
                        if (arr[i][j] == -1) {//check if already've been here
                            cherries--;
                        }
                        arr[i][j] = 1;
                        storePosX.removeLast();
                        storePosY.removeLast();
                        i = storePosX.peekLast();
                        j = storePosY.peekLast();
                        storePosX.removeLast();
                        storePosY.removeLast();
                        continue;
                    }
                }
                if (i == arr.length - 1) {//if faced bottom down wall
                    if (arr[i][j + 1] != 1) {
                        j++;
                        continue;
                    } else { //if dead end
                        if (arr[i][j] == -1) {//check if already've been here
                            cherries--;
                        }
                        arr[i][j] = 1;
                        storePosX.removeLast();
                        storePosY.removeLast();
                        i = storePosX.peekLast();
                        j = storePosY.peekLast();
                        storePosX.removeLast();
                        storePosY.removeLast();
                        continue;
                    }
                }
                if (arr[i][j + 1] == 2) {//greedy algorithm for finding more cherries
                    j++;
                    continue;
                } else if (arr[i + 1][j] == 2) {
                    i++;
                    continue;
                }
                if (arr[i][j + 1] != 1) {//not choosing walls
                    j++;
                    continue;
                } else if (arr[i + 1][j] != 1) {
                    i++;
                    continue;
                }
                if (arr[i + 1][j] == 1) if (arr[i][j + 1] == 1) {//if dead end
                    if (arr[i][j] == -1) {//subtract collected cherries
                        cherries--;
                    }
                    arr[i][j] = 1;
                    storePosX.removeLast();
                    storePosY.removeLast();
                    i = storePosX.peekLast();
                    j = storePosY.peekLast();
                    storePosX.removeLast();
                    storePosY.removeLast();
                    continue;
                }
            }
        }
        return -1;
    }
}
