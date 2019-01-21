/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordtrie;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Yash Shah
 */
public class WordTrieTest 
{
    /**
     * Test of insert method, of class WordTrie.
     */
    @Test
    public void testInsert()
    {
        System.out.println("insert");
        WordTrie instance = new WordTrie();
        ArrayList<String> list = new ArrayList(Arrays.asList("Word",
                                                             "Wordtrie",
                                                             "Any",
                                                             "Anything",
                                                             "Anyways",
                                                             "No",
                                                             "Noways",
                                                             "Nowhere"));
         
        list.forEach((w) -> {
            instance.insert(w);
        });
       
        ArrayList<String> words = instance.getAllWords();
        assertEquals(true, compareLists(list, words));
    }

    /**
     * Test of getAllWords method, of class WordTrie.
     */
    @Test
    public void testGetAllWords() 
    {
        System.out.println("getAllWords");
        WordTrie instance = new WordTrie();
        ArrayList<String> list = new ArrayList(Arrays.asList("Word",
                                                             "Wordtrie",
                                                             "Any",
                                                             "Anything",
                                                             "Anyways",
                                                             "No",
                                                             "Noways",
                                                             "Nowhere"));
         
        list.forEach((w) -> {
            instance.insert(w);
        });
       
        ArrayList<String> words = instance.getAllWords();
        assertEquals(true, compareLists(list, words));
    }

    /**
     * Test of delete method, of class WordTrie.
     */
    @Test
    public void testDelete() 
    {
        System.out.println("delete");
        WordTrie instance = new WordTrie();
        ArrayList<String> list = new ArrayList(Arrays.asList("Word",
                                                             "Wordtrie",
                                                             "Any",
                                                             "Anything",
                                                             "Anyways",
                                                             "No",
                                                             "Noways",
                                                             "Nowhere"));
         
        list.forEach((w) -> {
            instance.insert(w);
        });
        String deletedWord = "Words";
        
        ArrayList<String> words = instance.getAllWords();
        System.out.println("Before delete\n" + Arrays.asList(words).toString());
        instance.delete(deletedWord);
        words = instance.getAllWords();
        System.out.println("After deleting: " + deletedWord + "\n" + Arrays.asList(words).toString());
        
        list.remove(deletedWord);
        assertEquals(true, compareLists(list, words));
    }
    
    /**
     * Test of search method, of class WordTrie.
     */
    @Test
    public void testSearch() 
    {
        System.out.println("search");
        WordTrie instance = new WordTrie();
        ArrayList<String> list = new ArrayList(Arrays.asList("Word",
                                                             "Wordtrie",
                                                             "Any",
                                                             "Anything",
                                                             "Anyways",
                                                             "No",
                                                             "Noways",
                                                             "Nowhere"));
         
        list.forEach((w) -> {
            instance.insert(w);
        });
        
        assertEquals(true, instance.search("Any"));
        assertEquals(false, instance.search("Words"));
        assertEquals(false, instance.search("Now"));
    }
    
    /**
     * Test of searchAll method, of class WordTrie.
     */
    @Test
    public void testSearchAll() 
    {
        System.out.println("searchAll");
        WordTrie instance = new WordTrie();
        ArrayList<String> list = new ArrayList(Arrays.asList("Word",
                                                             "Wordtrie",
                                                             "Any",
                                                             "Anything",
                                                             "Anyways",
                                                             "No",
                                                             "Noways",
                                                             "Nowhere"));
         
        list.forEach((w) -> {
            instance.insert(w);
        });
        
        assertEquals(true, instance.searchAll("Any"));
        assertEquals(false, instance.searchAll("Words"));
        assertEquals(true, instance.searchAll("Now"));
    }
    
    private boolean compareLists(ArrayList<String> l1,ArrayList<String> l2)
    {
        if(l1 == null && l2 == null) return true;
        if(l1 == null || l2 == null) return false;
        if(l1.size() != l2.size())   return false;
        
        boolean result = true;
        for(int i=0; result && i<l1.size(); i++)
            result = (l1.get(i)).equals(l2.get(i).trim());
            
        return result;
    }
}
