package poker;

public class Game {

	Hand hand = new Hand();
	Hand AIHand = new Hand();

	public boolean isFlush(Hand hand) {
		String type = hand.getSuit(hand.get(0));
		boolean flush = true;

		for (int i = 1; i < hand.size(); ++i) {
			if (type.equals(hand.getSuit(hand.get(i)))) {
				flush = true;
			} else {
				flush = false;
				break;
			}
		}
		return flush;
	}
	
	public String highestCard(Hand h) {
		String highest = h.get(0);
		
		for (int i = 0; i < h.size() - 1; ++i) {
			if(h.getValue(h.get(i)) < h.getValue(h.get(i + 1))) {
				highest = h.get(i + 1);
			}else if (h.getValue(h.get(i)) == h.getValue(h.get(i + 1))) {
				// 
				System.out.println("There were two high cards");
			}
		}
		
		
		return highest;
	}
}
