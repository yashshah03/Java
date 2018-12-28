package linkedlist;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Yash Shah
 */
public class LinkedListTest 
{
    public class CustomObject
    {
        int a = 0;
        int b = 0;
        String c = "c";
    };

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
    
    @Test
    public void testCustomObject() 
    {
        System.out.println("Custom object");
        CustomObject cObj = new CustomObject();
        cObj.a = 10;
        cObj.b = 20;
        cObj.c = "Hello";
        LinkedList<CustomObject> list = new LinkedList<>();    
        list.add(cObj);    
        CustomObject cObj2 = (CustomObject)list.remove();
        assertEquals(cObj.a + " " + cObj.b + " " + cObj.c, cObj2.a + " " + cObj2.b + " " + cObj2.c);
    }
    
    @Test
    public void testGetHead() 
    {
        System.out.println("getHead");
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C", 0);
        list.add("D");
        assertEquals("C", list.getHead());
    }

    @Test
    public void testGetCurrent() 
    {
        System.out.println("getCurrent");
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C", 1);
        list.add("D");
        assertEquals("D", list.getCurrent());
    }

    @Test
    public void testGet() 
    {
        System.out.println("get");
        LinkedList<String> list = new LinkedList<>();
        list.add("A"); 
        list.add("B"); 
        list.add("C", 1); 
        list.add("D", 2); 
        assertEquals("B", list.get(3));
    }

    @Test
    public void testGetListSize() 
    {
        System.out.println("getListSize");
        LinkedList<String> list = new LinkedList<>();
        list.add("A"); 
        list.add("B"); 
        list.add("C", 1); 
        list.add("D", 2); 
        assertEquals(4, list.getListSize());
    }

    @Test
    public void testGetListValue() 
    {
        System.out.println("getListValue");
        LinkedList<String> list = new LinkedList<>();
        list.add("A"); 
        list.add("B"); 
        list.add("C", 1);
        list.add("D", 2);
        assertEquals("ACDB", list.getListValue());
    }
}
