package stack;

import java.io.*;
import java.util.ArrayList;
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
        } catch (NegativeArraySizeException | NullPointerException exception) {
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

    public void reverse() {
        for (int i = 0; i < getSize() / 2; i++) {
            T temp = arr[i];
            this.arr[i] = arr[getSize() - i - 1];
            this.arr[getSize() - i - 1] = temp;
        }
    }

    public void readFromFile(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println(filePath + " does not exist.");
            return;
        }
        if (!(file.isFile() && file.canRead())) {
            System.out.println(file.getName() + " cannot be read from.");
            return;
        }
        try {
            FileInputStream fis = new FileInputStream(file);
            char current;
            //TODO push chars to stack, not ints
            Object ch;
            while (fis.available() > 0) {
                ch = fis.read();
                push((T) ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean checkDelimeters() {
        ArrayList<Integer> brackets = new ArrayList<>();
        brackets.add(40);// (
        brackets.add(41);// )
        brackets.add(91);// [
        brackets.add(93);// ]
        brackets.add(123);// {
        brackets.add(125);// }

        Stack<Integer> myBr = new Stack<>();
        for (int i = 0; i < getSize(); i++) {
            if (brackets.contains((int) arr[i])) {
                myBr.push((int) arr[i]);
            }
        }
        if (myBr.getSize() % 2 != 0) return false;
        else return correctBrackets(myBr);
    }

    private int getBracket(int i) {
        return (int) arr[i];
    }

    private boolean correctBrackets(Stack<Integer> stack) {
        boolean res = true;
        for (int i = stack.getSize() / 2; i >= 0; i--) {
            if (stack.getBracket(i) == 40) {
                res = stack.getBracket(stack.getSize() - i - 1) == 41;
            } else {
                res = stack.getBracket(stack.getSize() - i - 1) - stack.getBracket(i) == 2;
            }

        }
        return res;
    }

    @Override
    public String toString() {
        return "Stack{" +
                "arr=" + Arrays.toString(arr) +
                '}';
    }
}