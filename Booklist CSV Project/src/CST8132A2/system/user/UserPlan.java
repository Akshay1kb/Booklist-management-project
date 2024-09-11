package CST8132A2.system.user;
//Project   : Assignment 2 
//Made By   : Akshay Kumar Bharti and Samarveer Singh Toor in a group of 2 individuals
//Proffesor : Jeremy Sivaneswaran
//
//Description : The UserPlan class represents a user's subscription plan, with attributes for the plan type (trial, 
//standard, vip) and activity status. It provides methods to create and manage user plans.
public class UserPlan {
    public enum planType {
        trial, standard, vip
    }

    private planType type; // Type of the plan (trial, standard, vip)
    private boolean isActive; // Status of the plan (active or not)

    // Constructor
    public UserPlan(planType type, boolean isActive) {
        this.type = type;
        this.isActive = isActive;
    }

    // Getters and Setters
    public planType getType() {
        return type;
    }

    public void setType(planType type) {
        this.type = type;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    /**
     * Static method to create a UserPlan object.
     * 
     * @param params An array of parameters: plan type and active status.
     * @return A new UserPlan object.
     * @throws IllegalArgumentException if the number of parameters is incorrect or the parameter values are invalid.
     */
    public static UserPlan createPlan(String... params) {
        if (params.length != 2) {
            throw new IllegalArgumentException("Invalid number of parameters to create a UserPlan.");
        }

        planType type;
        boolean isActive;

        try {
            type = planType.valueOf(params[0].toUpperCase()); // Convert the first parameter to planType
            isActive = Boolean.parseBoolean(params[1]); // Convert the second parameter to boolean
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid parameter value.");
        }

        return new UserPlan(type, isActive);
    }
}
