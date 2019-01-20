/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytree;

import customexception.CustomException;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Yash Shah
 */
public class BinaryTreeTest 
{
    
    public BinaryTreeTest() 
    {
    }

    /**
     * Test of createBT method, of class BinaryTree.
     */
    @Test
    public void testCreateBT() 
    {
        System.out.println("CreateBT");
        IBinaryTree<String> bt = new BinaryTree<>();
        String root = "Root";
        BinaryTreeNode result = bt.createBT(root);
        assertEquals("Root", bt.getBTNodes("Root").get(0).getValue());
    }

    /**
     * Test of insertLeftBTNode method, of class BinaryTree.
     */
    @Test
    public void testInsertLeftBTNode() throws Exception 
    {
        System.out.println("insertLeftBTNode");
        IBinaryTree<String> bt = new BinaryTree<>();
        String root = "Root";
        BinaryTreeNode result = bt.createBT(root);
        bt.insertLeftBTNode(result, "Root-Left");
        assertEquals("Root-Left", bt.getBTNodes("Root-Left").get(0).getValue());
    }

    /**
     * Test of insertRightBTNode method, of class BinaryTree.
     */
    @Test
    public void testInsertRightBTNode() throws Exception 
    {
        System.out.println("insertRightBTNode");
        IBinaryTree<String> bt = new BinaryTree<>();
        String root = "Root";
        BinaryTreeNode result = bt.createBT(root);
        bt.insertLeftBTNode(result, "Root-Right");
        assertEquals("Root-Right", bt.getBTNodes("Root-Right").get(0).getValue());
    }

    /**
     * Test of deleteBTNode method, of class BinaryTree.
     */
    @Test
    public void testDeleteBTNode() throws Exception 
    {
        System.out.println("deleteBTNode");
        IBinaryTree<String> bt = new BinaryTree<>();
        String root = "Root";
        BinaryTreeNode result = bt.createBT(root);
        BinaryTreeNode resultL = bt.insertLeftBTNode(result, "Root-left");
        BinaryTreeNode resultR = bt.insertRightBTNode(result, "Root-right");
        BinaryTreeNode resultLL = bt.insertLeftBTNode(resultL, "Root-left-Left");
        BinaryTreeNode resultLR = bt.insertRightBTNode(resultL, "Root-left-Right");
        BinaryTreeNode resultRL = bt.insertLeftBTNode(resultR, "Root-right-Left");
        BinaryTreeNode resultRR = bt.insertRightBTNode(resultR, "Root-right-Right");
        assertEquals("Root-left-Right", bt.deleteBTNode("Root-left-Right").getValue());
    }

    /**
     * Test of containsBTNode method, of class BinaryTree.
     */
    @Test
    public void testContainsBTNode() throws CustomException 
    {
        System.out.println("containsBTNode");
        IBinaryTree<String> bt = new BinaryTree<>();
        String root = "Root";
        BinaryTreeNode result = bt.createBT(root);
        BinaryTreeNode resultL = bt.insertLeftBTNode(result, "Root-left");
        BinaryTreeNode resultR = bt.insertRightBTNode(result, "Root-right");
        BinaryTreeNode resultLL = bt.insertLeftBTNode(resultL, "Root-left-Left");
        BinaryTreeNode resultLR = bt.insertRightBTNode(resultL, "Root-left-Right");
        BinaryTreeNode resultRL = bt.insertLeftBTNode(resultR, "Root-right-Left");
        BinaryTreeNode resultRR = bt.insertRightBTNode(resultR, "Root-right-Right");
        assertEquals(true, bt.containsBTNode("Root-left-Right"));
    }

    /**
     * Test of getBTNodes method, of class BinaryTree.
     */
    @Test
    public void testGetBTNodes() throws CustomException 
    {
        System.out.println("getBTNodes");
        IBinaryTree<String> bt = new BinaryTree<>();
        String root = "R";
        BinaryTreeNode result = bt.createBT(root);
        BinaryTreeNode resultL = bt.insertLeftBTNode(result, "Rl");
        BinaryTreeNode resultR = bt.insertRightBTNode(result, "Rr");
        BinaryTreeNode resultLL = bt.insertLeftBTNode(resultL, "RL");
        BinaryTreeNode resultLR = bt.insertRightBTNode(resultL, "RR");
        BinaryTreeNode resultRL = bt.insertLeftBTNode(resultR, "RL");
        BinaryTreeNode resultRR = bt.insertRightBTNode(resultR, "RR");
        ArrayList<BinaryTreeNode> list = bt.getBTNodes("RR");
        String res = "";
        for(int i=0; i<list.size(); i++)
            res += list.get(i).getValue() + "-";
        
        assertEquals("RR-RR-", res);
    }
    
}
