package poker;

import junit.framework.TestCase;

public class HandTest extends TestCase {
	
	public void testopenFile() {
		Hand hand = new Hand();
		assertEquals(true, hand.openFile("cards.txt"));
	}
	
	public void testCloseFile() {
		Hand hand = new Hand();
		assertEquals(true, hand.closeFile("cards.txt"));
	}
	
	public void testDraw() {
		Hand hand = new Hand();
		hand.openFile("");
		
		hand.add(hand.draw());
		hand.add(hand.draw());
		hand.add(hand.draw());
		
		assertEquals(3, hand.size());
		hand.close();
	}

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
		// remove all items in the hand
		p1.removeAll();
		assertEquals(0, p1.size());

	}

	public void testValidHand() {
		Hand p1 = new Hand();
		// check too see if it catches an error when the user has no cards
		assertEquals(false, p1.validHand(p1));

		// adding 5 cards
		p1.add("first");
		p1.add("second");
		p1.add(1, "middle");
		p1.add(0, "newFirst");

		// check too see if it catches an error when the user has 4 cards
		assertEquals(false, p1.validHand(p1));

		p1.add("a");

		// check to make sure 5 cards are in the user hand
		assertEquals(true, p1.validHand(p1));

		p1.add("b");
		// check too see if it catches an error when the user has 6 cards
		assertEquals(false, p1.validHand(p1));
	}

	public void testGetSuit() {
		Hand p1 = new Hand();
		assertEquals(0, p1.size());

		p1.add("S1");
		assertEquals("S", p1.getSuit(p1.get(0)));
		p1.add("D1");
		assertEquals("D", p1.getSuit(p1.get(1)));
		p1.add("C1");
		assertEquals("C", p1.getSuit(p1.get(2)));
		p1.add("H1");
		assertEquals("H", p1.getSuit(p1.get(3)));
	}

	public void testGetValue() {
		Hand p1 = new Hand();
		assertEquals(0, p1.size());

		p1.add("S3");
		assertEquals(3, p1.getValue(p1.get(0)));
		p1.add("D10");
		assertEquals(10, p1.getValue(p1.get(1)));
		p1.add("CJ");
		assertEquals(11, p1.getValue(p1.get(2)));
		p1.add("CQ");
		assertEquals(12, p1.getValue(p1.get(3)));
		p1.add("HK");
		assertEquals(13, p1.getValue(p1.get(4)));
		p1.add("HA");
		assertEquals(14, p1.getValue(p1.get(5)));
	}
}
