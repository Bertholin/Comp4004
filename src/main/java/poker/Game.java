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

		min = getMin(h);

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

	public boolean threeInSequence(Hand h) {
		/*
		 * System.out.println("Inside of the three in sequence method");
		 * ArrayList<String> h2 = new ArrayList<String>(); String highest = ""; while
		 * (!h.hand.isEmpty()) { highest = highestCard(h);
		 * 
		 * for (int i = 0; i < h.size(); ++i) { if (h.get(i).equals(highest)) {
		 * h.remove(i); h2.add(0, highest); break; } } }
		 * 
		 * h.hand = h2; System.out.println("Sorted Hand " + h.printHand()); int counter
		 * = 0; String min = "", max = "";
		 * 
		 * if (h.getValue(h.get(0)) == 2) { for (int j = 1; j < h.size(); ++j) if
		 * (h.getValue(h.get(j)) == 14) { min = h.get(j); counter++; } }
		 * 
		 * for (int i = 0; i < h.size() - 1; ++i) { System.out.println("I is " + i +
		 * " and i+1 is " + (i+1) + " The difference is " + (h.getValue(h.get(i)) -
		 * h.getValue(h.get(i+1)))); if ((h.getValue(h.get(i)) - h.getValue(h.get(i -
		 * 1))) == -1) { System.out.println("The difference was one"); if(counter == 0)
		 * min = h.get(i); counter++;
		 * 
		 * if(counter == 2) max = h.get(i + 1); }
		 * 
		 * 
		 * 
		 * if (counter == 2) { System.out.print("The min is " + min + " and the max is "
		 * + max); return true; } }
		 */
		return false;
	}

	public String checkStrategy(Hand h) {
		System.out.println("----------  Strategy  ----------");
		if (isRoyalFlush(h) || isStraightFlush(h) || isFullHouse(h) || isFlush(h) || isStraight(h)) {
			System.out.println("The current had AIP hand is " + h.printHand());
			if (isRoyalFlush(h))
				System.out.println("-----   AIP has a Royal flush  -----");
			else if (isStraightFlush(h))
				System.out.println("-----   AIP has a Straight flush  -----");
			else if (isFullHouse(h))
				System.out.println("-----   AIP has a Full house  -----");
			else if (isFlush(h))
				System.out.println("-----   AIP has a Flush  -----");
			else if (isStraight(h))
				System.out.println("-----   AIP has a Straight -----");

			System.out.println("----- Hold -----\n");
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
			String s = "";
			for (int i = 0; i < h.size(); ++i) {
				if (!h.getSuit(h.get(i)).equals(suit)) {
					System.out.println("The card being removed is " + h.get(i));
					h.remove(i);
					s = deck.draw();
					System.out.println("The card being added is " + h.get(i));
					h.add(i, s);
				}
			}

			System.out.println("The AIP hand after swapping is " + h.printHand());

			// need to find out what card doesn't have the same suit and swap them

			return "3Suits";
		} else if (ofAKind(h, 3)) {
			System.out.println("The current had AIP hand is " + h.printHand());
			int val = findValueOfAKind(h, 3);
			System.out.println("The three same ranks are " + val);

			String s = "";
			for (int i = 0; i < h.size(); ++i) {
				if (h.getValue(h.get(i)) != val) {
					System.out.println("The card being removed is " + h.get(i));
					h.remove(i);
					s = deck.draw();
					System.out.println("The card being added is " + s);
					h.add(i, s);
				}
			}

			// need to find out what card doesn't have the same ranks and swap them
			System.out.println("The AIP hand after swapping is " + h.printHand());
			return "3Ranks";
		} else if (threeInSequence(h)) {
			System.out.println("The current had AIP hand is " + h.printHand());

			System.out.println("\n ------------- Do Something ----------------");

			// need to find out what card doesn't have the same ranks and swap them
			System.out.println("The AIP hand after swapping is " + h.printHand());
			return "3Seq";
		} else if (isTwoPair(h)) {
			System.out.println("The current had AIP hand is " + h.printHand());
			int firstPair = findValueOfAKind(h, 2);
			System.out.println("The value of the first pair is " + firstPair);
			int count = 0;
			int num = 0;

			while (count < 2) {
				if (h.getValue(h.get(num)) == firstPair) {
					String s = h.get(num);
					h.remove(num);
					h.add(s);
					num = 0;
					count++;

					if (count == 2)
						break;
				}
				++num;
			}

			int otherPair = findValueOfAKind(h, 2);
			System.out.println("The value of the second pair is " + otherPair);

			String s = "";
			for (int i = 0; i < h.size(); ++i) {
				if (h.getValue(h.get(i)) != firstPair && h.getValue(h.get(i)) != otherPair) {
					System.out.println("The card being removed is " + h.get(i));
					h.remove(i);
					s = deck.draw();
					System.out.println("The card being added is " + s);
					h.add(s);
				}
			}

			System.out.println("The AIP hand after swapping is " + h.printHand());
			return "2Pair";
		} else if (ofAKind(h, 2)) {
			System.out.println("The current had AIP hand is " + h.printHand());
			int val = findValueOfAKind(h, 2);
			System.out.println("The value of the pair is " + val);

			for (int i = 0; i < h.size(); ++i) {
				if (h.getValue(h.get(i)) != val) {
					System.out.println("The card being removed is " + h.get(i));
					h.remove(i);
					String s = deck.draw();
					System.out.println("The card being added is " + s);
					h.add(i, s);
				}
			}
			System.out.println("The AIP hand after swapping is " + h.printHand());
			return "1Pair";
		} else {
			System.out.println("The current had AIP hand is " + h.printHand());
			String highest = highestCard(h);

			for (int i = 0; i < h.size(); ++i) {
				if (h.get(i).equals(highest)) {
					h.remove(i);
					break;
				}
			}

			String second = highestCard(h);
			h.add(highest);

			System.out.println("The two highest cards are " + highest + " and " + second);
			String s = "";
			for (int i = 0; i < h.size(); ++i) {
				if (!((h.get(i) != highest && h.get(i) == second) || (h.get(i) == highest && h.get(i) != second))) {
					System.out.println("The card being removed is " + h.get(i));
					h.remove(i);
					s = deck.draw();
					System.out.println("The card being added is " + s);
					h.add(i, s);
				}
			}

			System.out.println("The AIP hand after swapping is " + h.printHand());
			return "2High";
		}
	}

	public int score(Hand h) {
		if (isRoyalFlush(h))
			return 100;
		else if (isStraightFlush(h))
			return 90;
		else if (ofAKind(h, 4))
			return 80;
		else if (isFullHouse(h))
			return 70;
		else if (isFlush(h))
			return 60;
		else if (isStraight(h))
			return 50;
		else if (ofAKind(h, 3))
			return 40;
		else if (isTwoPair(h))
			return 30;
		else if (ofAKind(h, 2))
			return 20;
		else
			return 10;
	}
	
	public String checkWinner(Hand player, Hand AI) {
		String winner = "";
		
		if(score(player) > score(AI))
			winner = "Player";
		else if (score(player) < score(AI))
			winner = "AI";
		else
			winner = "Tie";
		
		return winner;
	}
}