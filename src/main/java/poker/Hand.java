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
	
}
