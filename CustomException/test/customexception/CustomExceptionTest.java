/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customexception;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
/**
 *
 * @author Yash Shah
 */
public class CustomExceptionTest 
{    
    /**
     * Test of code method, of class CustomException.
     */
    @Test
    public void testExceptionMC() 
    {
        try
        {
            throw new CustomException("CUSTOM MESSAGE", 1);
        }
        catch(CustomException e)
        {
            System.out.println(e.getMessage());
            System.out.println(e.code());
            System.out.println("------------------------");
        }
    }
    
    @Test
    public void testExceptionMCL() 
    {
        try
        {
            throw new CustomException("CUSTOM MESSAGE", 1, (new Exception()).getStackTrace()[0].getMethodName());
        }
        catch(CustomException e)
        {
            System.out.println(e.getMessage());
            System.out.println(e.code());
            System.out.println(e.location());
            System.out.println("------------------------");
        }
    }
    
    @Test
    public void testExceptionCLC() 
    {
        try
        {
            throw new CustomException(1, (new Exception()).getStackTrace()[0].getMethodName(), new IllegalAccessException());
        }
        catch(CustomException e)
        {
            System.out.println(e.code());
            System.out.println(e.location());
            System.out.println(e.getCause());
            System.out.println("------------------------");
        }
    }
    
    @Test
    public void testExceptionMCLC() 
    {
        try
        {
            throw new CustomException("CUSTOM MESSAGE", 1, (new Exception()).getStackTrace()[0].getMethodName(), new IllegalAccessException());
        }
        catch(CustomException e)
        {
            System.out.println(e.getMessage());
            System.out.println(e.code());
            System.out.println(e.location());
            System.out.println(e.getCause());
            System.out.println("------------------------");
        }
    }
    
    @Test
    public void testExceptionMCC() 
    {
        try
        {
            throw new CustomException("CUSTOM MESSAGE", 1, new IllegalAccessException());
        }
        catch(CustomException e)
        {
            System.out.println(e.getMessage());
            System.out.println(e.code());
            System.out.println(e.getCause());
            System.out.println("------------------------");
        }
    }
}
