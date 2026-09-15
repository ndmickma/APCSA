/**
 * PigGame.java
 *
 * This program allows the user to either:
 *
 * 1. Play the Pig game against the computer
 * OR
 * 2. Run a Monte Carlo statistical simulation of Pig turns.
 *
 * In the regular game:
 * - The first player to reach at least 100 points wins.
 * - Rolling 2 through 6 adds to the temporary turn score.
 * - Rolling a 1 loses all temporary points for that turn.
 * - Holding adds the temporary turn score to the permanent score.
 *
 * In the statistical simulation:
 * - The computer repeatedly plays ONE turn.
 * - The computer always tries to "hold at 20."
 * - If it rolls a 1, the result of that turn is 0.
 * - If its turn reaches 20 or higher, the final turn score is recorded.
 * - The program counts how often each possible result occurs.
 * - The counts are then converted into estimated probabilities.
 *
 * @author YOUR NAME
 * @since DATE
 */

public class PigGame
{
    /*
     * ------------------------------------------------------------
     * INSTANCE VARIABLES
     * ------------------------------------------------------------
     */


    /*
     * die is the Dice object used for rolling.
     *
     * The Dice class already knows how to:
     * - generate a random number from 1 to 6
     * - remember the last roll
     * - print the picture of the die
     *
     * We therefore do NOT need to write Math.random() ourselves.
     */
    private Dice die;


    /*
     * humanScore stores the HUMAN'S permanent/banked score
     * during the actual game.
     *
     * Example:
     *
     * humanScore = 45
     *
     * means the human has already safely banked 45 points.
     *
     * Temporary points from the current turn should NOT be
     * stored here until the player chooses HOLD.
     */
    private int humanScore;


    /*
     * computerScore stores the COMPUTER'S permanent/banked score
     * during the actual game.
     */
    private int computerScore;


    /*
     * The game ends when somebody reaches at least 100 points.
     *
     * Using a constant makes the code easier to understand.
     *
     * Instead of writing 100 everywhere, we can write
     * WINNING_SCORE.
     */
    private static final int WINNING_SCORE = 100;


    /*
     * The computer's strategy is to HOLD when its temporary
     * turn score reaches at least 20.
     */
    private static final int COMPUTER_HOLD_SCORE = 20;


    /*
     * During the statistical simulation, a turn can end with:
     *
     * 0
     * 20
     * 21
     * 22
     * 23
     * 24
     * 25
     *
     * 25 is the largest possible score because the computer
     * must stop once it reaches at least 20.
     *
     * For example:
     *
     * 19 + 6 = 25
     *
     * Therefore, our statistics array needs positions
     * from 0 through 25.
     */
    private static final int MAX_TURN_SCORE = 25;



    /*
     * ------------------------------------------------------------
     * CONSTRUCTOR
     * ------------------------------------------------------------
     */

    /**
     * Constructor for PigGame.
     *
     * The constructor sets up the starting values for a new game.
     *
     * There are no parameters because the user does not need to
     * give us any information when creating the PigGame object.
     */
    public PigGame()
    {
        /*
         * Create a normal six-sided die.
         *
         * Dice() is the default constructor from Dice.java.
         */
        die = new Dice();


        /*
         * Both players start with 0 permanent points.
         */
        humanScore = 0;
        computerScore = 0;
    }



    /*
     * ------------------------------------------------------------
     * MAIN METHOD
     * ------------------------------------------------------------
     */

    /**
     * Main method.
     *
     * Java starts the program here.
     *
     * @param args command-line arguments.
     *             We do not need to use these for this program.
     */
    public static void main(String[] args)
    {
        /*
         * Create a PigGame object.
         *
         * "game" is the variable that refers to this object.
         */
        PigGame game = new PigGame();


        /*
         * Start the program by calling run().
         */
        game.run();
    }



    /*
     * ------------------------------------------------------------
     * RUN METHOD
     * ------------------------------------------------------------
     */

    /**
     * Starts the Pig Game program.
     *
     * This method:
     *
     * 1. Prints the introduction.
     * 2. Asks whether the user wants to play or run statistics.
     * 3. Calls the appropriate method.
     *
     * There are no parameters because all necessary information
     * is handled inside this class.
     */
    public void run()
    {
        /*
         * Print the title and instructions.
         *
         * This method was already provided in your starter file.
         */
        printIntroduction();


        /*
         * Ask the user whether they want to:
         *
         * p = play the game
         * s = run statistics
         *
         * Prompt.getChar() returns ONE character.
         */
        char choice = Prompt.getChar("Play game or Statistics (p or s)");


        /*
         * Check whether the user selected PLAY.
         */
        if (choice == 'p' || choice == 'P')
        {
            /*
             * Run the normal Pig game.
             */
            playGame();
        }


        /*
         * Otherwise, check whether the user selected STATISTICS.
         */
        else if (choice == 's' || choice == 'S')
        {
            /*
             * Run the Monte Carlo simulation.
             */
            runStatistics();
        }


        /*
         * If the user did not enter p or s...
         */
        else
        {
            /*
             * TODO #1:
             *
             * Print a message saying that the user must
             * choose p or s.
             *
             * You could either:
             *
             * A. Simply end the program
             *
             * OR
             *
             * B. Put the question inside a loop so the user
             *    gets another chance.
             *
             * A loop would be more user-friendly.
             */
        }
    }



