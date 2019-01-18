package binarysearchtree;

import customexception.CustomException;

/**
 *
 * @author Yash Shah
 * @param <T>
 */
public class BinarySearchTree<T extends Comparable<T>> 
{
    private BinaryTreeNode<T> root;
    
    public BinarySearchTree (T value)
    {
        this.root = new BinaryTreeNode(value);
    }
    public BinarySearchTree ()
    {
        this.root = new BinaryTreeNode();
    }
    
    /**
     * Insert value in BST, throws exception if the value exists
     * 
     * @param value value of the node to be inserted 
     */
    public void insert(T value)
    {
        this.root = insertRecursive(this.root, value);        
    }
    
    /**
     * Search for a given value in BST
     * 
     * @param value value of the node to look for
     * @return True if found false otherwise
     */
    public boolean search(T value)
    {
        return searchRecursive(this.root, value) != null;
    }
    
    /**
     * Search and retrieve the node for a given value in BST
     * 
     * @param value value of the node to look for
     * @return BinaryTreeNode with the value 
     */
    public BinaryTreeNode<T> get(T value)
    {
        return searchRecursive(this.root, value);
    }
    
    /** PRIVATE HELPER METHODS ***/
    private BinaryTreeNode<T> insertRecursive(BinaryTreeNode<T> current, T value)
    {
        if(current == null)
            return new BinaryTreeNode(value);
        
        if(value.compareTo(current.getValue()) < 0)
            current.setLeft(insertRecursive(current.getLeft(), value));
        else
            current.setRight(insertRecursive(current.getRight(), value));
        
        return current;
    }
    
    private BinaryTreeNode<T> searchRecursive(BinaryTreeNode<T> current, T value)
    {
        if(current == null)
            return null;
        
        if(value.compareTo(current.getValue()) == 0)
            return current;
        else if(value.compareTo(current.getValue()) < 0)
            return searchRecursive(current.getLeft(), value);
        else
            return searchRecursive(current.getRight(), value);       
    }
    
    private String getFunctionLocation()
    {
        Exception e = new Exception();
        return e.getStackTrace()[0].getClassName() 
               + ": "
               + e.getStackTrace()[0].getMethodName();
    }
}
