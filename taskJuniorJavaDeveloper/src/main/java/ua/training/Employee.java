package ua.training;

import java.util.Date;

/**
 * Created by Roman Prokopenko on 14.12.2016.
 */
public abstract class Employee {
    private String name;
    private Date birthday;
    private Date hireDate;
    private String descriptionHistory;

    public Employee(String name, Date birthday, Date hireDate) {
        this.name = name;
        this.birthday = birthday;
        this.hireDate = hireDate;
    }

    public Employee(String name, Date birthday, Date hireDate, String descriptionHistory) {
        this.name = name;
        this.birthday = birthday;
        this.hireDate = hireDate;
        this.descriptionHistory = descriptionHistory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public String getDescriptionHistory() {
        return descriptionHistory;
    }

    public void setDescriptionHistory(String descriptionHistory) {
        this.descriptionHistory = descriptionHistory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;

        Employee employee = (Employee) o;

        if (!name.equals(employee.name)) return false;
        if (!birthday.equals(employee.birthday)) return false;
        if (!hireDate.equals(employee.hireDate)) return false;
        return descriptionHistory != null ? descriptionHistory.equals(employee.descriptionHistory) :
                employee.descriptionHistory == null;

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + birthday.hashCode();
        result = 31 * result + hireDate.hashCode();
        result = 31 * result + (descriptionHistory != null ? descriptionHistory.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", hireDate=" + hireDate +
                ", descriptionHistory='" + descriptionHistory + '\'' +
                '}';
    }
}
