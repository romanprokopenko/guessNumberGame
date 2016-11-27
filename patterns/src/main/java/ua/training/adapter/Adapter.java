package ua.training.adapter;

/**
 * Created by Graffit on 27.11.2016.
 */
public class Adapter {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        VectorGraphicInterface g1 = new GraphicAdapter();
        VectorGraphicInterface g2 = new GraphicAdapter2(new RasterGraphics());
        g1.drawLine();
        g1.drawSquare();

        g2.drawLine();
        g2.drawSquare();
    }

}

interface VectorGraphicInterface {
    public void drawLine();

    public void drawSquare();
}

class RasterGraphics {
    void rasterGraphicsDrawLine() {
        System.out.println("draw a line");
    }

    void rasterGraphicsDrawSquare() {
        System.out.println("draw a square");
    }
}

class GraphicAdapter extends RasterGraphics implements VectorGraphicInterface {

    public void drawLine() {
        // TODO Auto-generated method stub
        rasterGraphicsDrawLine();

    }

    public void drawSquare() {
        // TODO Auto-generated method stub
        rasterGraphicsDrawSquare();

    }

}

class GraphicAdapter2 implements VectorGraphicInterface {
    RasterGraphics r = null;

    public GraphicAdapter2(RasterGraphics r) {
        this.r = r;
    }

    public void drawLine() {
        // TODO Auto-generated method stub
        r.rasterGraphicsDrawLine();

    }

    public void drawSquare() {
        // TODO Auto-generated method stub
        r.rasterGraphicsDrawSquare();

    }

}
