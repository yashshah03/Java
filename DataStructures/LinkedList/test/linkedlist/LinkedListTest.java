package linkedlist;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Yash Shah
 */
public class LinkedListTest 
{
    @Test
    public void testAdd() 
    {
        System.out.println("Add");
        LinkedList<String> list = new LinkedList<>();        
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("A");  
        assertEquals("ABCDA", list.getListValue());
    }
    @Test
    public void testAddAtIndex() 
    {
        System.out.println("Add at index");
        LinkedList<String> list = new LinkedList<>();        
        list.add("A");
        list.add("B");
        list.add("C", 0);
        list.add("D", 1);
        list.add("A");  
        assertEquals("CDABA", list.getListValue());
    }
    @Test
    public void testRemove() 
    {
        System.out.println("Remove");
        LinkedList<String> list = new LinkedList<>();        
        list.add("A");
        list.add("B");
        list.add("A");
        list.remove();
        list.remove();
        list.remove(); 
        list.remove(); // List empty  
        assertEquals("", list.getListValue());
    }
    @Test
    public void testRemoveValue() 
    {
        System.out.println("Remove value");
        LinkedList<String> list = new LinkedList<>();        
        list.add("A");
        list.add("B");
        list.add("C", 0);
        list.add("D", 1);
        list.add("A");
        list.add("B");
        list.remove("A");
        list.remove("C");
        list.remove("B");
        list.remove("D");
        list.remove("A"); 
        list.remove("F"); // Not in list
        list.remove("B");
        list.remove("B"); // List empty  
        assertEquals("", list.getListValue());
    }
}
