package stack;

import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author Yash Shah
 */
public class StackTest 
{
    /**
     * Test of push method, of class Stack.
     */
    @Test
    public void testPush() 
    {
        System.out.println("push");
        Stack<String> stack = new Stack<>();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        assertEquals("CBA", stack.value());
    }

    /**
     * Test of pop method, of class Stack.
     */
    @Test
    public void testPop() 
    {
        System.out.println("pop");
        Stack<String> stack = new Stack<>();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        stack.push("E");
        stack.pop();
        assertEquals("DCBA", stack.value());
        stack.pop();
        stack.pop();
        assertEquals("BA", stack.value());
        stack.pop();
        stack.pop();
        assertEquals("", stack.value());
        stack.pop();
    }

    /**
     * Test of peek method, of class Stack.
     */
    @Test
    public void testPeek() 
    {
        System.out.println("peek");
        Stack<String> stack = new Stack<>();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        stack.push("E");
        assertEquals("E", stack.peek());
        stack.pop();
        assertEquals("D", stack.peek());
        stack.pop();
        stack.pop();
        assertEquals("B", stack.peek());
    }

    /**
     * Test of size method, of class Stack.
     */
    @Test
    public void testSize() 
    {
        System.out.println("size");
        Stack<String> stack = new Stack<>();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        stack.push("E");
        assertEquals(5, stack.size());
    }

    /**
     * Test of value method, of class Stack.
     */
    @Test
    public void testValue() 
    {
        System.out.println("value");
        Stack<String> stack = new Stack<>();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        stack.push("E");
        assertEquals("EDCBA", stack.value());
    }
}
