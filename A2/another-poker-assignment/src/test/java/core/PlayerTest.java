package core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

import java.util.*;

public class PlayerTest {
	
	@Test
	void testHandInOrder() {
		Deck deck = new Deck();
		ArrayList<Card> cards = new ArrayList<Card>();
		ArrayList<String> init = new ArrayList<String>();
		init.add("C8");
		init.add("C7");
		init.add("C6");
		init.add("C5");
		init.add("C4");
		cards = deck.drawMany(init);
		
		Player player = new Player(cards);
		Collections.sort(init);
		
		ArrayList<Card> playerCards = player.getCards();
		ArrayList<String> pCards = new ArrayList<String>();
		for (Card c : playerCards) {
			pCards.add(c.getId());
		}
		assertArrayEquals(init.toArray(), pCards.toArray());
	}
	
	@Test
	void testFindSeq() {
		Deck deck = new Deck();
		ArrayList<Card> cards = new ArrayList<Card>();
		ArrayList<String> init = new ArrayList<String>();
		init.add("C8");
		init.add("C7");
		init.add("C6");
		init.add("C5");
		init.add("C4");
		cards = deck.drawMany(init);
		
		Player player = new Player(cards);
		assertTrue(player.isInSeq());
	}
	
	@Test
	void testFindSeqWithSmallAce() {
		Deck deck = new Deck();
		ArrayList<Card> cards = new ArrayList<Card>();
		ArrayList<String> init = new ArrayList<String>();
		init.add("C3");
		init.add("C4");
		init.add("SA");
		init.add("D2");
		init.add("H5");
		cards = deck.drawMany(init);
		
		Player player = new Player(cards);
		assertTrue(player.isInSeq());
	}
	
	@Test
	void testFindOnePair() {
		Deck deck = new Deck();
		ArrayList<Card> cards = new ArrayList<Card>();
		ArrayList<String> init = new ArrayList<String>();
		init.add("C3");
		init.add("SA");
		init.add("D2");
		init.add("D3");
		init.add("H5");
		cards = deck.drawMany(init);
		
		Player player = new Player(cards);
		assertEquals(1, player.getNumPairs());
	}
	
	@Test
	void testFindTwoPair() {
		Deck deck = new Deck();
		ArrayList<Card> cards = new ArrayList<Card>();
		ArrayList<String> init = new ArrayList<String>();
		init.add("C10");
		init.add("SA");
		init.add("D10");
		init.add("DA");
		init.add("H5");
		cards = deck.drawMany(init);
		
		Player player = new Player(cards);
		assertEquals(2, player.getNumPairs());
	}
	
	@Test
	void testFindTrips() {
		Deck deck = new Deck();
		ArrayList<Card> cards = new ArrayList<Card>();
		ArrayList<String> init = new ArrayList<String>();
		init.add("C7");
		init.add("S7");
		init.add("CK");
		init.add("D7");
		init.add("D3");
		cards = deck.drawMany(init);
		
		Player player = new Player(cards);
		assertTrue(player.hasThreeOfAKind());
	}
	
	@Test
	void testFindFour() {
		Deck deck = new Deck();
		ArrayList<Card> cards = new ArrayList<Card>();
		ArrayList<String> init = new ArrayList<String>();
		init.add("HJ");
		init.add("SJ");
		init.add("CJ");
		init.add("D7");
		init.add("DJ");
		cards = deck.drawMany(init);
		
		Player player = new Player(cards);
		assertTrue(player.hasFourOfAKind());
	}
	
	@Test
	void testFindFourAlt() {
		Deck deck = new Deck();
		ArrayList<Card> cards = new ArrayList<Card>();
		ArrayList<String> init = new ArrayList<String>();
		init.add("H2");
		init.add("D2");
		init.add("D7");
		init.add("S2");
		init.add("C2");
		cards = deck.drawMany(init);
		
		Player player = new Player(cards);
		assertTrue(player.hasFourOfAKind());
	}
	
	@Test
	void testFindFullHouse() {
		Deck deck = new Deck();
		ArrayList<Card> cards = new ArrayList<Card>();
		ArrayList<String> init = new ArrayList<String>();
		init.add("H10");
		init.add("H9");
		init.add("D10");
		init.add("C10");
		init.add("C9");
		cards = deck.drawMany(init);
		
		Player player = new Player(cards);
		assertTrue(player.hasThreeOfAKind());
		assertEquals(1, player.getNumPairs());
		
	}
	
