package task22;

import java.util.ArrayList;
import java.util.List;

/*
Given a list of n points in a plane by their (x, y) coordinates,
determine the perimeter of the figure having the maximum area that can be obtained
from a subset of the n points and output the perimeter value
 */

public class Main {
    public static void main(String[] args) {
        List<Point> coordinates = new ArrayList<>();

        coordinates.add(new Point(0, 0));
        coordinates.add(new Point(0, 3));
        coordinates.add(new Point(3, 3));
        coordinates.add(new Point(3, 0));

        System.out.println(new Solution().findP(coordinates));
    }
}
