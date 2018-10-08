package poker;

import junit.framework.TestCase;

public class GameTest extends TestCase {
	public void testFlush() {
		Game game = new Game();
		Deck d = new Deck();
		d.openFile("flushtest.txt");

		// testing for flush with first invalid
		game.hand.add(d.draw());
		game.hand.add(d.draw());
		game.hand.add(d.draw());
		game.hand.add(d.draw());
		game.hand.add(d.draw());
		assertEquals(false, game.isFlush(game.hand));

		// testing for flush with last invalid
		game.AIHand.add(d.draw());
		game.AIHand.add(d.draw());
		game.AIHand.add(d.draw());
		game.AIHand.add(d.draw());
		game.AIHand.add(d.draw());
		assertEquals(false, game.isFlush(game.AIHand));

		game.hand.removeAll();
		game.AIHand.removeAll();

		// testing for flush with a middle invalid
		game.hand.add(d.draw());
		game.hand.add(d.draw());
		game.hand.add(d.draw());
		game.hand.add(d.draw());
		game.hand.add(d.draw());
		assertEquals(false, game.isFlush(game.hand));

		// testing for flush with valid cards
		game.AIHand.add(d.draw());
		game.AIHand.add(d.draw());
		game.AIHand.add(d.draw());
		game.AIHand.add(d.draw());
		game.AIHand.add(d.draw());
		assertEquals(true, game.isFlush(game.AIHand));

	}

	public void testHighCard() {
		Game game = new Game();
		Deck d = new Deck();
		d.openFile("highCard.txt");

		// middle
		game.hand.add(d.draw());
		game.hand.add(d.draw());
		game.hand.add(d.draw());
		game.hand.add(d.draw());
		game.hand.add(d.draw());
		assertEquals("D9", game.highestCard(game.hand));

		// first
		game.AIHand.add(d.draw());
		game.AIHand.add(d.draw());
		game.AIHand.add(d.draw());
		game.AIHand.add(d.draw());
		game.AIHand.add(d.draw());
		assertEquals("SJ", game.highestCard(game.AIHand));

		game.hand.removeAll();
		game.AIHand.removeAll();

		// highest card last
		game.hand.add(d.draw());
		game.hand.add(d.draw());
		game.hand.add(d.draw());
		game.hand.add(d.draw());
		game.hand.add(d.draw());
		assertEquals("D10", game.highestCard(game.hand));

		// multiple high cards gets results based on suit
		game.AIHand.add(d.draw());
		game.AIHand.add(d.draw());
		game.AIHand.add(d.draw());
		game.AIHand.add(d.draw());
		game.AIHand.add(d.draw());
		assertEquals("SK", game.highestCard(game.AIHand));

	}

	public void testFourOfAKind() {
		Game game = new Game();
		Deck d = new Deck();
		d.openFile("fourOfAKind.txt");

		// first 4 are the same
		for (int i = 0; i < 5; ++i)
			game.hand.add(d.draw());

		assertEquals(true, game.ofAKind(game.hand, 4));
		game.hand.removeAll();

		// last 4 are the same
		for (int i = 0; i < 5; ++i)
			game.hand.add(d.draw());

		assertEquals(true, game.ofAKind(game.hand, 4));
		game.hand.removeAll();

		// there are only three in common
		for (int i = 0; i < 5; ++i)
			game.hand.add(d.draw());

		assertEquals(false, game.ofAKind(game.hand, 4));

	}

	public void testThreeOfAKind() {
		Game game = new Game();
		Deck d = new Deck();
		d.openFile("threeOfAKind.txt");

		// first three are the same
		for (int i = 0; i < 5; ++i)
			game.hand.add(d.draw());

		assertEquals(true, game.ofAKind(game.hand, 3));
		game.hand.removeAll();

		// last three are the same
		for (int i = 0; i < 5; ++i)
			game.hand.add(d.draw());

		assertEquals(true, game.ofAKind(game.hand, 3));
		game.hand.removeAll();

		// there are only two in common
		for (int i = 0; i < 5; ++i)
			game.hand.add(d.draw());

		assertEquals(false, game.ofAKind(game.hand, 3));

	}

