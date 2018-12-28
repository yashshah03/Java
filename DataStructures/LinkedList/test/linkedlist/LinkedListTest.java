/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlist;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author yashs
 */
public class LinkedListTest 
{
    @Test
    public void testPush() 
    {
        System.out.println("push");
        LinkedList<String> list = new LinkedList<>();        
        list.push("A");
        list.push("B");
        list.push("C");
        list.push("D");
        list.push("A");  
        assertEquals("ABCDA", list.getListValue());
    }
}
