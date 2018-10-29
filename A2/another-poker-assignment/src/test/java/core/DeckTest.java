package core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

import java.util.*;

public class DeckTest {
	
	@Test
	void testDeckContainsSpecificCard() {
		Deck deck = new Deck();
		Card card = new Card("H7");
		assertTrue(deck.contains("H7"));
		assertTrue(deck.contains(card));
	}
	
	@Test
	void teskDeckDoesNotContainSpecificCard() {
		Deck deck = new Deck();
		deck.draw("H7");
		assertFalse(deck.contains("H7"));
	}
	
	@Test
	void teskDeckDoesNotContainIllegalCard() {
		Deck deck = new Deck();
		assertFalse(deck.contains("F5"));
	}
	
	@Test
	void testDeckContainsAllCards() {
		Deck deck = new Deck();
		assertEquals(52, deck.size());
		assertTrue(deck.contains("C2"));
		assertTrue(deck.contains("C3"));
		assertTrue(deck.contains("C4"));
		assertTrue(deck.contains("C5"));
		assertTrue(deck.contains("C6"));
		assertTrue(deck.contains("C7"));
		assertTrue(deck.contains("C8"));
		assertTrue(deck.contains("C9"));
		assertTrue(deck.contains("C10"));
		assertTrue(deck.contains("CJ"));
		assertTrue(deck.contains("CQ"));
		assertTrue(deck.contains("CK"));
		assertTrue(deck.contains("CA"));
		assertTrue(deck.contains("D2"));
		assertTrue(deck.contains("D3"));
		assertTrue(deck.contains("D4"));
		assertTrue(deck.contains("D5"));
		assertTrue(deck.contains("D6"));
		assertTrue(deck.contains("D7"));
		assertTrue(deck.contains("D8"));
		assertTrue(deck.contains("D9"));
		assertTrue(deck.contains("D10"));
		assertTrue(deck.contains("DJ"));
		assertTrue(deck.contains("DQ"));
		assertTrue(deck.contains("DK"));
		assertTrue(deck.contains("DA"));
		assertTrue(deck.contains("H2"));
		assertTrue(deck.contains("H3"));
		assertTrue(deck.contains("H4"));
		assertTrue(deck.contains("H5"));
		assertTrue(deck.contains("H6"));
		assertTrue(deck.contains("H7"));
		assertTrue(deck.contains("H8"));
		assertTrue(deck.contains("H9"));
		assertTrue(deck.contains("H10"));
		assertTrue(deck.contains("HJ"));
		assertTrue(deck.contains("HQ"));
		assertTrue(deck.contains("HK"));
		assertTrue(deck.contains("HA"));
		assertTrue(deck.contains("S2"));
		assertTrue(deck.contains("S3"));
		assertTrue(deck.contains("S4"));
		assertTrue(deck.contains("S5"));
		assertTrue(deck.contains("S6"));
		assertTrue(deck.contains("S7"));
		assertTrue(deck.contains("S8"));
		assertTrue(deck.contains("S9"));
		assertTrue(deck.contains("S10"));
		assertTrue(deck.contains("SJ"));
		assertTrue(deck.contains("SQ"));
		assertTrue(deck.contains("SK"));
		assertTrue(deck.contains("SA"));
	}
	
	@Test
	void testDeckDrawGivesYouCard() {
		Deck deck = new Deck();
		Card card = null;
		card = deck.draw();
		assertTrue(card instanceof Card);
	}
	
	@Test
	void testDeckDrawRemovesFromDeck() {
		Deck deck = new Deck();
		Card card = null;
		card = deck.draw();
		assertFalse(deck.contains(card));
		assertEquals(51, deck.size());
	}
	
	
	void testDeckDrawSpecificCardGivesYouCard() {
		Deck deck = new Deck();
		Card card = new Card("H7");
		Card drawnCard = null;
		drawnCard = deck.draw("H7");
		assertTrue(card.equals(drawnCard));
	}
	
	@Test
	void testDeckDrawSpecificCardRemovesFromDeck() {
		Deck deck = new Deck();
		Card drawnCard = deck.draw("H7");
		assertFalse(deck.contains(drawnCard));
		assertEquals(51, deck.size());
	}
	
	@Test 
	void testDrawManyGivesProperCards() {
		Deck deck = new Deck();
		ArrayList<Card> cards = new ArrayList<Card>();
		cards = deck.drawMany(4);
		assertEquals(4, cards.size());
		assertFalse(cards.get(0).equals(cards.get(1)));
		assertFalse(cards.get(0).equals(cards.get(2)));
		assertFalse(cards.get(0).equals(cards.get(3)));
		assertFalse(cards.get(1).equals(cards.get(2)));
		assertFalse(cards.get(1).equals(cards.get(3)));
		assertFalse(cards.get(2).equals(cards.get(3)));
	}
	
	@Test
	void testDrawManyRemovesCardsFromDeck() {
		Deck deck = new Deck();
		ArrayList<Card> cards = new ArrayList<Card>();
		cards = deck.drawMany(4);
		assertEquals(48, deck.size());
		assertFalse(deck.contains(cards.get(0)));
		assertFalse(deck.contains(cards.get(1)));
		assertFalse(deck.contains(cards.get(2)));
		assertFalse(deck.contains(cards.get(3)));
	}
	
	@Test 
	void testDrawManySpecificGivesProperCards() {
		Deck deck = new Deck();
		ArrayList<String> init = new ArrayList<String>();
		init.add("C2");
		init.add("S10");
		init.add("DA");
		init.add("HJ");
		init.add("H2");
		
		ArrayList<Card> cards = new ArrayList<Card>();
		cards = deck.drawMany(init);
		
		Card c1 = new Card("C2");
		Card c2 = new Card("S10");
		Card c3 = new Card("DA");
		Card c4 = new Card("HJ");
		Card c5 = new Card("H2");
		
		assertTrue(cards.contains(c1));
		assertTrue(cards.contains(c2));
		assertTrue(cards.contains(c3));
		assertTrue(cards.contains(c4));
		assertTrue(cards.contains(c5));
		
	}
	
	@Test
	void testDrawManySpecificRemovesCardsFromDeck() {
		Deck deck = new Deck();
		ArrayList<String> init = new ArrayList<String>();
		init.add("C2");
		init.add("S10");
		init.add("DA");
		init.add("HJ");
		init.add("H2");
		
		ArrayList<Card> cards = new ArrayList<Card>();
		cards = deck.drawMany(init);
		
		assertEquals(47, deck.size());
		assertFalse(deck.contains("C2"));
		assertFalse(deck.contains("S10"));
		assertFalse(deck.contains("DA"));
		assertFalse(deck.contains("HJ"));
		assertFalse(deck.contains("H2"));
	}

}
