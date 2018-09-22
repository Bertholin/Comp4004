package poker;

import junit.framework.TestCase;

public class HandTest extends TestCase {

	public void testSize() {
		Hand p1 = new Hand();
		Hand ai = new Hand();

		assertEquals(0, p1.size());
		assertEquals(0, ai.size());

	}

	public void testAdd(String str) {
		Hand p1 = new Hand();

		assertEquals(0, p1.size());
		// adding to an empty list
		p1.add("first");
		// adding to existing or end of list list
		p1.add("second");
		// adding to the middle of the list
		p1.add(1, "middle");
		// adding to the beginning of the list
		p1.add(0, "newFirst");

		assertEquals(4, p1.size());
	}

	public void testGet(int pos) {
		Hand p1 = new Hand();

		assertEquals(0, p1.size());

		p1.add("first");
		p1.add("second");
		p1.add(1, "middle");
		p1.add(0, "newFirst");

		assertEquals(4, p1.size());

		// testing the get function

		// get the front
		assertEquals("newFirst", p1.get(0));
		// get a middle element
		assertEquals("middle", p1.get(2));
		// get the last element
		assertEquals("second", p1.get(3));
	}

	public void testRemove(int pos) {
		Hand p1 = new Hand();
		assertEquals(0, p1.size());

		p1.add("first");
		p1.add("second");
		p1.add(1, "middle");
		p1.add(0, "newFirst");
		p1.add("a");
		p1.add("b");
		p1.add("c");
		p1.add("d");

		assertEquals(8, p1.size());
		// testing removing first
		p1.remove(0);
		assertEquals(7, p1.size());

		// removing middle
		p1.remove(3);
		assertEquals(6, p1.size());

		// removing last
		p1.remove(5);
		assertEquals(5, p1.size());
	}

}
