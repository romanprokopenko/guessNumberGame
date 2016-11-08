package ua.training;

import java.time.LocalDate;

/**
 * Class which represents date
 *
 * @author Roman Prokopenko
 */
public class Date {
    private LocalDate date;

    /**
     * Default constructor. Sets date as current date.
     */
    public Date() {
        this.date = LocalDate.now();
    }

    /**
     * Sets date as new LocalDate instance
     *
     * @param date LocalDate instance
     */
    public Date(LocalDate date) {
        this.date = date;
    }

    @Inspection
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Inspection(inspect = false)
    @Override
    public int hashCode() {
        return date != null ? date.hashCode() : 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null) {
            return false;
        } else if (obj instanceof Date) {
            Date newDate = (Date) obj;
            return this.date.equals(newDate.getDate());
        } else {
            return false;
        }
    }

    @Inspection(inspect = true)
    @Override
    public String toString() {
        return "Date{" +
                "date=" + date.toString() +
                '}';
    }
}

