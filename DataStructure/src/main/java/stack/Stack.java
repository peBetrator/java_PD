package stack;

import java.util.Arrays;

public class Stack<T> {
    private T[] arr;

    private int getSize() {
        return arr.length;
    }

    private void populateWithOldValues(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            this.arr[i] = arr[i];
        }

    }

    public void push(T element) {
        try {
            T[] tempArr = this.arr;
            this.arr = (T[]) new Object[getSize() + 1];
            populateWithOldValues(tempArr);
            this.arr[getSize() - 1] = element;

        } catch (NullPointerException e) { // if there are no elements in array
            this.arr = (T[]) new Object[]{element};
        }
    }

    public void pop() {
        try {
            this.arr = Arrays.copyOf(arr, getSize() - 1);
        } catch (NegativeArraySizeException e) {
            System.out.println("Nothing to pop\nThere are no elements left in Stack");
        }
    }

    public T peek() {
        return this.arr[getSize() - 1];
    }

    public int size() {
        return getSize();
    }

    public boolean isEmpty() {
        try {
            return getSize() <= 0;
        } catch (NullPointerException e) {
            return true;
        }
    }

    @Override
    public String toString() {
        return "Stack{" +
                "arr=" + Arrays.toString(arr) +
                '}';
    }
}