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
    
    public void setValue(String value) { this.value = value; }
    public String getValue() { return value; }
}
