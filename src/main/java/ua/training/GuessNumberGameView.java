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
    public static final String WRONG_INPUT_MESSAGE = "INVALID NUMBER";
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
     * @param lowerBorder  lower range boundary
     * @param biggerBorder bigger range boundary
     */
    public void printMessageAndRange(String message, int lowerBorder, int biggerBorder) {
        System.out.println(message + RANGE_MESSAGE_FIRST_PART + lowerBorder
                + RANGE_MESSAGE_SECOND_PART + biggerBorder
                + RANGE_MESSAGE_THIRD_PART);
    }

    public void printMessageAndStatistics(String message, ArrayList statistics) {
        System.out.println(message + statistics.size());
        System.out.println(STATISTICS_MESSAGE);
        for (int i = 0; i < statistics.size(); i++) {
            System.out.println(statistics.get(i).toString());
        }
    }
}