    /*
     * ============================================================
     * REGULAR GAME
     * ============================================================
     */



    /**
     * Controls the overall human-vs-computer Pig game.
     *
     * This method is basically the "manager" of the game.
     *
     * It should:
     *
     * 1. Give the human a turn.
     * 2. Check whether the human won.
     * 3. Give the computer a turn if necessary.
     * 4. Check whether the computer won.
     * 5. Repeat until somebody reaches 100.
     */
    public void playGame()
    {
        /*
         * Keep playing while BOTH players have less than 100.
         */
        while (humanScore < WINNING_SCORE
                && computerScore < WINNING_SCORE)
        {
            /*
             * Announce the human's turn.
             */
            System.out.println("**** USER Turn ***");


            /*
             * Run ONE complete human turn.
             */
            humanTurn();


            /*
             * TODO #2:
             *
             * Check whether the human has now reached
             * at least 100 points.
             *
             * If so, the game should stop before giving
             * the computer another turn.
             *
             * HINT:
             *
             * if (humanScore >= WINNING_SCORE)
             * {
             *     ...
             * }
             */


            /*
             * Announce the computer's turn.
             */
            System.out.println("**** COMPUTER'S Turn ***");


            /*
             * Run ONE complete computer turn.
             */
            computerTurn();
        }


        /*
         * TODO #3:
         *
         * Determine who won.
         *
         * If humanScore is at least 100:
         *
         *     Print the human winning message.
         *
         * Otherwise:
         *
         *     Print the computer winning message.
         *
         * Remember that the sample output uses:
         *
         * "Congratulations!!! YOU WON!!!!"
         *
         * when the user wins.
         */


        /*
         * Print the goodbye message.
         */
        System.out.println("Thanks for playing the Pig Game!!!");
    }



    /**
     * Runs one complete human turn.
     *
     * turnScore is temporary.
     *
     * It is NOT added to humanScore until the human chooses HOLD.
     */
    public void humanTurn()
    {
        /*
         * Temporary points earned during this turn.
         *
         * Every new turn starts at 0.
         */
        int turnScore = 0;


        /*
         * Keeps track of whether the turn is finished.
         *
         * false = keep playing
         * true = end the turn
         */
        boolean turnOver = false;


        /*
         * Continue until the human either:
         *
         * - rolls a 1
         * OR
         * - chooses HOLD
         */
        while (!turnOver)
        {
            /*
             * Display temporary turn points.
             */
            System.out.println("\nYour turn score: " + turnScore);


            /*
             * Display permanent points.
             */
            System.out.println("Your total score: " + humanScore);


            /*
             * Ask the user whether they want to roll or hold.
             */
            char choice = Prompt.getChar("(r)oll or (h)old");


            /*
             * ----------------------------------------------------
             * USER CHOOSES ROLL
             * ----------------------------------------------------
             */
            if (choice == 'r' || choice == 'R')
            {
                System.out.println("\nYou ROLL");


                /*
                 * TODO #4:
                 *
                 * Roll the die and save the result.
                 *
                 * HINT:
                 *
                 * int roll = die.roll();
                 *
                 * The roll() method returns an int from 1 to 6.
                 */


                /*
                 * TODO #5:
                 *
                 * Print the picture of the die.
                 *
                 * The Dice class already has a method for this.
                 *
                 * HINT:
                 *
                 * die.printDice();
                 */


                /*
                 * TODO #6:
                 *
                 * Check whether roll == 1.
                 *
                 * If the roll is 1:
                 *
                 * - The human loses ALL temporary points.
                 * - humanScore does NOT change.
                 * - turnScore becomes 0.
                 * - The turn ends.
                 *
                 * Otherwise:
                 *
                 * - Add roll to turnScore.
                 */
            }


            /*
             * ----------------------------------------------------
             * USER CHOOSES HOLD
             * ----------------------------------------------------
             */
            else if (choice == 'h' || choice == 'H')
            {
                /*
                 * TODO #7:
                 *
                 * The human has chosen to HOLD.
                 *
                 * Add turnScore to humanScore.
                 *
                 * Then set turnOver to true.
                 *
                 * Remember:
                 *
                 * HOLD = permanently save the temporary points.
                 */
            }


            /*
             * ----------------------------------------------------
             * INVALID INPUT
             * ----------------------------------------------------
             */
            else
            {
                /*
                 * The user entered something other than r or h.
                 *
                 * Since turnOver is still false, the while loop
                 * will ask the user again.
                 */
                System.out.println("Please enter r or h.");
            }
        }
    }



