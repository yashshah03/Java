/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binraytree;
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
    */ 
    public void createBT(T root);
    /**
    * Adds new element as the right child of the node.
    *
    * @param  parentNode Parent node to which the right child is added
    * @param  value Element to be added
    */ 
    public void insertLeftBT(BinaryTreeNode parentNode, T value);
    /**
    * Adds new element as the right child of the node.
    *
    * @param  parentNode Parent node to which the right child is added
    * @param  value Element to be added
    */ 
    public void insertRightBT(BinaryTreeNode parentNode, T value);
    /**
    * Deletes a node with given value. This will remove the entire sub-tree of
    * with deleted node as root.
    * <p>
    * If multiple nodes with the same value exist, deletes the first node found
    *
    * @param  value Element to be deleted
    * @return True if deleted, false otherwise
    */ 
    public boolean deleteNodeBT(T value);
    /**
    * Check if a node with given value exist
    *
    * @param  value Element to be found
    * @return True if found, false otherwise 
    */ 
    public boolean containsNodeBT(T value);
    /**
    * Get all nodes with the given value
    *
    * @param  value Element to be found
    * @return List of all nodes with given values 
    */ 
    public ArrayList<BinaryTreeNode> getNodesBT(T value);
}
