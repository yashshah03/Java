package graph;

/**
 *
 * @author Yash Shah
 */
public enum GraphEx 
{
    // CODES
    SOURCE_NODE_DOES_NOT_EXIST(100),
    DESTINATION_DOES_NOT_EXIST(101),
    EDGE_DOES_NOT_EXIST(102),
    EDGE_ALREADY_EXISTS(103);
    
    // IMPLEMENTATION
    private final int number;
    
    private GraphEx(int number) {
      this.number = number;
    } 
    
    public int c() {
      return this.number;
    }
};
