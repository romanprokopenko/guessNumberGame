package trainingTask.airplane;

/**
 * Created by Graffit on 16.12.2016.
 */
public class Airplane {
    private PlaneState state;

    public Airplane(PlaneState state) {
        this.state = state;
    }

    public PlaneState getState() {
        return state;
    }

    public void setState(PlaneState state) {
        this.state = state;
    }

    public void shoot() {
        state.fire();
    }
}
