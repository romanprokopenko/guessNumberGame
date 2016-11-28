package ua.training.composite;

import java.util.ArrayList;

/**
 * Created by Roman on 27.11.2016.
 */
public class CompositePattern {
    public static void main(String[] args) {

        Shape square1 = new Square();
        Shape square2 = new Square();
        Shape triangle1 = new Triangle();

        Shape square3 = new Square();
        Shape circle1 = new Circle();
        Shape circle2 = new Circle();
        Shape circle3 = new Circle();

        Composite composite = new Composite();
        Composite composite1 = new Composite();
        Composite composite2 = new Composite();

        composite1.addComposite(square1);
        composite1.addComposite(square2);
        composite1.addComposite(triangle1);


        composite2.addComposite(square3);
        composite2.addComposite(circle1);
        composite2.addComposite(circle2);
        composite2.addComposite(circle3);
        //composite1.addComposite(composite2);


        composite.addComposite(composite1);
        composite.addComposite(composite2);
        composite.addComposite(triangle1);

        composite.draw();
    }
}

interface Shape {
    void draw();
}

class Square implements Shape {

    public void draw() {
        // TODO Auto-generated method stub
        System.out.println("Square");
    }

}

class Triangle implements Shape {

    public void draw() {
        // TODO Auto-generated method stub
        System.out.println("Triangle");
    }

}

class Circle implements Shape {

    public void draw() {
        // TODO Auto-generated method stub
        System.out.println("Circle");
    }

}

class Composite implements Shape {
    ArrayList<Shape> components = new ArrayList<>();

    public void addComposite(Shape component) {
        components.add(component);
    }

    public void removeComposite(Shape component) {
        components.remove(component);
    }

    public void draw() {
        // TODO Auto-generated method stub
        for (Shape component : components) {
            component.draw();
        }
    }
}
