/**
 *	The game of Pig.
 *	The goal is to reach 100 points before the opposing player (computer)
 * 	One turn consists of rolling the dice over and over until you either 
 *  pick to hold (and save your current points) or you roll a 1 (turn ends
 *  and you lose that turn's progress). Rolling a 2 - 6 gives you that
 *  many points. 
 *
 *	@author	Sanvitti Shah
 *	@since	September 10th, 2026
 * //to run example:  java -cp PigGame.jar PigGame
 */
public class PigGame {
	
	private int userTotalScore;
	private int userTurnScore;
	private int compTotalScore;
	private int compTurnScore;
	private String userInput;
	
	public static void main(String [] args)
	{
		printIntroduction;
		//call prompt with the parameter of our question
		userInput = Prompt.getString("(r)oll or (h)old ");
		diceVal = Dice.getValue()
		while(!userInput.equals(h) && diceVal != 1)
		{
			oneUserTurn(userInput);
			//get user input again
			userInput = Prompt.getString("(r)oll or (h)old "); 
		}
	}
	
	/**	Print the introduction to the game */
	public void printIntroduction() {
		System.out.println("\n");
		System.out.println("______ _         _____");
		System.out.println("| ___ (_)       |  __ \\");
		System.out.println("| |_/ /_  __ _  | |  \\/ __ _ _ __ ___   ___");
		System.out.println("|  __/| |/ _` | | | __ / _` | '_ ` _ \\ / _ \\");
		System.out.println("| |   | | (_| | | |_\\ \\ (_| | | | | | |  __/");
		System.out.println("\\_|   |_|\\__, |  \\____/\\__,_|_| |_| |_|\\___|");
		System.out.println("          __/ |");
		System.out.println("         |___/");
		System.out.println("\nThe Pig Game is human vs computer. Each takes a"
							+ " turn rolling a die and the first to score");
		System.out.println("100 points wins. A player can either ROLL or "
							+ "HOLD. A turn works this way:");
		System.out.println("\n\tROLL:\t2 through 6: add points to turn total, "
							+ "player's turn continues");
		System.out.println("\t\t1: player loses turn");
		System.out.println("\tHOLD:\tturn total is added to player's score, "
							+ "turn goes to other player");
		System.out.println("\n");
	}
	
	/**
	 *	Goes through one user turn
	 *	@param userInput  If the user holds or rolls (based on input)
	 *	@return  The int turn score
	 */
	public int oneUserTurn(String userInput)
	{
		if(userInput.eqauls(r)
		{
			
		}
	}
	
	/**
	 *	Goes through one computer turn
	 *	@param randChoice  If the computer holds or rolls
	 *	@return  The int turn score
	 */
	 public int oneCompTurn(String randChoice)
	 {
		 if(turnScore < 20)
		 {
			//then the comp rolls
			Dice.roll();
			Dice.printDice();
			 
		 }
	 }
	 
	 public void userTotalScore()
	 {
		 userTotalScore+=userTurnScore;
	 }
	 
	 public void compTotalScore()
	 {
		 compTotalScore += compTurnScore;
	 } 
	
}
