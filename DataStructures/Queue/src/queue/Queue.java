package queue;

import linkedlist.LinkedList;

/**
 *
 * @author Yash Shah
 * @param <T>
 */
public class Queue<T> 
{
    private final LinkedList<T> list;
    public Queue() 
    {
        list = new LinkedList<>();
    }
    
    /**
     * Insert element in queue at the last position
     * 
     * @param value Element to be inserted
     */
    public void enqueue(T value)
    {
        // List is Thread-Safe and as that's the only operation
        // being called, we don't have to worry about
        // synchronizing this method
        list.add(value);
    }
    
    /**
     * Remove first element from queue
     * 
     * @return Element removed
     */
    public T dequeue()
    {
        // List is Thread-Safe and as that's the only operation
        // being called, we don't have to worry about
        // synchronizing this method
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
     * Check if the queue is empty. 
     * 
     * @return True if empty, false otherwise.
     */
    public boolean isEmpty()
    {
        return list.getListSize() == 0;
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
