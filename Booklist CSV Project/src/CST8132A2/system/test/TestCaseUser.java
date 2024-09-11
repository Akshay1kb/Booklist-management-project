package CST8132A2.system.test;
//Project   : Assignment 2 
//Made By   : Akshay Kumar Bharti and Samarveer Singh Toor in a group of 2 individuals
//Proffesor : Jeremy Sivaneswaran
//
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import CST8132A2.system.user.*;
import CST8132A2.system.book.Book;
import CST8132A2.system.exception.UserException;

class TestCaseUser {

    @Test
    void testUser() throws UserException {
        System.out.println("Testing users...................");

        // Initialize variables
        Book book;
        UserPlan plan;
        User user;

        // Test creating an invalid plan
        plan = UserPlan.createPlan("invalid", "invalid");
        assertNull(plan);
        System.out.println("User test1 - Invalid plan checked");

        // Test creating a valid plan
        plan = UserPlan.createPlan("trial", "true");
        assertNotNull(plan);
        System.out.println("User test2 - Valid plan created");

        // Test creating an invalid user
        try {
            user = User.createUser("", "invalid", null, null);
            fail("Expected UserException for invalid user creation");
        } catch (UserException e) {
            System.out.println("User test3 - Invalid user checked");
        }

        // Test creating a valid user
        user = User.createUser("paulo@mail.com", "validPassword123", "trial", "true");
        assertNotNull(user);
        System.out.println("User test4 - Valid user created");

        // Set plan for user and verify
        user.setPlan(plan);
        plan = user.getPlan();
        assertNotNull(plan);
        System.out.println("User test5 - Valid plan from user");

        // Test creating a valid book
        book = Book.createBook("MyBook", "Paulo Sousa", "English", "2000", "0", "Fiction", "1000");
        assertNotNull(book);
        System.out.println("User test6 - Valid book created");

        // Test adding a book to the user's booklist
        try {
            user.addToBooklist(book);
        } catch (Exception e) {
            fail("Error adding book to booklist");
        }
        int size = user.getBookListSize();
        assertEquals(1, size);
        System.out.println("User test7 - Valid book inclusion in list");

        // Test reading a book
        boolean canRead = book.read(user);
        assertTrue(canRead);
        System.out.println("User test8 - Valid book read checked");

        // Test downloading a book (expected to fail for trial plan)
        boolean canDownload = book.download(user);
        assertFalse(canDownload);
        System.out.println("User test9 - Invalid book download checked");
    }
}
