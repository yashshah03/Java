package binraytree;

import java.util.ArrayList;
import customexception.CustomException;

/**
 *
 * @author Yash Shah
 * @param <T>
 */
public class BinrayTree<T> implements IBinaryTree<T>
{
    private final BinaryTreeNode<T> root;
    public BinrayTree()
    {
        root = new BinaryTreeNode<>();
    }

    @Override
    public BinaryTreeNode createBT(T root) 
    {
        if(this.root.getValue() == null)
        {
            this.root.setValue(root);
        }
        
        return this.root;
    }

    @Override
    public BinaryTreeNode 
    insertLeftBTNode(BinaryTreeNode parentNode, T value) 
    throws CustomException 
    {
        BinaryTreeNode newNode = new BinaryTreeNode(value);
        if(parentNode == null)
            throw new CustomException("Parent node can not be NULL", 1001, getFunctionLocation());   
        else
            parentNode.setLeft(newNode);
        
        return newNode;
    }

    @Override
    public BinaryTreeNode 
    insertRightBTNode(BinaryTreeNode parentNode, T value)
    throws CustomException  
    {
        BinaryTreeNode newNode = new BinaryTreeNode(value);
        if(parentNode == null)
            throw new CustomException("Parent node can not be NULL", 1001, getFunctionLocation());   
        else
            parentNode.setRight(newNode);
        
        return newNode;
    }

    @Override
    public BinaryTreeNode deleteBTNode(T value) 
    {
        return inorderDeleteBTNode(value, this.root);
    }

    @Override
    public boolean containsBTNode(T value) 
    {
        return inorderContainsBTNode(value, this.root);
    }

    @Override
    public ArrayList<BinaryTreeNode> getBTNodes(T value) 
    {
        ArrayList<BinaryTreeNode> returnList = new ArrayList<>();
        return inorderGetBTNodes(value, this.root, returnList);
    }
    
    private String getFunctionLocation()
    {
        Exception e = new Exception();
        return e.getStackTrace()[0].getClassName() 
               + ": "
               + e.getStackTrace()[0].getMethodName();
    }
    
    private BinaryTreeNode inorderDeleteBTNode(T value, BinaryTreeNode curNode)
    {
        if(curNode == null)
            return null;
        
        BinaryTreeNode deletedNode = null;
        
        if(curNode.getValue() == value)
        {
            deletedNode = curNode;
            curNode = null;
        }
        
        if(deletedNode == null) 
            deletedNode = inorderDeleteBTNode(value, curNode.getRight());
        
        if(deletedNode == null) 
            deletedNode = inorderDeleteBTNode(value, curNode.getLeft());
        
        return deletedNode;
    }
    
    private boolean inorderContainsBTNode(T value, BinaryTreeNode curNode)
    {
        boolean found = false;
        if(curNode == null)
            return found;
        
        if(curNode.getValue() == value)
            found = true;
        
        if(!found) found = inorderContainsBTNode(value, curNode.getRight());        
        if(!found) found = inorderContainsBTNode(value, curNode.getLeft());
        
        return found;
    }
    
    private ArrayList<BinaryTreeNode> inorderGetBTNodes(T value, BinaryTreeNode curNode, ArrayList<BinaryTreeNode> list)
    {
        if(curNode == null)
            return list;
            
        if(curNode.getValue() == value)
            list.add(curNode);
        
        list = inorderGetBTNodes(value, curNode.getRight(), list);        
        list = inorderGetBTNodes(value, curNode.getLeft(), list);
        
        return list;
    }
}
