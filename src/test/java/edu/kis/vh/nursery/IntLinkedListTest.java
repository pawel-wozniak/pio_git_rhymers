package edu.kis.vh.nursery;

import edu.kis.vh.nursery.list.IntLinkedList;
import org.junit.Assert;
import org.junit.Test;

public class IntLinkedListTest {

    @Test
    public void testNewIntLinkedList() {
        IntLinkedList list = new IntLinkedList();
        Assert.assertTrue(list.isEmpty());
        list.push(1);
        Assert.assertFalse(list.isEmpty());
        Assert.assertEquals(1, list.top());
        int result = list.pop();
        Assert.assertTrue(list.isEmpty());
        Assert.assertEquals(1, result);
    }
}
