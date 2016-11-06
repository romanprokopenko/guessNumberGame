/*
 *
 *
 */

package ua.training;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


import java.io.ByteArrayInputStream;
import java.util.Scanner;


/**
 * Created by Roman Prokopenko on 30.10.2016.
 */
public class GuessNumberGameControlTest {

    private GuessNumberGameControl control;
    private GuessNumberGameModel model;
    private GuessNumberGameView view;

    @Rule
    public final ExpectedException exp = ExpectedException.none();

    @Before
    public void initialize() {
        this.model = new GuessNumberGameModel();
        this.view = new GuessNumberGameView();
        this.control = new GuessNumberGameControl(model, view);
    }

    @Test
    public void startGameTest() {
        exp.expect(NullPointerException.class);
        this.control = new GuessNumberGameControl(null, null);
        control.startGame();
    }

    @Test
    public void inputIntValueWithScannerNullScanner() throws Exception {
        exp.expect(NullPointerException.class);
        Scanner scan = null;
        control.inputIntValueWithScanner(scan);
    }

    @Test
    public void inputIntValueWithScanner() {
        Integer expected = 50;
        String input = expected.toString();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        Scanner scan = new Scanner(inputStream);
        Integer result = control.inputIntValueWithScanner(scan);
        Assert.assertEquals(expected, result);
    }

}