package core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

import java.util.*;

public class GameTest {
	
	@Test
	void testEvalFunctionDelegatesCardsToAIP() {
		Game game = new Game();
		game.evaluate("S10 SJ SQ SK SA H10 HJ HQ HK HA");
		ArrayList<Card> AICards = game.getAICards();
		assertTrue(AICards.contains(new Card("H10")));
		assertTrue(AICards.contains(new Card("HJ")));
		assertTrue(AICards.contains(new Card("HQ")));
		assertTrue(AICards.contains(new Card("HK")));
		assertTrue(AICards.contains(new Card("HA")));
	}
	
	@Test
	void testEvalFunctionHoldsCardsToBeat() {
		Game game = new Game();
		game.evaluate("S10 SJ SQ SK SA H10 HJ HQ HK HA");
		ArrayList<Card> cardsToBeat = game.getCardsToBeat();
		assertTrue(cardsToBeat.contains(new Card("S10")));
		assertTrue(cardsToBeat.contains(new Card("SJ")));
		assertTrue(cardsToBeat.contains(new Card("SQ")));
		assertTrue(cardsToBeat.contains(new Card("SK")));
		assertTrue(cardsToBeat.contains(new Card("SA")));
	}
	
	@Test
	void testFileStartsGame() {
		Game game = new Game();
		game.init();
		AIPlayer aip = game.getAIP();
		Player beat = game.getHandToBeat();
		assertTrue(aip != null);
		assertTrue(beat != null);
	}
	
	@Test
	void testFileStartsGamePrints() {
		Game game = new Game();
		game.evaluate("S10 SJ SQ SK SA H10 HJ HQ HK HA");
		game.printGame();
	}
	
	@Test
	void testAIPExchangesCards() {
		Game game = new Game();
		game.evaluate("S10 SJ SQ SK SA H10 HJ HQ HK D8");
		ArrayList<Card> initial = game.getAICards();
		game.exchange();
		assertEquals(1, game.getNumExchanged());
		assertFalse(game.getAICards().contains(new Card("D8")));
		assertTrue(game.getAICards().containsAll(game.getDrawnCards()));
	}
	
	@Test
	void testFindWinnerSimple() {
		Game game = new Game();
		game.evaluate("S10 SJ SQ SK SA H10 HJ HQ HK D8");
		game.findWinner();
		assertFalse(game.AIPWon());
	}
	
	@Test
	void testFindWinnerSimpleV2() {
		Game game = new Game();
		game.evaluate("S10 SJ SQ SK SA H10 HJ H4 HK D8");
		game.findWinner();
		assertFalse(game.AIPWon());
	}
	
	@Test
	void testFindWinnerSimpleV3() {
		Game game = new Game();
		game.evaluate("H10 HJ H4 HK D8 S10 SJ SQ SK SA");
		game.findWinner();
		assertTrue(game.AIPWon());
	}
	
}
