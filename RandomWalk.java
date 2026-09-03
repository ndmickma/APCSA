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
	public static void main(String [] args)
	{
		
	}
	
	/**
	 *	Randomly generates the direction that the step will be taken in
	 *	@param 
	 *	@return  	The string direction
	 */
	public static String randomDirection()
	{
		String direction; 
		//north = 1, east = 2, west = 3, south = 4
		int directionVal = (int)(Math.random()*4 + 1);
		if(directionVal == 1)
		{
			direction = "NORTH";
		}
		if(directionVal == 2)
		{
			direction = "EAST";
		}
		if(directionVal == 3)
		{
			direction = "WEST";
		}
		if(directionVal == 4)
		{
			direction = "SOUTH";
		}
		
		return direction;
	}
	
	/**
	 *	Loops through and gets the final points for all the walk lengths
	 *  and it also will put those values to find the avg distance
	 *	@param 
	 *	@return  
	 */
	public static void loopWalkLength()
	{
		String
		for(i==1, i<=20, i++)  //loop through the possible walk lengths
						//and run the travel method on it
		{
			travel(i); //this will calculate the final point so we can calculate distance
		}
	}
	
	/**
	 *	Calculates the final x and y coordinate point, using direction
	 *	@param stepNum is an integer that is the walk length, direction is a string that will tell what direction 
	 *	@return coord is a string that is the final x, y coordinate placement. 
	 */
	public static String travel(int stepNum, String direction) //will return final x and y coordinate placement
	{
		String coord;
		//get ints x2 and y2 and put them into a string that is 
		//a coordinate 
		return coord
	}
	
	//method that will use substring to get the x2 and y2 points in an integer
	//and store them in their own seperate variables (use parseInt to make it an int)
	
	
}


