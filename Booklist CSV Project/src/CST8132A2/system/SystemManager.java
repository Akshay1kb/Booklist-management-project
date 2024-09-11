package CST8132A2.system;
//Project   : Assignment 2 
//Made By   : Akshay Kumar Bharti and Samarveer Singh Toor in a group of 2 individuals
//Proffesor : Jeremy Sivaneswaran
//
//Description : The SystemManager class manages the main operations and user interactions of the system, 
//              including loading book lists, managing users, and handling user sessions. 
//              It provides a menu-driven interface for both logged-in users and administrators.

import java.util.Scanner;

import CST8132A2.system.book.BookList;
import CST8132A2.system.exception.BookException;
import CST8132A2.system.book.Book;
import CST8132A2.system.exception.UserException;
import CST8132A2.system.user.User;
import CST8132A2.system.user.userList;
import CST8132A2.system.util.SystemUtil;

public class SystemManager {
    // Constants representing menu options
    private static final int LOAD_BOOKLIST = 1;
    private static final int SHOW_BOOKLIST = 2;
    private static final int SEARCH_BOOKLIST = 3;
    private static final int CREATE_USER = 4;
    private static final int SHOW_USERS = 5;
    private static final int SAVE_USERS = 6;
    private static final int LOAD_USERS = 7;
    private static final int LOGIN_USER = 8;
    private static final int EXIT = 9;

    private static final int SHOW_ALL_BOOKS = 10;
    private static final int ADD_BOOK_TO_LIST = 11;
    private static final int SHOW_USER_BOOKLIST = 12;
    private static final int READ_BOOK = 13;
    private static final int DOWNLOAD_BOOK = 14;
    private static final int CHANGE_PASSWORD = 15;
    private static final int LOGOFF = 16;

    // File paths for book list and user list
    private static final String BOOK_LIST_FILE = "C:\\Users\\aksha\\OneDrive\\Desktop\\Assignment2 (2)\\best-selling-books (1).csv";
    private static final String USER_LIST_FILE = "C:\\Users\\aksha\\OneDrive\\Desktop\\Assignment2 (2)\\userlist.csv"; // Ensure you have the correct path for the user list file

    private static Scanner scanner = new Scanner(System.in);
    private static boolean isLoggedIn = false;  // Flag to check if a user is logged in
    private static User loggedInUser = null;  // Reference to the logged-in user
    private static BookList bookList = new BookList();  // List of books
    private static userList userList = new userList();  // List of users

    public static void main(String[] args) {
        int choice;
        do {
            showMenu();  // Display the menu
            choice = getInput();  // Get the user's choice
            handleMenuChoice(choice);  // Handle the user's choice
        } while (choice != EXIT);  // Loop until the user chooses to exit
    }

    // Display the appropriate menu based on the login status
    private static void showMenu() {
        if (isLoggedIn) {
            System.out.println("================================");
            System.out.println("|| Menu - User .............. ||");
            System.out.println("================================");
            System.out.println("10. Show all books");
            System.out.println("11. Add book in my list");
            System.out.println("12. Show my booklist");
            System.out.println("13. Read book");
            System.out.println("14. Download book");
            System.out.println("15. Change password");
            System.out.println("16. Logoff");
        } else {
            System.out.println("================================");
            System.out.println("|| Menu - Mini-System: OOP/A2 ||");
            System.out.println("================================");
            System.out.println("1. Load Booklist");
            System.out.println("2. Show Booklist");
            System.out.println("3. Search in the list");
            System.out.println("4. Create user");
            System.out.println("5. Show users");
            System.out.println("6. Save users");
            System.out.println("7. Load users");
            System.out.println("8. Login user");
            System.out.println("9. Exit");
        }
        System.out.print("Choose an option: ");
    }

    // Get the user's choice from the console
    private static int getInput() {
        return Integer.parseInt(scanner.nextLine());
    }

