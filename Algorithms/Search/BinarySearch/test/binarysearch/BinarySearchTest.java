package binarysearch;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Yash Shah
 */
public class BinarySearchTest 
{    
    /**
     * Test of search method, of class BinarySearch.
     */
    @Test
    public void testSearch() 
    {
        System.out.println("search");
        int[] input = {11, 12, 23, 34, 35, 46, 57, 68, 79, 100, 145, 156};
        assertEquals(-1, BinarySearch.search(input, 134));
        assertEquals(9, BinarySearch.search(input, 100));
        assertEquals(-1, BinarySearch.search(input, 5));
    }
    
}
