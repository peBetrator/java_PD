package implementations;

import org.junit.Before;
import org.junit.Test;
import stack.Stack;

import static org.junit.Assert.assertEquals;

public class Push {
    private Stack stack;

    @Before
    public void setup() {
        this.stack = new Stack();
    }

    @Test
    public void testEmpty() {
        char a = 'a';
        stack.push(a);
        assertEquals("Stack{arr=[" + a + "]}", stack.toString());
    }

    @Test
    public void testAdding() {
        char a = 'a';
        char b = 'b';

        stack.push(a);
        stack.push(b);
        assertEquals("Stack{arr=[" + a + ", " + b + "]}", stack.toString());
    }

    @Test
    public void testTypes() {
        char a = 'a';
        int one = 1;
        String element = "element";
        boolean trueBool = true;
        double d = 0.99;

        stack.push(a);
        stack.push(one);
        stack.push(element);
        stack.push(trueBool);
        stack.push(d);

        assertEquals("Stack{arr=[" + a + ", " + one + ", " + element + ", " + trueBool + ", " + d + "]}", stack.toString());
    }
}
