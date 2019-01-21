package wordtrie;

import java.util.ArrayList;

/**
 *
 * @author Yash Shah
 */
public class WordTrie 
{
    private final WordTrieNode root;
    
    public WordTrie()
    {
        this.root = new WordTrieNode();
    }
    
    /**
     * Insert a value in the WordTrie
     * @param value 
     */
    public synchronized void 
    insert(String value)
    {
        WordTrieNode current = this.root;
        for(int i=0; i<value.length(); i++)
        {
            current = current.insertAndOrGet(value.charAt(i));
        }
        current.setEnd(true);
    }
    
    /**
     * Delete the given word from WordTrie
     * @param value word to be deleted
     */
    public synchronized void 
    delete(String value)
    {
        WordTrieNode current = this.root;
        WordTrieNode parent;
        boolean removed = false;
        for(int i=0; !removed && i<value.length(); i++)
        {      
            parent = current;
            current = current.getChild(value.charAt(i));
            if(current != null)
            {
                if(current.isLeaf())
                {
                    parent.deleteChild(value.charAt(i));
                    removed = true;
                }
            }
            else
            {
                System.err.println(value + " does not exist, stopped at: " + value.charAt(i));
                break;
            }
        }
        if(current != null && !removed) current.setEnd(false);
    }
    
    /**
     * Search if the given word exists in WordTrie
     * <br><br>
     * <b>for example</b>
     * <br>
     * WordTrie: ["Anything", "No"]
     * <ul> 
     * <li> search("No")   will return true as it exists as a word
     * <li> search("Any")  will return false as it exists in a separate word
     * <li> search("Nope") will return false as it doesn't exists entirely
     * </ul>
     * @param value
     * @return true if the word exists
     */
    public synchronized boolean 
    search(String value)
    {
        WordTrieNode current = this.root;
        for(int i=0; i<value.length(); i++)
        {      
            current = current.getChild(value.charAt(i));
            if(current != null)
            {
                if((i == value.length()-1) && current.isEnd())
                    return true;
                
            }
            else
            {
                System.err.println(value + " does not exist, stopped at: " + value.charAt(i));
                return false;
            }
        }
        System.err.println(value + " does not exist as it's own word");
        return false;
    }
    
    /**
     * Search if the given word exists entirely in WordTrie
     * <br><br>
     * <b>for example</b>
     * <br>
     * WordTrie: ["Anything", "No"]
     * <ul> 
     * <li> searchAll("Any") will return true as it exists entirely albeit in a separate word
     * <li> searchAll("Nope") will return false as it doesn't exists entirely
     * </ul>
     * 
     * @param value
     * @return true if the word exists
     */
    public synchronized boolean 
    searchAll(String value)
    {
        WordTrieNode current = this.root;
        for(int i=0; i<value.length(); i++)
        {      
            current = current.getChild(value.charAt(i));
            if(current != null)
            {
                if((i == value.length()-1) && current.isEnd())
                    return true;
                
            }
            else
            {
                System.err.println(value + " does not exist, stopped at: " + value.charAt(i));
                return false;
            }
        }
        return true;
    }
    
    /**
     * Get all the words stored in WordTrie
     * @return List of words
     */
    public synchronized ArrayList<String> 
    getAllWords()
    {
        ArrayList<String> words = new ArrayList<>();
        getAllWordsRec(this.root, "", words);
        return words;
    }
    
    /**************************************
     * PRIVATE HELPER METHODS
     **************************************/
    
    private void getAllWordsRec(WordTrieNode current, String curString, ArrayList<String> words)
    {
        if(current == null) return;
        if(current.isEnd()) words.add(curString + current.getValue());
        
        for(int i=0; i<current.getChildSize();i++)
        {
            getAllWordsRec(current.getChild(i), 
                           curString+current.getValue(), 
                           words);
        }
    }
}
