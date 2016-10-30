package ua.training;

import java.util.ArrayList;
import java.util.Random;

/**
 * Class which used for game-logic purposes
 *
 * @author Roman Prokopenko
 */
public class GuessNumberGameModel {

    /**
     * Defines what is the biggest range boundary
     */
    public static final int RAND_MAX = 100;

    /**
     * Stores user's input
     */
    private ArrayList<Integer> statistics = new ArrayList<>();

    /**
     * The number that is user have to guess
     */
    private final int secretNumber;

    //current lower boundary
    private int min = 0;

    //current bigger boundary
    private int max = 100;

    /**
     * Default constructor.
     */
    public GuessNumberGameModel() {
        secretNumber = getRandomNumber();
    }

    /**
     * Method checks if the number is correct or not.
     *
     * @param checkedNumber number that needs to be checked
     * @return If checkedNumber is correct method returns 0, if bigger than
     * {@link GuessNumberGameModel#secretNumber} it returns
     * integer lower than zero, if lower returns value bigger than zero
     */
    public int guessNumber(int checkedNumber) {
        int temp = getSecretNumber() - checkedNumber;
        if (temp > 0) {
            min = checkedNumber + 1;
        } else if (temp < 0) {
            max = checkedNumber - 1;
        }
        return temp;
    }

    /**
     * @return integer value from 0 to
     * {@link GuessNumberGameModel#RAND_MAX} inclusive
     */
    public int getRandomNumber() {
        Random randomGenerator = new Random();
        return randomGenerator.nextInt(RAND_MAX + 1);
    }

    /**
     * @param min lower range boundary
     * @param max bigger range boundary
     * @return integer FROM min to max inclusive
     */
    public int getRandomNumber(int min, int max) {
        Random randomGenerator = new Random();
        return randomGenerator.nextInt((max - min) + 1) + min;
    }

    public boolean isNumberEqualsSecret(int checkedNumber) {
        return checkedNumber == getSecretNumber();
    }

    public void addStatisticsData(int input) {
        getStatistics().add(input);
    }

    public ArrayList<Integer> getStatistics() {
        return statistics;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public int getSecretNumber() {
        return secretNumber;
    }
}

