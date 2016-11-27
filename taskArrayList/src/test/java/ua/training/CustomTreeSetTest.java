package ua.training;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Graffit on 27.11.2016.
 */
public class CustomTreeSetTest {


    CustomTreeSet<Integer> tree;
    @Before
    public void init() {
        tree = new CustomTreeSet<>();
        tree.add(5);
        tree.add(2);
        tree.add(18);
        tree.add(1);
        tree.add(3);
    }

    @Test
    public void contains() throws Exception {
        Assert.assertEquals(tree.contains(5), true);
        Assert.assertEquals(tree.contains(-1), false);
    }

    @Test
    public void remove() throws Exception {
        tree.remove(5);
        Assert.assertEquals(tree.contains(5), false);
    }

}