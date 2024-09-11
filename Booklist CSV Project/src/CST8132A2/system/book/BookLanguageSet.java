package CST8132A2.system.book;
//Project   : Assignment 2 
//Made By   : Akshay Kumar Bharti and Samarveer Singh Toor in a group of 2 individuals
//Proffesor : Jeremy Sivaneswaran
//
//Description :The BookLanguageSet class manages a set of unique book languages, providing methods to retrieve the set of languages.
import java.util.HashSet;
import java.util.Set;

public class BookLanguageSet {
    private Set<String> languageSet = new HashSet<>(); // Set to store unique book languages

    /**
     * Returns the set of languages.
     */
    public Set<String> getLanguageSet() {
        return languageSet;
    }
}
