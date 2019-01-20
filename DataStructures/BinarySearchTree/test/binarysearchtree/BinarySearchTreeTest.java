/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearchtree;

import customexception.CustomException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Yash Shah
 */
public class BinarySearchTreeTest {
    
    public BinarySearchTreeTest() {
    }
    
    /**
     * Test of insert method, of class BinarySearchTree.
     */
    @Test
    public void testInsert() 
    {
        System.out.println("insert");
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(10);
        bst.insert(20);
        bst.insert(14);
        bst.insert(12);
        bst.insert(18);
        bst.insert(15);
        try 
        {
            assertEquals(bst.getInOrder().trim(), "10 12 14 15 18 20");
        } 
        catch (CustomException e)
        {
            fail(e.getMessage());
        }
    }

    /**
     * Test of search method, of class BinarySearchTree.
     */
    @Test
    public void testSearch() 
    {
        System.out.println("search");
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(10);
        bst.insert(20);
        bst.insert(14);
        bst.insert(12);
        bst.insert(18);
        assertEquals(true, bst.search(10));
        assertEquals(true, bst.search(20));
        assertEquals(false, bst.search(15));
        assertEquals(true, bst.search(14));
        assertEquals(true, bst.search(12));
        assertEquals(false, bst.search(25));
        assertEquals(true, bst.search(18));
        assertEquals(false, bst.search(-18));
    }

    /**
     * Test of get method, of class BinarySearchTree.
     */
    @Test
    public void testGet() 
    {
        System.out.println("get");
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(10);
        bst.insert(20);
        bst.insert(14);
        bst.insert(12);
        bst.insert(18);
        assertEquals(10, Integer.parseInt(bst.get(10).getValue().toString()));
        assertEquals(20, Integer.parseInt(bst.get(20).getValue().toString()));
    }

    /**
     * Test of delete method, of class BinarySearchTree.
     * @throws java.lang.Exception
     */
    @Test
    public void testDelete() throws Exception 
    {
        System.out.println("delete");
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(10);
        bst.insert(20);
        bst.insert(14);
        bst.insert(12);
        bst.insert(18);
        bst.delete(10);
        bst.delete(20);
        assertEquals(false, bst.search(10));
        assertEquals(false, bst.search(20));
        try
        {
            bst.delete(30);
        }
        catch(CustomException e)
        {
            System.out.println(e.getMessage() + " @[" + e.location() + "]");
        }
    }

    /**
     * Test of getMinimum method, of class BinarySearchTree.
     */
    @Test
    public void testGetMinimum_0args() 
    {
        System.out.println("getMinimum");
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(10);
        bst.insert(20);
        bst.insert(14);
        bst.insert(12);
        bst.insert(18);
        assertEquals(10, Integer.parseInt(bst.getMinimum().toString()));
        bst.insert(4);
        bst.insert(2);
        bst.insert(8);
        assertEquals(2, Integer.parseInt(bst.getMinimum().toString()));
    }

    /**
     * Test of getMinimum method, of class BinarySearchTree.
     */
    @Test
    public void testGetMinimum_BinaryTreeNode() 
    {
        System.out.println("getMinimum");
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(10);
        bst.insert(20);
        bst.insert(14);
        bst.insert(12);
        bst.insert(18);
        /*
        10
          20
        14
      12  18
        */
        assertEquals(12, Integer.parseInt(bst.getMinimum(bst.get(14)).toString()));
        bst.insert(4);
        bst.insert(2);
        bst.insert(8);
        /*
        10
    4        20
   2 8     14
         12  18
        */
        assertEquals(2, Integer.parseInt(bst.getMinimum(bst.get(4)).toString()));
    }

    /**
     * Test of printInOrder method, of class BinarySearchTree.
     * @throws customexception.CustomException
     */
    @Test
    public void testGetInOrder() throws CustomException 
    {
        System.out.println("printInOrder");
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(10);
        bst.insert(20);
        bst.insert(14);
        bst.insert(12);
        bst.insert(18);
        bst.insert(4);
        bst.insert(2);
        bst.insert(8);
        /*
        10
    4        20
   2 8     14
         12  18
        */
        assertEquals("2 4 8 10 12 14 18 20", bst.getInOrder().trim());
    }

    /**
     * Test of printPreOrder method, of class BinarySearchTree.
     * @throws customexception.CustomException
     */
    @Test
    public void testGetPreOrder() throws CustomException 
    {
        System.out.println("printPreOrder");
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(10);
        bst.insert(20);
        bst.insert(14);
        bst.insert(12);
        bst.insert(18);
        bst.insert(4);
        bst.insert(2);
        bst.insert(8);
        /*
        10
    4        20
   2 8     14
         12  18
        */
        assertEquals("10 4 2 8 20 14 12 18", bst.getPreOrder().trim());
    }

    /**
     * Test of printPostOrder method, of class BinarySearchTree.
     * @throws customexception.CustomException
     */
    @Test
    public void testGetPostOrder() throws CustomException 
    {
        System.out.println("printPostOrder");
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(10);
        bst.insert(20);
        bst.insert(14);
        bst.insert(12);
        bst.insert(18);
        bst.insert(4);
        bst.insert(2);
        bst.insert(8);
        /*
        10
    4        20
   2 8     14
         12  18
        */
        assertEquals("2 8 4 12 18 14 20 10", bst.getPostOrder().trim());
    }    
}
