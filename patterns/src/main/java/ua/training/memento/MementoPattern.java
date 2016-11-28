package ua.training.memento;

/**
 * Created by Roman on 28.11.2016.
 */
public class MementoPattern {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Game game = new Game();
        game.set("1", 30000);
        System.out.println(game.toString());

        File file = new File();
        file.setSave(game.save());
        
        game.set("2", 50000);
        System.out.println(game.toString());

        game.load(file.getSave());
        System.out.println(game.toString());


    }

}

class Game {
    private String lvl;
    private int ms;

    public void set(String lvl, int ms) {
        this.lvl = lvl;
        this.ms = ms;
    }

    public void load(Save save) {
        lvl = save.getLvl();
        ms = save.getMs();
    }

    public Save save() {
        return new Save(lvl, ms);
    }

    @Override
    public String toString() {
        return "Game [lvl=" + lvl + ", ms=" + ms + "]";
    }
}

class Save {
    private final String lvl;
    private final int ms;

    public Save(String lvl, int ms) {
        this.lvl = lvl;
        this.ms = ms;
    }

    public String getLvl() {
        return lvl;
    }

    public int getMs() {
        return ms;
    }

}

class File {
    Save save;

    public Save getSave() {
        return save;
    }

    public void setSave(Save save) {
        this.save = save;
    }

}
