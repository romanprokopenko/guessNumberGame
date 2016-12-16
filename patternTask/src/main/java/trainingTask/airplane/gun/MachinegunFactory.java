package trainingTask.airplane.gun;

/**
 * Created by Graffit on 16.12.2016.
 */
public class MachinegunFactory implements GunFactory {
    @Override
    public Gun makeGun(int bullets) {
        return new Machinegun(bullets);
    }
}
