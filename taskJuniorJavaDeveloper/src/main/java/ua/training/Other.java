package ua.training;

import java.util.Date;

/**
 * Created by Roman Prokopenko on 14.12.2016.
 */
public class Other extends Employee {
    private String description;

    public Other(String name, Date birthday, Date hireDate, String description) {
        super(name, birthday, hireDate);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return super.toString() + " + Other{" +
                "description='" + description + '\'' +
                '}';
    }
}
