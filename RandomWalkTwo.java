/**
 * RandomWalk.java
 * This program runs 1 million random walks (same start point -> (0,0)) of 
 * different lengths (1 to 20 steps) and calculates the average distance
 * for each walk length.
 *
 * @author Sanvitti Shah
 * @since September 3, 2026
 */
public class RandomWalk // Declares the public class named RandomWalk so the Java compiler recognizes it
{ // Opens the main code block containing everything inside the RandomWalk class
    
    public static void main(String[] args) // The main method is the mandatory starting point of the program; it takes an array of Strings as a parameter
    { // Opens the code block for the main method
        System.out.println("Welcome to RandomWalk"); // Prints the exact welcome message requested in the assignment instructions
        
        // TODO: Declare an array of doubles here to hold your 20 average distances // This is a placeholder comment reminding you to store your results
        
        loopWalkLength(); // Calls your custom method to start calculating the random walks
        
        // TODO: Call a print method here, passing your array as a parameter // This is a placeholder comment reminding you to print the final histogram
        
        System.out.println("All Done!"); // Prints the final exit message to the console
    } // Closes the code block for the main method
    
    /**
     * Loops through walk lengths 1 to 20, runs 1 million trials for each, 
     * and calculates the average distance.
     */
    public static void loopWalkLength() // Declares the method that handles the loops; returns nothing (void); takes no parameters
    { // Opens the code block for the loopWalkLength method
        int trials = 1000000; // Defines an integer variable named 'trials' and sets it to 1,000,000 for the Monte Carlo simulation
        
        for (int i = 1; i <= 20; i++) // A for loop: initializes integer i at 1; runs as long as i is less than or equal to 20; increments i by 1 each time
        { // Opens the code block for the outer for loop
            double totalDistance = 0.0; // Defines a double (decimal) variable to keep a running sum of all distances for this specific walk length
            
            // TODO: Write a second loop here (a nested loop) that runs 'trials' number of times (1 to 1,000,000) // Placeholder for the simulation loop
            // TODO: Inside that inner loop, call travel(i) and add its return value to totalDistance // Placeholder for tracking the distance
            
            // TODO: After the inner loop finishes, divide totalDistance by trials to get the average // Placeholder for the final math
            // TODO: Save that average distance into your array // Placeholder to store the data for the histogram
        } // Closes the code block for the outer for loop
    } // Closes the code block for the loopWalkLength method
    
    /**
     * Calculates the final point after taking stepNum random steps and returns the distance.
     * @param stepNum is an integer representing the walk length
     * @return a double representing the Euclidean distance from (0,0)
     */
    public static double travel(int stepNum) // Declares the method that simulates one walk; takes integer stepNum as a parameter; returns a double representing distance
    { // Opens the code block for the travel method
        int x = 0; // Defines integer x and initializes the starting x-coordinate to 0
        int y = 0; // Defines integer y and initializes the starting y-coordinate to 0
        
        for (int i = 0; i < stepNum; i++) // A for loop: initializes integer i at 0; runs as long as i is strictly less than stepNum; increments i by 1
        { // Opens the code block for the for loop
            int directionVal = randomDirection(); // Calls the randomDirection method and stores the returned integer in a new variable called directionVal
            
            if (directionVal == 1) // An if statement: evaluates the condition to see if the value of directionVal is exactly equal to 1
            { // Opens the code block for the first if statement
                y++; // Increments the y coordinate by 1 (which simulates moving North)
            } // Closes the code block for the first if statement
            else if (directionVal == 2) // An else-if statement: evaluates the condition to see if the value of directionVal is exactly equal to 2
            { // Opens the code block for the else-if statement
                x++; // Increments the x coordinate by 1 (which simulates moving East)
            } // Closes the code block for the else-if statement
            
            // TODO: Add else-if statements for 3 (West, x--) and 4 (South, y--) // Placeholder instruction for you to finish coding the remaining directions
        } // Closes the code block for the for loop
        
        // TODO: Use Math.pow() and Math.sqrt() to calculate the distance from (0,0) to the final (x,y) point // Placeholder instruction for the Euclidean distance formula
        return 0.0; // Temporarily returns 0.0 so the code compiles; you will replace this with your actual calculated distance
    } // Closes the code block for the travel method
    
    /**
     * Randomly generates the direction that the step will be taken in
     * @return an integer representing direction (1=North, 2=East, 3=West, 4=South)
     */
    public static int randomDirection() // Declares the method that picks a random direction; takes no parameters; returns an integer
    { // Opens the code block for the randomDirection method
        int directionVal = (int)(Math.random() * 4 + 1); // Generates a random decimal, multiplies by 4, adds 1, and forces it to be an integer (yielding 1, 2, 3, or 4)
        return directionVal; // Returns the randomly generated integer back to the method that originally called it
    } // Closes the code block for the randomDirection method
    
    // TODO: Create your method to print the histogram chart down here // Placeholder instruction for the final piece of the assignment requirements
    
} // Closes the code block for the entire RandomWalk class