    /**
     * Runs one complete computer turn.
     *
     * The computer's strategy is:
     *
     * - Keep rolling while turnScore < 20.
     * - If it rolls a 1, lose the temporary points and end the turn.
     * - Once turnScore >= 20, HOLD.
     * - If the computer can reach 100 by holding, it should hold.
     */
    public void computerTurn()
    {
        /*
         * Temporary points for THIS computer turn.
         */
        int turnScore = 0;


        /*
         * Keeps track of whether the computer's turn has ended.
         */
        boolean turnOver = false;


        /*
         * Continue until the computer rolls a 1
         * or decides to hold.
         */
        while (!turnOver)
        {
            /*
             * Display the computer's current temporary score.
             */
            System.out.println("\nComputer's turn score: " + turnScore);


            /*
             * Display the computer's permanent score.
             */
            System.out.println("Computer's total score: " + computerScore);


            /*
             * Pause so the user can see each computer roll.
             *
             * We don't need to save the String because the user
             * is simply pressing Enter.
             */
            Prompt.getString("Press enter for computer's turn");


            /*
             * TODO #8:
             *
             * Determine whether the computer should HOLD.
             *
             * The computer should hold when:
             *
             * turnScore >= COMPUTER_HOLD_SCORE
             *
             * OR
             *
             * computerScore + turnScore >= WINNING_SCORE
             *
             * If it holds:
             *
             * 1. Add turnScore to computerScore.
             * 2. Print "Computer will HOLD".
             * 3. Set turnOver = true.
             *
             * IMPORTANT:
             *
             * The computer should NOT voluntarily hold at 18 or 19.
             * It must keep rolling until it reaches at least 20.
             */


            /*
             * TODO #9:
             *
             * If the computer does NOT hold, it must roll.
             *
             * Use:
             *
             * int roll = die.roll();
             *
             * Then print the die.
             */


            /*
             * TODO #10:
             *
             * Check the computer's roll.
             *
             * If roll == 1:
             *
             *     turnScore = 0;
             *     turnOver = true;
             *
             * The computer loses the temporary points.
             *
             * Otherwise:
             *
             *     turnScore += roll;
             *
             * The computer continues rolling.
             */
        }
    }



    /*
     * ============================================================
     * STATISTICS / MONTE CARLO SIMULATION
     * ============================================================
     */



    /**
     * Runs the statistical analysis.
     *
     * This method does NOT play a full 100-point game.
     *
     * Instead, it runs many individual computer turns.
     *
     * For example, if the user chooses 1,000,000 turns,
     * the program will simulate 1,000,000 separate turns.
     *
     * Each simulated turn produces ONE final result:
     *
     * 0
     * 20
     * 21
     * 22
     * 23
     * 24
     * 25
     *
     * The method counts how many times each result occurs.
     */
    public void runStatistics()
    {
        /*
         * Tell the user what type of simulation is being run.
         */
        System.out.println("\nRun statistical analysis - "
                         + "\"Hold at 20\"");


        /*
         * Ask how many turns to simulate.
         *
         * The assignment's sample uses a range of:
         *
         * 1,000 through 1,000,000
         *
         * Prompt.getInt(String, int, int) is perfect for this
         * because it automatically restricts the input to a range.
         */
        int numTurns = Prompt.getInt(
            "Number of turns",
            1000,
            1000000
        );


        /*
         * Create an array to count the results.
         *
         * Index = final turn score.
         *
         * For example:
         *
         * results[0]  = number of turns that ended with 0
         * results[20] = number of turns that ended with 20
         * results[21] = number of turns that ended with 21
         *
         * etc.
         *
         * Why MAX_TURN_SCORE + 1?
         *
         * Because arrays start at index 0.
         *
         * If MAX_TURN_SCORE is 25, we need:
         *
         * 0 through 25
         *
         * which is 26 positions.
         */
        int[] results = new int[MAX_TURN_SCORE + 1];


        /*
         * Run the simulation numTurns times.
         *
         * Example:
         *
         * numTurns = 1,000,000
         *
         * This loop runs 1,000,000 times.
         */
        for (int i = 0; i < numTurns; i++)
        {
            /*
             * TODO #11:
             *
             * Simulate ONE computer turn.
             *
             * The method simulateTurn() should return the final
             * score for that turn.
             *
             * Store that result in a variable.
             *
             * HINT:
             *
             * int score = simulateTurn();
             */


            /*
             * TODO #12:
             *
             * Use the score as an INDEX into the results array.
             *
             * Increase that array position by 1.
             *
             * For example, if score == 22:
             *
             * results[22]++;
             *
             * This means:
             *
             * "We just had one more turn that ended with 22."
             */
        }


        /*
         * Once all the turns have been simulated,
         * display the probabilities.
         */
        printStatistics(results, numTurns);
    }



