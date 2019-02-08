package binarysearch;

/**
 *
 * @author Yash Shah
 */
public class BinarySearch 
{
    /**
     * Search for a number in the given ASCENDING SORTED array
     * 
     * @param input Integer array to search in
     * @param number Integer value to search for
     * @return int position of the value found
     */
    public static int search(int[] input, int number) 
    {
        int left = 0;
        int right = input.length;
        int mid = right/2;        
        int location = -1;
        
        while(left < right)
        {
            if(input[mid] == number)
            {
                location = mid;
                break;
            }
            else if(input[mid] < number)
            {
                left = mid + 1;
                mid = left + (right-left)/2;
            }
            else
            {
                right = mid - 1;
                mid = left + (right-left)/2;
            }
        }
        return location;
    }
}
