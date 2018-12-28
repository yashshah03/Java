package linkedlist;

/**
 *
 * @author Yash Shah
 */
public class LinkedListNode<T> 
{
    private T value;
    private LinkedListNode<T> next = null;
    
    /**
    * Creates a LinkedListNode with given value 
    *
    * @param  value value of the node
    */
    public LinkedListNode(T value)
    {
        this.value = value;
    }
    public LinkedListNode()
    {}
    
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
}
