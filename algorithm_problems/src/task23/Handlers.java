package task23;

import java.util.*;

public class Handlers {
    static <T> boolean left(ArrayList<T> arr, T elem) {//checks if such element exists in array
        for (T x : arr) if (x == elem) return true;
        return false;
    }

    static <T> int getNextPosition(ArrayList<T> arr, T el) {//gets position of next element
        int i;
        for (i = 0; i < arr.size(); i++) {
            if (arr.get(i) == el) break;
        }
        return i;
    }

    static <T> ArrayList countNumbs(ArrayList<T> arr) {//group elements
        ArrayList<T> res = new ArrayList<>();
        T temp = arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            if (temp != arr.get(i)) {
                res.add(temp);
                temp = arr.get(i);
            }
            if (i == arr.size() - 1) if (res.get(res.size() - 1) != arr.get(i)) res.add(arr.get(i));
        }
        return res;
    }

    static <T> ArrayList countQty(ArrayList<T> arr) {//count times same element is met
        ArrayList<Integer> res = new ArrayList<>();
        T temp = arr.get(0);
        int count = 1;
        for (int i = 1; i < arr.size(); i++) {
            if (temp != arr.get(i)) {
                res.add(count);
                temp = arr.get(i);
                count = 1;
            } else {
                count++;
            }
            if (i == arr.size() - 1) if (res.get(res.size() - 1) != arr.get(i)) res.add(count);
        }
        return res;
    }

    static <T> int removeFirstOccurrence(ArrayList<T> arr, T element) {//removes first occurrence of element and returns position of it
        int i;
        for (i = 0; i < arr.size(); i++) {//group elements
            if (element == arr.get(i)) {
                arr.remove(i);
                break;
            }
        }
        return i;
    }

    static int getFirstOccurrence(ArrayList<Integer> arr, int element) {//return first occurrence
        int i;
        for (i = 0; i < arr.size(); i++) {//group elements
            if (element == arr.get(i)) {
                break;
            }
        }
        return i;
    }

    static int getSecondOccurrence(ArrayList<Integer> arr, int element) {//return second occurrence
        int i;
        boolean check = false;
        for (i = 0; i < arr.size(); i++) {//group elements
            if (check) if (element == arr.get(i)) break;
            if (element == arr.get(i)) {
                check = true;
            }
        }
        return i;
    }

    static Map<Integer, Integer> countOccurs(int[] arr) {//counts occurrences of elements in array
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

    static int countQtyBetween(ArrayList<Integer> arr) {//counts qty for elements between same numbs
        int res = 0;
        for (int i = 0; i < arr.size(); i++) {
            res += arr.get(i);
        }
        return res;
    }

    static int[] convertToArray(List<Integer> integers) {
        int[] ret = new int[integers.size()];
        Iterator<Integer> iterator = integers.iterator();
        for (int i = 0; i < ret.length; i++) {
            ret[i] = iterator.next();
        }
        return ret;
    }

    static ArrayList convertToList(int arr[]) {
        ArrayList<Integer> array_list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            array_list.add(arr[i]);
        System.out.print(array_list);
        return array_list;
    }
}
