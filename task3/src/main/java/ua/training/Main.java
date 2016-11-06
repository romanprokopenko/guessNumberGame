package ua.training;

/**
 * Class represents main game-class where the game runs
 *
 * @author Roman Prokopenko
 */
public class GuessNumberGame {
    public static void main(String[] args) {

        //initialization of components
        GuessNumberGameView view = new GuessNumberGameView();
        GuessNumberGameModel model = new GuessNumberGameModel();
        GuessNumberGameControl control = new GuessNumberGameControl(model, view);

        //run
        control.startGame();
    }
}
