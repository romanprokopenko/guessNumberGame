package ua.training.builder;

/**
 * Created by Graffit on 27.11.2016.
 */
public class CheapComputerBuilder extends ComputerBuilder {
    public void buildSystemBlock() {
        computer.setSystemBlock("Everest");
    }
    public void buildDisplay() {
        computer.setDisplay("CRT");
    }
    public void buildManipulators() {
        computer.setManipulators("mouse+keyboard");
    }
}
