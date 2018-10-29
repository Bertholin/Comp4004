package core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

import java.util.*;

public class StrategyTest {
	
	
	/* ------- STRATEGY - ONE -------- */
	
	@Test
	void testRoyalFlushExchangesNothing() {
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card("D10"));
		cards.add(new Card("DJ"));
		cards.add(new Card("DQ"));
		cards.add(new Card("DK"));
		cards.add(new Card("DA"));
		
		AIPlayer player = new AIPlayer(cards);
		int numExchanged = player.exchange();
		assertEquals(0, numExchanged);
		assertEquals(Hand.ROYAL_FLUSH, player.getHighestHand());
	}
	
	@Test
	void testStraightFlushExchangesNothing() {
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card("D7"));
		cards.add(new Card("D8"));
		cards.add(new Card("D9"));
		cards.add(new Card("D10"));
		cards.add(new Card("DJ"));
		
		AIPlayer player = new AIPlayer(cards);
		int numExchanged = player.exchange();
		assertEquals(0, numExchanged);
		assertEquals(Hand.STRAIGHT_FLUSH, player.getHighestHand());
	}
	
	@Test
	void testFourOfKindExchangesNothing() {
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card("DJ"));
		cards.add(new Card("HJ"));
		cards.add(new Card("SJ"));
		cards.add(new Card("CJ"));
		cards.add(new Card("D7"));
		
		AIPlayer player = new AIPlayer(cards);
		int numExchanged = player.exchange();
		assertEquals(0, numExchanged);
		assertEquals(Hand.FOUR_OF_A_KIND, player.getHighestHand());
	}
	
	@Test
	void testFullHouseExchangesNothing() {
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card("D10"));
		cards.add(new Card("H10"));
		cards.add(new Card("C10"));
		cards.add(new Card("C9"));
		cards.add(new Card("D9"));
		
		AIPlayer player = new AIPlayer(cards);
		int numExchanged = player.exchange();
		assertEquals(0, numExchanged);
		assertEquals(Hand.FULL_HOUSE, player.getHighestHand());
	}
	
	@Test
	void testFlushExchangesNothing() {
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card("C4"));
		cards.add(new Card("CJ"));
		cards.add(new Card("CQ"));
		cards.add(new Card("C7"));
		cards.add(new Card("C9"));
		
		AIPlayer player = new AIPlayer(cards);
		int numExchanged = player.exchange();
		assertEquals(0, numExchanged);
		assertEquals(Hand.FLUSH, player.getHighestHand());
	}
	
	@Test
	void testStraightExchangesNothing() {
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card("C5"));
		cards.add(new Card("D4"));
		cards.add(new Card("H6"));
		cards.add(new Card("S7"));
		cards.add(new Card("S8"));
		
		AIPlayer player = new AIPlayer(cards);
		int numExchanged = player.exchange();
		assertEquals(0, numExchanged);
		assertEquals(Hand.STRAIGHT, player.getHighestHand());
	}
	
	/* ------- STRATEGY - TWO ------- */
	
	@Test
	void testOneAwayFromRoyalFlushExchangeCard() {
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card("D10"));
		cards.add(new Card("DJ"));
		cards.add(new Card("DQ"));
		cards.add(new Card("DK"));
		cards.add(new Card("S8"));
		
		AIPlayer player = new AIPlayer(cards);
		int numExchanged = player.exchange();
		assertEquals(1, numExchanged);
		assertTrue(player.isOneAwayFromRoyalFlush());
		assertTrue(player.getDiscarded().contains(new Card("S8")));
	}
	
	@Test
	void testOneAwayFromStraightFlushExchangeCard() {
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card("D3"));
		cards.add(new Card("D4"));
		cards.add(new Card("D5"));
		cards.add(new Card("D6"));
		cards.add(new Card("H9"));
		
		AIPlayer player = new AIPlayer(cards);
		int numExchanged = player.exchange();
		assertEquals(1, numExchanged);
		assertTrue(player.isOneAwayFromStraightFlush());
		assertTrue(player.getDiscarded().contains(new Card("H9")));
	}
	
	@Test
	void testOneAwayFromFullHouseExchangeCard() {
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card("D10"));
		cards.add(new Card("H10"));
		cards.add(new Card("HQ"));
		cards.add(new Card("DK"));
		cards.add(new Card("S10"));
		
		AIPlayer player = new AIPlayer(cards);
		int numExchanged = player.exchange();
		assertEquals(1, numExchanged);
		assertTrue(player.hasThreeOfAKind());
		//assertTrue(player.getDiscarded().contains(new Card("HQ")));
	}
	
	@Test
	void testOneAwayFromFullHouseV2ExchangeCard() {
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card("C10"));
		cards.add(new Card("SA"));
		cards.add(new Card("D10"));
		cards.add(new Card("DA"));
		cards.add(new Card("H5"));
		
		AIPlayer player = new AIPlayer(cards);
		int numExchanged = player.exchange();
		assertEquals(1, numExchanged);
		assertTrue(player.hasTwoPairs());
		assertTrue(player.getDiscarded().contains(new Card("H5")));
	}
	
	@Test
	void testOneAwayFromFlushExchangeCard() {
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card("S4"));
		cards.add(new Card("SJ"));
		cards.add(new Card("S8"));
		cards.add(new Card("S2"));
		cards.add(new Card("C9"));
		
		AIPlayer player = new AIPlayer(cards);
		int numExchanged = player.exchange();
		assertEquals(1, numExchanged);
		assertTrue(player.isOneAwayFromFlush());
		assertTrue(player.getDiscarded().contains(new Card("C9")));
	}
	
	@Test
	void testOneAwayFromStraightExchangeCard() {
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card("C2"));
		cards.add(new Card("S5"));
		cards.add(new Card("D6"));
		cards.add(new Card("H7"));
		cards.add(new Card("D8"));
		
		AIPlayer player = new AIPlayer(cards);
		int numExchanged = player.exchange();
		assertEquals(1, numExchanged);
		assertTrue(player.isOneAwayFromStraight());
		assertTrue(player.getDiscarded().contains(new Card("C2")));
	}
	
	/* ------- STRATEGY - THREE ------- */
	
	@Test
	void testThreeCardsSameSuitExchangeTwoCards() {
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card("C2"));
		cards.add(new Card("C5"));
		cards.add(new Card("C6"));
		cards.add(new Card("H10"));
		cards.add(new Card("DQ"));
		
		AIPlayer player = new AIPlayer(cards);
		int numExchanged = player.exchange();
		assertEquals(2, numExchanged);
		assertTrue(player.hasExactThreeSameSuit());
		assertTrue(player.getDiscarded().contains(new Card("H10")));
		assertTrue(player.getDiscarded().contains(new Card("DQ")));
	}
	
	/* ------- STRATEGY - FOUR ------- */
	
	@Test
	void testThreeCardInSeqExchangeTwoCards() {
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card("H4"));
		cards.add(new Card("C5"));
		cards.add(new Card("S6"));
		cards.add(new Card("H10"));
		cards.add(new Card("DQ"));
		
		AIPlayer player = new AIPlayer(cards);
		int numExchanged = player.exchange();
		assertEquals(2, numExchanged);
		assertTrue(player.hasThreeInSeq());
		assertTrue(player.getDiscarded().contains(new Card("H10")));
		assertTrue(player.getDiscarded().contains(new Card("DQ")));
	}
	
	/* ------- STRATEGY - FIVE ------- */
	
	@Test
	void testOnePairExchangeOtherThreeCard() {
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card("H4"));
		cards.add(new Card("C4"));
		cards.add(new Card("S6"));
		cards.add(new Card("H10"));
		cards.add(new Card("DQ"));
		
		AIPlayer player = new AIPlayer(cards);
		int numExchanged = player.exchange();
		assertEquals(3, numExchanged);
		assertTrue(player.hasPair());
		assertTrue(player.getDiscarded().contains(new Card("S6")));
		assertTrue(player.getDiscarded().contains(new Card("H10")));
		assertTrue(player.getDiscarded().contains(new Card("DQ")));
	}
	
	/* ------- STRATEGY - SIX ------- */
	
	@Test
	void testHighestCardExchangesLowestThree() {
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card("H4"));
		cards.add(new Card("C5"));
		cards.add(new Card("SJ"));
		cards.add(new Card("H10"));
		cards.add(new Card("DA"));
		
		AIPlayer player = new AIPlayer(cards);
		int numExchanged = player.exchange();
		assertEquals(3, numExchanged);
		assertEquals(Hand.HIGH_CARD, player.getHighestHand());
		assertTrue(player.getDiscarded().contains(new Card("H4")));
		assertTrue(player.getDiscarded().contains(new Card("H10")));
		assertTrue(player.getDiscarded().contains(new Card("C5")));
	}
}
