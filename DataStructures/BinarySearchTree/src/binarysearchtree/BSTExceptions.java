package binarysearchtree;

/**
 *
 * @author Yash Shah
 */
public enum BSTExceptions 
{
    // CODES
    VALUE_ALREADY_EXISTS(100);
    
    // IMPLEMENTATION
    private final int number;
    
    private BSTExceptions(int number) {
      this.number = number;
    } 
    
    public int c() {
      return this.number;
    }
};
