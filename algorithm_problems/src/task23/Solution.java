package task23;

import java.util.*;

import static task23.Handlers.*;

//TODO NEED IMPROVEMENTS
// to check if elements at start are not the biggest ones
// to try more examples and improve the algorithm itself

public class Solution {
    public static int[] removeIt(int[] arr) throws CustomExceptions {
        Set<Integer> elems = new HashSet<>();//sorted set of elements
        Map<Integer, Integer> occurrences = countOccurs(arr); //sorted map(number - quantity) of elements
        ArrayList<Integer> qty, numbs; //arrays to maintain current list of gathered numbers
        ArrayList<Integer> res = convertToList(arr); //result

        System.out.println(occurrences);

        qty = countQty(res);
        numbs = countNumbs(res);

        for (int i = 0; i < qty.size(); i++) {
            System.out.print(numbs.get(i) + " - " + qty.get(i));
            System.out.println();
        }
        System.out.println();

        for (int i = 0; i < res.size() - 1; i++) {
            if (res.get(i) != res.get(i + 1)) { //if numbers doesn't match
                if (res.get(i) > res.get(i + 1)) { //if next number is less than current one
                    removeElement(i, res, numbs, qty);
                    continue;
                }
                if (left(new ArrayList<>(res.subList(i + 1, res.size())), res.get(i))) { //if there are such elements left
                    int next = i + 1 + getNextPosition(new ArrayList<>(res.subList(i + 1, res.size())), res.get(i));
                    int first = getFirstOccurrence(numbs, res.get(i + 1));
                    int second = getSecondOccurrence(numbs, res.get(next));
                    int countBetween = countQtyBetween(new ArrayList<>(qty.subList(first, second))); //counts number of elements between 2 same ones
                    if (countBetween <= qty.get(second)) {
                        qty.remove(removeFirstOccurrence(numbs, res.get(i + 1)));
                        res.remove(i + 1);
                        i--;
                        qty = countQty(res);
                        numbs = countNumbs(res);
                        continue;
                    }
//                    else if (occurrences.get(res.get(i)) > occurrences.get(res.get(i + 1))) {
//                        qty.remove(removeFirstOccurrence(numbs, res.get(i + 1)));
//                        res.remove(i + 1);
//                        i--;
//                        qty = countQty(res);
//                        numbs = countNumbs(res);
//                    }
                    int avg = countAverage(new ArrayList<>(numbs.subList(first, second)), new ArrayList<>(qty.subList(first, second)));
                    if (res.get(i + 1) >= avg) {
                        qty.remove(removeFirstOccurrence(numbs, res.get(i + 1)));
                        res.remove(i + 1);
                        i--;
                        qty = countQty(res);
                        numbs = countNumbs(res);
                    }
                }
            }
        }
        return convertToArray(res);
    }

    private static void removeElement(int index, ArrayList<Integer> mainArr, ArrayList<Integer> numbs, ArrayList<Integer> qty) {
        qty.remove(removeFirstOccurrence(numbs, mainArr.get(index + 1)));
        ArrayList<Integer> newMainArr = new ArrayList<>(mainArr.remove(index + 1));
        index--;
        qty = countQty(mainArr);
        numbs = countNumbs(mainArr);
    }
}