    // Handle the user's menu choice
    private static void handleMenuChoice(int choice) {
        try {
            if (isLoggedIn) {
                switch (choice) {
                    case SHOW_ALL_BOOKS:
                        showAllBooks();
                        break;
                    case ADD_BOOK_TO_LIST:
                        addBookToUserList();
                        break;
                    case SHOW_USER_BOOKLIST:
                        showUserBookList();
                        break;
                    case READ_BOOK:
                        readBook();
                        break;
                    case DOWNLOAD_BOOK:
                        downloadBook();
                        break;
                    case CHANGE_PASSWORD:
                        changePassword();
                        break;
                    case LOGOFF:
                        logoffUser();
                        break;
                    default:
                        System.out.println("Invalid option.");
                        break;
                }
            } else {
                switch (choice) {
                    case LOAD_BOOKLIST:
                        loadBookList();
                        break;
                    case SHOW_BOOKLIST:
                        showBookList();
                        break;
                    case SEARCH_BOOKLIST:
                        searchBookList();
                        break;
                    case CREATE_USER:
                        createUser();
                        break;
                    case SHOW_USERS:
                        showUserList();
                        break;
                    case SAVE_USERS:
                        saveUserList();
                        break;
                    case LOAD_USERS:
                        loadUserList();
                        break;
                    case LOGIN_USER:
                        loginUser();
                        break;
                    case EXIT:
                        System.out.println("Exiting the system...");
                        break;
                    default:
                        System.out.println("Invalid option.");
                        break;
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    // Load the book list from the file
    private static void loadBookList() throws BookException {
        bookList.loadBookList(BOOK_LIST_FILE);
        System.out.println("Book list created successfully!");
    }

    // Display the book list
    private static void showBookList() {
        System.out.println(bookList);
    }

    // Search the book list for a specific term
    private static void searchBookList() throws BookException {
        System.out.print("Enter the search term: ");
        String searchTerm = scanner.nextLine();
        System.out.println(bookList.searchInBookList(searchTerm));
    }

    // Create a new user and add it to the user list
    private static void createUser() throws UserException {
        System.out.println("Enter the User data:\n- Email: ");
        String email = scanner.nextLine();
        System.out.print("- Password: ");
        String password = scanner.nextLine();
        System.out.print("- Plan type (trial, standard, vip): ");
        String planType = scanner.nextLine();
        System.out.print("- Activation (true, false): ");
        String isActive = scanner.nextLine();
        User user = User.createUser(email, password, planType, isActive);
        userList.addUser(user);
        System.out.println("User successfully created!");
    }

    // Display the list of users
    private static void showUserList() {
        System.out.println(userList);
    }

    // Save the user list to the file
    private static void saveUserList() throws UserException {
        userList.saveUserList(USER_LIST_FILE);
        System.out.println("User list saved successfully!");
    }

    // Load the user list from the file
    private static void loadUserList() throws UserException {
        userList.loadUserList(USER_LIST_FILE);
        System.out.println("User list loaded successfully!");
    }

    // Log in a user based on email and password
    private static void loginUser() throws UserException {
        System.out.print("Enter the user email: ");
        String email = scanner.nextLine();
        System.out.print("Enter the user password: ");
        String password = scanner.nextLine();
        for (User user : userList.getUserList()) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                loggedInUser = user;
                isLoggedIn = true;
                System.out.println("User " + email + " logged in!");
                return;
            }
        }
        throw new UserException("Invalid email or password.");
    }

    // Display all books in the system
    private static void showAllBooks() {
        System.out.println(bookList);
    }

    // Add a book to the logged-in user's book list
    private static void addBookToUserList() throws BookException, UserException {
        System.out.print("Enter the book index: ");
        int index = Integer.parseInt(scanner.nextLine());
        Book book = bookList.findBookByIndex(index);
        loggedInUser.addToBooklist(book);
        System.out.println("Book added to your list.");
    }

    // Display the logged-in user's book list
    private static void showUserBookList() {
        loggedInUser.displayBookList();
    }

    // Read a book from the logged-in user's book list
    private static void readBook() throws BookException, UserException {
        System.out.print("Enter the book index: ");
        int index = Integer.parseInt(scanner.nextLine());
        Book book = loggedInUser.findBookByIndex(index);
        if (book.read(loggedInUser)) {
            System.out.println("Book " + book.getName() + " read!");
        } else {
            throw new BookException("Cannot read the book.");
        }
    }

    // Download a book from the logged-in user's book list
    private static void downloadBook() throws BookException, UserException {
        System.out.print("Enter the book index: ");
        int index = Integer.parseInt(scanner.nextLine());
        Book book = loggedInUser.findBookByIndex(index);
        if (book.download(loggedInUser)) {
            System.out.println("Book " + book.getName() + " downloaded!");
        } else {
            throw new BookException("Your user plan does not have permission to download books.");
        }
    }

    // Change the logged-in user's password
    private static void changePassword() throws UserException {
        System.out.print("Enter new password: ");
        String newPassword = scanner.nextLine();
        if (!SystemUtil.isValid(newPassword)) {
            throw new UserException("Invalid password.");
        }
        loggedInUser.setPassword(newPassword);
        System.out.println("Password changed successfully.");
    }

    // Log off the current user
    private static void logoffUser() {
        loggedInUser = null;
        isLoggedIn = false;
        System.out.println("User logged off.");
    }
}
