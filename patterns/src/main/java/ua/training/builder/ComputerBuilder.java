package ua.training.builder;

/**
 * Created by Graffit on 27.11.2016.
 */
public abstract class ComputerBuilder {
    protected Computer computer;

    public Computer getComputer() {
        return computer;
    }

    public void createNewComputer() {
        computer = new Computer();
    }

    public abstract void buildSystemBlock();
    public abstract void buildDisplay();
    public abstract void buildManipulators();
}
