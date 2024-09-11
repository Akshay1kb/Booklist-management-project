package CST8132A2.system.book;
//Project   : Assignment 2 
//Made By   : Akshay Kumar Bharti and Samarveer Singh Toor in a group of 2 individuals
//Proffesor : Jeremy Sivaneswaran
//
//Description :The Book class represents a book with attributes such as name,
//             author, language, genre, publication year, sales, and index. 
//             It implements interfaces for reading and downloading books, 
//             with methods to handle these actions based on user permissions.
import CST8132A2.system.user.User;
import CST8132A2.system.user.UserPlan.planType;
import CST8132A2.system.util.SystemUtil;

public class Book implements BookReadable, BookDownloadable {
    private String name; // Name of the book
    private String author; // Author of the book
    private String originalLanguage; // Original language of the book
    private String genre; // Genre of the book
    private int firstPublished; // Year the book was first published
    private float millionSales; // Approximate sales of the book in millions
    private int index; // Index of the book in the list

    // Constructor
    public Book(String name, String author, String originalLanguage, int firstPublished, float millionSales, String genre ,int index) {
        this.name = name;
        this.author = author;
        this.originalLanguage = originalLanguage;
        this.genre = genre;
        this.firstPublished = firstPublished;
        this.millionSales = millionSales;
        this.index = index;
    }

    // Overloaded constructor
    public Book(String name, String author, String originalLanguage, String genre, int firstPublished, float millionSales, int index) {
        this.name = name;
        this.author = author;
        this.originalLanguage = originalLanguage;
        this.genre = genre;
        this.firstPublished = firstPublished;
        this.millionSales = millionSales;
        this.index = index;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public String getGenre() {
        return genre;
    }

    public int getFirstPublished() {
        return firstPublished;
    }

    public float getMillionSales() {
        return millionSales;
    }

    public int getIndex() {
        return index;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setFirstPublished(int firstPublished) {
        this.firstPublished = firstPublished;
    }

    public void setMillionSales(float millionSales) {
        this.millionSales = millionSales;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    // Implementation of the read method from BookReadable interface
    @Override
    public boolean read(User user) {
        if (user != null && user.isActive()) {
            System.out.println("Book " + this.name + " read by " + user.getEmail());
            return true;
        }
        return false;
    }

    // Implementation of the download method from BookDownloadable interface
    @Override
    public boolean download(User user) {
        if (user != null && user.isActive() && (user.getPlan().getType() == planType.vip || user.getPlan().getType() == planType.standard)) {
            System.out.println("Book " + this.name + " downloaded by " + user.getEmail());
            return true;
        }
        return false;
    }

    // Override the toString method to provide a formatted string representation of the book
    @Override
    public String toString() {
        return String.format("Book [" + index + "] {Book='" + name + "', Author(s)=" + author + ", Original language='" + originalLanguage + "', First published=" + firstPublished + ", Approximate sales in millions=" + millionSales + ", Genre='" + genre + "'}");
    }

    // Static factory method to create a book from parameters
    public static Book createBook(String... params) {
        if (params.length != 7) {
            throw new IllegalArgumentException("Invalid number of parameters to create a Book.");
        }

        String name = params[0];
        String author = params[1];
        String originalLanguage = params[2];
        String genre = params[5]; 
        int firstPublished;
        float millionSales;
        int index;

        try {
            firstPublished = Integer.parseInt(params[3]);
            millionSales = Float.parseFloat(params[4]);
            index = Integer.parseInt(params[6]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid number format in parameters.");
        }

        if (!SystemUtil.isValid(name) || !SystemUtil.isValid(author) || !SystemUtil.isValid(originalLanguage) || !SystemUtil.isValid(genre)) {
            throw new IllegalArgumentException("Invalid parameter value.");
        }

        return new Book(name, author, originalLanguage, genre, firstPublished, millionSales, index);
    }
}
