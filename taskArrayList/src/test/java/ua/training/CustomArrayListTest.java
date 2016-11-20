package ua.training;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Roman Prokopenko on 20.11.2016.
 */
public class CustomArrayListTest {
    private List<Integer> actualList;
    @Before
    public void init() {
        actualList = new CustomArrayList();
        actualList.add(1);
        actualList.add(2);
        actualList.add(3);
        actualList.add(4);
    }

    @Test
    public void size() throws Exception {
        Assert.assertEquals("4 elements", 4, actualList.size());
        actualList.remove(0);
        Assert.assertEquals("3 elements", 3, actualList.size());
        actualList.add(10);
        Assert.assertEquals("4 elements", 4, actualList.size());
    }

    @Test
    public void add() throws Exception {
        Integer[] expectedArray = new Integer[] {1, 2, 3, 4, 10};
        actualList.add(10);
        Assert.assertArrayEquals(expectedArray, actualList.toArray());
    }

    @Test
    public void get() throws Exception {
        Assert.assertEquals(new Integer(1), actualList.get(0));
    }

    @Test
    public void addToIndex() throws Exception {
        Integer[] expectedArray = new Integer[] {1, 2, 10, 3, 4};
        actualList.add(2, 10);
        Assert.assertArrayEquals(expectedArray, actualList.toArray());
    }

    @Test
    public void remove() throws Exception {
        Integer[] expectedArray = new Integer[] {1, 2, 3};
        actualList.remove(3);
        Assert.assertArrayEquals(expectedArray, actualList.toArray());
    }

}