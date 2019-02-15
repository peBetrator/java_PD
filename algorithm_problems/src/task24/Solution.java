package task24;

import java.util.LinkedList;

public class Solution {
    public static int moreCherries(int[][] arr) {
        int cherries = 0;
        int steps = 0;
        LinkedList<Integer> storePosX = new LinkedList<>();
        LinkedList<Integer> storePosY = new LinkedList<>();
        for (int i = 0; i < arr.length; ) {
            for (int j = 0; j < arr.length; ) {
                steps++;
                System.out.println("[" + i + "]; [" + j + "]");
                storePosX.add(i);
                storePosY.add(j);
                if (arr[i][j] == 2) {
                    cherries++;
                    arr[i][j] = -1;
                }
                if (i == arr.length - 1 && j == arr.length - 1) {
                    System.out.println(steps + " steps");
                    return cherries;
                }
                if (j == arr.length - 1) {
                    if (arr[i + 1][j] != 1) {
                        i++;
                        continue;
                    } else {
                        if (arr[i][j] == -1) {
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
                if (i == arr.length - 1) {
                    if (arr[i][j + 1] != 1) {
                        j++;
                        continue;
                    } else {
                        if (arr[i][j] == -1) {
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
                if (arr[i][j + 1] == 2) {
                    j++;
                    continue;
                } else if (arr[i + 1][j] == 2) {
                    i++;
                    continue;
                }
                if (arr[i][j + 1] != 1) {
                    j++;
                    continue;
                } else if (arr[i + 1][j] != 1) {
                    i++;
                    continue;
                }
                if (arr[i + 1][j] == 1) if (arr[i][j + 1] == 1) {
                    if (arr[i][j] == -1) {
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
