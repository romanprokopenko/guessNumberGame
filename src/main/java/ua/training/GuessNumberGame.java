package ua.training;

/**
 * Hello world!
 *
 */
public class GuessNumberGame
{
    public static void main( String[] args ) {

        //initialization
        GuessNumberGameView view = new GuessNumberGameView();
        GuessNumberGameModel model = new GuessNumberGameModel();
        GuessNumberGameControl control = new GuessNumberGameControl(model, view);

        //run
        control.startGame();
    }
}
