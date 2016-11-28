package ua.training.delegate;

/**
 * Created by Roman on 27.11.2016.
 */
public class Delegate {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Painter painter = new Painter();
        painter.setGraphic(new Triangle());
        painter.draw();

        painter.setGraphic(new Square());
        painter.draw();

        painter.setGraphic(new Circle());
        painter.draw();
    }

}

interface Graphic {
    void draw();
}

class Triangle implements Graphic {
    public void draw() {
        System.out.println("draw triangle");

    }

}

class Circle implements Graphic {
    public void draw() {
        System.out.println("draw circle");

    }

}

class Square implements Graphic {
    public void draw() {
        System.out.println("draw square");

    }

}

class Painter {

    Graphic g;

    void setGraphic(Graphic g) {
        this.g = g;
    }

    void draw() {
        g.draw();
    }
}
