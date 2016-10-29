package ua.training;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple GuessNumberGame.
 */
public class GuessNumberGameTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public GuessNumberGameTest(String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( GuessNumberGameTest.class );
    }

    /**
     * Rigourous GuessNumberGameControl :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}
