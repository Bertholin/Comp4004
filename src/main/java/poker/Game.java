package poker;

import java.util.*;

public class Game {

	Hand hand = new Hand();
	Hand AIHand = new Hand();
	Deck deck = new Deck();

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
			for (int j = 0; j < h.size(); ++j) {
				if (h.getValue(h.get(i)) == h.getValue(h.get(j)))
					counter++;

				if (counter == amount) {
					return true;
				}
			}
		}
		return false;
	}

	public int findValueOfAKind(Hand h, int amount) {
		int counter = 0;
		int val = 0;
		for (int i = 0; i < 5; ++i) {
			counter = 0;
			for (int j = 0; j < h.size(); ++j) {
				if (h.getValue(h.get(i)) == h.getValue(h.get(j))) {
					counter++;
					val = h.getValue(h.get(i));
				}

				if (counter == amount) {
					return val;
				}
			}
		}
		return -1;
	}

	public boolean isStraight(Hand h) {
		int min = h.getValue(h.get(0));
		int counter = 0;

		for (int i = 1; i < h.size(); ++i)
			if (min > h.getValue(h.get(i))) {
				min = h.getValue(h.get(i));
			}

		if (min == 2) {
			for (int i = 1; i < h.size(); ++i)
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

	public boolean isStraightFlush(Hand h) {
		return (isStraight(h) && isFlush(h));
	}

	public boolean isRoyalFlush(Hand h) {
		int min = h.getValue(h.get(0));
		for (int i = 1; i < h.size(); ++i)
			if (min > h.getValue(h.get(i))) {
				min = h.getValue(h.get(i));
			}

		if (min == 10) {
			return (isStraight(h) && isFlush(h));
		}

		return (false && isFlush(h));
	}

	public boolean isTwoPair(Hand h) {

		if (ofAKind(h, 2)) {
			int pair = findValueOfAKind(h, 2);

			int counter = 0;
			for (int i = 0; i < h.size(); ++i) {
				counter = 0;
				for (int j = 0; j < h.size(); ++j) {
					if (pair != h.getValue(h.get(i)))
						if (h.getValue(h.get(i)) == h.getValue(h.get(j)))
							counter++;

					if (counter == 2) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public boolean isFullHouse(Hand h) {

		if (ofAKind(h, 3)) {
			int pair = findValueOfAKind(h, 3);

			int counter = 0;
			for (int i = 0; i < h.size(); ++i) {
				counter = 0;
				for (int j = 0; j < h.size(); ++j) {
					if (pair != h.getValue(h.get(i)))
						if (h.getValue(h.get(i)) == h.getValue(h.get(j)))
							counter++;

					if (counter == 2) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public boolean oneAway(Hand h) {

		return false;
	}

	public String findSuitOfAKind(Hand h, int amount) {
		int counter = 0;
		String suit = "";
		for (int i = 0; i < 5; ++i) {
			counter = 0;
			for (int j = 0; j < h.size(); ++j) {
				if (h.getSuit(h.get(i)).equals(h.getSuit(h.get(j)))) {
					counter++;
					suit = h.getSuit(h.get(i));
				}

				if (counter == amount) {
					return suit;
				}
			}
		}
		return "";
	}

	public boolean threeSameSuit(Hand h, int amount) {
		int counter = 0;
		for (int i = 0; i < 5; ++i) {
			counter = 0;
			for (int j = 0; j < h.size(); ++j) {
				if (h.getSuit(h.get(i)).equals(h.getSuit(h.get(j)))) {
					counter++;
				}

				if (counter == amount) {
					return true;
				}
			}
		}
		return false;
	}

	public int getMin(Hand h) {
		int min = h.getValue(h.get(0));
		for (int i = 1; i < h.size(); ++i)
			if (min > h.getValue(h.get(i))) {
				min = h.getValue(h.get(i));
			}

		return min;
	}

	public boolean threeInSequence(Hand h, int amount) {
		/*ystem.out.println("\n\n\n ------------------------------------------------------");
		System.out.println("In 3 card in sequence");
		int counter = 0;
		int num = 0;

		for (int i = 0; i < 5; ++i) {
			System.out.println("The value of i is " + h.getValue(h.get(i)));
			num = h.getValue(h.get(i));
			for (int j = 0; j < 5; ++j) {
				if (num == h.getValue(h.get(j))) {
					System.out.println("The value of j is " + h.getValue(h.get(j)));
					counter++;
				}
			}
		}

		System.out.println("The final value of count is : " + counter);
		if (counter == amount)
			return true;
*/
		return false;
	}

	public String checkStrategy(Hand h) {
		System.out.println("----------  Strategy  ----------");
		if (isRoyalFlush(h) || isStraightFlush(h) || isFullHouse(h) || isFlush(h) || isStraight(h)) {
			System.out.println("The current had AIP hand is " + h.printHand());
			if (isRoyalFlush(h))
				System.out.println("-----   AIP has a Royal flush  -----\n");
			else if (isStraightFlush(h))
				System.out.println("-----   AIP has a Straight flush  -----\n");
			else if (isFullHouse(h))
				System.out.println("-----   AIP has a Full house  -----\n");
			else if (isFlush(h))
				System.out.println("-----   AIP has a Flush  -----\n");
			else if (isStraight(h))
				System.out.println("-----   AIP has a Straight -----\n");

			return "hold";
		} else if (oneAway(h)) {
			// still need to code that

			return "oneAway";
		} else if (threeSameSuit(h, 3)) {
			System.out.println("The current had AIP hand is " + h.printHand());
			String suit = findSuitOfAKind(h, 3);
			System.out.println("The three same suits are " + suit);

			// check to find the other two cars that don't have the same suit and replaces
			// them
			for (int i = 0; i < h.size(); ++i) {
				if (!h.getSuit(h.get(i)).equals(suit)) {
					h.remove(i);
					h.add(i, deck.draw());
				}
			}

			System.out.println("The AIP hand after swapping is " + h.printHand());

			// need to find out what card doesn't have the same suit and swap them

			return "3Suits";
		} else if (ofAKind(h, 3)) {
			System.out.println("The current had AIP hand is " + h.printHand());
			int val = findValueOfAKind(h, 3);
			System.out.println("The three same ranks are " + val);

			for (int i = 0; i < h.size(); ++i) {
				if (h.getValue(h.get(i)) != val) {
					h.remove(i);
					h.add(i, deck.draw());
				}
			}

			// need to find out what card doesn't have the same ranks and swap them
			System.out.println("The AIP hand after swapping is " + h.printHand());
			return "3Ranks";
		} else if (threeInSequence(h, 3)) {
			System.out.println("The current had AIP hand is " + h.printHand());
			
			
			System.out.println("\n ------------- Do Something ----------------");
			
			// need to find out what card doesn't have the same ranks and swap them
			System.out.println("The AIP hand after swapping is " + h.printHand());
			return "3Seq";
		} else if (false) {
			return "2Pair";
		} else if (false) {
			return "1Pair";
		} else {
			return "2High";
		}
	}
}