package core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

import java.util.*;

public class AIPlayerTest {
	
	@Test
	void testOneAwayFromFlush() {
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card("S4"));
		cards.add(new Card("SJ"));
		cards.add(new Card("S8"));
		cards.add(new Card("S2"));
		cards.add(new Card("C9"));
		
		AIPlayer player = new AIPlayer(cards);
		assertTrue(player.isOneAwayFromFlush());
	}
	
	@Test
	void testOneAwayFromStraightFirstCardOff() {
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card("C2"));
		cards.add(new Card("S5"));
		cards.add(new Card("D6"));
		cards.add(new Card("H7"));
		cards.add(new Card("D8"));
		
		AIPlayer player = new AIPlayer(cards);
		assertTrue(player.isOneAwayFromStraight());
	}
	
	@Test
	void testOneAwayFromStraightFirstCardOffVersion2() {
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card("C2"));
		cards.add(new Card("S4"));
		cards.add(new Card("D6"));
		cards.add(new Card("H7"));
		cards.add(new Card("D8"));
		
		AIPlayer player = new AIPlayer(cards);
		assertTrue(player.isOneAwayFromStraight());
	}
	
	@Test
	void testOneAwayFromStraightSecondCardOff() {
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card("C4"));
		cards.add(new Card("S4"));
		cards.add(new Card("D6"));
		cards.add(new Card("H7"));
		cards.add(new Card("D8"));
		
		AIPlayer player = new AIPlayer(cards);
		assertTrue(player.isOneAwayFromStraight());
	}
	
	@Test
	void testOneAwayFromStraightThirdCardOff() {
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card("C4"));
		cards.add(new Card("S5"));
		cards.add(new Card("D5"));
		cards.add(new Card("H7"));
		cards.add(new Card("D8"));
		
		AIPlayer player = new AIPlayer(cards);
		assertTrue(player.isOneAwayFromStraight());
	}
	
	@Test
	void testOneAwayFromStraightFourthCardOff() {
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card("C4"));
		cards.add(new Card("S5"));
		cards.add(new Card("D6"));
		cards.add(new Card("H6"));
		cards.add(new Card("D8"));
		
		AIPlayer player = new AIPlayer(cards);
		assertTrue(player.isOneAwayFromStraight());
	}
	
	@Test
	void testOneAwayFromStraightFifthCardOff() {
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card("C4"));
		cards.add(new Card("S5"));
		cards.add(new Card("D6"));
		cards.add(new Card("H7"));
		cards.add(new Card("D10"));
		
		AIPlayer player = new AIPlayer(cards);
		assertTrue(player.isOneAwayFromStraight());
	}
	
	@Test
	void testOneAwayFromStraightAceLowMissing4() {
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card("C2"));
		cards.add(new Card("S3"));
		cards.add(new Card("D5"));
		cards.add(new Card("H9"));
		cards.add(new Card("DA"));
		
		AIPlayer player = new AIPlayer(cards);
		assertTrue(player.isOneAwayFromStraight());
	}
	
	@Test
	void testOneAwayFromStraightAceLowMissing3() {
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card("C2"));
		cards.add(new Card("S4"));
		cards.add(new Card("D5"));
		cards.add(new Card("H9"));
		cards.add(new Card("DA"));
		
		AIPlayer player = new AIPlayer(cards);
		assertTrue(player.isOneAwayFromStraight());
	}
	
	@Test
	void testOneAwayFromStraightAceLowMissing2() {
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card("C3"));
		cards.add(new Card("S3"));
		cards.add(new Card("D4"));
		cards.add(new Card("H5"));
		cards.add(new Card("DA"));
		
		AIPlayer player = new AIPlayer(cards);
		assertTrue(player.isOneAwayFromStraight());
	}
	
	@Test
	void testOneAwayFromStraightAceLowMissing5() {
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card("C2"));
		cards.add(new Card("S3"));
		cards.add(new Card("D4"));
		cards.add(new Card("H9"));
		cards.add(new Card("DA"));
		
		AIPlayer player = new AIPlayer(cards);
		assertTrue(player.isOneAwayFromStraight());
	}
	
	@Test
	void testOneAwayFromStraightAceLowMissingAce() {
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card("C3"));
		cards.add(new Card("S4"));
		cards.add(new Card("D2"));
		cards.add(new Card("H5"));
		cards.add(new Card("D9"));
		
		AIPlayer player = new AIPlayer(cards);
		assertTrue(player.isOneAwayFromStraight());
	}
	
	@Test
	void testOneAwayFromStraightFlushStraightOff() {
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card("D3"));
		cards.add(new Card("D4"));
		cards.add(new Card("D5"));
		cards.add(new Card("D6"));
		cards.add(new Card("D9"));
		
		AIPlayer player = new AIPlayer(cards);
		assertTrue(player.isOneAwayFromStraightFlush());
	}
	
	@Test
	void testOneAwayFromStraightFlushFlushOff() {
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card("D4"));
		cards.add(new Card("D6"));
		cards.add(new Card("D5"));
		cards.add(new Card("D7"));
		cards.add(new Card("H8"));
		
		AIPlayer player = new AIPlayer(cards);
		assertTrue(player.isOneAwayFromStraightFlush());
	}
	
	@Test
	void testOneAwayFromStraightFlushStraightAndFlushOff() {
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card("D4"));
		cards.add(new Card("D5"));
		cards.add(new Card("D6"));
		cards.add(new Card("D7"));
		cards.add(new Card("H10"));
		
		AIPlayer player = new AIPlayer(cards);
		assertTrue(player.isOneAwayFromStraightFlush());
	}
	
	@Test
	void testFailOneAwayFromStraightFlush() {
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card("D4"));
		cards.add(new Card("D5"));
		cards.add(new Card("H6"));
		cards.add(new Card("D7"));
		cards.add(new Card("D9"));
		
		AIPlayer player = new AIPlayer(cards);
		assertFalse(player.isOneAwayFromStraightFlush());
	}
	
	@Test
	void testOneAwayFromRoyalFlushStraightOff() {
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card("D10"));
		cards.add(new Card("DJ"));
		cards.add(new Card("DQ"));
		cards.add(new Card("DK"));
		cards.add(new Card("D8"));
		
		AIPlayer player = new AIPlayer(cards);
		assertTrue(player.isOneAwayFromStraightFlush());
	}
	
	@Test
	void testOneAwayFromRoyalFlushHaveStraightFlush() {
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card("D10"));
		cards.add(new Card("DJ"));
		cards.add(new Card("DQ"));
		cards.add(new Card("DK"));
		cards.add(new Card("D9"));
		
		AIPlayer player = new AIPlayer(cards);
		assertTrue(player.isOneAwayFromRoyalFlush());
	}
	
	@Test
	void testOneAwayFromRoyalFlushFlushOff() {
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card("D10"));
		cards.add(new Card("DQ"));
		cards.add(new Card("DJ"));
		cards.add(new Card("DK"));
		cards.add(new Card("HA"));
		
		AIPlayer player = new AIPlayer(cards);
		assertTrue(player.isOneAwayFromRoyalFlush());
	}
	
	@Test
	void testOneAwayFromRoyalFlushBothOff() {
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card("D10"));
		cards.add(new Card("DJ"));
		cards.add(new Card("DQ"));
		cards.add(new Card("DK"));
		cards.add(new Card("H10"));
		
		AIPlayer player = new AIPlayer(cards);
		assertTrue(player.isOneAwayFromRoyalFlush());
	}
	
	@Test
	void testOneAwayFromRoyalFlushFail() {
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card("D10"));
		cards.add(new Card("DJ"));
		cards.add(new Card("HQ"));
		cards.add(new Card("DK"));
		cards.add(new Card("D8"));
		
		AIPlayer player = new AIPlayer(cards);
		assertFalse(player.isOneAwayFromRoyalFlush());
	}
	
	@Test
	void testExactThreeCardsSameSuit() {
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card("D10"));
		cards.add(new Card("DJ"));
		cards.add(new Card("HQ"));
		cards.add(new Card("DK"));
		cards.add(new Card("H8"));
		
		AIPlayer player = new AIPlayer(cards);
		assertTrue(player.hasExactThreeSameSuit());
	}
	
	@Test
	void testExactThreeCardsSameSuitFail() {
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card("D10"));
		cards.add(new Card("DJ"));
		cards.add(new Card("HQ"));
		cards.add(new Card("DK"));
		cards.add(new Card("D8"));
		
		AIPlayer player = new AIPlayer(cards);
		assertFalse(player.hasExactThreeSameSuit());
	}
	
	@Test
	void testExactThreeSameRank() {
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card("D10"));
		cards.add(new Card("H10"));
		cards.add(new Card("HQ"));
		cards.add(new Card("DK"));
		cards.add(new Card("S10"));
		
		AIPlayer player = new AIPlayer(cards);
		assertTrue(player.hasThreeOfAKind());
	}
	
	@Test
	void testExactThreeInSeq() {
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card("D10"));
		cards.add(new Card("HJ"));
		cards.add(new Card("HQ"));
		cards.add(new Card("D9"));
		cards.add(new Card("S10"));
		
		AIPlayer player = new AIPlayer(cards);
		assertTrue(player.hasThreeInSeq());
	}
	
	@Test
	void testExactThreeInSeqFail() {
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card("D10"));
		cards.add(new Card("HJ"));
		cards.add(new Card("HQ"));
		cards.add(new Card("DK"));
		cards.add(new Card("S10"));
		
		AIPlayer player = new AIPlayer(cards);
		assertFalse(player.hasThreeInSeq());
	}
	
	@Test
	void testFindTwoPair() {
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card("C10"));
		cards.add(new Card("SA"));
		cards.add(new Card("D10"));
		cards.add(new Card("DA"));
		cards.add(new Card("H5"));
		
		AIPlayer player = new AIPlayer(cards);
		assertTrue(player.hasTwoPairs());
	}
	
	@Test
	void testFindTwoPairsFalse() {
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card("C10"));
		cards.add(new Card("SA"));
		cards.add(new Card("D10"));
		cards.add(new Card("D9"));
		cards.add(new Card("H5"));
		
		AIPlayer player = new AIPlayer(cards);
		assertFalse(player.hasTwoPairs());
	}
	
	@Test
	void testFindPair() {
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card("C10"));
		cards.add(new Card("SA"));
		cards.add(new Card("D11"));
		cards.add(new Card("DA"));
		cards.add(new Card("H5"));
		
		AIPlayer player = new AIPlayer(cards);
		assertTrue(player.hasPair());
	}
	
	@Test
	void testFindPairFalse() {
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card("C10"));
		cards.add(new Card("SA"));
		cards.add(new Card("D11"));
		cards.add(new Card("D9"));
		cards.add(new Card("H5"));
		
		AIPlayer player = new AIPlayer(cards);
		assertFalse(player.hasPair());
	}
	
	@Test
	void testExchangeCards() {
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card("D10"));
		cards.add(new Card("DJ"));
		cards.add(new Card("DQ"));
		cards.add(new Card("DK"));
		cards.add(new Card("S8"));
		
		AIPlayer player = new AIPlayer(cards);
		int numExchanged = player.exchange();
		assertEquals(1, numExchanged);
		Deck deck = new Deck();
		ArrayList<Card> adding = new ArrayList<Card>(deck.drawMany(numExchanged));
		player.addCards(adding);
		assertEquals(5, player.getCards().size());
		assertFalse(player.getCards().contains(new Card("S8")));
		assertTrue(player.getCards().containsAll(adding));
	}
	
	@Test
	void testExchangeCardsNewHand() {
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card("D10"));
		cards.add(new Card("DJ"));
		cards.add(new Card("DQ"));
		cards.add(new Card("DK"));
		cards.add(new Card("S8"));
		
		
		
		AIPlayer player = new AIPlayer(cards);
		assertEquals(Hand.HIGH_CARD, player.getHighestHand());
		int numExchanged = player.exchange();
		assertEquals(1, numExchanged);
		
		ArrayList<Card> adding = new ArrayList<Card>();
		adding.add(new Card("DA"));
		player.addCards(adding);
		assertEquals(5, player.getCards().size());
		assertTrue(player.getCards().contains(new Card("DA")));
		assertEquals(Hand.ROYAL_FLUSH, player.getHighestHand());
	}

}
