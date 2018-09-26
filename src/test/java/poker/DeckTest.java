package poker;

import junit.framework.TestCase;

public class DeckTest extends TestCase{
	public void testopenFile() {
		Deck deck = new Deck();
		assertEquals(true, deck.openFile("cards.txt"));
	}

	public void testCloseFile() {
		Deck deck = new Deck();
		assertEquals(true, deck.closeFile());
	}

	public void testDraw() {
		Deck deck = new Deck();
		Hand hand = new Hand();
		deck.openFile("cards.txt");

		hand.add(deck.draw());
		hand.add(deck.draw());
		hand.add(deck.draw());

		assertEquals(3, hand.size());
		deck.closeFile();
	}
}