    /**
     * Simulates ONE computer turn for the statistics.
     *
     * This is different from computerTurn().
     *
     * computerTurn() is used during the actual game and changes
     * computerScore.
     *
     * simulateTurn() should NOT change computerScore because
     * we are not actually playing a game.
     *
     * It simply answers:
     *
     * "What score would one computer turn end with?"
     *
     * @return the final score of this simulated turn
     */
    public int simulateTurn()
    {
        /*
         * Temporary score for this simulated turn.
         *
         * Every simulation starts at 0.
         */
        int turnScore = 0;


        /*
         * TODO #13:
         *
         * Keep simulating rolls until the turn ends.
         *
         * You can use a while loop.
         *
         * The turn ends when:
         *
         * A. The die rolls a 1
         *
         * OR
         *
         * B. turnScore reaches at least 20
         *
         * You do NOT need a boolean if you structure your
         * while condition carefully.
         */


        /*
         * TODO #14:
         *
         * Inside the loop:
         *
         * 1. Roll the die.
         *
         * 2. If the roll is 1:
         *
         *       return 0;
         *
         *    This represents losing all temporary points.
         *
         * 3. Otherwise:
         *
         *       turnScore += roll;
         *
         * 4. Keep going until turnScore >= 20.
         */


        /*
         * TODO #15:
         *
         * Once turnScore reaches at least 20, return it.
         *
         * Example:
         *
         * Rolls: 4, 5, 6, 5
         *
         * Turn score:
         * 4
         * 9
         * 15
         * 20
         *
         * Return 20.
         *
         *
         * Another example:
         *
         * Rolls: 6, 6, 6, 6
         *
         * Turn score:
         * 6
         * 12
         * 18
         * 24
         *
         * Return 24.
         */
        return 0;   // TEMPORARY - replace with your actual logic
    }



    /**
     * Prints the results of the Monte Carlo simulation.
     *
     * @param results an array containing the number of times each
     *                possible turn score occurred
     *
     * @param numTurns the total number of simulated turns
     *
     * The probability is calculated using:
     *
     *     number of times score occurred
     *     --------------------------------
     *            total number of turns
     *
     * For example, if:
     *
     * results[20] = 99,990
     *
     * and:
     *
     * numTurns = 1,000,000
     *
     * then:
     *
     * probability = 99990 / 1000000
     *              = 0.09999
     */
    public void printStatistics(int[] results, int numTurns)
    {
        /*
         * Print the headings for the table.
         *
         * The sample output has:
         *
         * Estimated
         * Score Probability
         */
        System.out.println("\nEstimated");
        System.out.println("Score\tProbability");


        /*
         * TODO #16:
         *
         * Loop through the results array.
         *
         * You need to print:
         *
         * 0
         *
         * and then:
         *
         * 20
         * 21
         * 22
         * 23
         * 24
         * 25
         *
         * You probably do NOT want to print scores
         * 1 through 19 because those are not possible final
         * scores under the "hold at 20" strategy.
         *
         * HINT:
         *
         * You could use:
         *
         * System.out.println("0\t" + ...);
         *
         * and then a loop beginning at 20.
         */


        /*
         * TODO #17:
         *
         * Calculate the probability for each score.
         *
         * Formula:
         *
         * probability = results[score] / (double) numTurns
         *
         *
         * IMPORTANT:
         *
         * Use (double) somewhere!
         *
         * If you divide two ints, Java performs integer division.
         *
         * For example:
         *
         * 20 / 100 = 0
         *
         * But we need:
         *
         * 20 / 100 = 0.20
         *
         * Therefore:
         *
         * results[score] / (double) numTurns
         *
         * will give you a decimal probability.
         */


        /*
         * TODO #18:
         *
         * Format the probability so it looks like the sample.
         *
         * The sample has values such as:
         *
         * 0.62450
         * 0.09999
         * 0.09502
         *
         * Therefore, you should print approximately FIVE digits
         * after the decimal point.
         *
         * You can use printf if you know how.
         *
         * For example, the general idea is:
         *
         * System.out.printf("%d\t%.5f%n", score, probability);
         *
         * %d     -> integer
         * %.5f   -> decimal with 5 digits after the decimal
         * %n     -> new line
         */
    }



    /*
     * ============================================================
     * INTRODUCTION
     * ============================================================
     */

    /**
     * Prints the introduction to the game.
     *
     * This method was already provided in your starter PigGame.java.
     *
     * It only prints text, so:
     *
     * - it has no parameters
     * - it returns nothing
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
