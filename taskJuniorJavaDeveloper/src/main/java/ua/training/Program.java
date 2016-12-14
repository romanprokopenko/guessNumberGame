package ua.training;

import java.util.Date;

/**
 * Created by Roman Prokopenko on 14.12.2016.
 */
public class Program {
    public static void main(String[] args) {
        Personnel personnel = new Personnel();

        Worker worker1 = new Worker("Ivan", new Date(), new Date());
        Worker worker2 = new Worker("John", new Date(), new Date());

        Manager manager1 = new Manager("Bob", new Date(), new Date());
        manager1.addSubordinate(worker1);
        manager1.addSubordinate(worker2);

        Manager manager2 = new Manager("Rick",new Date(), new Date());

        Other director1 = new Other("Donald",new Date(), new Date(),"executive director");

        personnel.addEmployee(worker1);
        personnel.addEmployee(worker2);
        personnel.addEmployee(manager1);
        personnel.addEmployee(manager2);
        personnel.addEmployee(director1);

        System.out.println(personnel.getEmployees().toString());

        personnel.removeEmployee(worker1);
        System.out.println(personnel.getEmployees().toString());

        personnel.removeEmployee(manager1);
        System.out.println(personnel.getEmployees().toString());

        Employee test = personnel.changeEmployeeType(director1, EmployeeType.WORKER);
        System.out.println(test);
        System.out.println(personnel.changeEmployeeType(test, EmployeeType.OTHER));
    }
}
