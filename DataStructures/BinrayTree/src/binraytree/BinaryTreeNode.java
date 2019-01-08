package binraytree;
/**
 *
 * @author Yash Shah
 * @param <T>
 */
public class BinaryTreeNode<T> 
{
    private T value;
    private BinaryTreeNode<T> left;
    private BinaryTreeNode<T> right;
    
    public BinaryTreeNode()
    {
        this.value = null;
        this.left = null;
        this.right = null;
    }
    /** 
     * Binary tree node with value
     * 
     * @param value value the node to be initiated with
     */
    public BinaryTreeNode(T value)
    {
        this.value = value;
        this.left = null;
        this.right = null;
    }
    /**
     * Set the node value
     * 
     * @param value value of the node
     */
    public void setValue(T value)
    {
        this.value = value;
    }
    /**
     * Set the right child node
     * 
     * @param right the node to be set as right node
     */
    public void setRight(BinaryTreeNode<T> right)
    {
        this.right = right;
    }
    /**
     * Set the left child node
     * 
     * @param left the node to be set as left node
     */
    public void setLeft(BinaryTreeNode<T> left)
    {
        this.left = left;
    }
    /**
     * Create and Set the right child node
     * 
     * @param value the value of right node
     */
    public void setRight(T value)
    {
        BinaryTreeNode<T> rNode = new BinaryTreeNode<>(value); 
        this.right = rNode;
    }
    /**
     * Create and Set the left child node
     * 
     * @param value the value of left node
     */
    public void setLeft(T value)
    {
        BinaryTreeNode<T> lNode = new BinaryTreeNode<>(value); 
        this.left = lNode;
    }
    /**
     * Get the node value
     * 
     * @return  value of the node
     */
    public T getValue()
    {
        return this.value;
    }
    /**
     * Get the right child node
     * 
     * @return  The right node
     */
    public BinaryTreeNode<T> getRight()
    {
        return this.right;
    }
    /**
     * Get the left child node
     * 
     * @return  the left node
     */
    public BinaryTreeNode<T> getLeft()
    {
        return this.left;
    }
}
