package ua.training;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Created by Graffit on 28.10.2016.
 */
public class GuessNumberGameControl {
    private final static InputStream INPUT = System.in;

    private GuessNumberGameModel model;
    private GuessNumberGameView view;

    //constructor
    public GuessNumberGameControl(GuessNumberGameModel model, GuessNumberGameView view) {
        this.model = model;
        this.view = view;
    }

    public void startGame() {
        Scanner scan = new Scanner(INPUT);
        int estimateNumber;
        view.printMessage(GuessNumberGameView.START_GAME_MESSAGE);
        do {
            estimateNumber = inputIntValueWithScanner(scan);
            if ((model.getMin() <= estimateNumber) && (estimateNumber <= model.getMax())) {
                int result = model.guessNumber(estimateNumber);
                if (result > 0) {
                    view.printMessage(GuessNumberGameView.CANDIDATE_IS_SMALLER_MESSAGE);
                }
                if (result < 0) {
                    view.printMessage(GuessNumberGameView.CANDIDATE_IS_BIGGER_MESSAGE);
                }
            } else {
                view.printMessage(GuessNumberGameView.INPUT_IS_OUT_OF_RANGE_MESSAGE);
            }
        } while (!model.checkCorrectness(estimateNumber));
        view.printMessage(GuessNumberGameView.VICTORY_MESSAGE);
    }

    public int inputIntValueWithScanner(Scanner sc) {
        view.printMessageAndRange(GuessNumberGameView.INPUT_NUMBER_MESSAGE, model.getMin(), model.getMax());
        while( ! sc.hasNextInt()) {
            view.printMessage(GuessNumberGameView.WRONG_INPUT_MESSAGE + " " + GuessNumberGameView.INPUT_NUMBER_MESSAGE);
            sc.next();
        }
        return sc.nextInt();
    }
}
