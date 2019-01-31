package stack;

import linkedlist.LinkedList;
/**
 *
 * @author Yash Shah
 * @param <T>
 */
public class Stack<T>
{
    private final LinkedList<T> list;
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
        // List is Thread-Safe and as that's the only operation
        // being called, we don't have to worry about
        // synchronizing this method
        list.add(value);
    }
    
    /**
     * Remove top element from stack
     * 
     * @return Element removed
     */
    public T pop()
    {
        // List is Thread-Safe and as that's the only operation
        // being called, we don't have to worry about
        // synchronizing this method
        return list.removeCurrent();
    }
    
    /**
     * Retrieve but don't remove the first element from stack. 
     * 
     * @return The first element in stack, null if stack empty
     */
    public T peek()
    {
        return list.getCurrent();
    }
    
    /**
     * Retrieve stack size. 
     * 
     * @return The size of the stack.
     */
    public int size()
    {
        return list.getListSize();
    }
    
    /**
     * Check if stack is empty. 
     * 
     * @return true if stack is empty, false otherwise.
     */
    public boolean isEmpty()
    {
        return list.getListSize() == 0;
    }

    /**
     * Get the contents of stack. 
     * 
     * @return Contents of stack in string format.
     */
    public String value()
    {
        return list.getListValueReversed();
    }
}
