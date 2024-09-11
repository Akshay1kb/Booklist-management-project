package CST8132A2.system.book;
//Project   : Assignment 2 
//Made By   : Akshay Kumar Bharti and Samarveer Singh Toor in a group of 2 individuals
//Proffesor : Jeremy Sivaneswaran
//
//Description :The BookReadable interface defines the contract for reading a book, 
//             requiring the implementation of a read method that accepts a User object.
import CST8132A2.system.user.User;

public interface BookReadable {
    /**
     * Reads a book for a given user.
     */
    boolean read(User user);
}
