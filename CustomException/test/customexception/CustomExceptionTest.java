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
    public void testCode() {
        System.out.println("code");
        CustomException instance = null;
        int expResult = 0;
        int result = instance.code();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of location method, of class CustomException.
     */
    @Test
    public void testLocation() {
        System.out.println("location");
        CustomException instance = null;
        String expResult = "";
        String result = instance.location();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
