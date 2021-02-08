package edu.kis.vh.nursery;

import org.junit.Assert;
import org.junit.Test;

public class HanoiRhymerTest {

    @Test
    public void testCountIn() {
        HanoiRhymer rhymer = new HanoiRhymer();
        Assert.assertEquals(0,rhymer.reportRejected());
        rhymer.countIn(10);
        Assert.assertEquals(10,rhymer.peekaboo());
        rhymer.countIn(9);
        Assert.assertEquals(9,rhymer.peekaboo());
        rhymer.countIn(11);
        Assert.assertEquals(9,rhymer.peekaboo());
        Assert.assertEquals(1,rhymer.reportRejected());
    }
}
