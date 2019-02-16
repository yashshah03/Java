package countingsort;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Yash Shah
 */
public class CountingSortTest 
{
    /**
     * Test of sort method, of class CountingSort.
     */
    @Test
    public void testSort() 
    {
        System.out.println("sort");
        char[] input = {'a', 'b', 'a', 'c', 'e', 'A', 'B', 'h', 'I', 'j', 'k'};
        char[] expResult = {'a', 'a', 'A', 'b', 'B', 'c', 'e', 'h', 'I', 'j', 'k'};
        char[] result = CountingSort.sort(input);
        assertArrayEquals(expResult, result);
        char[] input2 = {'a', 'b', 'A', 'c', 'e', 'C', 'B', 'h', 'I', 'i', 'k'};
        char[] expResult2 = {'a', 'A', 'b', 'B', 'c', 'C', 'e', 'h', 'I', 'i', 'k'};
        char[] result2 = CountingSort.sort(input2);
        assertArrayEquals(expResult2, result2);
    }
}
