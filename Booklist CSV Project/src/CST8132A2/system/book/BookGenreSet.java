package CST8132A2.system.book;
//Project   : Assignment 2 
//Made By   : Akshay Kumar Bharti and Samarveer Singh Toor in a group of 2 individuals
//Proffesor : Jeremy Sivaneswaran
//
//Description :The BookGenreSet class manages a set of unique book genres, providing methods to retrieve the set of genres.
//
import java.util.HashSet;
import java.util.Set;

public class BookGenreSet {
    private Set<String> genreSet = new HashSet<>(); // Set to store unique book genres

    /**
     * Returns the set of genres.
     */
    public Set<String> getGenreSet() {
        return genreSet;
    }
}
