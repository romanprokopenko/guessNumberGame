package ua.training;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Roman Prokopenko on 14.12.2016.
 */
public class Manager extends Employee {
    private List<Worker> subordinates = new ArrayList<>();

    public Manager(String name, Date birthday, Date hireDate) {
        super(name, birthday, hireDate);
    }

    public Manager(String name, Date birthday, Date hireDate, List<Worker> subordinates) {
        super(name, birthday, hireDate);
        this.subordinates = subordinates;
    }

    public List<Worker> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(List<Worker> subordinates) {
        this.subordinates = subordinates;
    }

    public void addSubordinate(Worker worker) {
        this.subordinates.add(worker);
    }

    public void addSubordinate(List<Worker> workerList) {
        this.subordinates.addAll(workerList);
    }

    @Override
    public String toString() {
        return super.toString() + " + Manager{" +
                "subordinates=" + subordinates +
                '}';
    }
}
