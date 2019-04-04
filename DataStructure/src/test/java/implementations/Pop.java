package implementations;

import org.junit.Before;
import org.junit.Test;
import stack.Stack;

import static org.junit.Assert.assertEquals;

public class Pop {
    private Stack stack;
    private int a = 1;
    private int b = 2;
    private int c = 3;
    private int d = 4;
    private int e = 5;

    @Before
    public void setup() {
        this.stack = new Stack();
        stack.push(a);
        stack.push(b);
        stack.push(c);
        stack.push(d);
        stack.push(e);
    }

    @Test
    public void testDeleting() {
        stack.pop();

        assertEquals("Stack{arr=[" + a + ", " + b + ", " + c + ", " + d + "]}", stack.toString());
    }

    @Test
    public void testDeletingAll(){
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();

        assertEquals("Stack{arr=[]}", stack.toString());
    }



}
