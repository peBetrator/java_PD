package task23;

import java.util.*;

import static task23.Handlers.*;

public class Solution {
    public static int[] removeIt(int[] arr) {
        Set<Integer> elems = new HashSet<>();//sorted set of elements
        Map<Integer, Integer> occurrences = countOccurs(arr);
        ArrayList<Integer> qty, numbs;
        ArrayList<Integer> res = convertToList(arr);

        System.out.println(occurrences);

        qty = countQty(res);
        numbs = countNumbs(res);

        for (int i = 0; i < qty.size(); i++) {
            System.out.print(numbs.get(i) + " - " + qty.get(i));
            System.out.println();
        }
        System.out.println();

        for (int i = 0; i < res.size() - 1; i++) {
            if (res.get(i) != res.get(i + 1)) {
                System.out.println(res.get(i));
                if (left(new ArrayList<>(res.subList(i + 1, res.size())), res.get(i))) {
                    int next = i + 1 + getNextPosition(new ArrayList<>(res.subList(i + 1, res.size())), res.get(i));
                    System.out.println("position " + next + "\telement " + res.get(i + 1));
                    int first = getFirstOccurrence(numbs, res.get(i + 1));
                    int second = getSecondOccurrence(numbs, res.get(next));
                    System.out.println("first " + first + "; second " + second);
                    int countBetween = countQtyBetween(new ArrayList<>(qty.subList(first, second)));
                    System.out.println(countBetween + " between");
                    if (countBetween <= qty.get(second)) {
                        qty.remove(removeFirstOccurrence(numbs, res.get(i + 1)));
                        res.remove(i + 1);
                        i--;
                        qty = countQty(res);
                        numbs = countNumbs(res);
                    } else if (occurrences.get(res.get(i)) > occurrences.get(res.get(i + 1))) {
                        qty.remove(removeFirstOccurrence(numbs, res.get(i + 1)));
                        res.remove(i + 1);
                        i--;
                        qty = countQty(res);
                        numbs = countNumbs(res);
                    }
                    System.out.println(res);
                    System.out.println(numbs);
                    System.out.println(qty);
                }
            }
        }
        return convertToArray(res);
    }
}
