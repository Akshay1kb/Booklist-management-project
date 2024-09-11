package CST8132A2.system.user;
//Project   : Assignment 2 
//Made By   : Akshay Kumar Bharti and Samarveer Singh Toor in a group of 2 individuals
//Proffesor : Jeremy Sivaneswaran
//
//Descrription : The userList class manages a collection of users, providing methods to add, retrieve, 
//               and display users, as well as save and load the user list from a file.
import CST8132A2.system.exception.UserException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class userList {
    private List<User> userList; // List to store User objects

    // Constructor
    public userList() {
        this.userList = new ArrayList<>();
    }

    /**
     * Adds a user to the user list.
     */
    public void addUser(User user) {
        this.userList.add(user);
    }

    /**
     * Returns the list of users.
     */
    public List<User> getUserList() {
        return userList;
    }

    /**
     * Checks if the user list is empty.
     */
    public boolean isEmpty() {
        return userList.isEmpty();
    }

    /**
     * Returns a string representation of the user list.
     */
    @Override
    public String toString() {
        if (userList.isEmpty()) {
            return "The user list is empty.";
        }
        StringBuilder sb = new StringBuilder();
        for (User user : userList) {
            sb.append(user.getEmail())
              .append(", Plan: ")
              .append(user.getPlan().getType())
              .append(", IsActive: ")
              .append(user.isActive())
              .append("\n");
        }
        return sb.toString();
    }

    /**
     * Loads the user list from a file.
     */
    public void loadUserList(String filename) throws UserException {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] params = line.split(",");
                User user = User.createUser(params[0], params[1], params[2], params[3]);
                addUser(user);
            }
        } catch (IOException e) {
            throw new UserException("Error loading user list: " + e.getMessage());
        }
    }

    /**
     * Saves the user list to a file.
     */
    public void saveUserList(String filename) throws UserException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (User user : userList) {
                bw.write(user.getEmail() + "," + user.getPassword() + "," + user.getPlan().getType() + "," + user.isActive());
                bw.newLine();
            }
        } catch (IOException e) {
            throw new UserException("Error saving user list: " + e.getMessage());
        }
    }
}
