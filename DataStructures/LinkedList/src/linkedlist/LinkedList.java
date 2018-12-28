package linkedlist;

/**
 *
 * @author Yash Shah
 * @param <T>
 */
public class LinkedList<T> 
{
    private LinkedListNode<T> head = null;
    private LinkedListNode<T> current = null;
    private int size = 0;
    /**
    * Pushes new element to the list. 
    *
    * @param  value Element to be added
    * @see         LinkedListNode
    */ 
    public void push(T value)
    {
        // If HEAD is populated
        if(head!=null)
        {
            LinkedListNode<T> cNode = new LinkedListNode<>(value);
            current.setNext(cNode);
            current = cNode;
        }
        else
        {
            head = new LinkedListNode<>(value);
            head.setValue(value);
            current = head;
        }
        size++;
    }
    
    public String getListValue()
    {
        String retValue = "";
        LinkedListNode<T> cNode = head;
        while(cNode != null)
        {
            retValue += cNode.getValue();
            cNode = cNode.getNext();
        }
        return retValue;
    }
}
