package ua.training;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.Result;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Roman Prokopenko on 30.10.2016.
 */
public class GuessNumberGameModelTest {
    GuessNumberGameModel model;

    @Rule
    public final ExpectedException exp = ExpectedException.none();

    @Before
    public void initialize() {
        this.model = new GuessNumberGameModel();
    }

    @Test
    public void guessNumber() throws Exception {
        final int ITERATIONS = GuessNumberGameModel.RAND_MAX    ;

        //fill list with int values from 0 to ITERATIONS
        ArrayList<Integer> input = new ArrayList<>();
        for (int i = 0; i < ITERATIONS; i++) {
            input.add(i);
        }

        //count expected list of integers
        ArrayList<Integer> expected = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            expected.add(model.getSecretNumber() - input.get(i));
        }

        //get actual list of integers
        ArrayList<Integer> result = new ArrayList<>(expected.size());
        for (int i = 0; i < input.size(); i++) {
            result.add(model.guessNumber(input.get(i)));
        }
        Assert.assertArrayEquals(expected.toArray(), result.toArray());
    }

    @Test
    public void getRandomNumber() throws Exception {
        int min = -100;
        int max = 100;
        int result = model.getRandomNumber(min, max);
        Assert.assertTrue((min <= result) && (result <= max));
    }

    @Test
    public void getRandomNumberWrongInput() throws Exception {
        exp.expect(Exception.class);
        int min = -100;
        int max = 100;
        model.getRandomNumber(max, min);
    }

}