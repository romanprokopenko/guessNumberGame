package ua.training;

/**
 * Created by Graffit on 29.10.2016.
 */
public class GuessNumberGameView {

    public static final String START_GAME_MESSAGE = "GREETINGS!";
    public static final String INPUT_NUMBER_MESSAGE = "Enter the number";
    public static final String WRONG_INPUT_MESSAGE = "INVALID NUMBER";
    public static final String CANDIDATE_IS_SMALLER_MESSAGE = "your number is smaller than secret number";
    public static final String CANDIDATE_IS_BIGGER_MESSAGE = "your number is bigger than secret number";
    public static final String INPUT_IS_OUT_OF_RANGE_MESSAGE = "input is out of range";
    public static final String VICTORY_MESSAGE = "CONGRATULATIONS! YOU GUESSED RIGHT";

    private static final String RANGE_MESSAGE = "Secret number is in range [ {0} , {1} ]";


    public void printMessage(String message) {
        System.out.println(message);
    }


    public void printMessageAndRange(String message, int lowerBorder, int biggerBorder) {
        System.out.println(message+"."+formRange(lowerBorder, biggerBorder)); // Secret number is in range [" + lowerBorder + "," + biggerBorder + "]"
    }


    private String formRange(Integer lowerBorder, Integer biggerBorder) {
        String firstSequence = "{0}";
        String secondSequence = "{1}";
        return RANGE_MESSAGE.replace(firstSequence, lowerBorder.toString())
                                    .replace(secondSequence, biggerBorder.toString());
        //return resultString;
    }
}
