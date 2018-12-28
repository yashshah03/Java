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
    * Adds new element to the end of the list. 
    *
    * @param  value Element to be added
    * @see          LinkedListNode
    */ 
    public void add(T value)
    {
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
    /**
    * Adds new element to the list at given index, except at the end of list.
    * To push element at the end of list use regular Add method without index.
    * <p>
    * The list must be initialized and have at least one element.
    *
    * @param  value Element to be added
    * @param  index index for the new element
    * @see          LinkedListNode
    * @see          LinkedList.add()
    */ 
    public void add(T value, int index)
    {
        if(index == size)
        {
            System.err.println("[ERROR] Cannot enter element at the end"
                    + ", To add at the end, use push without index");
            return;
        }
        if(index > size)
        {
            System.err.println("[ERROR] Cannot enter element at given index"
                    + ", index must be smaller than list size");
            return;
        }
        
        LinkedListNode<T> nNode = new LinkedListNode<>(value);
        LinkedListNode<T> cNode = head;
        LinkedListNode<T> pNode = cNode;
        int i = 0;
        while(i++ < index)
        {
            pNode = cNode;
            cNode = cNode.getNext();
        }
        nNode.setNext(cNode);
        if(index > 0) pNode.setNext(nNode);
        if(index == 0) head = nNode;
        size++;
    }
    /**
    * Removes the head element out of the list. 
    *
    * @return  Removed linkedListNode
    * @see     LinkedListNode
    */ 
    public T remove()
    {
        if(head!=null)
        {
            LinkedListNode<T> rNode = head;
            head = head.getNext();
            size--;
            return rNode.getValue();
        }
        else
        {
            System.err.println("[ERROR] Cannot remove, list empty");
            return null;
        }
    }
    /**
    * Removes element with given value out of the list.
    * <p>
    * If multiple elements exists with given value, method removes first 
    * element found with the value
    *
    * @param  value Element to be removed
    * @return  Removed linkedListNode
    * @see     LinkedListNode
    */ 
    public T remove(T value)
    {
        if(head!=null)
        {
            LinkedListNode<T> cNode = head;
            LinkedListNode<T> pNode = cNode;
            while(cNode != null && cNode.getValue() != value)
            {
                pNode = cNode;
                cNode = cNode.getNext();
            }
            if(cNode == null)
            {
                System.err.println("[ERROR] Cannot remove, No element found");
                return null;
            }
            if(cNode == head)
                head = head.getNext();
            else
                pNode.setNext(cNode.getNext());            
            
            size--;
            return cNode.getValue();
        }
        else
        {
            System.err.println("[ERROR] Cannot remove, list empty");
            return null;
        }
    }
    /**
    * Get the head element of list.  
    * <p>
    * This will not remove any element of the list.
    *
    * @return  Head element of the list
    * @see     LinkedListNode
    */ 
    public T getHead()
    {
        if(head!=null)
            return head.getValue();
        else
            System.err.println("[ERROR] list empty");
        
        return null;
    }
    /**
    * Get the current (Tail) element of list. 
    * <p>
    * This will not remove any element of the list.
    *
    * @return  current element of the list
    * @see     LinkedListNode
    */ 
    public T getCurrent()
    {
        if(current!=null)
            return current.getValue();
        else
            System.err.println("[ERROR] list empty");
        
        return null;
    }
    /**
    * Get the element at given index of list. Indexing is 0 (zero) based.
    * <p>
    * This will not remove any element of the list. 
    *
    * @param   index index of the element to be returned
    * @return  current element of the list
    * @see     LinkedListNode
    */ 
    public T get(int index)
    {
        if(index<size)
        {
            LinkedListNode<T> cNode = head;
            int i = 0;
            while(i++ < index)
                cNode = cNode.getNext();
            
            return cNode.getValue();
        }
        else
            System.err.println("[ERROR] Index can't be greater than list size");
        
        return null;
    }
    /**
    * Get the list size
    *
    * @return  size of the list
    * @see     LinkedList
    */
    public int getListSize()
    {
        return this.size;
    }
    /**
    * Get the list element in form of a string
    *
    * @return  list elements represented as string
    * @see     LinkedList
    */
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
