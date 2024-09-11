package CST8132A2.system.test;
//Project   : Assignment 2 
//Made By   : Akshay Kumar Bharti and Samarveer Singh Toor in a group of 2 individuals
//Proffesor : Jeremy Sivaneswaran
//
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import CST8132A2.system.book.*;

class TestCaseBook {

    @Test
    void testAccessBook() {
        System.out.println("Testing books...................");

        // Test creating a book with invalid parameters
        try {
            Book invalidBook = Book.createBook("", "null", null, "error", "invalid", "a", "0");
            fail("Expected IllegalArgumentException for invalid book creation");
        } catch (IllegalArgumentException e) {
            System.out.println("Book test1 - Invalid book checked");
        }

        // Test creating a book with valid parameters
        Book validBook = Book.createBook("MyBook", "Paulo Sousa", "English", "2000", "0", "Fiction", "1000");
        assertNotNull(validBook);
        System.out.println("Book test2 - Valid book created");
    }
}