	@Test
	void testHasRoyalFlush() {
		Deck deck = new Deck();
		ArrayList<Card> cards = new ArrayList<Card>();
		ArrayList<String> init = new ArrayList<String>();
		init.add("DJ");
		init.add("DK");
		init.add("DA");
		init.add("DQ");
		init.add("D10");
		cards = deck.drawMany(init);
		
		Player player = new Player(cards);
		
		assertTrue(Hand.ROYAL_FLUSH == player.getHighestHand());
	}
	
	@Test
	void testHasStraightFlush() {
		Deck deck = new Deck();
		ArrayList<Card> cards = new ArrayList<Card>();
		ArrayList<String> init = new ArrayList<String>();
		init.add("C6");
		init.add("C8");
		init.add("C5");
		init.add("C7");
		init.add("C4");
		cards = deck.drawMany(init);
		
		Player player = new Player(cards);
		assertTrue(Hand.STRAIGHT_FLUSH == player.getHighestHand());
	}
	
	@Test
	void testHasFourOfAKind() {
		Deck deck = new Deck();
		ArrayList<Card> cards = new ArrayList<Card>();
		ArrayList<String> init = new ArrayList<String>();
		init.add("HJ");
		init.add("D7");
		init.add("DJ");
		init.add("SJ");
		init.add("CJ");
		cards = deck.drawMany(init);
		
		Player player = new Player(cards);
		assertTrue(Hand.FOUR_OF_A_KIND == player.getHighestHand());
	}
	
	@Test
	void testHasFullHouse() {
		Deck deck = new Deck();
		ArrayList<Card> cards = new ArrayList<Card>();
		ArrayList<String> init = new ArrayList<String>();
		init.add("H10");
		init.add("D10");
		init.add("C10");
		init.add("C9");
		init.add("H9");
		cards = deck.drawMany(init);
		
		Player player = new Player(cards);
		assertTrue(Hand.FULL_HOUSE == player.getHighestHand());
	}
	
	@Test
	void testHasFlush() {
		Deck deck = new Deck();
		ArrayList<Card> cards = new ArrayList<Card>();
		ArrayList<String> init = new ArrayList<String>();
		init.add("S4");
		init.add("SJ");
		init.add("S8");
		init.add("S2");
		init.add("S9");
		cards = deck.drawMany(init);
		
		Player player = new Player(cards);
		assertTrue(Hand.FLUSH == player.getHighestHand());
	}
	
	@Test
	void testHasStraight() {
		Deck deck = new Deck();
		ArrayList<Card> cards = new ArrayList<Card>();
		ArrayList<String> init = new ArrayList<String>();
		init.add("C9");
		init.add("D8");
		init.add("S7");
		init.add("D6");
		init.add("H5");
		cards = deck.drawMany(init);
		
		Player player = new Player(cards);
		assertTrue(Hand.STRAIGHT == player.getHighestHand());
	}
	
	@Test
	void testHasThreeOfAKind() {
		Deck deck = new Deck();
		ArrayList<Card> cards = new ArrayList<Card>();
		ArrayList<String> init = new ArrayList<String>();
		init.add("C7");
		init.add("D7");
		init.add("S7");
		init.add("CK");
		init.add("D3");
		cards = deck.drawMany(init);
		
		Player player = new Player(cards);
		assertTrue(Hand.THREE_OF_A_KIND == player.getHighestHand());
	}
	
	@Test
	void testHasDoublePair() {
		Deck deck = new Deck();
		ArrayList<Card> cards = new ArrayList<Card>();
		ArrayList<String> init = new ArrayList<String>();
		init.add("C4");
		init.add("S4");
		init.add("C3");
		init.add("D3");
		init.add("CQ");
		cards = deck.drawMany(init);
		
		Player player = new Player(cards);
		assertTrue(Hand.DOUBLE_PAIR == player.getHighestHand());
	}
	
	@Test
	void testHasPair() {
		Deck deck = new Deck();
		ArrayList<Card> cards = new ArrayList<Card>();
		ArrayList<String> init = new ArrayList<String>();
		init.add("DA");
		init.add("HA");
		init.add("C8");
		init.add("S4");
		init.add("H7");
		cards = deck.drawMany(init);
		
		Player player = new Player(cards);
		assertTrue(Hand.PAIR == player.getHighestHand());
	}
	
	@Test
	void testHighCard() {
		Deck deck = new Deck();
		ArrayList<Card> cards = new ArrayList<Card>();
		ArrayList<String> init = new ArrayList<String>();
		init.add("D3");
		init.add("CJ");
		init.add("S8");
		init.add("H4");
		init.add("S2");
		cards = deck.drawMany(init);
		
		Player player = new Player(cards);
		assertTrue(Hand.HIGH_CARD == player.getHighestHand());
	}
	
}
