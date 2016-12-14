package ua.training;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Roman Prokopenko on 14.12.2016.
 */
public class Personnel {
    private List<Employee> employees = new ArrayList<>();

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public boolean removeEmployee(Employee employee) {
        //if employee is worker we have to remove him from all managers subordinates lists
        if (employee instanceof Worker) {
            for (Employee manager :
                    employees) {
                if (manager instanceof Manager) {
                    ((Manager) manager).getSubordinates().remove(employee);
                }
            }
            return this.employees.remove(employee);
        } else if (employee instanceof Manager) {
            //if employee is manager all his subordinates are moved to another manager
            //if there are no such manager employee is not removed
            for (Employee subordinatesTargetManager :
                    employees) {
                if (subordinatesTargetManager instanceof Manager && !subordinatesTargetManager.equals(employee)) {
                    ((Manager) subordinatesTargetManager).addSubordinate(((Manager) employee).getSubordinates());
                    return this.employees.remove(employee);
                }
            }
            return false;
        } else {
            //in other cases just remove employee
            return this.employees.remove(employee);
        }
    }

    public Employee changeEmployeeType(Employee employee, EmployeeType targetType) {
        if (employee instanceof Worker) {
            switch (targetType) {
                case WORKER:
                    return employee;
                case MANAGER:
                    return new Manager(employee.getName(), employee.getBirthday(), employee.getHireDate());
                case OTHER:
                    return new Other(employee.getName(), employee.getBirthday(), employee.getHireDate(), employee.getDescriptionHistory());
            }
        } else if (employee instanceof Manager) {
            return changeManagerType((Manager) employee, targetType);
        } else if (employee instanceof Other) {
            return changeOtherType((Other) employee, targetType);
        }
        return null;
    }

    private Employee changeOtherType(Other other, EmployeeType employeeType) {
        Employee employee = other;
        switch (employeeType) {
            case WORKER:
                employee = new Worker(other.getName(), other.getBirthday(), other.getHireDate());
                break;
            case MANAGER:
                employee = new Manager(other.getName(), other.getBirthday(), other.getHireDate());
                break;
        }
        employee.setDescriptionHistory(other.getDescription());
        return employee;
    }

    private Employee changeManagerType(Manager manager, EmployeeType employeeType) {
        if (employeeType == EmployeeType.MANAGER) {
            return manager;
        }
        for (Employee subordinatesTargetManager :
                employees) {
            if (subordinatesTargetManager instanceof Manager && !subordinatesTargetManager.equals(manager)) {
                ((Manager) subordinatesTargetManager).addSubordinate(manager.getSubordinates());
                if (employeeType == EmployeeType.WORKER) {
                    return new Worker(manager.getName(), manager.getBirthday(), manager.getHireDate());
                } else if (employeeType == EmployeeType.OTHER) {
                    return new Other(manager.getName(), manager.getBirthday(), manager.getHireDate(), manager.getDescriptionHistory());
                }
            }
        }
        return null;
    }


}

enum EmployeeType {
    WORKER, MANAGER, OTHER
}
