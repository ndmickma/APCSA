/**
* RandomWalk.java
* This program runs 1 million random walks (same start point -> (0,0)) of 
* different lengths (1 to 20 steps) and calculates the average distance
* for each walk length.
*
* @author Sanvitti Shah
* @since September 3, 2026
*/

public class RandomWalk
{
    // Maximum number of steps we will test.
    // The assignment wants walk lengths from 1 through 20.
    private static final int MAX_WALK_LENGTH = 20;

    // Number of times we repeat each walk length.
    // Repeating the walk many times makes the average more reliable.
    private static final int NUM_TRIALS = 1000000;


    public static void main(String[] args)
    {
        // Stores the average distance for each walk length.
        //
        // averages[0] = average for a 1-step walk
        // averages[1] = average for a 2-step walk
        // ...
        // averages[19] = average for a 20-step walk
        double[] averages = new double[MAX_WALK_LENGTH];


        // Prints the beginning of the program.
        System.out.println("Welcome to RandomWalk");
        System.out.println("-------------------------");


        // TODO:
        // Write a loop that goes from walk length 1 through 20.
        //
        // For each walk length:
        // 1. Call monteCarlo(walkLength)
        // 2. Store the returned average in the averages array
        //
        // Remember:
        // walk length 1 goes in index 0
        // walk length 2 goes in index 1
        // etc.
        int i = 0;
        for(int walkLength = 1; walkLength <=20; walkLength++)
        {
			averages[i] = monteCarlo(walkLength);
			i++; 
		}


        // Prints the completed histogram.
        printHistogram(averages);


        // Prints the end of the program.
        System.out.println("----------------------------");
        System.out.println("All Done!");
    }


    /**
     * Runs many random walks of the SAME length and calculates
     * the average ending distance.
     *
     * @param walkLength
     *        The number of steps in each individual random walk.
     *
     * @return
     *        The average distance after performing all the trials.
     */
    public static double monteCarlo(int walkLength)
    {
        // Adds together the distances from every random walk.
        double totalDistance = 0.0;


        // TODO:
        // Repeat NUM_TRIALS times.
        //
        // Each time:
        // 1. Call randomWalk(walkLength)
        // 2. Save or use the distance that it returns
        // 3. Add that distance to totalDistance
        for(int count = 1; count <= NUM_TRIALS; count++)
        {
			double dist = randomWalk(walkLength);
			totalDistance += dist;
		}


        // TODO:
        // Find the average:
        //
        // totalDistance / number of trials
        //
        // Then return that average.
        double avgDistance = totalDistance/NUM_TRIALS;


        return avgDistance; // TEMPORARY - replace this
    }


    /**
     * Performs ONE random walk.
     *
     * For example:
     * randomWalk(5)
     *
     * means that the walker should randomly move exactly 5 times.
     *
     * @param numberOfSteps
     *        The total number of random steps this walk should take.
     *
     * @return
     *        The straight-line distance from the starting point
     *        to the ending point.
     */
    public static double randomWalk(int numberOfSteps)
    {
        // x keeps track of horizontal movement.
        //
        // Positive x = east
        // Negative x = west
        //
        // The walker begins at x = 0.
        int x = 0;


        // y keeps track of vertical movement.
        //
        // Positive y = north
        // Negative y = south
        //
        // The walker begins at y = 0.
        int y = 0;


        // TODO:
        // Write a loop that repeats numberOfSteps times.
        //
        // Each repetition represents ONE movement.
        int count = 1;
        while(count <= numberOfSteps)
        {
			
            // This creates a random integer from 0 through 3.
            //
            // Math.random() gives a decimal:
            //
            //      0.0 <= number < 1.0
            //
            // Multiplying by 4 changes the range to:
            //
            //      0.0 <= number < 4.0
            //
            // Casting to int removes the decimal part.
            //
            // Possible answers:
            // 0, 1, 2, or 3
            int direction = (int)(Math.random() * 4);


            // We will let each number represent one direction:
            //
            // 0 = north
            // 1 = south
            // 2 = east
            // 3 = west


            // TODO:
            // Use direction to decide how x or y changes.
            //
            // Think about:
            //
            // direction == 0:
            //     Move NORTH
            //
            // direction == 1:
            //     Move SOUTH
            //
            // direction == 2:
            //     Move EAST
            //
            // direction == 3:
            //     Move WEST
            //
            // You can use an if / else if statement.
            
            // 0 means move NORTH.
			// Moving north increases y by 1.
            if(direction == 0)
            {
				y++;
			}
			//1 means move SOUTH
			// decreases y by 1
			else if(direction == 1)
			{
				y--;
			}
			//2 means EAST
			//increase x by 1
			else if(direction == 2)
			{
				x++;
			}
			//3 means WEST
			//decrease x by 1
			else if(direction == 3)
			{
				x--;
			}
			
			count++; //one step has been completed so increase count
        }


        // Once all the steps are finished,
        // x and y represent the final location.
        //
        // Send that location to calculateDistance().
        return calculateDistance(x, y);
    }


    /**
     * Finds the straight-line distance from the starting point
     * (0, 0) to the final point (x, y).
     *
     * @param x
     *        Final horizontal position.
     *
     * @param y
     *        Final vertical position.
     *
     * @return
     *        Distance from (0, 0) to (x, y).
     */
    public static double calculateDistance(int x, int y)
    {
        // TODO:
        // Use the distance formula.
        //
        // Because we start at (0, 0), it simplifies to:
        //
        // square root of (x² + y²)
        //
        // Math.sqrt(...) will probably be useful.
        
        double squared = Math.pow(x,2)+Math.pow(y,2);
        double distance = Math.sqrt(squared);


        return distance; 
    }


    /**
     * Prints the average distance for every walk length
     * and prints its histogram bar.
     *
     * @param averages
     *        Array containing all of the calculated average distances.
     */
    public static void printHistogram(double[] averages)
    {
        System.out.println("Walks of");
        System.out.println("Length AveDist");


        // TODO:
        // Loop through the averages array.
        //
        // For each element:
        //
        // 1. Figure out its walk length.
        //
        //    index 0 = length 1
        //    index 1 = length 2
        //    ...
        //
        // 2. Print the walk length.
        //
        // 3. Print the average distance.
        //
        // 4. Call makeBar(averageDistance) and print
        //    the String it returns.
        //
        // You can use printf() if you need to show
        // exactly 4 digits after the decimal.
        for(int i = 0; i < averages.length; i++)
        {
			int walkLength = i+1;
			double averageDistance = averages[i];
			String bar = makeBar(averageDistance);
			System.out.printf("%2d %5.4f %s%n",
                          walkLength, averageDistance, bar);
		}
    }


    /**
     * Creates the stars for one row of the histogram.
     *
     * @param averageDistance
     *        The average distance for that walk length.
     *
     * @return
     *        A String containing the correct number of stars.
     */
    public static String makeBar(double averageDistance)
    {
        // Begin with an empty histogram bar.
        String bar = "";


        // TODO:
        // Figure out how many stars should be printed.
        //
        // Use the example output to find the relationship:
        //
        // 1.0000 --> about 15 stars
        // 2.0000 --> about 30 stars
        // 4.0000 --> about 60 stars
        //
        // Think:
        //
        // averageDistance * ? = number of stars
        
        int numStars = (int)Math.round(averageDistance * 15);


        // TODO:
        // Write a loop that runs once for every star.
        //
        // Each time through the loop:
        //
        // bar = bar + "*";
        for(int i = 1; i<=numStars; i++)
        {
			bar = bar.concat("*");
		}


        // Return the finished row of stars.
        return bar;
    }
}
