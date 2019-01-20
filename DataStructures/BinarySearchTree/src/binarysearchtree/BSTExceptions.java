package binarysearchtree;

/**
 *
 * @author Yash Shah
 */
public enum BSTExceptions 
{
    // CODES
    TREE_EMPTY(100),
    VALUE_DOES_NOT_EXISTS(101);
    
    // IMPLEMENTATION
    private final int number;
    
    private BSTExceptions(int number) {
      this.number = number;
    } 
    
    public int c() {
      return this.number;
    }
};
