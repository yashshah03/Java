package countingsort;
/**
 *
 * @author Yash Shah
 */
public class CountingSort 
{    
    /**
     * Implements counting sort for a char array
     * 
     * @param input 
     * @return sorted array
     */
    public static char[] 
    sort(char[] input)
    {
        // output array
        char[] output = new char[input.length];
        // Auxilary array
        int[] aux = new int[256];
        
        // Store the occurences of chars
        for(int i=0; i<input.length; i++)
        {
            char temp = input[i];
            // If not letter
            if(!Character.isLetter(temp))
                throw new IllegalArgumentException("Only Letters are supported");
            // Increament count
            aux[getCharToInt(temp)]++;
        }
        
        // Add count of previous cell to current cell
        for(int i=1; i<aux.length; i++)
        {
            aux[i] += aux[i-1];
        }
        
        // sort based on the counts
        for(int i= input.length-1; i>=0; i--)
        {
            char temp = input[i];
            int pos = getCharToInt(temp);
            // Decrement the count at POS by 1 in AUX array
            aux[pos]--;
            // Put the element fron input at i in output at aux[pos]
            output[aux[pos]] = temp;
        }
        return output;
    }
    
    private static int 
    getCharToInt(char val)
    {
        int pos;
        // If letter is uppercase
        if(Character.isUpperCase(val))
            pos = val - 'A';
        else
            pos = val - 'a';
        
        return pos;
    }
}
