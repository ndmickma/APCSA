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

public class PigGame
{
    /*
     * die is the Dice object used by BOTH the human and the computer.
     *
     * We do NOT need Math.random() here because the Dice class already
     * uses Math.random() inside its roll() method.
     */
    private Dice die;


    /*
     * humanScore is the HUMAN'S PERMANENT/BANKED score.
     *
     * IMPORTANT:
     * Points from the current turn should NOT immediately go here.
     * They first go into a local variable such as turnScore.
     *
     * Only when the human HOLDS should the turn points be added here.
     */
    private int humanScore;


    /*
     * computerScore is the COMPUTER'S PERMANENT/BANKED score.
     *
     * Just like humanScore, this should only receive points after
     * the computer successfully holds.
     */
    private int computerScore;


    /*
     * Instead of writing the number 100 throughout the program,
     * we can give it a name.
     *
     * "static final" means this value is a constant:
     * it belongs to the class and should never change.
     */
    private static final int WINNING_SCORE = 100;


    /*
     * The computer holds once its temporary turn score reaches
     * AT LEAST 20.
     *
     * Examples:
     * 18 -> computer rolls again
     * 19 -> computer rolls again
     * 20 -> computer holds
     * 21 -> computer holds
     * 24 -> computer holds
     */
    private static final int COMPUTER_HOLD_SCORE = 20;



    /**
     * Constructor for PigGame.
     *
     * A constructor sets up a new PigGame object before the game begins.
     *
     * There are NO parameters because we do not need the user to give
     * us any information when the game is created.
     */
    public PigGame()
    {
        /*
         * Create a normal 6-sided die.
         *
         * Dice() is the default constructor from Dice.java.
         */
        die = new Dice();


        /*
         * Both players begin the game with 0 permanent points.
         */
        humanScore = 0;
        computerScore = 0;
    }



    /**
     * The main method is where Java starts the program.
     *
     * @param args command-line information given when the program starts.
     *             We do not actually need to use args in this program.
     */
    public static void main(String[] args)
    {
        /*
         * Create one PigGame object.
         *
         * "game" is a variable that refers to our PigGame object.
         */
        PigGame game = new PigGame();


        /*
         * Tell the PigGame object to begin running the program.
         */
        game.run();
    }



    /**
     * Starts the Pig Game.
     *
     * This method does not need parameters because all of the important
     * game information (die, humanScore, computerScore) is stored as
     * instance variables above.
     *
     * This method also does not return anything, so its return type is void.
     */
    public void run()
    {
        /*
         * First show the directions/title that were already provided
         * in your starter PigGame.java.
         */
        printIntroduction();


        /*
         * Then actually play the game.
         *
         * You said you DO NOT need the statistics portion, so there
         * is no reason to ask the user whether they want play/statistics.
         */
        playGame();
    }



    /**
     * Controls the OVERALL game.
     *
     * Think of this method as the manager.
     *
     * It should:
     * 1. Give the human a turn.
     * 2. Check whether the human won.
     * 3. If not, give the computer a turn.
     * 4. Check whether the computer won.
     * 5. Repeat until someone reaches at least 100 points.
     *
     * This method should NOT contain all of the rolling details.
     * humanTurn() and computerTurn() handle those.
     */
    public void playGame()
    {
        /*
         * Keep repeating while NEITHER player has won.
         *
         * && means AND.
         *
         * Therefore, the loop continues only if:
         *
         * humanScore is less than 100
         * AND
         * computerScore is less than 100.
         */
        while (humanScore < WINNING_SCORE
                && computerScore < WINNING_SCORE)
        {
            System.out.println("**** USER Turn ***");


            /*
             * This method should take care of the ENTIRE human turn.
             *
             * When humanTurn() finishes, control comes back here.
             */
            humanTurn();


            /*
             * TODO #1:
             *
             * Check whether the human's PERMANENT score is now
             * at least WINNING_SCORE.
             *
             * If the human has won, you do NOT want to give the
             * computer another turn.
             *
             * HINT:
             *
             * if ( ______________________________ )
             * {
             *     break;
             * }
             *
             * "break" immediately exits the while loop.
             */
             if(humanScore >= WINNING_SCORE)
             {
				 break;
			 }


            /*
             * If the human did NOT win, it is now the computer's turn.
             */
            System.out.println("**** COMPUTER'S Turn ***");


            /*
             * computerTurn() handles the entire computer turn.
             */
            computerTurn();


            /*
             * You do not necessarily need another break here because
             * the while condition at the top will check both scores
             * before another round begins.
             *
             * However, think about whether adding one would make the
             * flow easier for you to understand.
             */
             
             if(computerScore >= WINNING_SCORE)
             {
				 break;
			 }
			 
        }


        /*
         * At this point the while loop has ended, so SOMEONE
         * must have reached at least 100 permanent points.
         *
         * TODO #2:
         *
         * Use an if/else statement to figure out who won.
         *
         * If humanScore >= WINNING_SCORE:
         *     print the human winning message.
         *
         * Otherwise:
         *     print the computer winning message.
         */
         if(humanScore >= WINNING_SCORE)
			System.out.println("Congratulations!!! YOU WON!!!!");
		 else
			System.out.println("Uh oh! The computer won!");


        /*
         * This happens after the winner has been announced.
         */
        System.out.println("\nThanks for playing the Pig Game!!!");
    }



