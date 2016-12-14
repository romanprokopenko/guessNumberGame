package ua.training.state;

/**
 * Created by Graffit on 12.12.2016.
 */
public class Mushroomer implements PersonState {
    @Override
    public void doTask() {
        System.out.println("i collect the mushrooms");
    }
}
