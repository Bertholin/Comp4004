package poker;

import junit.framework.TestCase;

public class DeckTest extends TestCase {
	Deck jpDeck = new Deck();
	//jpDeck.openFile("jpDraw.txt");
	
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
	
	public void testJPWayToDraw() {
		Hand hand = new Hand();

		jpDeck.openJustFile("jpDraw.txt");
		assertEquals(true,jpDeck.getNextLine());
		for( int i = 0; i < 5; ++i)
			hand.add(jpDeck.draw());
		
		assertEquals(5, hand.size());
	}
	
	public void testJPWayToDraw2() {
		System.out.println("\nPart 2");
		Hand hand = new Hand();
		Hand AIHand = new Hand();
		System.out.println("Before getting next line");
		assertEquals(true,jpDeck.getNextLine());
		System.out.println("after getting next line");
		for( int i = 0; i < 5; ++i)
			hand.add(jpDeck.draw());
		
		
		for( int i = 0; i < 5; ++i) 
			System.out.println(hand.get(i));
		
		assertEquals(5, hand.size());
		
		for( int i = 0; i < 5; ++i)
			AIHand.add(jpDeck.draw());
		
		assertEquals(5, AIHand.size());
	}
	
	public void testJPWayToDraw3() {
		Hand hand = new Hand();
		assertEquals(true,jpDeck.getNextLine());
		
		for( int i = 0; i < 5; ++i)
			hand.add(jpDeck.draw());
		
		assertEquals(5, hand.size());
		
		assertEquals(false,jpDeck.getNextLine());
	}
}
