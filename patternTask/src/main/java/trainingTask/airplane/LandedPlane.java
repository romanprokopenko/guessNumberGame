package trainingTask.airplane;

/**
 * Created by Graffit on 16.12.2016.
 */
public class LandedPlane implements PlaneState{
    @Override
    public void fire() {
        System.out.println("plane is on ground");
    }
}
