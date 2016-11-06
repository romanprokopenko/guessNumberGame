package ua.training;

import java.util.ArrayList;

/**
 * Class which used for business-logic purposes
 *
 * @author Roman Prokopenko
 */
public class Model {

    /**
     * Stores records
     */
    private ArrayList<Record> recordsList = new ArrayList<>();

    /**
     * Adds a record to records list
     *
     * @param record new record to add
     */
    public void addRecord(Record record) {
        recordsList.add(record);
    }

    public ArrayList<Record> getRecordsList() {
        return recordsList;
    }

    public void setRecordsList(ArrayList<Record> recordsList) {
        this.recordsList = recordsList;
    }
}

