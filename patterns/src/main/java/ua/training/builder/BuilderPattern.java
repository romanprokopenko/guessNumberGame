package ua.training.builder;

/**
 * Created by Roman on 27.11.2016.
 */
public class BuilderPattern {
    public static void main(String[] args) {
        Director director = new Director();
        ComputerBuilder cheapComputerBuilder = new CheapComputerBuilder();

        director.setComputerBuilder(cheapComputerBuilder);
        director.constructComputer();

        Computer computer = director.getComputer();
    }
}
