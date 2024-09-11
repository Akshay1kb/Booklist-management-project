package CST8132A2.system.book;
//Project   : Assignment 2 
//Made By   : Akshay Kumar Bharti and Samarveer Singh Toor in a group of 2 individuals
//Proffesor : Jeremy Sivaneswaran
//
//Description : The BookList class handles the loading, storing, and searching of a list
//              of books. It provides methods to load book data from a CSV file, 
//              find books by index, and search for books by various attributes.
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import CST8132A2.system.exception.BookException;
import CST8132A2.system.util.SystemUtil;

public class BookList {
    private static final int NUMCOLS = 6; // Expected number of columns in the CSV file
    private List<Book> bestsellers; // List to store bestseller books

    // Constructor
    public BookList() {
        bestsellers = new ArrayList<>();
    }

    /**
     * Loads the book list from a CSV file.
     */
    public void loadBookList(String csvFile) throws BookException {
        // Regex to split CSV line correctly handling quoted fields with commas
        Pattern pattern = Pattern.compile(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
        
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line = br.readLine(); // Read header line
            int index = 0;
            
            while ((line = br.readLine()) != null) {
                String[] data = pattern.split(line);
                boolean missingFields = data.length < NUMCOLS;

                // Assign fields with defaults for missing values
                String name = data.length > 0 ? data[0].trim().replaceAll("^\"|\"$", "") : "Unknown";
                String author = data.length > 1 ? data[1].trim().replaceAll("^\"|\"$", "") : "Unknown";
                String originalLanguage = data.length > 2 ? data[2].trim().replaceAll("^\"|\"$", "") : "Unknown";
                int firstPublished = data.length > 3 ? Integer.parseInt(data[3].trim().replaceAll("^\"|\"$", "")) : 0;
                float millionSales = data.length > 4 ? Float.parseFloat(data[4].trim().replaceAll("^\"|\"$", "")) : 0.0f;
                String genre = data.length > 5 ? data[5].trim().replaceAll("^\"|\"$", "") : "null";

                if (genre.isEmpty()) {
                    genre = "null";
                }

                // Create a new Book object and add it to the list
                Book book = new Book(name, author, originalLanguage, firstPublished, millionSales, genre, index++);
                bestsellers.add(book);

                if (missingFields) {
                    System.out.print(""); // Placeholder for missing fields
                }
                System.out.print(""); // Placeholder for additional processing
            }
        } catch (IOException e) {
            System.err.println("Error details: " + e.getMessage()); // Detailed error message
            throw new BookException("Error reading CSV file: " + e.getMessage());
        }
    }

    /**
     * Returns a string representation of the book list.
     */
    @Override
    public String toString() {
        if (bestsellers.isEmpty()) {
            return "The book list is empty.";
        }
        StringBuilder sb = new StringBuilder();
        for (Book book : bestsellers) {
            sb.append(book.toString()).append("\n");
        }
        return sb.toString();
    }

    /**
     * Finds a book by its index.
     */
    public Book findBookByIndex(int index) throws BookException {
        if (index < 0 || index >= bestsellers.size()) {
            throw new BookException("Index out of range.");
        }
        return bestsellers.get(index);
    }

    /**
     * Searches for books containing a specific string.
     */
    public List<Book> searchInBookList(String searchString) throws BookException {
        if (!SystemUtil.isValid(searchString)) {
            throw new BookException("Invalid search string.");
        }
        List<Book> result = new ArrayList<>();
        for (Book book : bestsellers) {
            if (book.getName().contains(searchString) || 
                book.getAuthor().contains(searchString) ||
                book.getOriginalLanguage().contains(searchString) ||
                book.getGenre().contains(searchString)) {
                result.add(book);
            }
        }
        if (result.isEmpty()) {
            throw new BookException("No books found matching the search criteria.");
        }
        return result;
    }
}
