package CST8132A2.system.exception;
//Project   : Assignment 2 
//Made By   : Akshay Kumar Bharti and Samarveer Singh Toor in a group of 2 individuals
//Proffesor : Jeremy Sivaneswaran
//
//
import java.io.Serializable;

public class UserException extends Exception implements Serializable {
    private static final long serialVersionUID = 1L; // Serialization ID for compatibility

    /**
     * Constructs a new UserException with the specified detail message.
     * 
     * @param errorMessage The detail message for the exception.
     */
    public UserException(String errorMessage) {
        super(errorMessage);
        System.err.println("UserException: " + errorMessage); // Prints the error message to the error stream
    }
}
