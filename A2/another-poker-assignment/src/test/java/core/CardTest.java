package core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CardTest {
	
	@Test
	void testRank() {
		Card c1 = new Card("H3");
		Card c2 = new Card("CK");
		Card c3 = new Card("SJ");
		Card c4 = new Card("DQ");
		Card c5 = new Card("S10");
		
		assertEquals(3, c1.getRank());
		assertEquals(13, c2.getRank());
		assertEquals(11, c3.getRank());
		assertEquals(12, c4.getRank());
		assertEquals(10, c5.getRank());
	}
	
	@Test 
	void testSuit() {
		Card c1 = new Card("H3");
		Card c2 = new Card("CK");
		Card c3 = new Card("SJ");
		Card c4 = new Card("DQ");
		Card c5 = new Card("S10");
		
		assertEquals(Suit.HEARTS, c1.getSuit());
		assertEquals(Suit.CLUBS, c2.getSuit());
		assertEquals(Suit.SPADES, c3.getSuit());
		assertEquals(Suit.DIAMONDS, c4.getSuit());
		assertEquals(Suit.SPADES, c5.getSuit());
	}
	
	@Test
	void testId() {
		Card c1 = new Card("H3");
		Card c2 = new Card("CK");
		Card c3 = new Card("SJ");
		Card c4 = new Card("DQ");
		Card c5 = new Card("S10");
		
		assertEquals("H3", c1.getId());
		assertEquals("CK", c2.getId());
		assertEquals("SJ", c3.getId());
		assertEquals("DQ", c4.getId());
		assertEquals("S10", c5.getId());
	}
	
	@Test
	void testEquals() {
		Card c1 = new Card("S10");
		Card c2 = new Card("S10");
		
		assertTrue(c1.equals(c2));
		assertEquals(c1.getRank(), c2.getRank());
		assertEquals(c1.getSuit(), c2.getSuit());
	}
	
}
