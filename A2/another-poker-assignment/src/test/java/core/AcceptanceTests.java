package core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.io.*;
import java.util.*;

public class AcceptanceTests {

	@ParameterizedTest
	@CsvFileSource(resources = "winTests.csv")
	void testWinConditions(String input, int OppWon) {
		Game game = new Game();
		game.playWithoutExchange(input);
		
		boolean opp = false;
		if (OppWon > 0) {
			opp = true;
		}
		assertEquals(opp, !(game.AIPWon()));
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "exchangeTests.csv")
	void testExchanges(String input, int numExchange) {
		Game game = new Game();
		game.play(input);
		assertEquals(numExchange, game.getNumExchanged());
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "simpleWinning.csv")
	void testSimpleWinning(String input, int win) {
		Game game = new Game();
		game.playWithoutExchange(input);
		boolean Aiw = (win>0);
		assertEquals(Aiw, game.AIPWon());
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "tieWinning.csv")
	void testTieWinning(String input, int win) {
		Game game = new Game();
		game.playWithoutExchange(input);
		boolean Aiw = (win>0);
		assertEquals(Aiw, game.AIPWon());
	}
}
