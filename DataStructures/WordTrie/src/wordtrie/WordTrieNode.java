package wordtrie;

import java.util.ArrayList;

/**
 *
 * @author Yash Shah
 */
public class WordTrieNode 
{
    private boolean isLeaf;
    private boolean isEnd;
    private final boolean isRoot;
    private char value;
    private ArrayList<WordTrieNode> children;
    
    /**
     * Create root node
     */
    public WordTrieNode()
    {
        this.isRoot = true;
        this.isLeaf = false;
        this.isEnd = false;
        this.children = new ArrayList();
    }
    
    /**
     * Create new node with value
     * @param value value of the node
     */
    public WordTrieNode(char value)
    {
        this.isRoot = false;
        this.isLeaf = true;
        this.isEnd = false;
        this.value = value;
        this.children = new ArrayList();
    }
    
    /**
     * Create and or retrieve a child node with given value
     * @param value
     * @return 
     */
    public WordTrieNode insertAndOrGet(char value)
    {
        // Get if the node exists
        WordTrieNode newNode = getChild(value);
        // If child does not exist
        if(newNode == null)
        {
            // Make sure current node is not set as leaf
            if(this.isLeaf) this.isLeaf = false;
            // Create and Insert
            newNode = new WordTrieNode(value);
            this.children.add(newNode);
        }
        return newNode;
    }
    
    /**
     * Check and retrieve if the node has a child with given value
     * @param value value of the child node to search for
     * @return child node
     */
    public WordTrieNode getChild(char value)
    {   
        for(int i = 0; i < this.children.size(); i++)
        {
            if(this.children.get(i).getValue() == value)
                return this.children.get(i);
        }
        return null;
    }
    
    /**
     * Retrieve a child with given index
     * @param value value of the child node to search for
     * @return child node
     */
    public WordTrieNode getChild(int value)
    {   
        if(value < this.getChildSize())
            return this.children.get(value);
        
        return null;
    }
    
    /**
     * Check if the node has a child with given value
     * @param value value of the child node to search for
     * @return child node
     */
    public boolean hasChild(char value)
    {   
        for(int i = 0; i < this.children.size(); i++)
        {
            if(this.children.get(i).getValue() == value)
                return true;
        }
        return false;
    }
    
    /**
     * Check if the node has any children
     * @return true/false
     */
    public boolean hasChild()
    {   
        return this.getChildSize() > 0;
    }
    /**
     * Delete a child node with given value
     * 
     * @param value value of the child node to be deleted
     */
    public void deleteChild(char value)
    {
        this.children.remove(getChild(value));
    }

    /**
     * Set whether or not the current word is ended
     * @param isEnd is the word ended or not
     */
    public void setEnd(boolean isEnd)
    { 
        this.isEnd = isEnd;
    }
    
    /**
     * Get the value of the node
     * @return char value of current node
     */
    public char getValue() { return this.value;}
    
    /**
     * Get the size of children of current node
     * @return number of the children 
     */
    public int getChildSize() { return this.children.size();}

    /**
     * Check if the current node is root or not
     * @return true if root, false otherwise
     */
    public boolean isRoot() { return this.isRoot;}
    
    
    /**
     * Check if the current node is leaf or not
     * @return true if leaf, false otherwise
     */
    public boolean isLeaf() { return this.isLeaf;}
    
    
    /**
     * Check if the current node is the end of a word or not
     * @return true if it is the end, false otherwise
     */
    public boolean isEnd() { return this.isEnd;}
}
