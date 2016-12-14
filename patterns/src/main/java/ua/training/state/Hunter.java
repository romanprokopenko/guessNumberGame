package ua.training.state;

/**
 * Created by Graffit on 12.12.2016.
 */
public class Hunter implements PersonState {
    @Override
    public void doTask() {
        System.out.println("i hunt animals");
    }
}
