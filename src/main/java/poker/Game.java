package poker;

import java.util.*;

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
			if (h.getValue(highest) < h.getValue(h.get(i))) {
				highest = h.get(i);
			} else if (h.getValue(highest) == h.getValue(h.get(i))) {
				// S H D C -> highest to lowest
				if (h.getSuit(h.get(i)).equals("S") || h.getSuit(highest).equals("S")) {
					// if highest was a spade
					if (h.getSuit(h.get(i)).equals("S")) {
						highest = h.get(i);
					}
				} else if (h.getSuit(h.get(i)).equals("H") || h.getSuit(highest).equals("H")) {
					// if highest was a Heart
					if (h.getSuit(h.get(i)).equals("H")) {
						highest = h.get(i);
					}
				} else if (h.getSuit(h.get(i)).equals("D") || h.getSuit(highest).equals("D")) {
					// if highest was a Diamond
					if (h.getSuit(h.get(i)).equals("D")) {
						highest = h.get(i);
					}
				}
			}
		}

		return highest;
	}

	public boolean ofAKind(Hand h, int amount) {
		int counter = 0;
		for (int i = 0; i < 5; ++i) {
			counter = 0;
			for (int j = 0; j < 5; ++j) {
				if (h.getValue(h.get(i)) == h.getValue(h.get(j)))
					counter++;

				if (counter == amount) {
					return true;
					}
			}
		}
		return false;
	}
	
	public boolean isStraight(Hand h) {
		int min = h.getValue(h.get(0));
		int counter = 0;
		
		for( int i = 1; i < h.size(); ++i) 
			if (min > h.getValue(h.get(i))) {
				min = h.getValue(h.get(i));
			}
		
		if (min == 2) {
			for( int i = 1; i < h.size(); ++i) 
				if (h.getValue(h.get(i)) == 14) {
					counter++;
				}
		}
		
		for (int i = 0; i < 5; ++i) {
			for (int j = 0; j < 5; ++j) {
				if (min == h.getValue(h.get(j))) {
					counter++;
					min++;
				}
			}
		}
		
		if (counter == 5)
			return true;
		
		
		return false;
	}
}
