package trainingTask.airplane;

import trainingTask.airplane.gun.Gun;

/**
 * Created by Graffit on 16.12.2016.
 */
public class FlyingPlane implements PlaneState {
    private Gun gun;

    public FlyingPlane(Gun gun) {
        this.gun = gun;
    }

    @Override
    public void fire() {
        gun.makeShot();
    }
}
