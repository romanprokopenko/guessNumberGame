package trainingTask;

import trainingTask.airplane.Airplane;
import trainingTask.airplane.FlyingPlane;
import trainingTask.airplane.LandedPlane;
import trainingTask.airplane.PlaneState;
import trainingTask.airplane.gun.GunFactory;
import trainingTask.airplane.gun.MachinegunFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        GunFactory gunFactory = new MachinegunFactory();
        PlaneState state = new FlyingPlane(gunFactory.makeGun(5));
        Airplane plane = new Airplane(state);
        plane.shoot();
        plane.shoot();
        plane.shoot();
        plane.shoot();
        plane.shoot();
        plane.shoot();
        plane.setState(new LandedPlane());
        plane.shoot();
    }
}
