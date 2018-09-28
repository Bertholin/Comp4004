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
		assertEquals(false, game.isFlush(game.hand));
		
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
		assertEquals(true, game.isFlush(game.hand));

	}
	
	public void testHighCard() {
		String highest = ""; 
		
		
	}
	
	public void testFourOfAKind() {
		
	}
	
	public void testThreeOfAKind() {
		
	}
	
	
	
	public void testStraight() {
		
	}
} 
