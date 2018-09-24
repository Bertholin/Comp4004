package poker;

import java.util.*;

public class Hand {
	ArrayList<String> hand = new ArrayList<String>();

	public int size() {
		return hand.size();
	}

	public void add(int i, String val) {
		hand.add(i, val);
	}

	public void add(String val) {
		hand.add(val);
	}

	public String get(int num) {
		return hand.get(num);
	}

	public void remove(int i) {
		hand.remove(i);
	}

	public void removeAll() {
		hand.clear();
	}

	public boolean validHand(Hand h) {
		if (h.size() == 5)
			return true;
		return false;
	}

	public String getSuit(String s) {

		return s.substring(0, 1);
	}

	public int getValue(String s) {
		String val = s.substring(1);

		if (val.equals("A")) {
			return 14;
		} else if (val.equals("K")) {
			return 13;
		} else if (val.equals("Q")) {
			return 12;
		} else if (val.equals("J")) {
			return 11;
		} else {
			return Integer.parseInt(val);
		}
	}

}

// for multiple cards maybe use a dictionary
// dictionary (ace , 1)