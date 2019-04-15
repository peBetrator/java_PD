package implementations;

import org.junit.Before;
import org.junit.Test;
import stack.Stack;

import static org.junit.Assert.assertEquals;

public class Peek {
    private Stack stack;
    private int a = 1;
    private int b = 2;

    @Before
    public void setup() {
        this.stack = new Stack();
        stack.push(a);
        stack.push(b);
    }

    @Test
    public void testPeeking() {
        String element = "element";
        stack.push(element);
        String last = (String) stack.peek();

        assertEquals(element, last);
    }

    @Test
    public void testPrePeeking() {
        stack.pop();
        int last = (int) stack.peek();

        assertEquals(a, last);
    }
}
