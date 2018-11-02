package core;

import java.util.*;

public class Player {

	Hand highestHand = Hand.HIGH_CARD;
	public ArrayList<Card> cards = new ArrayList<Card>();
	
	int numPairs = 0;
	boolean three_of_kind = false;
	boolean four_of_kind = false;
	int tripRank = 0;
	boolean in_seq = false;
	boolean same_suit = false;
	
	public ArrayList<Card> getCards(){
		return cards;
	}
	public Hand getHighestHand() {
		return highestHand;
	}
	public boolean isInSeq() {
		return in_seq;
	}
	public int getNumPairs() {
		return numPairs;
	}
	public boolean hasThreeOfAKind() {
		return three_of_kind;
	}
	public boolean hasFourOfAKind() {
		return four_of_kind;
	}
	
	public Player(ArrayList<Card> c) {
		cards = new ArrayList<Card>(c);
		
		orderCards();
		findHighestHand();
	}
	
	public void orderCards() {
		int n = cards.size();
		for (int i=0; i<n-1; i++) {
			for (int j=0; j < n-i-1; j++) {
				if (cards.get(j).getRank() > cards.get(j+1).getRank()) {
					Card tmp = cards.get(j);
					cards.set(j, cards.get(j+1));
					cards.set(j+1, tmp);
				}
				else if (cards.get(j).getRank() == cards.get(j+1).getRank()) {
					if (cards.get(j).getSuit().getWeight() > cards.get(j+1).getSuit().getWeight()) {
						Card tmp = cards.get(j);
						cards.set(j, cards.get(j+1));
						cards.set(j+1, tmp);
					}
				}
			}
		}
	}
	
	void findHighestHand() {
		findSeq();
		findFourAndThree();
		findPairs();
		findSameSuit();
		
		if (in_seq && same_suit) {
			if (cards.get(0).getRank() == 10) {
				highestHand = Hand.ROYAL_FLUSH;
			}
			else {
				highestHand = Hand.STRAIGHT_FLUSH;
			}
		}
		else if (four_of_kind) {
			highestHand = Hand.FOUR_OF_A_KIND;
		}
		else if (three_of_kind && numPairs == 1) {
			highestHand = Hand.FULL_HOUSE;
		}
		else if (same_suit){
			highestHand = Hand.FLUSH;
		}
		else if (in_seq) {
			highestHand = Hand.STRAIGHT;
		}
		else if (three_of_kind) {
			highestHand = Hand.THREE_OF_A_KIND;
		}
		else if (numPairs == 2) {
			highestHand = Hand.DOUBLE_PAIR;
		}
		else if (numPairs == 1) {
			highestHand = Hand.PAIR;
		}
		else {
			highestHand = Hand.HIGH_CARD;
		}
		
	}
	
	void findSeq() {
		in_seq = true;
		boolean two = (cards.get(0).getRank() == 2);
		
		int prev = cards.get(0).getRank() - 1;
		for (int i=0; i<cards.size(); i++) {
			if (cards.get(i).getRank() != (prev+1)) {
				if (two && (i==4) && cards.get(i).getRank() == 14) {
					continue;
				}
				else {
					in_seq = false;
					break;
				}
			}
			prev = cards.get(i).getRank();
		}
	}
	
	void findFourAndThree() {
		four_of_kind = false;
		three_of_kind = false;
		tripRank = 0;
		
		int counter = 0;
		int prev = cards.get(0).getRank();
		
		for (Card c : cards) {
			if (c.getRank() == prev) {
				counter += 1;
				if (counter==3) {
					three_of_kind = true;
					tripRank = c.getRank();
				}
				if (counter==4) {
					three_of_kind = false;
					tripRank = 0;
					four_of_kind = true;
				}
			}
			else {
				counter=1;
			}
			prev = c.getRank();
		}
	}
	
	void findPairs() {
		int counter = 0;
		int prev = cards.get(0).getRank();
		
		if (four_of_kind || in_seq) return;
		
		
		for (Card c : cards) {
			if (c.getRank() == prev && c.getRank() != tripRank) {
				counter += 1;
				if (counter==2) {
					numPairs += 1;
					counter = 1;
				}
			}
			else {
				counter=1;
			}
			prev = c.getRank();
		}
	}
	

	void findSameSuit() {
		Suit suit = cards.get(0).getSuit();
		same_suit = true;
		
		for (Card x : cards) {
			if (x.getSuit() != suit) {
				same_suit = false;
				break;
			}
		}
	}
}
