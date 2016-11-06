package ua.training;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.zip.DataFormatException;

import static org.junit.Assert.*;

/**
 * Created by Graffit on 06.11.2016.
 */
public class RecordTest {

    @Rule
    public final ExpectedException exp = ExpectedException.none();


    @Test
    public void setUserGroup() throws Exception {
        Record r = new Record();
        ArrayList<String> input = new ArrayList<>();
        input.add("WORK");
        input.add("FAMILY");
        input.add("STUDY");
        ArrayList<Group> expected = new ArrayList<>();
        expected.add(Group.WORK);
        expected.add(Group.FAMILY);
        expected.add(Group.STUDY);
        ArrayList<Group> actual = new ArrayList<>();
        for(int i = 0; i < input.size(); i++) {
            r.setUserGroup(input.get(i));
            actual.add(r.getUserGroup());
            Assert.assertTrue(expected.get(i) == r.getUserGroup());
        }
    }

    @Test
    public void getFullName() throws Exception {
        Record r = new Record();
        r.setName("Ivan");
        r.setSurname("Ivanov");
        Assert.assertEquals("Ivanov I.", r.getFullName());
    }

    @Test
    public void getFullAddress() throws Exception {
        Record r = new Record();
        String postcode = "00000";
        String city = "Kyiv";
        String street = "Lobanovskoho avenue";
        String houseNumber = "100";
        String apartmentNumber = "25";
        r.setPostcode(postcode);
        r.setCity(city);
        r.setStreet(street);
        r.setHouseNumber(houseNumber);
        r.setApartmentNumber(apartmentNumber);
        Assert.assertEquals(postcode + " " + city +" "+ street + " " +houseNumber +
                " " + apartmentNumber, r.getFullAddress());
    }

    @Test
    public void setRecordAddTime() throws Exception {
        exp.expect(DateTimeException.class);
        Record r = new Record();
        String falseDate = "33/13/0000";
        r.setRecordAddTime(falseDate);
    }

    @Test
    public void setRecordUpdateTime() throws Exception {
        exp.expect(DateTimeException.class);
        Record r = new Record();
        String falseDate = "33/13/0000";
        r.setRecordAddTime(falseDate);
    }

}