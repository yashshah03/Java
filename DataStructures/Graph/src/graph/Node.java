package graph;

/**
 *
 * @author Yash Shah
 */
public class Node 
{
    private String value;

    public Node(String value)
    {
        this.value = value;
    }
   
    public String getValue() { return this.value; }
    
    @Override
    public String toString() { return this.value; }
}
