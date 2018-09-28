package poker;

import junit.framework.TestCase;

public class GameTest extends TestCase{
	public void testFlush() {
		Game game = new Game();
		Deck d = new Deck();
		d.openFile("flushtest.txt");
		
		game.hand.add(d.draw());
		game.hand.add(d.draw());
		game.hand.add(d.draw());
		game.hand.add(d.draw());
		game.hand.add(d.draw());
		assertEquals(false, game.isFlush(game.hand));
		
		game.AIHand.add(d.draw());
		game.AIHand.add(d.draw());
		game.AIHand.add(d.draw());
		game.AIHand.add(d.draw());
		game.AIHand.add(d.draw());
		assertEquals(false, game.isFlush(game.hand));
		
		game.hand.removeAll();
		game.AIHand.removeAll();
		
		game.hand.add(d.draw());
		game.hand.add(d.draw());
		game.hand.add(d.draw());
		game.hand.add(d.draw());
		game.hand.add(d.draw());
		assertEquals(false, game.isFlush(game.hand));
		
		game.AIHand.add(d.draw());
		game.AIHand.add(d.draw());
		game.AIHand.add(d.draw());
		game.AIHand.add(d.draw());
		game.AIHand.add(d.draw());
		assertEquals(true, game.isFlush(game.hand));

	}
	
	public void testHighCard() {
		
	}
	
	public void testFourOfAKind() {
		
	}
	
	public void testThreeOfAKind() {
		
	}
	
	
	
	public void testStraight() {
		
	}
} 
