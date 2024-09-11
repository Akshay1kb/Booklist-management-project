package CST8132A2.system.book;
//Project   : Assignment 2 
//Made By   : Akshay Kumar Bharti and Samarveer Singh Toor in a group of 2 individuals
//Proffesor : Jeremy Sivaneswaran
//
//Description :The BookDownloadable interface defines the contract for downloading a book, 
//             requiring the implementation of a download method that accepts a User object.
import CST8132A2.system.user.User;

public interface BookDownloadable {
    /**
     * Downloads a book for a given user
     * */
    boolean download(User user);
}
