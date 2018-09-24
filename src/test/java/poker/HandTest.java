package poker;

import junit.framework.TestCase;

public class HandTest extends TestCase {

	public void testSize() {
		Hand p1 = new Hand();
		Hand ai = new Hand();

		assertEquals(0, p1.size());
		assertEquals(0, ai.size());

	}

	public void testAdd() {
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

	public void testGet() {
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

	public void testRemove() {
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
	
	public void testRemoveAll() {
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
		//remove all items in the hand
		p1.removeAll();
		assertEquals(0, p1.size());

	}
	
	public void testValidHand() {
		Hand p1 = new Hand();
		//check too see if it catches an error when the user has no cards
		assertEquals(false, p1.validHand());
		
		//adding 5 cards
		p1.add("first");
		p1.add("second");
		p1.add(1, "middle");
		p1.add(0, "newFirst");
		
		//check too see if it catches an error when the user has 4 cards
		assertEquals(false, p1.validHand());
		
		p1.add("a");
		
		//check to make sure 5 cards are in the user hand
		assertEquals(false, p1.validHand());
		
		p1.add("b");
		//check too see if it catches an error when the user has 6 cards
		assertEquals(false, p1.validHand());
	}

}
