package ua.training;

import java.io.InputStream;

/**
 * Class which controls the process of program work
 *
 * @author Roman Prokopenko
 */
public class Control {
    private final static InputStream INPUT = System.in;

    /**
     * Reference to model part
     *
     * @see Model
     */
    private Model model;

    /**
     * Reference to view part
     *
     * @see View
     */
    private View view;

    /**
     * Constructor which binds model and view with controller
     *
     * @param model reference to model
     * @param view  reference to view
     */
    public Control(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    /**
     * Creates new {@link RecordControl} and puts {@link Record}
     * to Model.
     */
    public void processUser() {
        RecordControl recordControl = new RecordControl(INPUT, view);
        model.addRecord(recordControl.getInput());
        for (Record r : model.getRecordsList()) {
            view.printMessage(r.toString());
        }
    }
}
