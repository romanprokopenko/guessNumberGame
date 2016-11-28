package ua.training.facade;

/**
 * Created by Roman on 27.11.2016.
 */
public class Facade {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Computer computer = new Computer();
        computer.copy();
    }

}

// facade
class Computer {
    Power power = new Power();
    DVDRom dvd = new DVDRom();
    HDD hdd = new HDD();

    void copy() {
        power.on();
        dvd.load();
        hdd.copyFromDVD(dvd);
    }
}

class Power {
    void on() {
        System.out.println("turn on");
    }

    void off() {
        System.out.println("turn off");
    }
}

class DVDRom {
    private boolean data = false;

    public boolean hasData() {
        return data;
    }

    public void load() {
        data = true;
    }

    public void unload() {
        data = false;
    }
}

class HDD {
    void copyFromDVD(DVDRom dvdRom) {
        if (dvdRom.hasData()) {
            System.out.println("copy data from dvd");
        } else {
            System.out.println("put in dvd with data");
        }

    }
}