    /**
     * Runs ONE COMPLETE HUMAN TURN.
     *
     * The human begins each turn with a temporary turn score of 0.
     *
     * The turn continues until ONE of these happens:
     *
     * 1. The human rolls a 1
     *       -> temporary points are lost
     *       -> permanent score does NOT change
     *       -> turn ends
     *
     * 2. The human chooses HOLD
     *       -> temporary points are added to humanScore
     *       -> turn ends
     *
     * There are no parameters because the method can directly access
     * humanScore and die, which are instance variables.
     */
    public void humanTurn()
    {
        /*
         * turnScore stores ONLY the points earned during THIS TURN.
         *
         * It is local because every new human turn should start at 0.
         *
         * Example:
         *
         * humanScore = 30
         *
         * Human rolls 5:
         * turnScore = 5
         * humanScore is STILL 30
         *
         * Human rolls 4:
         * turnScore = 9
         * humanScore is STILL 30
         *
         * Human holds:
         * humanScore becomes 39
         */
        int turnScore = 0;


        /*
         * This boolean tells us whether the current turn is finished.
         *
         * false = keep the human turn going
         * true  = stop the human turn
         */
        boolean turnOver = false;


        /*
         * Keep repeating until something changes turnOver to true.
         */
        while (!turnOver)
        {
            /*
             * ! means NOT.
             *
             * Therefore:
             *
             * while (!turnOver)
             *
             * means:
             *
             * "while the turn is NOT over"
             */


            /*
             * Show the temporary points earned during this turn.
             */
            System.out.println("\nYour turn score: " + turnScore);


            /*
             * Show the permanent points that have already been banked.
             */
            System.out.println("Your total score: " + humanScore);


            /*
             * Ask the user for ONE character using your Prompt class.
             *
             * choice will contain something such as:
             * 'r'
             * 'R'
             * 'h'
             * 'H'
             */
            char choice = Prompt.getChar("(r)oll or (h)old");


            /*
             * Check whether the user wants to ROLL.
             *
             * We check both lowercase and uppercase so either
             * r or R will work.
             */
            if (choice == 'r' || choice == 'R')
            {
                System.out.println("\nYou ROLL");


                /*
                 * TODO #3:
                 *
                 * Roll the Dice object.
                 *
                 * Dice.roll() RETURNS the number that was rolled,
                 * so store that number in an int variable.
                 *
                 * Your line should look roughly like:
                 *
                 * int roll = __________________;
                 *
                 * Look in Dice.java for the method you need.
                 */
                 int roll = die.roll();


                /*
                 * TODO #4:
                 *
                 * Print the picture of the die that was just rolled.
                 *
                 * The Dice class already contains a method that
                 * prints the ASCII-art die for you.
                 *
                 * You do NOT need to create the die picture yourself.
                 */
                 die.printDice();


                /*
                 * TODO #5:
                 *
                 * Now examine the number that was rolled.
                 *
                 * CASE A: roll == 1
                 *
                 * The human loses ALL points earned THIS TURN.
                 *
                 * IMPORTANT:
                 * Do NOT change humanScore here!
                 *
                 * The points were never banked, so humanScore should
                 * remain exactly what it was before the turn.
                 *
                 * You should:
                 *
                 * - print a message explaining that the turn was lost
                 * - make the temporary turn points 0
                 * - end the turn by changing turnOver
                 *
                 *
                 * CASE B: roll is 2 through 6
                 *
                 * Add the roll to turnScore.
                 *
                 * DO NOT add it directly to humanScore.
                 *
                 * Example:
                 *
                 * turnScore = turnScore + roll;
                 *
                 * or the shorter version:
                 *
                 * turnScore += roll;
                 */
                 if(roll == 1)
                 {
					 System.out.println("You LOSE your turn.");
					 turnOver = true;
					 turnScore = 0;
					 System.out.println("Your total score: " + humanScore);
					 
				 }
				 else
				 {
					 turnScore += roll;
				 }
            }


            /*
             * Otherwise check whether the user chose HOLD.
             */
            else if (choice == 'h' || choice == 'H')
            {
                /*
                 * TODO #6:
                 *
                 * This is where the human SAVES/BANKS the temporary
                 * points.
                 *
                 * Add turnScore to humanScore.
                 *
                 * Then end the turn.
                 *
                 * You can also print:
                 *
                 * "You HOLD"
                 *
                 * followed by the new human total.
                 */
                 System.out.println("You HOLD");
                 humanScore += turnScore;
                 System.out.println("Your total score: " + humanScore);
                 turnOver = true;
            }


            /*
             * The character was neither R nor H.
             */
            else
            {
                /*
                 * Because turnOver is still false, the while loop
                 * will repeat and ask the user again.
                 */
                System.out.println("Please enter r or h.");
            }
        }
    }



