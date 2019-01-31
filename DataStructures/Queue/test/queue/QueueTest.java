package queue;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Yash Shah
 */
public class QueueTest 
{
    /**
     * Test of enqueue method, of class Queue.
     */
    @Test
    public void testEnqueue() 
    {
        System.out.println("enqueue");
        Queue<String> queue = new Queue<>();
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        assertEquals("ABC", queue.value());
    }

    /**
     * Test of dequeue method, of class Queue.
     */
    @Test
    public void testDequeue() 
    {
        System.out.println("dequeue");
        Queue<String> queue = new Queue<>();
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        queue.dequeue();
        assertEquals("BC", queue.value());
        queue.dequeue();
        queue.dequeue();
        assertEquals("", queue.value());
        queue.dequeue();
    }

    /**
     * Test of peek method, of class Queue.
     */
    @Test
    public void testPeek() 
    {
        System.out.println("peek");
        Queue<String> queue = new Queue<>();
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        assertEquals("A", queue.peek());
    }

    /**
     * Test of size method, of class Queue.
     */
    @Test
    public void testSize() 
    {
        System.out.println("size");
        Queue<String> queue = new Queue<>();
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        queue.enqueue("B");
        queue.enqueue("C");
        queue.dequeue();
        queue.dequeue();
        assertEquals(3, queue.size());
    }

    /**
     * Test of value method, of class Queue.
     */
    @Test
    public void testValue() 
    {
        System.out.println("value");
        Queue<String> queue = new Queue<>();
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        queue.enqueue("B");
        queue.enqueue("C");
        queue.dequeue();
        assertEquals("BCBC", queue.value());
    }
}
