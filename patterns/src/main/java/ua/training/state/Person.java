package ua.training.state;

/**
 * Created by Graffit on 12.12.2016.
 */
public class Person {
    PersonState state;

    public void setState(PersonState state) {
        this.state = state;
    }
}
