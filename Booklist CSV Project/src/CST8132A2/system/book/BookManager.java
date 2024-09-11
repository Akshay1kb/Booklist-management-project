package CST8132A2.system.book;
//Project   : Assignment 2 
//Made By   : Akshay Kumar Bharti and Samarveer Singh Toor in a group of 2 individuals
//Proffesor : Jeremy Sivaneswaran
//
//Description : The BookManager class manages a collection of books, providing methods to add, delete, print, 
//              and search for books, as well as save and load the book list from a file.
import java.util.ArrayList;
import java.util.List;

public class BookManager {
    private List<Book> books; // List to store books

    // Constructor
    public BookManager() {
        this.books = new ArrayList<>();
    }

    /**
     * Placeholder method to create a book list from a file.
     */
    public void createBookList(String filename) {
        // Logic to create a book list from a file can be added here
    }

    /**
     * Adds a book to the book list.
     */
    public void addToBookList(Book book) {
        this.books.add(book);
    }

    /**
     * Deletes a book from the list by index.
     */
    public void delete(int index) {
        if (index >= 0 && index < books.size()) {
            books.remove(index);
        }
    }

    /**
     * Returns the size of the book list.
     */
    public int getSize() {
        return books.size();
    }

    /**
     * Returns the list of books.
     */
    public List<Book> getUserList() {
        return books;
    }

    /**
     * Prints the list of books to the console.
     */
    public void printList() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    /**
     * Placeholder method to save the list of books to a file.
     */
    public void saveList() {
        // Logic to save the list of books to a file can be added here
    }

    /**
     * Searches for books containing a specific string in their name or author.
     */
    public List<Book> search(String searchString) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getName().contains(searchString) || book.getAuthor().contains(searchString)) {
                result.add(book);
            }
        }
        return result;
    }

    /**
     * Placeholder method to set the filename for the book list.
     */
    public void setFilename(String filename) {
        // Logic to set the filename for the book list can be added here
    }
}
