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
		Deck d = new Deck();
		d.openFile("cards.txt");

		assertEquals(0, p1.size());
		// adding to an empty list
		p1.add(d.draw());
		// adding to existing or end of list list
		p1.add(d.draw());
		// adding to the middle of the list
		p1.add(1, d.draw());
		// adding to the beginning of the list
		p1.add(0, d.draw());

		assertEquals(4, p1.size());
	}

	public void testGet() {
		Hand p1 = new Hand();
		Deck d = new Deck();
		d.openFile("cards.txt");

		assertEquals(0, p1.size());

		p1.add(d.draw());
		p1.add(d.draw());
		p1.add(1, d.draw());
		p1.add(0, d.draw());

		assertEquals(4, p1.size());

		// testing the get function

		// get the front
		assertEquals("D8", p1.get(0));
		// get a middle element
		assertEquals("S4", p1.get(2));
		// get the last element
		assertEquals("CA", p1.get(3));
	}

	public void testRemove() {
		Hand p1 = new Hand();
		Deck d = new Deck();
		d.openFile("cards.txt");

		p1.add(d.draw());
		p1.add(d.draw());
		p1.add(1, d.draw());
		p1.add(0, d.draw());
		p1.add(d.draw());
		p1.add(d.draw());
		p1.add(d.draw());
		p1.add(d.draw());

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
		Deck d = new Deck();
		d.openFile("cards.txt");

		p1.add(d.draw());
		p1.add(d.draw());
		p1.add(1, d.draw());
		p1.add(0, d.draw());
		p1.add(d.draw());
		p1.add(d.draw());
		p1.add(d.draw());
		p1.add(d.draw());

		assertEquals(8, p1.size());
		// remove all items in the hand
		p1.removeAll();
		assertEquals(0, p1.size());

	}

	public void testValidHand() {
		Hand p1 = new Hand();
		Deck d = new Deck();
		d.openFile("cards.txt");

		p1.add(d.draw());
		p1.add(d.draw());
		p1.add(1, d.draw());
		p1.add(0, d.draw());

		// check too see if it catches an error when the user has 4 cards
		assertEquals(false, p1.validHand(p1));

		p1.add(d.draw());

		// check to make sure 5 cards are in the user hand
		assertEquals(true, p1.validHand(p1));

		p1.add(d.draw());
		// check too see if it catches an error when the user has 6 cards
		assertEquals(false, p1.validHand(p1));
	}

	public void testGetSuit() {
		Hand p1 = new Hand();
		Deck d = new Deck();
		d.openFile("cards.txt");

		p1.add(d.draw());
		assertEquals("S", p1.getSuit(p1.get(0)));
		p1.add(d.draw());
		assertEquals("C", p1.getSuit(p1.get(1)));
		p1.add(d.draw());
		assertEquals("S", p1.getSuit(p1.get(2)));
		p1.add(d.draw());
		assertEquals("D", p1.getSuit(p1.get(3)));
	}

	public void testGetValue() {
		Hand p1 = new Hand();
		Deck d = new Deck();
		d.openFile("cards.txt");

		p1.add(d.draw());
		assertEquals(14, p1.getValue(p1.get(0)));
		p1.add(d.draw());
		assertEquals(14, p1.getValue(p1.get(1)));
		p1.add(d.draw());
		assertEquals(4, p1.getValue(p1.get(2)));
		p1.add(d.draw());
		assertEquals(8, p1.getValue(p1.get(3)));
		p1.add(d.draw());
		assertEquals(4, p1.getValue(p1.get(4)));
		p1.add(d.draw());
		assertEquals(12, p1.getValue(p1.get(5)));
	}
}
