package com.mycompany.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.stream.Stream;

/**
 * Unit test for simple StringManipulator.
 */
public class StringManipulatorTest
    extends TestCase
{

    public StringManipulatorTest(String testName )
    {
        super( testName );
    }


    public static Test suite()
    {
        return new TestSuite( StringManipulatorTest.class );
    }


    public void testHasUniqueChars()
    {

        assertTrue(StringManipulator.hasUniqueChars("RED"));
        assertFalse(StringManipulator.hasUniqueChars("APPLE"));
        assertTrue(StringManipulator.hasUniqueChars("BLUE"));
        assertTrue(StringManipulator.hasUniqueChars("COMPUTER"));

    }

    public void testGetWeight()
    {
        assertEquals(StringManipulator.getWeight("RED"), 73.0f);
        assertEquals(StringManipulator.getWeight("APPLE"), 74.0f);
        assertEquals(StringManipulator.getWeight("BLUE"), 74.0f);
        assertEquals(StringManipulator.getWeight("COMPUTER"), 77.875f);

    }

    public void testSortStrings()
    {
        String[] inputWords = {"APPLE", "BLUE", "COMPUTER", "RED"};
        String[] expected = {"RED", "APPLE", "BLUE", "COMPUTER"};
        String[] sortedWords = StringManipulator.sortStrings(inputWords);
        for (int i = 0; i < sortedWords.length; i++) {

            assertEquals(sortedWords[i], expected[i]);
        }

    }


}
