import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {
    SILab2 lab = new SILab2();
    @Test
    void MultipleCondition()
    {
        List<Time> timeList = new LinkedList<>();
        timeList.add(new Time(-2, 0, 0));
        RuntimeException ex = null;
        try
        {
            lab.function(timeList);
        }
        catch (RuntimeException e)
        {
            ex = e;
        }
        assertNotNull(ex);
        assertTrue(ex.getMessage().contains("The hours are smaller than the minimum"));

        timeList = new LinkedList<>();
        timeList.add(new Time(25, 61, 61));
        ex = null;
        try
        {
            lab.function(timeList);
        }
        catch (RuntimeException e)
        {
            ex = e;
        }
        assertNotNull(ex);
        assertTrue(ex.getMessage().contains("The hours are grater than the maximum"));

        timeList = new LinkedList<>();
        timeList.add(new Time(2, -1, -1));
        ex = null;
        try
        {
            lab.function(timeList);
        }
        catch (RuntimeException e)
        {
            ex = e;
        }
        assertNotNull(ex);
        assertTrue(ex.getMessage().contains("The minutes are not valid!"));

        timeList = new LinkedList<>();
        timeList.add(new Time(2, 1, -1));
        ex = null;
        try
        {
            lab.function(timeList);
        }
        catch (RuntimeException e)
        {
            ex = e;
        }
        assertNotNull(ex);
        assertTrue(ex.getMessage().contains("The seconds are not valid"));

        timeList = new LinkedList<>();
        timeList.add(new Time(2, 1, 1));
        List<Integer> result = new ArrayList<>();
        result.add(2 * 3600 + 1 * 60 + 1);
        assertEquals(result, lab.function(timeList));

        timeList = new LinkedList<>();
        timeList.add(new Time(24, 1, 1));
        ex = null;
        try
        {
            lab.function(timeList);
        }
        catch (RuntimeException e)
        {
            ex = e;
        }
        assertNotNull(ex);
        assertTrue(ex.getMessage().contains("The time is greater than the maximum"));

        timeList = new LinkedList<>();
        timeList.add(new Time(24, 0, 0));
        result = new ArrayList<>();
        result.add(24 * 3600 + 0 * 60 + 0);
        assertEquals(result, lab.function(timeList));
    }

    @Test
    void EveryBranch()
    {
        List<Time> timeList = new LinkedList<>();
        timeList.add(new Time(24, 0, 0));
        List<Integer> result = new ArrayList<>();
        result.add(24 * 3600 + 0 * 60 + 0);
        assertEquals(result, lab.function(timeList));

        timeList = new LinkedList<>();
        timeList.add(new Time(24, 59, 1));
        RuntimeException ex = null;
        try
        {
            lab.function(timeList);
        }
        catch (RuntimeException e)
        {
            ex = e;
        }
        assertNotNull(ex);
        assertTrue(ex.getMessage().contains("The time is greater than the maximum"));

        timeList = new LinkedList<>();
        timeList.add(new Time(2, 61, -1));
        ex = null;
        try
        {
            lab.function(timeList);
        }
        catch (RuntimeException e)
        {
            ex = e;
        }
        assertNotNull(ex);
        assertTrue(ex.getMessage().contains("The minutes are not valid!"));

        timeList = new LinkedList<>();
        timeList.add(new Time(2, 30, 61));
        ex = null;
        try
        {
            lab.function(timeList);
        }
        catch (RuntimeException e)
        {
            ex = e;
        }
        assertNotNull(ex);
        assertTrue(ex.getMessage().contains("The seconds are not valid"));

        timeList = new LinkedList<>();
        timeList.add(new Time(2, 30, 25));
        result = new ArrayList<>();
        result.add(2 * 3600 + 30 * 60 + 25);
        assertEquals(result, lab.function(timeList));

        timeList = new LinkedList<>();
        timeList.add(new Time(-1, 0, 0));
        ex = null;
        try
        {
            lab.function(timeList);
        }
        catch (RuntimeException e)
        {
            ex = e;
        }
        assertNotNull(ex);
        assertTrue(ex.getMessage().contains("The hours are smaller than the minimum"));

        timeList = new LinkedList<>();
        timeList.add(new Time(25, 0, 0));
        ex = null;
        try
        {
            lab.function(timeList);
        }
        catch (RuntimeException e)
        {
            ex = e;
        }
        assertNotNull(ex);
        assertTrue(ex.getMessage().contains("The hours are grater than the maximum"));
    }
}