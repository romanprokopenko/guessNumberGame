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
     * Refererence to view part
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
        do {
            estimateNumber = inputIntValueWithScanner(scan);
            if (isInRange(estimateNumber)) {
                model.addStatisticsData(estimateNumber);                                        //after all validations we could add input to statistics
                int result = model.guessNumber(estimateNumber);
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
        view.printMessageAndStatistics(GuessNumberGameView.ATTEMPTS_MESSAGE, model.getStatistics());
    }

    /**
     * Reads data with scanner from InputStream. Requests data until integer is entered
     *
     * @param sc Scanner
     * @return integer value scanned from InputStream
     */
    public int inputIntValueWithScanner(Scanner sc) {
        view.printMessageAndRange(GuessNumberGameView.INPUT_NUMBER_MESSAGE,
                model.getMin(), model.getMax());
        while (!sc.hasNextInt()) {
            view.printMessage(GuessNumberGameView.WRONG_INPUT_MESSAGE
                    + " " + GuessNumberGameView.INPUT_NUMBER_MESSAGE);
            sc.next();
        }
        return sc.nextInt();
    }

    /**
     * Checks if number is in range
     *
     * @param number value to check
     * @return result of checking
     */
    public boolean isInRange(int number) {
        return (model.getMin() <= number) && (number <= model.getMax());
    }
}
