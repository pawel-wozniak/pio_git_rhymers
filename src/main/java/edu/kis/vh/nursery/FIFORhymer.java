package edu.kis.vh.nursery;

public class FIFORhymer extends DefaultCountingOutRhymer {

	/**
	 * Field containing DefaultCountingOutRhymer
	 */
    private final DefaultCountingOutRhymer temp = new DefaultCountingOutRhymer();

	/**
	 * Overriding method from DefaultCountingOutRhymer
	 * @return current value
	 */
    @Override
    public int countOut() {
		while (!callCheck()) {
			temp.countIn(super.countOut());
		}

		int ret = temp.countOut();

		while (!temp.callCheck()) {
			countIn(temp.countOut());
		}

		return ret;
    }
}
