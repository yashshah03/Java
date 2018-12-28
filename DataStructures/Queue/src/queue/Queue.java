package queue;

import linkedlist.LinkedList;

/**
 *
 * @author Yash Shah
 * @param <T>
 */
public class Queue<T> 
{
    private LinkedList<T> list = new LinkedList<>();
    
    /**
     * Insert element in queue at the last position
     * 
     * @param value Element to be inserted
     */
    public void enqueue(T value)
    {
        list.add(value);
    }
    /**
     * Remove first element from queue
     * 
     * @return Element removed
     */
    public T dequeue()
    {
        return list.remove();
    }
    /**
     * Retrieve but don't remove the first element from queue. 
     * 
     * @return The first element in queue, null if queue empty
     */
    public T peek()
    {
        return list.getHead();
    }
    /**
     * Retrieve queue size. 
     * 
     * @return The size of the queue.
     */
    public int size()
    {
        return list.getListSize();
    }
    /**
     * Get the contents of queue. 
     * 
     * @return Contents of queue in string format.
     */
    public String value()
    {
        return list.getListValue();
    }
}
