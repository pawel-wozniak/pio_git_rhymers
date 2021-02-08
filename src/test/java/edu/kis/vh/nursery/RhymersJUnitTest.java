package edu.kis.vh.nursery;

import org.junit.Assert;
import org.junit.Test;
import java.lang.reflect.Field;
import static org.junit.Assert.fail;

public class RhymersJUnitTest {

	@Test
	public void testCountIn() {
		DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
		int testValue = 4;
		rhymer.countIn(testValue);

		int result = rhymer.peekaboo();
		Assert.assertEquals(testValue, result);
	}

	@Test
	public void testCallCheck() {
		DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
		boolean result = rhymer.callCheck();
		Assert.assertTrue(result);

		rhymer.countIn(888);

		result = rhymer.callCheck();
		Assert.assertFalse(result);
	}

	@Test
	public void testIsFull() {
		DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
		int stackCapacity = 0;
		try {
			Field maxSize = rhymer.getClass().getDeclaredField("MAX_SIZE");
			maxSize.setAccessible(true);
			stackCapacity = maxSize.getInt(rhymer);
		} catch (Exception e) {
			fail("testIsFull() - can't access MAX_SIZE field using reflection");
		}

		for (int i = 0; i < stackCapacity; i++) {
			boolean result = rhymer.isFull();
			Assert.assertFalse(result);
			rhymer.countIn(888);
		}

		boolean result = rhymer.isFull();
		Assert.assertTrue(result);
	}

	@Test
	public void testPeekaboo() {
		DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
		int emptyStackValue = 0;
		try {
			Field emptyIndex = rhymer.getClass().getDeclaredField("EMPTY_INDEX");
			emptyIndex.setAccessible(true);
			emptyStackValue = emptyIndex.getInt(rhymer);
		} catch (Exception e) {
			fail("testPeekaboo() - can't access EMPTY_INDEX field using reflection");
		}

		int result = rhymer.peekaboo();
		Assert.assertEquals(emptyStackValue, result);

		int testValue = 4;
		rhymer.countIn(testValue);

		result = rhymer.peekaboo();
		Assert.assertEquals(testValue, result);
		result = rhymer.peekaboo();
		Assert.assertEquals(testValue, result);
	}

	@Test
	public void testCountOut() {
		DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
		int emptyStackValue = 0;
		try {
			Field emptyIndex = rhymer.getClass().getDeclaredField("EMPTY_INDEX");
			emptyIndex.setAccessible(true);
			emptyStackValue = emptyIndex.getInt(rhymer);
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
