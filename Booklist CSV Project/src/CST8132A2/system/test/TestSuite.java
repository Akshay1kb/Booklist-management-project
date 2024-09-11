package CST8132A2.system.test;
//Project   : Assignment 2 
//Made By   : Akshay Kumar Bharti and Samarveer Singh Toor in a group of 2 individuals
//Proffesor : Jeremy Sivaneswaran
//
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ TestCaseBook.class, TestCaseUser.class })
public class TestSuite {

    /**
     * Method to run before all tests in the suite.
     */
    @BeforeAll
    static void initAll() {
        printInitialMsg();
        System.out.println("Initializing all tests...");
    }

    /**
     * Method to run before each individual test.
     */
    @BeforeEach
    void init() {
        System.out.println("Initializing individual test...");
    }

    /**
     * A test that always succeeds.
     */
    @Test
    void succeedingTest() {
        System.out.println("A succeeding test...");
    }

    /**
     * A test that is meant to fail (currently commented out).
     */
    @Test
    void failingTest() {
        // Uncomment to test a failing scenario
        // fail("A failing test...");
        System.out.println("A failing test...");
    }

    /**
     * A test that is skipped (disabled).
     */
    @Test
    @Disabled("for demonstration purposes")
    void skippedTest() {
        System.out.println("A skipped test...");
    }

    /**
     * A test that is meant to be aborted (currently commented out).
     */
    @Test
    void abortedTest() {
        // Assume a condition to abort the test
        // assumeTrue("abc".contains("Z"));
        // fail("Test should have been aborted");
        System.out.println("An aborted test...");
    }

    /**
     * Method to run after each individual test.
     */
    @AfterEach
    void tearDown() {
        System.out.println("Tearing down after individual test...");
    }

    /**
     * Method to run after all tests in the suite.
     */
    @AfterAll
    static void tearDownAll() {
        System.out.println("Tearing down all tests...");
    }

    /**
     * Prints the initial message before running all tests.
     */
    static void printInitialMsg() {
        System.out.println("================================");
        System.out.println("||    Test Suite Validation   ||");
        System.out.println("================================");
    }
}
