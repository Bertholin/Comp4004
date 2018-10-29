package core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;


public class SuitTest {

	@Test
	void testWeights() {
		assertEquals(1, Suit.CLUBS.getWeight());
		assertEquals(2, Suit.DIAMONDS.getWeight());
		assertEquals(3, Suit.HEARTS.getWeight());
		assertEquals(4, Suit.SPADES.getWeight());
	}
	
}
