/**
 * Examples of printf formatting
 * 
 * @author Sanvitti Shah
 * @since September 1, 2026
 */
public class PrintfExample
{
	public static void main(String [] args)
	{
		int i = 987;
		double d = 23.56789;
		String str = "Hello world!";
		
		//output strings
		System.out.printf("%s after\n", str); 	//open format
		System.out.printf("%20s after\n", str); //right justified
		System.out.printf("%-20s after\n", str); //left justified
		
		//output integers
		System.out.printf("%d after\n", i);
		System.out.printf("%20d after\n", i);
		System.out.printf("%-20d after\n", i);
		
		//output doubles
		System.out.printf("%f after\n", d);
		System.out.printf("%20.2f after\n", d); //reserve 20 spaces, print 2 decimal places (rounds)
		System.out.printf("%-20.2f after\n", d); //rounds
		System.out.printf("%20.3e after\n", d);	//e signifies scientific notation
					//e+01 means 10 to the power of 1
					
		//formatting text
		String myStr = String.format("%15s %10d %15f\n", str, i, d);
			//formats and stores in variable
		System.out.println(myStr);
		
	}
}
