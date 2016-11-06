package ua.training;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Class which controls the process of game and where game-loop runs
 *
 * @author Roman Prokopenko
 */
public class GuessNumberGameControl {
    private final static InputStream INPUT = System.in;

    /**
     * Reference to model part
     *
     * @see GuessNumberGameModel
     */
    private GuessNumberGameModel model;

    /**
     * Reference to view part
     *
     * @see GuessNumberGameView
     */
    private GuessNumberGameView view;

    /**
     * Constructor which binds model and view with controller
     *
     * @param model reference to model
     * @param view  reference to view
     */
    public GuessNumberGameControl(GuessNumberGameModel model, GuessNumberGameView view) {
        this.model = model;
        this.view = view;
    }

    /**
     * Main game-loop. Checks if estimate number is in range
     */
    public void startGame() {
        Scanner scan = new Scanner(INPUT);
        int estimateNumber = 0;

        view.printMessage(GuessNumberGameView.START_GAME_MESSAGE);
        initializeRange(scan);

        /*this loop handles guessed numbers input and statistics gathering*/
        do {
            view.printMessageAndRange(GuessNumberGameView.INPUT_NUMBER_MESSAGE,
                    model.getMin(), model.getMax());
            estimateNumber = inputIntValueWithScanner(scan);
            if (model.isInRange(estimateNumber)) {

                /*after all validations we could add input to statistics*/
                model.addStatisticsData(estimateNumber);
                int result = model.guessNumber(estimateNumber);

                /*to output lesser/bigger message we have to check results of guessNumber(int)*/
                if (result > 0) {
                    view.printMessage(GuessNumberGameView.CANDIDATE_IS_SMALLER_MESSAGE);
                } else if (result < 0) {
                    view.printMessage(GuessNumberGameView.CANDIDATE_IS_BIGGER_MESSAGE);
                }
            } else {
                view.printMessage(GuessNumberGameView.INPUT_IS_OUT_OF_RANGE_MESSAGE);
            }
        } while (!model.isNumberEqualsSecret(estimateNumber));
        view.printMessage(GuessNumberGameView.VICTORY_MESSAGE);
        view.printMessageAndStatistics(GuessNumberGameView.ATTEMPTS_MESSAGE, model.getStatistics());    //statistics output
    }

    /**
     * Sets values of range boundaries using {@link GuessNumberGameControl#inputIntValueWithScanner}
     * if values are entered incorrectly - repeats
     *
     * @param scan Scanner
     */
    private void initializeRange(Scanner scan) {
        int min;
        int max;

        /*in this loop user have to input the secret number generation range*/
        do {
            view.printMessage(GuessNumberGameView.ENTER_LESSER_BOUNDARY_MESSAGE);
            min = inputIntValueWithScanner(scan);
            view.printMessage(GuessNumberGameView.ENTER_BIGGER_BOUNDARY_MESSAGE);
            max = inputIntValueWithScanner(scan);
        } while (!isLesser(min, max));

        /*after boundaries input new model with same parameters is created*/
        this.model = new GuessNumberGameModel(min, max);
    }

    /**
     * Checks if max greater than min and their difference is greater than 1 . If so returns true else
     * prints error message and returns false
     *
     * @param min lesser number
     * @param max bigger number
     * @return comparision result
     */
    public boolean isLesser(int min, int max) {
        if ((max - min) > 1) {
            return true;
        } else {
            view.printMessage(GuessNumberGameView.BOUNDARIES_ERROR_MESSAGE);
            return false;
        }
    }

    /**
     * Reads data with scanner from InputStream. Requests data until integer is entered
     *
     * @param sc Scanner
     * @return integer value scanned from InputStream
     */
    public int inputIntValueWithScanner(Scanner sc) {
        while (!sc.hasNextInt()) {
            view.printMessage(GuessNumberGameView.WRONG_INPUT_MESSAGE
                    + GuessNumberGameView.INPUT_NUMBER_MESSAGE);
            sc.next();
        }
        return sc.nextInt();
    }

}
