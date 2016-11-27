package ua.training.factoryMethod;

import java.util.Date;

/**
 * Created by Graffit on 27.11.2016.
 */
public class FactoryMethod {
    public static void main(String[] args) {
        WatchMaker maker = new DigitalWatchMaker();
        Watch watch = maker.createWatch();
        watch.showTime();
    }

    interface Watch {
        void showTime();
    }

    static class DigitalWatch implements Watch {
        @Override
        public void showTime() {
            System.out.println(new Date());
        }
    }

    class RomeWatch implements Watch {
        @Override
        public void showTime() {
            System.out.println("VII-XX");
        }
    }

    interface WatchMaker {
        Watch createWatch();
    }

    static class DigitalWatchMaker implements WatchMaker {
        @Override
        public Watch createWatch() {
            return new DigitalWatch();
        }
    }

    class RomeWatchMaker implements WatchMaker {
        @Override
        public Watch createWatch() {
            return new RomeWatch();
        }
    }
}
