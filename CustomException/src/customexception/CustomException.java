package customexception;

/**
 *
 * @author Yash Shah
 */
public class CustomException extends Exception
{
    private final int code;
    private String location = "";
    
    /**
     * Create an exception with a message and an error code
     * 
     * @param message Exception message
     * @param code Exception Error Code
     */
    public CustomException(String message, int code) 
    {
        super(message);
        this.code = code;
    }
    /**
     * Create an exception with a message, an error code and location of
     * the exception
     * 
     * @param message Exception message
     * @param code Exception Error Code
     * @param location Location of the Exception
     */
    public CustomException(String message, int code, String location) 
    {
        super(message);
        this.code = code;
        this.location = location;
    }
    /**
     * Create an exception with an error code, location of the exception
     * and root exception
     * 
     * @param code Exception Error Code
     * @param location Location of the Exception
     * @param cause Root exception
     */
    public CustomException(int code, String location, Throwable cause) 
    {
        super(cause);
        this.code = code;
        this.location = location;
    }
    /**
     * Create an exception with a message, an error code, location of 
     * the exception and root exception
     * 
     * @param message Exception message
     * @param code Exception Error Code
     * @param location Location of the Exception
     * @param cause Root exception
     */
    public CustomException(String message, int code, String location, Throwable cause) 
    {
        super(message, cause);
        this.code = code;
        this.location = location;
    }
    /**
     * Create an exception with a message, an error code and root exception
     * 
     * @param message Exception message
     * @param code Exception Error Code
     * @param cause Root exception
     */
    public CustomException(String message, int code, Throwable cause) 
    {
        super(message, cause);
        this.code = code;
    }
    
    /**
     * Get the Error code
     * 
     * @return Error Code
     */
    public int code()
    {
        return this.code;
    }
    
    /**
     * Get the location of the error
     * 
     * @return Location
     */
    public String location()
    {
        return this.location;
    }
}
