package stack;

import linkedlist.LinkedList;
/**
 *
 * @author Yash Shah
 * @param <T>
 */
public class Stack<T>
{
    private LinkedList<T> list;
    public Stack() 
    {
        this.list = new LinkedList<>();
    }
    
    /**
     * Insert element in stack at the top position
     * 
     * @param value Element to be inserted
     */
    public void push(T value)
    {
        list.add(value);
    }
    /**
     * Remove top element from stack
     * 
     * @return Element removed
     */
    public T pop()
    {
        return list.removeCurrent();
    }
    /**
     * Retrieve but don't remove the first element from queue. 
     * 
     * @return The first element in queue, null if queue empty
     */
    public T peek()
    {
        return list.getCurrent();
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
        return list.getListValueReversed();
    }
}
