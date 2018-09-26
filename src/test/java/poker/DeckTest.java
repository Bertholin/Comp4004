package poker;

public class DeckTest {
	public void testopenFile() {
		Hand hand = new Hand();
		assertEquals(true, hand.file.openFile("cards.txt"));
	}

	public void testCloseFile() {
		Hand hand = new Hand();
		assertEquals(true, hand.file.closeFile("cards.txt"));
	}

	public void testDraw() {
		Hand hand = new Hand();
		hand.file.openFile("cards.txt");

		hand.add(hand.draw());
		hand.add(hand.draw());
		hand.add(hand.draw());

		assertEquals(3, hand.size());
		hand.file.close("cards.txt");
	}
}
