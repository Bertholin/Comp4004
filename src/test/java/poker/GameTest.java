package poker;

import junit.framework.TestCase;

public class GameTest extends TestCase{
	public void testFlush() {
		Game game = new Game();
		Deck d = new Deck();
		d.openFile("flushtest.txt");
		
		//testing for flush with first invalid
		game.hand.add(d.draw());
		game.hand.add(d.draw());
		game.hand.add(d.draw());
		game.hand.add(d.draw());
		game.hand.add(d.draw());
		assertEquals(false, game.isFlush(game.hand));
		
		//testing for flush with last invalid
		game.AIHand.add(d.draw());
		game.AIHand.add(d.draw());
		game.AIHand.add(d.draw());
		game.AIHand.add(d.draw());
		game.AIHand.add(d.draw());
		assertEquals(false, game.isFlush(game.AIHand));
		
		game.hand.removeAll();
		game.AIHand.removeAll();
		
		//testing for flush with a middle invalid
		game.hand.add(d.draw());
		game.hand.add(d.draw());
		game.hand.add(d.draw());
		game.hand.add(d.draw());
		game.hand.add(d.draw());
		assertEquals(false, game.isFlush(game.hand));
		
		//testing for flush with valid cards
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
		
		//middle
		game.hand.add(d.draw());
		game.hand.add(d.draw());
		game.hand.add(d.draw());
		game.hand.add(d.draw());
		game.hand.add(d.draw());
		assertEquals("D9", game.highestCard(game.hand));
		
		//first
		game.AIHand.add(d.draw());
		game.AIHand.add(d.draw());
		game.AIHand.add(d.draw());
		game.AIHand.add(d.draw());
		game.AIHand.add(d.draw());
		assertEquals("SJ", game.highestCard(game.AIHand));
		
		game.hand.removeAll();
		game.AIHand.removeAll();
		
		System.out.println("\nPart 3");
		//highest card last
		game.hand.add(d.draw());
		game.hand.add(d.draw());
		game.hand.add(d.draw());
		game.hand.add(d.draw());
		game.hand.add(d.draw());
		assertEquals("D10", game.highestCard(game.hand));
		
		//multiple high cards gets results based on suit
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
		
		//first 4 are the same
		for( int i = 0; i < 5; ++i)
			game.hand.add(d.draw());
		
		assertEquals(true, game.ofAKind(game.hand, 4));
		game.hand.removeAll();
		
		//last 4 are the same
		System.out.println("\nPart 2");
		for( int i = 0; i < 5; ++i)
			game.hand.add(d.draw());
		
		assertEquals(true, game.ofAKind(game.hand, 4));
		game.hand.removeAll();
		
		//there are only three in common
		System.out.println("\nPart 3");
		for( int i = 0; i < 5; ++i)
			game.hand.add(d.draw());
		
		assertEquals(false, game.ofAKind(game.hand, 4));
		
	}
	
	public void testThreeOfAKind() {
			Game game = new Game();
			Deck d = new Deck();
			d.openFile("threeOfAKind.txt");
			
			//first three are the same
			for( int i = 0; i < 5; ++i)
				game.hand.add(d.draw());
			
			assertEquals(true, game.ofAKind(game.hand, 3));
			game.hand.removeAll();
			
			//last three are the same
			for( int i = 0; i < 5; ++i)
				game.hand.add(d.draw());
			
			assertEquals(true, game.ofAKind(game.hand, 3));
			game.hand.removeAll();
			
			//there are only two in common
			for( int i = 0; i < 5; ++i)
				game.hand.add(d.draw());
			
			assertEquals(false, game.ofAKind(game.hand, 3));
	
	}
	
	
	
	public void testStraight() {
		
	}
} 
