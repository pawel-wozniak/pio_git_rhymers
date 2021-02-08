package edu.kis.vh.nursery;

import edu.kis.vh.nursery.factory.DefaultRhymersFactory;
import edu.kis.vh.nursery.factory.RhymersFactory;
import org.junit.Assert;
import org.junit.Test;

public class DefaultRhymesFactoryTest {

    @Test
    public void getStandardRhymerTest() {
        RhymersFactory factory = new DefaultRhymersFactory();
        DefaultCountingOutRhymer result = factory.getStandardRhymer();

        Assert.assertNotNull(result);
    }
    @Test
    public void getFalseRhymerTest() {
        RhymersFactory factory = new DefaultRhymersFactory();
        DefaultCountingOutRhymer result = factory.getFalseRhymer();

        Assert.assertNotNull(result);
    }
    @Test
    public void getFIFORhymerTest() {
        RhymersFactory factory = new DefaultRhymersFactory();
        DefaultCountingOutRhymer result = factory.getFIFORhymer();

        Assert.assertNotNull(result);
    }
    @Test
    public void getHanoiRhymerTest() {
        RhymersFactory factory = new DefaultRhymersFactory();
        DefaultCountingOutRhymer result = factory.getHanoiRhymer();

        Assert.assertNotNull(result);
    }
}
