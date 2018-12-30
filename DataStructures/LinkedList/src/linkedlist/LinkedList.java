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
    public synchronized void add(T value)
    {
        if(this.head!=null)
        {
            LinkedListNode<T> cNode = new LinkedListNode<>(value);
            // Set next node
            current.setNext(cNode);
            // Set previous node
            cNode.setPrev(current);
            current = cNode;
        }
        else
        {
            this.head = new LinkedListNode<>(value);
            current = this.head;
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
    public synchronized void add(T value, int index)
    {
        if(index < 0) 
        {
            System.err.println("[ERROR] Index cannot be less than 0");
            return;
        }
        if(index == size)
        {
            System.err.println("[ERROR] To add at the end, use regular add()");
            return;
        }
        if(index > size)
        {
            System.err.println("[ERROR] Cannot enter element at given index"
                    + ", index must be smaller than list size");
            return;
        }
        
        LinkedListNode<T> nNode = new LinkedListNode<>(value);
        LinkedListNode<T> cNode = this.head;
        LinkedListNode<T> pNode = cNode;
        int i = 0;
        while(i++ < index)
        {
            pNode = cNode;
            cNode = cNode.getNext();
        }
        // Set next
        nNode.setNext(cNode);
        // Set previous
        cNode.setPrev(nNode);
        if(index > 0) 
        {
            // Set next
            pNode.setNext(nNode);
            // Set previous
            nNode.setPrev(pNode);
            
        }
        else this.head = nNode;
        size++;
    }
    /**
    * Removes the head element out of the list. 
    *
    * @return  Removed linkedListNode
    * @see     LinkedListNode
    */ 
    public synchronized T remove()
    {
        if(this.head!=null)
        {
            LinkedListNode<T> rNode = this.head;
            this.head = head.getNext();
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
    * Removes the current(tail) element out of the list. 
    *
    * @return  Removed linkedListNode value
    * @see     LinkedListNode
    */ 
    public synchronized T removeCurrent()
    {
        if(this.current!=null)
        {
            LinkedListNode<T> nullNode = null;
            LinkedListNode<T> rNode = this.current;
            if(rNode.getPrev()!=null)
            {
                this.current = rNode.getPrev();
                this.current.setNext(nullNode);
            }
            else
            {
                this.current = null;
                this.head = null;
            }
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
    public synchronized T remove(T value)
    {
        if(this.head!=null)
        {
            LinkedListNode<T> cNode = this.head;
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
            if(cNode == this.head)
            {
                if(this.head.getNext()!= null)
                {
                    this.head = this.head.getNext();
                    // Clear previous
                    this.head.setPrev(null);
                }
                else 
                    this.head = null;
            }
            else
            {
                LinkedListNode<T> nNode = cNode.getNext();
                // set next
                pNode.setNext(nNode);
                // set previous
                nNode.setPrev(pNode);
            }            
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
    * Get the this.head element of list.  
    * <p>
    * This will not remove any element of the list.
    *
    * @return  Head element of the list
    * @see     LinkedListNode
    */ 
    public T getHead()
    {
        if(this.head!=null)
            return this.head.getValue();
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
        if(index < 0) 
        {
            System.err.println("[ERROR] Index cannot be less than 0");
            return null;
        }
        if(index<size)
        {
            LinkedListNode<T> cNode = this.head;
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
    * Get all the list elements (from head to current) in form of a string
    *
    * @return  list elements (from head to current) represented as string
    * @see     LinkedList
    */
    public String getListValue()
    {
        String retValue = "";
        LinkedListNode<T> cNode = this.head;
        while(cNode != null)
        {
            retValue += cNode.getValue();
            cNode = cNode.getNext();
        }
        return retValue;
    }
    /**
    * Get all the list elements (from current to head) in form of a string
    *
    * @return  list elements (from current to head) represented as string
    * @see     LinkedList
    */
    public String getListValueReversed()
    {
        String retValue = "";
        LinkedListNode<T> cNode = current;
        while(cNode != null)
        {
            retValue += cNode.getValue();
            cNode = cNode.getPrev();
        }
        return retValue;
    }
}
