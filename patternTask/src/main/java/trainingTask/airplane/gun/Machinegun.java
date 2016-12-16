package trainingTask.airplane.gun;

/**
 * Created by Graffit on 16.12.2016.
 */
public class Machinegun implements Gun {

    private int bullets;

    public Machinegun(int bullets) {
        this.bullets = bullets;
    }

    public int getBullets() {
        return bullets;
    }

    public void setBullets(int bullets) {
        this.bullets = bullets;
    }

    @Override
    public void makeShot() {
        if (bullets > 0) {
            bullets--;
            System.out.println("machinegun made shot");
        } else {
            System.out.println("machinegun has no bullets");
        }
    }
}
