package ua.training.builder;

/**
 * Created by Graffit on 27.11.2016.
 */
public class Director {
    private ComputerBuilder computerBuilder;

    public void setComputerBuilder(ComputerBuilder computerBuilder) {
        this.computerBuilder = computerBuilder;
    }

    public Computer getComputer() {
        return computerBuilder.getComputer();
    }

    public void constructComputer() {
        computerBuilder.createNewComputer();
        computerBuilder.buildSystemBlock();
        computerBuilder.buildDisplay();
        computerBuilder.buildManipulators();
    }
}