	public void testPair() {
		Game game = new Game();
		Deck d = new Deck();
		d.openFile("pair.txt");

		// first 2 are the same
		for (int i = 0; i < 5; ++i)
			game.hand.add(d.draw());

		assertEquals(true, game.ofAKind(game.hand, 2));
		game.hand.removeAll();

		// last and random are the same
		for (int i = 0; i < 5; ++i)
			game.hand.add(d.draw());

		assertEquals(true, game.ofAKind(game.hand, 2));
		game.hand.removeAll();

		// Nothing the same
		for (int i = 0; i < 5; ++i)
			game.hand.add(d.draw());

		assertEquals(false, game.ofAKind(game.hand, 2));
	}

	public void testStraight() {
		Game game = new Game();
		Deck d = new Deck();
		d.openFile("straight.txt");

		for (int i = 0; i < 5; ++i)
			game.hand.add(d.draw());
		assertEquals(true, game.isStraight(game.hand));

		game.hand.removeAll();
		for (int i = 0; i < 5; ++i)
			game.hand.add(d.draw());
		assertEquals(true, game.isStraight(game.hand));

		game.hand.removeAll();
		for (int i = 0; i < 5; ++i)
			game.hand.add(d.draw());
		assertEquals(false, game.isStraight(game.hand));
	}

	public void testStraightFlush() {
		Game game = new Game();
		Deck d = new Deck();
		d.openFile("straightFlush.txt");

		// flush
		for (int i = 0; i < 5; ++i)
			game.hand.add(d.draw());
		assertEquals(false, game.isStraightFlush(game.hand));
		game.hand.removeAll();

		// straight
		for (int i = 0; i < 5; ++i)
			game.hand.add(d.draw());
		assertEquals(false, game.isStraightFlush(game.hand));
		game.hand.removeAll();

		// straight flush
		for (int i = 0; i < 5; ++i)
			game.hand.add(d.draw());
		assertEquals(true, game.isStraightFlush(game.hand));
	}

	public void testRoyalFlush() {
		Game game = new Game();
		Deck d = new Deck();
		d.openFile("royalFlush.txt");

		// test Royal
		for (int i = 0; i < 5; ++i)
			game.hand.add(d.draw());
		assertEquals(false, game.isRoyalFlush(game.hand));
		game.hand.removeAll();

		// flush
		for (int i = 0; i < 5; ++i)
			game.hand.add(d.draw());
		assertEquals(false, game.isRoyalFlush(game.hand));
		game.hand.removeAll();

		// Royal flush
		for (int i = 0; i < 5; ++i)
			game.hand.add(d.draw());

		assertEquals(true, game.isRoyalFlush(game.hand));
	}

	public void testTwoPair() {
		Game game = new Game();
		Deck d = new Deck();
		d.openFile("twoPair.txt");

		// test one pair
		for (int i = 0; i < 5; ++i)
			game.hand.add(d.draw());
		assertEquals(false, game.isTwoPair(game.hand));
		game.hand.removeAll();

		// two pairs
		for (int i = 0; i < 5; ++i)
			game.hand.add(d.draw());
		assertEquals(true, game.isTwoPair(game.hand));
		game.hand.removeAll();
	}
	
	
	public void testFullHouse() {
		Game game = new Game();
		Deck d = new Deck();
		d.openFile("fullHouse.txt");

		// test just three of a kind
		for (int i = 0; i < 5; ++i)
			game.hand.add(d.draw());
		assertEquals(false, game.isFullHouse(game.hand));
		game.hand.removeAll();

		// test just pair
		for (int i = 0; i < 5; ++i)
			game.hand.add(d.draw());
		assertEquals(false, game.isFullHouse(game.hand));
		game.hand.removeAll();
		
		// test just full house
		for (int i = 0; i < 5; ++i)
			game.hand.add(d.draw());
		assertEquals(true, game.isFullHouse(game.hand));
	}
}
