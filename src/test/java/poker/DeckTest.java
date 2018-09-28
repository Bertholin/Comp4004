package poker;

import junit.framework.TestCase;

public class DeckTest extends TestCase {
	public void testopenFile() {
		Deck deck = new Deck();
		assertEquals(true, deck.openFile("cards.txt"));
	}


	public void testDraw() {
		Deck deck = new Deck();
		Hand hand = new Hand();
		deck.openFile("cards.txt");

		hand.add(deck.draw());
		hand.add(deck.draw());
		hand.add(deck.draw());
		hand.add(deck.draw());
		hand.add(deck.draw());

		assertEquals(5, hand.size());
		assertEquals("SA", hand.get(0));
		assertEquals("CA", hand.get(1));
		assertEquals("S4", hand.get(2));
		assertEquals("D8", hand.get(3));
		assertEquals("H4", hand.get(4));
	}
}