    /**
     * Runs ONE COMPLETE COMPUTER TURN.
     *
     * The computer does NOT randomly decide whether to roll or hold.
     *
     * Its strategy is:
     *
     * - Start the turn with 0 temporary points.
     * - Keep rolling while the temporary score is below 20.
     * - If it rolls a 1, it loses the temporary points and its turn ends.
     * - Once the temporary score reaches 20 OR goes above 20,
     *   it immediately holds.
     * - If its permanent score + temporary score reaches at least 100,
     *   it should hold and win instead of rolling unnecessarily.
     *
     * There are no parameters because the method directly accesses
     * computerScore and die.
     */
    public void computerTurn()
    {
        /*
         * The computer also needs its own temporary score.
         *
         * This becomes 0 again every time computerTurn() is called.
         */
        int turnScore = 0;


        /*
         * false means the computer is still taking its turn.
         */
        boolean turnOver = false;


        /*
         * Continue until the computer either:
         *
         * - rolls a 1, OR
         * - reaches the point where it should hold.
         */
        while (!turnOver)
        {
            System.out.println("\nComputer's turn score: " + turnScore);

            System.out.println("Computer's total score: " + computerScore);


            /*
             * The sample program lets the human press Enter before
             * each computer action.
             *
             * We don't care what String is typed, so we do not
             * necessarily need to save the returned String.
             */
            Prompt.getString("Press enter for computer's turn");


            /*
             * TODO #7:
             *
             * Decide whether the computer ALREADY has enough points
             * to hold.
             *
             * There are TWO important reasons to hold:
             *
             * A. turnScore has reached at least 20
             *
             * OR
             *
             * B. computerScore + turnScore has reached at least 100
             *
             *
             * Think about an if statement involving:
             *
             * turnScore >= COMPUTER_HOLD_SCORE
             *
             * and
             *
             * computerScore + turnScore >= WINNING_SCORE
             *
             *
             * If it should hold:
             *
             * 1. Add turnScore to computerScore.
             * 2. Print "Computer will HOLD".
             * 3. Print the computer's new total.
             * 4. End the turn.
             */
             if(turnScore >= COMPUTER_HOLD_SCORE || computerScore + turnScore >= WINNING_SCORE)
             {
				 computerScore += turnScore;
				 System.out.println("Computer will HOLD");
				 System.out.println("Computer's total score: " + computerScore);
				 turnOver = true;
			 }
			 /*
			

            /*
             * TODO #8:
             *
             * If the computer should NOT hold yet, it must roll.
             *
             * Remember your rule:
             *
             * It CANNOT voluntarily hold at 19.
             * It MUST roll again.
             *
             * It only holds once the turn reaches 20 or higher
             * (unless its total would already reach 100).
             *
             * Inside this section:
             *
             * 1. Print "Computer will ROLL".
             * 2. Roll using the Dice object.
             * 3. Store the result in an int.
             * 4. Print the die.
             * 5. Check whether the roll was 1.
             */
             System.out.println("Computer will ROLL");
             int roll = die.roll();
             die.printDice();


            /*
             * TODO #9:
             *
             * If the computer rolled 1:
             *
             * - it loses ALL temporary turn points
             * - computerScore stays unchanged
             * - turnOver becomes true
             *
             *
             * Otherwise:
             *
             * - add the roll to turnScore
             *
             *
             * EXAMPLE:
             *
             * computerScore = 42
             * turnScore = 18
             *
             * Computer rolls 5.
             *
             * turnScore becomes 23.
             *
             * Since 23 >= 20, it should hold instead of rolling again.
             *
             * computerScore would then become:
             *
             * 42 + 23 = 65
             */
             if(roll == 1)
             {
				 turnOver = true;
				 turnScore = 0;
				 System.out.println("Computer loses turn.");
				 System.out.println("Computer's total score: " + computerScore);
			 }
			 else
				turnScore += roll;
        }
    }



    /**
     * Print the introduction to the game.
     *
     * This method was already provided in your starter file.
     * It only prints text, so it does not need parameters and
     * does not return a value.
     */
    public void printIntroduction()
    {
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
}
