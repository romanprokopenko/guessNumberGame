package ua.training;

import java.util.Random;

/**
 * Created by Graffit on 29.10.2016.
 */
public class GuessNumberGameModel {

    private static final int RAND_MAX = 100;

    private int min = 0;
    private int max = 100;
    private int secretNumber;


    public GuessNumberGameModel() {
        secretNumber = getRandomNumber();
    }


    public int guessNumber(int checkedNumber) {
        if (isNumberEqualsSecret(checkedNumber)) {
            return 0;
        } else {
            int temp = secretNumber - checkedNumber;
            if (temp > 0) {
                min = checkedNumber + 1;
                return temp;
            }
            else {
                max = checkedNumber - 1;
                return temp;
            }
        }

    }


    public int getRandomNumber() {
        Random randomGenerator = new Random();
        return randomGenerator.nextInt(RAND_MAX + 1);
    }


    public int getRandomNumber(int min, int max) {
        Random randomGenerator = new Random();
        return randomGenerator.nextInt((max - min) + 1) + min;
    }


    public boolean isNumberEqualsSecret(int checkedNumber) {
        return checkedNumber == secretNumber;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }
}
