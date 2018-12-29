package linkedlist;

/**
 *
 * @author Yash Shah
 */
public class LinkedListNode<T> 
{
    private T value;
    private LinkedListNode<T> next;
    private LinkedListNode<T> prev;
    
    /**
    * Creates a LinkedListNode with given value 
    *
    * @param  value value of the node
    */
    public LinkedListNode(T value)
    {
        this.value = value;
        next = null;
        prev = null;
    }
    public LinkedListNode()
    {
        next = null;
        prev = null;
    }
    
    /**
    * Sets the node value to given value 
    *
    * @param  value Node value to be set
    */
    public void setValue(T value)
    {
        this.value = value;
    }
    /**
    * get the node value of next node 
    *
    * @return  The nextNode value from current node
    */
    public T getValue()
    {
        return this.value;
    }
    
    /**
    * Creates the next node from given value 
    *
    * @param  value value of the next node
    */
    public void setNext(T value)
    {
        LinkedListNode<T> nextNode = new LinkedListNode<>(value);
        this.next = nextNode;
    }
    /**
    * Sets the next node 
    *
    * @param  nextNode The next node to be set
    */
    public void setNext(LinkedListNode<T> nextNode)
    {
        this.next = nextNode;
    }
    /**
    * Sets the previous node 
    *
    * @param  prevNode The previous node to be set
    */
    public void setPrev(LinkedListNode<T> prevNode)
    {
        this.prev = prevNode;
    }
    /**
    * get the next node 
    *
    * @return  The nextNode from current node
    */
    public LinkedListNode<T> getNext()
    {
        return this.next;
    }
    /**
    * get the next node value
    *
    * @return  The nextNode value from current node
    */
    public T getNextVal()
    {
        return this.next.getValue();
    }
    /**
    * get the previous node 
    *
    * @return  The prevNode from current node
    */
    public LinkedListNode<T> getPrev()
    {
        return this.prev;
    }
    /**
    * get the previous node value
    *
    * @return  The prevNode value from current node
    */
    public T getPrevtVal()
    {
        return this.prev.getValue();
    }
}
