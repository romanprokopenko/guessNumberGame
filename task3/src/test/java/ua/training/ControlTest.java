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
 * Created by Roman Prokopenko on 06.11.2016.
 */
public class ControlTest {

    private Control control;
    private Model model;
    private View view;

    @Rule
    public final ExpectedException exp = ExpectedException.none();

    @Before
    public void initialize() {
        this.model = new Model();
        this.view = new View();
        this.control = new Control(model, view);
    }

    @Test
    public void processUserTest() {
        exp.expect(NullPointerException.class);
        this.control = new Control(null, null);
        control.processUser();
    }



}