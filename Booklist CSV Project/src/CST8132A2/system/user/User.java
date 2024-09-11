package CST8132A2.system.user;
//Project   : Assignment 2 
//Made By   : Akshay Kumar Bharti and Samarveer Singh Toor in a group of 2 individuals
//Proffesor : Jeremy Sivaneswaran
//
//Description : The User class represents a user with attributes such as email, password, 
//              book list, and subscription plan. It provides methods to manage the
//              user's book list, check activity status, and create new users.
import CST8132A2.system.book.Book;
import CST8132A2.system.exception.UserException;
import CST8132A2.system.util.SystemUtil;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String email; // User's email
    private String password; // User's password
    private List<Book> bookList; // List of books associated with the user
    private UserPlan plan; // User's subscription plan

    // Constructor
    public User(String email, String password, UserPlan plan) {
        this.email = email;
        this.password = password;
        this.plan = plan;
        this.bookList = new ArrayList<>();
    }

    // Getters and Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public UserPlan getPlan() {
        return plan;
    }

    public void setPlan(UserPlan plan) {
        this.plan = plan;
    }

    // Check if the user is active
    public boolean isActive() {
        return this.plan.isActive();
    }

    /**
     * Adds a book to the user's book list.
     */
    public void addToBooklist(Book book) throws UserException {
        if (!this.isActive()) {
            throw new UserException("User is not active.");
        }
        this.bookList.add(book);
    }

    /**
     * Adds all books to the user's book list.
     */
    public void addAllToBooklist(List<Book> books) throws UserException {
        if (!this.isActive()) {
            throw new UserException("User is not active.");
        }
        this.bookList.addAll(books);
    }

    /**
     * Displays the user's book list.
     */
    public void displayBookList() {
        if (bookList.isEmpty()) {
            System.out.println("Your book list is empty.");
        } else {
            for (Book book : bookList) {
                System.out.println(book);
            }
        }
    }

    /**
     * Creates a new user.
     */
    public static User createUser(String email, String password, String planType, String isActive) {
        if (!SystemUtil.isValid(email) || !SystemUtil.isValid(password)) {
            return null;
        }
        UserPlan plan = UserPlan.createPlan(planType, isActive);
        return new User(email, password, plan);
    }

    /**
     * Returns the size of the user's book list.
     */
    public int getBookListSize() {
        return this.bookList.size();
    }

    /**
     * Finds a book by index in the user's book list.
     */
    public Book findBookByIndex(int index) throws UserException {
        if (index < 0 || index >= bookList.size()) {
            throw new UserException("Invalid book index.");
        }
        return bookList.get(index);
    }
}
