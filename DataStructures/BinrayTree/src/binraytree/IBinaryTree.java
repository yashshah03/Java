/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binraytree;
import customexception.CustomException;
import java.util.ArrayList;
/**
 *
 * @author Yash Shah
 * @param <T>
 */
public interface IBinaryTree <T>
{
    /**
     * Creates a new tree with root value as given.
     *
     * @param  root Root Element value
     * @return Binary Tree Root Node 
     */ 
    public BinaryTreeNode createBT(T root);
    /**
     * Adds new element as the right child of the node.
     *
     * @param  parentNode Parent node to which the right child is added
     * @param  value Element to be added
     * @return inserted Binary Tree Node 
     * @throws customexception.CustomException 
     */ 
    public BinaryTreeNode insertLeftBTNode(BinaryTreeNode parentNode, T value) throws CustomException;
    /**
     * Adds new element as the right child of the node.
     *
     * @param  parentNode Parent node to which the right child is added
     * @param  value Element to be added
     * @return inserted Binary Tree Node 
     * @throws customexception.CustomException 
     */ 
    public BinaryTreeNode insertRightBTNode(BinaryTreeNode parentNode, T value) throws CustomException;
    /**
     * Deletes a node with given value. This will remove the entire sub-tree of
     * with deleted node as root.
     * <p>
     * If multiple nodes with the same value exist, deletes the first node found
     *
     * @param  value Element to be deleted
     * @return deleted Binary Tree Node 
     */ 
    public BinaryTreeNode deleteBTNode(T value);
    /**
     * Check if a node with given value exist
     *
     * @param  value Element to be found
     * @return True if found, false otherwise 
     */ 
    public boolean containsBTNode(T value);
    /**
     * Get all nodes with the given value
     *
     * @param  value Element to be found
     * @return List of all nodes with given values 
     */ 
    public ArrayList<BinaryTreeNode> getBTNodes(T value);
}
