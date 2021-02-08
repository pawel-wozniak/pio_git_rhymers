package edu.kis.vh.nursery;

import org.junit.Assert;
import org.junit.Test;
import java.lang.reflect.Field;
import static org.junit.Assert.fail;

public class FIFORhymerTest {

    @Test
    public void testCountOut() {
        FIFORhymer rhymer = new FIFORhymer();
        int emptyStackValue = 0;
        try {
            Field maxSize = FIFORhymer.class.getSuperclass().getDeclaredField("EMPTY_INDEX");
            maxSize.setAccessible(true);
            emptyStackValue = maxSize.getInt(rhymer);
        } catch (Exception e) {
            fail("testCountOut() - can't access EMPTY_INDEX field using reflection");
        }

        int result = rhymer.countOut();
        Assert.assertEquals(emptyStackValue, result);

        int testValue = 4;
        rhymer.countIn(testValue);

        result = rhymer.countOut();
        Assert.assertEquals(testValue, result);
        result = rhymer.countOut();
        Assert.assertEquals(emptyStackValue, result);
    }
}