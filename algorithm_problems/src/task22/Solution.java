package task22;

import java.util.List;

public class Solution {
    public double findP(List<Point> coordinates) {
        double distance = 0;
        int len = coordinates.size();
        for (int i = 0; i < len; i++) {
            distance += coordinates.get(i).dist(coordinates.get((i + 1) % len));
        }
        return distance;

    }
}
