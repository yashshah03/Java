## This project contains sample implementation of a custom exceptions in java
**The project is developed using Apache Netbeans IDE 10.0, Java 8, Windows 10**

## Features:
   - [X] Can store Error Message, Error Code, Location of error and cause (Underlying root exception)

## Use:
   - CustomException(CUSTOM_MESSAGE, ERROR_CODE)
     * Raise an exception with a message and an error code
   - CustomException(CUSTOM_MESSAGE, ERROR_CODE, LOCATION)
     * Raise an exception with a message, an error code and location of the error
   - CustomException(ERROR_CODE, LOCATION, CAUSE)
     * Raise an exception with an error code, location of the error and error cause
   - CustomException(CUSTOM_MESSAGE, ERROR_CODE, LOCATION, CAUSE)
     * Raise an exception with a message, an error code, location of the error and error cause
   - CustomException(CUSTOM_MESSAGE, ERROR_CODE, CAUSE)
     * Raise an exception with a message, an error code and error cause
