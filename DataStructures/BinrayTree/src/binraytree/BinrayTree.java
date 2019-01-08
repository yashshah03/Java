package binraytree;

import java.util.ArrayList;

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
    public void createBT(T root) 
    {
        if(this.root.getValue() == null)
        {
            this.root.setValue(root);
        }
        else
        {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
            
    }

    @Override
    public void insertLeftBT(BinaryTreeNode parentNode, T value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertRightBT(BinaryTreeNode parentNode, T value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteNodeBT(T value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean containsNodeBT(T value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<BinaryTreeNode> getNodesBT(T value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
