package ua.training;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Class which controls the process of program work
 *
 * @author Roman Prokopenko
 */
public class Control {

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


    public void processUser() {
        Class clazz;
        Object instance;
        try {
            clazz = Class.forName("ua.training.Notebook");
            instance = clazz.newInstance();

            //invocation of annotated methods
            for (Method m : clazz.getMethods()) {
                Inspection inspection = m.getAnnotation(Inspection.class);
                if (inspection != null && inspection.inspect()) {
                    System.out.println(m.getName());
                    System.out.println(m.invoke(instance));
                }
            }

            System.out.println("==============================================");

            //list of constructors with parameters
            for (Constructor constructor : clazz.getConstructors()) {
                System.out.println("Constructor:" + constructor.getName());
                for (Class paramType : constructor.getParameterTypes()) {
                    System.out.println(paramType.getName());
                }
            }

            System.out.println("==============================================");

            //class modifiers
            int mods = clazz.getModifiers();
            if (Modifier.isPublic(mods)) {
                System.out.println("public");
            } else if (Modifier.isAbstract(mods)) {
                System.out.println("abstract");
            } else if (Modifier.isFinal(mods)) {
                System.out.println("final");
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }
}
