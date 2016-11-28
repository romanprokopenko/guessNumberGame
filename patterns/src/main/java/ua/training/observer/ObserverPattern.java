package ua.training.observer;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Roman on 27.11.2016.
 */
public class ObserverPattern {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MeteoStation meteoStation = new MeteoStation();
        meteoStation.addObserver(new ConsoleObserver());
        meteoStation.addObserver(new FileObserver());
        meteoStation.setMeasurements(10,760);
        meteoStation.setMeasurements(15,760);
    }

}

interface Observed {
    void addObserver(Observer o);

    void remodeObserver(Observer o);

    void notifyObservers();
}

class MeteoStation implements Observed {
    int temperature;
    int pressure;

    public void setMeasurements(int temperature, int pressure) {
        this.temperature = temperature;
        this.pressure = pressure;
        notifyObservers();
    }

    List<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer o) {
        // TODO Auto-generated method stub
        observers.add(o);

    }

    @Override
    public void remodeObserver(Observer o) {
        // TODO Auto-generated method stub
        observers.remove(o);

    }

    @Override
    public void notifyObservers() {
        // TODO Auto-generated method stub
        for (Observer obs : observers) {
            obs.handleEvent(temperature, pressure);
        }
    }

}

interface Observer {

    void handleEvent(int temp, int pressure);
}

class ConsoleObserver implements Observer {

    @Override
    public void handleEvent(int temp, int pressure) {
        // TODO Auto-generated method stub
        System.out.println("weather changed, temperature = " + temp + ", preassure = " + pressure + ".");
    }

}

class FileObserver implements Observer{

    @Override
    public void handleEvent(int temp, int pressure) {
        File f;
        try {
            f = File.createTempFile("TempPreassure", "_txt");
            PrintWriter pw = new PrintWriter(f);
            pw.print("weather changed, temperature = " + temp + ", preassure = " + pressure + ".");
            pw.println();
            pw.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
