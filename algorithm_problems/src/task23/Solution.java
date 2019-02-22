package task23;

import java.util.*;

public class Solution {
    public int[] removeIt(int[] arr) {
        Set<Integer> elems = new HashSet<>();
        Map<Integer, Integer> occurrences = countOccurs(arr);
        ArrayList<Integer> qty = new ArrayList<>();
        ArrayList<Integer> numbs = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();

        int temp = arr[0];
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            elems.add(arr[i]);
            if (temp != arr[i]) {
                qty.add(count);
                numbs.add(temp);
                temp = arr[i];
                count = 1;
            } else {
                count++;
            }
        }
        for (int i = 0; i < qty.size(); i++) {
            System.out.print(numbs.get(i) + " - " + qty.get(i));
            System.out.println();
        }
        for (int i : elems) {
            System.out.print(i + "\t");
        }
        System.out.println();

        for (int i = 0; i < numbs.size() - 1; i++) {
            if (left(new ArrayList<>(numbs.subList(i + 1, numbs.size())), numbs.get(i))) {
                int nextPos = getNextPosition(new ArrayList<>(numbs.subList(i + 1, numbs.size())), numbs.get(i));
                
//                if (qty.get(nextPos) < countQtyBetween(qty, i, nextPos)) {
//                    for (int cut = i + 1; cut < nextPos; cut++) {
//                        if (occurrences.get(cut) > occurrences.get(i)) {
//                            for (int j = 0; j < qty.get(cut); j++) {
//                                res.add(numbs.get(cut));
//                            }
//                        }
//                    }
//                }
            }
        }
        System.out.println(occurrences);
        int[] solution = convertIntegers(res);
        return solution;
    }

    private <T> boolean left(ArrayList<T> arr, T elem) {//checks if such element exists in array
        for (T x : arr) if (x == elem) return true;
        return false;
    }

    private <T> int getNextPosition(ArrayList<T> arr, T el) {//gets position of next element
        int i;
        for (i = 0; i < arr.size(); i++) {
            if (arr.get(i) == el) break;
        }
        return i;
    }

    private Map<Integer, Integer> countOccurs(int[] arr) {//counts occurrences
        Map<Integer, Integer> res = new HashMap();
        for (int x : arr) {
            if (!res.containsKey(x)) {
                res.put(x, 1);
            } else {
                res.put(x, res.get(x) + 1);
            }
        }
        return res;
    }

    private int countQtyBetween(ArrayList<Integer> arr, int from, int till) {//counts qty for elements between same numbs
        int res = 0;
        for (int i = from; i < till; i++) {
            res += arr.get(i);
        }
        return res;
    }

    private int[] convertIntegers(List<Integer> integers) {
        int[] ret = new int[integers.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = integers.get(i).intValue();
        }
        return ret;
    }
}
