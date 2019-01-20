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
    private enum Traversal 
    {
        IN_ORDER, PRE_ORDER, POST_ORDER;
    }
    
    public BinarySearchTree (T value)
    {
        this.root = new BinaryTreeNode(value);
    }
    public BinarySearchTree ()
    {
        this.root = null;
    }
    
    /**
     * Insert value in BST, throws exception if the value exists
     * 
     * @param value value of the node to be inserted 
     */
    public synchronized void
    insert(T value)
    {
        this.root = insertRecursive(this.root, value);        
    }
    
    /**
     * Search for a given value in BST
     * 
     * @param value value of the node to look for
     * @return True if found false otherwise
     */
    public boolean 
    search(T value)
    {
        return searchRecursive(this.root, value) != null;
    }
    
    /**
     * Search and retrieve the node for a given value in BST
     * 
     * @param value value of the node to look for
     * @return BinaryTreeNode with the value 
     */
    public BinaryTreeNode<T> 
    get(T value)
    {
        return searchRecursive(this.root, value);
    }
    
    /**
     * Delete the node for a given value in BST
     * 
     * @param value value of the node to look for
     * @throws CustomException if value to be deleted does not exist
     */
    public synchronized void 
    delete(T value) 
    throws CustomException
    {
        this.root = deleteRecursive(this.root, value);
    }
    
    /**
     * Get the minimum value of the entire BST
     * 
     * @return Minimum value of the tree
     */
    public T 
    getMinimum()
    {
        return getMinimum(this.root);
    }
    
    /**
     * Get the minimum value of the sub-tree of the given node
     * 
     * @param currentNode Root node of the sub-tree
     * @return Minimum value of the sub-tree rooted at given node
     */
    public T 
    getMinimum(BinaryTreeNode<T> currentNode)
    {
        if(currentNode == null)
            return null;
        
        T minVal = currentNode.getValue();
        while(currentNode.getLeft() != null)
        {
            currentNode = currentNode.getLeft();
            minVal = currentNode.getValue();
        }
        return minVal;
    }
  
    /**
     * Get the contents of BST in In_Order_Traversal
     * @return In_Order traversal in string form
     * @throws CustomException if the tree is empty
     */
    public String
    getInOrder() 
    throws CustomException
    {
        if(this.root == null)
            throw new CustomException("The BST is empty", 
                                      BSTExceptions.TREE_EMPTY.c(),
                                      getClassLocation()+": getInOrder");
        return getRecursive(this.root, Traversal.IN_ORDER, "");
    }
    
    /**
     * Get the contents of BST in Pre_Order_Traversal
     * @return Pre_Order traversal in string form
     * @throws CustomException if the tree is empty
     */
    public String
    getPreOrder() 
    throws CustomException
    {
        if(this.root == null)
            throw new CustomException("The BST is empty", 
                                      BSTExceptions.TREE_EMPTY.c(),
                                      getClassLocation()+": getPreOrder");
        return getRecursive(this.root, Traversal.PRE_ORDER, "");
    }
    
    /**
     * Get the contents of BST in Post_Order_Traversal
     * @return Pose_Order traversal in string form
     * @throws CustomException if the tree is empty
     */
    public String
    getPostOrder() 
    throws CustomException
    {
        if(this.root == null)
            throw new CustomException("The BST is empty", 
                                      BSTExceptions.TREE_EMPTY.c(),
                                      getClassLocation()+": getPostOrder");
        return getRecursive(this.root, Traversal.POST_ORDER, "");
    }
    
    
    /***************************** 
        PRIVATE HELPER METHODS 
     ****************************/
    private BinaryTreeNode<T> 
    insertRecursive(BinaryTreeNode<T> current, T value)
    {
        if(current == null)
            return new BinaryTreeNode(value);
        
        if(value.compareTo(current.getValue()) < 0)
            current.setLeft(insertRecursive(current.getLeft(), value));
        else
            current.setRight(insertRecursive(current.getRight(), value));
        
        return current;
    }
    
    private BinaryTreeNode<T> 
    searchRecursive(BinaryTreeNode<T> current, T value)
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
    
    private BinaryTreeNode<T> 
    deleteRecursive(BinaryTreeNode<T> current, T value) 
    throws CustomException
    {
        if(current == null)
            throw new CustomException("The value to be deleted does not exist", 
                                      BSTExceptions.VALUE_DOES_NOT_EXISTS.c(), 
                                      getClassLocation()+": delete");
        
        
        if(value.compareTo(current.getValue()) < 0)
        {
            current.setLeft(deleteRecursive(current.getLeft(), value));
        }
        else if(value.compareTo(current.getValue()) > 0)
        {
            current.setRight(deleteRecursive(current.getRight(), value));
        }
        else
        {
            // Node with only one child
            if(current.getLeft() == null)
                return current.getRight();
            else if(current.getRight() == null)
                return current.getLeft();
            
            // Node with 2 children
            // Find the "In-Order Successor"
            //   - Smallest value in the subtree rooted at right of current node
            // Replace current node with in-order successor found
            // Delete the "In-Order Successor"
            current.setValue(getMinimum(current.getRight()));
            current.setRight(deleteRecursive(current.getRight(), 
                             current.getValue()));
            
        }
        return current;
    }
    
    private String
    getRecursive(BinaryTreeNode<T> current, Traversal type, String ret)
    {
        if(current == null)
            return "";
        
        String left, right;
        switch (type) 
        {
            // IN-ORDER
            case IN_ORDER:
                left = getRecursive(current.getLeft(), type, ret);
                right = getRecursive(current.getRight(), type, ret);
                ret = left + current.getValue() + " " + right;
                break;
            // PRE-ORDER
            case PRE_ORDER:
                left = getRecursive(current.getLeft(), type, ret);
                right = getRecursive(current.getRight(), type, ret);
                ret = current.getValue() + " " + left + right;
                break;
            // POST-ORDER
            case POST_ORDER:
                left = getRecursive(current.getLeft(), type, ret);
                right = getRecursive(current.getRight(), type, ret);
                ret = left + right + current.getValue() + " ";
                break;
        }
        return ret;
    }
    
    private String 
    getClassLocation()
    {
        Exception e = new Exception();
        return e.getStackTrace()[0].getClassName();
    }
}
