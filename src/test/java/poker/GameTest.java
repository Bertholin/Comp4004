package poker;

public class GameTest {
	public void testFiveOfAKind() {
		
	}
	
	public void testFourOfAKind() {
		
	}
	
	public void testThreeOfAKind() {
		
	}
	
	public void testFlush() {
		Game game = new Game();
		game.hand.add("CJ");
		game.hand.add("D1");
		game.hand.add("D9");
		game.hand.add("D7");
		game.hand.add("D3");
		assertEquals(false, game.isFlush(game.hand));
		
		game.AIHand.add("SQ");
		game.AIHand.add("S3");
		game.AIHand.add("S4");
		game.AIHand.add("S6");
		game.AIHand.add("HA");
		assertEquals(false, game.isFlush(game.hand));
		
		game.hand.removeAll();
		game.AIHand.removeAll();
		
		game.hand.add("HK");
		game.hand.add("H4");
		game.hand.add("S10");
		game.hand.add("H6");
		game.hand.add("H7");
		assertEquals(false, game.isFlush(game.hand));
		
		game.AIHand.add("D8");
		game.AIHand.add("D5");
		game.AIHand.add("D1");
		game.AIHand.add("DK");
		game.AIHand.add("DJ");
		assertEquals(true, game.isFlush(game.hand));
		
		
	}
	
	public void testStraight() {
		
	}
} 
