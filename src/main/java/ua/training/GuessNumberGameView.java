package ua.training;

import java.util.ArrayList;

/**
 * Class which used to interact with player
 *
 * @author Roman Prokopenko
 */
public class GuessNumberGameView {

    public static final String START_GAME_MESSAGE = "GREETINGS!";
    public static final String INPUT_NUMBER_MESSAGE = "Enter the number";
    public static final String WRONG_INPUT_MESSAGE = "INVALID NUMBER.";
    public static final String CANDIDATE_IS_SMALLER_MESSAGE = "your number is" +
            " smaller than secret number";
    public static final String CANDIDATE_IS_BIGGER_MESSAGE = "your number is" +
            " bigger than secret number";
    public static final String INPUT_IS_OUT_OF_RANGE_MESSAGE = "input is out" +
            " of range";
    public static final String VICTORY_MESSAGE = "CONGRATULATIONS! YOU" +
            " GUESSED RIGHT";
    public static final String ATTEMPTS_MESSAGE = "attempts used: ";
    public static final String RANGE_MESSAGE_FIRST_PART = "Secret number" +
            " is in range [ ";
    public static final String RANGE_MESSAGE_SECOND_PART = " , ";
    public static final String RANGE_MESSAGE_THIRD_PART = " ]";
    public static final String STATISTICS_MESSAGE = "moves made:";
    public static final String ENTER_LESSER_BOUNDARY_MESSAGE = "please," +
            " enter lesser boundary: ";
    public static final String ENTER_BIGGER_BOUNDARY_MESSAGE = "please," +
            " enter bigger boundary: ";
    public static final String BOUNDARIES_ERROR_MESSAGE = "difference" +
            " between bigger and lesser boundaries must be greater than 1";


    /**
     * Prints message to System.out
     *
     * @param message any string
     */
    public void printMessage(String message) {
        System.out.println(message);
    }

    /**
     * Prints combined message to System.out
     *
     * @param message      any string
     * @param lesserBorder  lesser range boundary
     * @param biggerBorder bigger range boundary
     */
    public void printMessageAndRange(String message, int lesserBorder, int biggerBorder) {
        System.out.println(message + RANGE_MESSAGE_FIRST_PART + lesserBorder
                + RANGE_MESSAGE_SECOND_PART + biggerBorder
                + RANGE_MESSAGE_THIRD_PART);
    }

    /**
     * Prints message plus number of tries and then outputs all valid tries
     *
     * @param message    any string
     * @param statistics ArrayList of tries
     */
    public void printMessageAndStatistics(String message, ArrayList statistics) {
        System.out.println(message + statistics.size());
        System.out.println(STATISTICS_MESSAGE);
        for (int i = 0; i < statistics.size(); i++) {
            System.out.println(statistics.get(i).toString());
        }
    }
}
