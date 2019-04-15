import stack.Stack;

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.readFromFile("data.txt");
        System.out.println(stack.toString());
        System.out.println(stack.checkDelimeters());
    }
}
