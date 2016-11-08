package ua.training;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Class which represents notebook
 *
 * @author Roman Prokopenko
 */
public class Notebook extends Date {
    private String fullName;
    private String phone;

    /**
     * Default constructor. Calls Date default constructor and sets
     * fullName and phone to default values
     */
    public Notebook() {
        super();
        this.fullName = "defaultName";
        this.phone = "000-000-00-00";
    }

    /**
     * Constructor with parameters
     *
     * @param fullName user's full name
     * @param phone    user's phone
     * @param date     user's birthday
     */
    public Notebook(String fullName, String phone, LocalDate date) {
        super(date);
        this.fullName = fullName;
        this.phone = phone;
    }

    /**
     * Calculates days to next birthday
     *
     * @return days to birthday
     */
    @Inspection
    public long daysToBirthDay() {
        LocalDate now = LocalDate.now();
        LocalDate birthday = LocalDate.of(now.getYear(), getDate().getMonth(), getDate().getDayOfMonth());

        if (birthday.isBefore(now)) {
            birthday = LocalDate.of(now.getYear() + 1, getDate().getMonth(), getDate().getDayOfMonth());
        }
        return ChronoUnit.DAYS.between(now, birthday);
    }

    @Inspection
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Inspection
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public int hashCode() {
        return ((this.fullName.hashCode() * 31) + this.phone.hashCode()) * 31 + super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null) {
            return false;
        } else if (obj instanceof Notebook) {
            Notebook newNotebook = (Notebook) obj;
            return this.fullName.equals(newNotebook.getFullName()) && this.phone.equals(newNotebook.getPhone()) &&
                    super.equals(obj);
        } else {
            return false;
        }
    }

    @Inspection
    @Override
    public String toString() {
        return "Notebook{" +
                "birthday=" + super.getDate().toString() + '\'' +
                "fullName='" + fullName + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
