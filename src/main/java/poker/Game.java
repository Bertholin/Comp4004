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
		
		for (int i = 1; i < h.size(); i++) {
			System.out.println("The current highest is " + highest);
			System.out.println("The next card is " + h.get(i));
			if(h.getValue(highest) < h.getValue(h.get(i))) {
				highest = h.get(i);
			}else if (h.getValue(highest) == h.getValue(h.get(i))) {
				// 
				System.out.println("There were two high cards");
			}
		}
		
		
		return highest;
	}
}
