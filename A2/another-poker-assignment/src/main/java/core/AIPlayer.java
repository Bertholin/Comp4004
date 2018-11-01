package core;

import java.util.*;

public class AIPlayer extends Player{
	
	int numClubs = 0;
	int numDiamonds = 0;
	int numHearts = 0;
	int numSpades = 0;
	
	boolean threeInSeq = false;
	boolean oneFromStraight = false;
	boolean suitMatchesStraight = false;
	boolean oneFromFlush = false;
	
	Suit flushSuit;
	
	int[] sequence = { 0, 0, 0, 0, 0 };
	int[] suit = {0, 0, 0, 0, 0 };
	
	Set<Integer> sequencedCards = new HashSet<Integer>();
	
	ArrayList<HashSet<Card>> repeats = new ArrayList<>(); 
	
	ArrayList<HashSet<Card>> sequences = new ArrayList<>();
	
	ArrayList<Card> discard = new ArrayList<Card>();
	public ArrayList<String> toDiscard = new ArrayList<String>();
	
	ArrayList<Card> recieved = new ArrayList<Card>();
	
	public AIPlayer(ArrayList<Card> cards) {
		super(cards);
		countSuits();
		evalFlush();
		evalSeq();
		evalSeq2();
		evalRanks();
	}
	
	public void addCards(ArrayList<Card> c) {
		cards.addAll(c);
		super.orderCards();
		super.findHighestHand();
		countSuits();
		evalFlush();
		evalSeq();
		evalSeq2();
		evalRanks();
	}
	
	void countSuits() {
		numClubs = 0;
		numDiamonds = 0;
		numHearts = 0;
		numSpades = 0;
		for(Card c : cards) {
			switch(c.getSuit()) {
			case CLUBS: numClubs += 1; break;
			case DIAMONDS: numDiamonds += 1; break;
			case HEARTS: numHearts += 1; break;
			case SPADES: numSpades += 1; break;
			}
		}
	}
	
	void evalFlush() {
		if (numClubs == 4 || numDiamonds == 4 || numHearts == 4 || numSpades == 4){
			oneFromFlush = true;
		}
		
		if (oneFromFlush || same_suit) {
			if (numClubs >= 4) {
				flushSuit = Suit.CLUBS;
			}
			else if (numDiamonds >= 4) {
				flushSuit = Suit.DIAMONDS;
			}
			else if (numHearts >= 4) {
				flushSuit = Suit.HEARTS;
			}
			else if (numSpades >= 4) {
				flushSuit = Suit.SPADES;
			}
		}
	}
	
	void evalSeq2() {
		int prevRank = -1;
		HashSet<Card> tmp = new HashSet<>();
		boolean flag = false;
		int count = 0; 
		for (int i=0; i<cards.size(); i++) {
			if (cards.get(i).getRank() == prevRank + 1) {
				count += 1;
				tmp.add(cards.get(i));
				tmp.add(cards.get(i-1));
				flag = true;
			}
			else if (flag) {
				if (count == 2) threeInSeq = true;
				count = 0;
				sequences.add(new HashSet<Card>(tmp));
				flag = false;
				tmp.clear();
			}
			prevRank = cards.get(i).getRank();
		}
		if (flag) {
			sequences.add(new HashSet<Card>(tmp));
		}
	}
	
	
	
	void evalSeq() {
		sequencedCards.clear();
		sequence = new int[]  { 0, 0, 0, 0, 0 };
		suit = new int[] {0, 0, 0, 0, 0 };
		int count = 0;
		for(int i=0; i<cards.size() - 1; i++) {
			if (cards.get(i).getRank() == (cards.get(i+1).getRank() - 1)) {
				sequence[i] = 1;
				sequence[i+1] = 1;
				count += 1;
				if (i==3) count += 1;
				
				sequencedCards.add(cards.get(i).getRank());
				sequencedCards.add(cards.get(i+1).getRank());
				
			}
			else count = 0;
			
			if (cards.get(i).getSuit() == cards.get(i+1).getSuit()) {
				suit[i] = 1;
				suit[i+1] = 1;
			}
		}
		
		if (count == 3) threeInSeq = true;
		
		if (Arrays.equals(new int[] {0, 1, 1, 1, 1}, sequence)) {
			if (cards.get(1).getRank() == (cards.get(4).getRank()-3)) {
				oneFromStraight = true;
			}
			if (Arrays.equals(new int[] {1, 1, 1, 1, 1}, suit) || Arrays.equals(new int[] {0, 1, 1, 1, 1}, suit)) {
				suitMatchesStraight = true;
			}
			if (cards.get(0).getRank() == cards.get(1).getRank() && 
				cards.get(0).getSuit() == cards.get(2).getSuit() && 
				Arrays.equals(new int[] {1, 1, 1}, Arrays.copyOfRange(suit, 2, 5))){
				suitMatchesStraight = true;
			}
			
		}
		
		else if (Arrays.equals(new int[] {1, 1, 1, 1, 0}, sequence)) {
			if (cards.get(0).getRank() == (cards.get(3).getRank()-3)) {
				oneFromStraight = true;
			}
			else if (cards.get(0).getRank() == 2 && cards.get(4).getRank() == 14) {
				//case low ace
				oneFromStraight = true;
			}
			if (Arrays.equals(new int[] {1, 1, 1, 1, 1}, suit) || Arrays.equals(new int[] {1, 1, 1, 1, 0}, suit)) {
				suitMatchesStraight = true;
			}
			if (cards.get(3).getRank() == cards.get(4).getRank() && 
					cards.get(4).getSuit() == cards.get(0).getSuit() && 
					Arrays.equals(new int[] {1, 1, 1}, Arrays.copyOfRange(suit, 0, 3))){
					suitMatchesStraight = true;
				}
		}
		else if (Arrays.equals(new int[] {0, 0, 1, 1, 1}, sequence)) {
			if (cards.get(0).getRank() == (cards.get(2).getRank()-2) || cards.get(0).getRank() == (cards.get(2).getRank()-1)){
				oneFromStraight = true;
				if (Arrays.equals(new int[] {1, 1, 1}, Arrays.copyOfRange(suit, 2, 5)) && cards.get(0).getSuit() == cards.get(2).getSuit()){
					suitMatchesStraight = true;
				}
			}
			else if (cards.get(1).getRank() == (cards.get(2).getRank()-2) || cards.get(1).getRank() == (cards.get(2).getRank()-1)) {
				oneFromStraight = true;
				if (Arrays.equals(new int[] {1, 1, 1}, Arrays.copyOfRange(suit, 2, 5)) && cards.get(1).getSuit() == cards.get(2).getSuit()){
					suitMatchesStraight = true;
				}
			}
				
		}
		else if (Arrays.equals(new int[] {1, 1, 0, 1, 1}, sequence)) {
			if (cards.get(1).getRank() == (cards.get(3).getRank()-2)) {
				oneFromStraight = true;
			}
			if (Arrays.equals(new int[] {1, 1, 1, 1, 1}, suit)) {
				suitMatchesStraight = true;
			}
			else if ((Arrays.equals(new int[] {1, 1, 0, 1, 1}, suit)) && cards.get(0).getSuit() == cards.get(4).getSuit()){
				suitMatchesStraight = true;
			}
		}
		
		else if (Arrays.equals(new int[] {1, 1, 1, 0, 0}, sequence)){
			if (cards.get(2).getRank() == (cards.get(3).getRank()-2) || cards.get(2).getRank() == (cards.get(3).getRank()-1)) {
				if (Arrays.equals(new int[] {1, 1, 1}, Arrays.copyOfRange(suit, 0, 3)) && cards.get(3).getSuit() == cards.get(0).getSuit()){
					suitMatchesStraight = true;
				}
				oneFromStraight = true;
			}
			else if (cards.get(2).getRank() == (cards.get(4).getRank()-2) || cards.get(2).getRank() == (cards.get(4).getRank()-1)) {
				if (Arrays.equals(new int[] {1, 1, 1}, Arrays.copyOfRange(suit, 0, 3)) && cards.get(4).getSuit() == cards.get(0).getSuit()){
					suitMatchesStraight = true;
				}
				oneFromStraight = true;
			}
			else if (cards.get(0).getRank() == 2 && cards.get(4).getRank() == 14) {
				// case low ace
				oneFromStraight = true;
				if (Arrays.equals(new int[] {1, 1, 1}, Arrays.copyOfRange(suit, 0, 3)) && cards.get(4).getSuit() == cards.get(0).getSuit()){
					suitMatchesStraight = true;
				}
				
			}
		}
		else if (Arrays.equals(new int[] {0, 1, 1, 1, 0}, sequence)) {
			if (cards.get(1).getRank() == 3 && cards.get(4).getRank() == 14) {
				// case low ace
				oneFromStraight = true;
				if (Arrays.equals(new int[] {1,  1, 1, 1, 1}, suit) || Arrays.equals(new int[] {0,  1, 1, 1, 1}, suit)) {
					suitMatchesStraight = true;
				}
			}
		}
		
		else if (Arrays.equals(new int[] { 1,  1, 0, 0, 0}, sequence)) {
			if (cards.get(0).getRank() == 2 && cards.get(4).getRank() == 14) {
				if (cards.get(2).getRank() == 4 || cards.get(2).getRank() == 5){
					// case low ace
					oneFromStraight = true;
					
					if (Arrays.equals(new int[] {1, 1, 1}, Arrays.copyOfRange(suit, 0, 3)) && cards.get(4).getSuit() == cards.get(0).getSuit()){
						suitMatchesStraight = true;
					}
				}
				else if(cards.get(3).getRank() == 4 || cards.get(3).getRank() == 5) {
					// case low ace
					oneFromStraight = true;
					
					if (Arrays.equals(new int[] {1, 1}, Arrays.copyOfRange(suit, 0, 2)) && 
							(cards.get(4).getSuit() == cards.get(0).getSuit()) 
							&& (cards.get(3).getSuit() == cards.get(0).getSuit())){
						suitMatchesStraight = true;
					}
				}
			}
		}
		
		else if (Arrays.equals(new int[] { 0,  1, 1, 0, 0}, sequence)) {
			if (cards.get(1).getRank() == 4 && cards.get(4).getRank() == 14) {
				if (cards.get(0).getRank() == 2) {
					// case low ace
					oneFromStraight = true;
					
					if (Arrays.equals(new int[] {1, 1, 1}, Arrays.copyOfRange(suit, 0, 3)) && cards.get(4).getSuit() == cards.get(0).getSuit()){
						suitMatchesStraight = true;
					}
				}
			}
		}
	}

	void evalRanks() {
		int prevRank = -1;
		HashSet<Card> tmp = new HashSet<>();
		boolean flag = false;
		for(int i=0; i<cards.size(); i++) {
			if (cards.get(i).getRank() == prevRank) {
				tmp.add(cards.get(i));
				tmp.add(cards.get(i-1));
				flag = true;
			}
			else if (flag) {
				repeats.add(new HashSet<Card>(tmp));
				tmp.clear();
				flag = false;
			}
			
			prevRank = cards.get(i).getRank();
		}
		if (flag) {
			repeats.add(new HashSet<Card>(tmp));
		}
		
	}
	
	public int exchange() {
		int ret = 0;
		if ((highestHand == Hand.ROYAL_FLUSH) ||
			(highestHand == Hand.STRAIGHT_FLUSH) || 
			(highestHand == Hand.FOUR_OF_A_KIND) ||
			(highestHand == Hand.FULL_HOUSE) ||
			(highestHand == Hand.FLUSH) ||
			(highestHand == Hand.STRAIGHT)) {
			ret = 0;
		}
		
		else if(isOneAwayFromRoyalFlush()) {
			ret = 1;
			findDiscardForRoyalFlush();
		}
		else if (isOneAwayFromStraightFlush()) {
			ret = 1;
			findDiscardForStraightFlush();
		}
		else if (isOneAwayFromFullHouse()) {
			ret = 1;
			findDiscardForFullHouse();
		}
		else if (isOneAwayFromFlush()) {
			ret = 1;
			findDiscardForFlush();
		}
		else if (isOneAwayFromStraight()) {
			ret = 1;
			findDiscardForStraight();
		}
		else if (hasExactThreeSameSuit()) {
			ret = 2;
			findDiscardThreeSuit();
		}
		else if (hasThreeInSeq()) {
			ret = 2;
			findDiscardThreeSeq();
		}
		else if (hasPair()) {
			ret = 3;
			findDiscardPair();
		} 
		else {
			ret = 3;
			findDiscardHighCard();
		}
		
		discard();
		return ret;
	}
	
	void discard() {
		for(String c : toDiscard) {
			Card curr = new Card(c);
			cards.remove(curr);
			discard.add(curr);
		}
	}
	
	public boolean isOneAwayFromRoyalFlush() {
		boolean ret = false;
		if (in_seq && same_suit && cards.get(0).getRank() == 9) {
			ret = true;
		}
		else if (in_seq && oneFromFlush && cards.get(0).getRank() == 9) {
			//in sequence, 9 is off suit
			if ((cards.get(0).getSuit() != cards.get(1).getSuit()) && (cards.get(0).getSuit() != cards.get(2).getSuit())){
				ret = true;
			}
		}
		else if ((in_seq && oneFromFlush) || (suitMatchesStraight && oneFromStraight)){
			if (sequencedCards.containsAll(Arrays.asList(new Integer[] {10,11, 12, 13, 14}))){
				ret = true;
			}
			else if (!sequencedCards.contains(10) && sequencedCards.containsAll(Arrays.asList(new Integer[] {11, 12, 13, 14}))){
				ret = true;
			}
			else if (!sequencedCards.contains(11) && sequencedCards.containsAll(Arrays.asList(new Integer[] {10, 12, 13, 14}))){
				ret = true;
			}
			else if (!sequencedCards.contains(12) && sequencedCards.containsAll(Arrays.asList(new Integer[] {11, 10, 13, 14}))){
				ret = true;
			}
			else if (!sequencedCards.contains(13) && sequencedCards.containsAll(Arrays.asList(new Integer[] {11, 12, 10, 14}))){
				ret = true;
			}
			else if (!sequencedCards.contains(14) && sequencedCards.containsAll(Arrays.asList(new Integer[] {11, 12, 13, 10}))){
				ret = true;
			}
		}
		
		return ret;
	}
	
	void findDiscardForRoyalFlush() {
		if (cards.get(0).getRank() == 9) toDiscard.add(cards.get(0).getId());
		else if (in_seq) toDiscard.add(findMissingFromFlush());
		else toDiscard.add(findMissingFromSeq());
	}
	
	public boolean isOneAwayFromStraightFlush() {
		boolean ret = false;
		if (oneFromStraight && suitMatchesStraight) {
			ret = true;
			
		}
		if (in_seq && oneFromFlush) {
			ret = true;
		}
		return ret;
	}
	
	void findDiscardForStraightFlush() {
		if (oneFromStraight) toDiscard.add(findMissingFromSeq());
		else if (oneFromFlush) toDiscard.add(findMissingFromFlush());
	}
	
	public boolean isOneAwayFromFullHouse() {
		return three_of_kind || (numPairs == 2);
	}
	
	void findDiscardForFullHouse() {

		for(int i=0; i<cards.size(); i++) {
			boolean inSet = false;
			for (HashSet<Card> c : repeats) {
				if (c.contains(cards.get(i))){
					inSet = true;
				}
			}
			if (!inSet) {
				toDiscard.add(cards.get(i).getId());
				break;
			}
		}
	}
	
	public boolean isOneAwayFromFlush() {
		return oneFromFlush && (!in_seq);
	}
	
	void findDiscardForFlush() {
		toDiscard.add(findMissingFromFlush());
	}

	public boolean isOneAwayFromStraight() {
		return oneFromStraight;
	}
	
	void findDiscardForStraight() {
		toDiscard.add(findMissingFromSeq());
	}
	
	String findMissingFromFlush() {
		String ret = "";
		for (int i=0; i<cards.size(); i++) {
			if (cards.get(i).getSuit() != flushSuit) {
				ret = cards.get(i).getId();
			}
		}
		
		return ret;
	}
	
	String findMissingFromSeq() {
		String ret = "";
		for (int i=0; i<cards.size(); i++) {
			if (!sequencedCards.contains(cards.get(i).getRank())) {
				ret = cards.get(i).getId();
				break;
			}
		}
		return ret;
	}
	
	String findAllMissingFromSeq() {
		String ret = "";
		for (int i=0; i<cards.size(); i++) {
			if (!sequencedCards.contains(cards.get(i).getRank())) {
				ret = cards.get(i).getId();
			}
		}
		return ret;
	}

	public boolean hasExactThreeSameSuit() {
		return ((numClubs == 3) || (numDiamonds == 3) || (numHearts == 3) || (numSpades == 3));
		
	}
	
	void findDiscardThreeSuit() {
		if (numClubs == 3) flushSuit = Suit.CLUBS;
		else if (numDiamonds == 3) flushSuit = Suit.DIAMONDS;
		else if (numHearts == 3) flushSuit = Suit.HEARTS;
		else if (numSpades == 3) flushSuit = Suit.SPADES;
		
		for (int i=0; i<cards.size(); i++) {
			if (cards.get(i).getSuit() != flushSuit) {
				toDiscard.add(cards.get(i).getId());
			}
		}
	}
	
	public boolean hasThreeInSeq() {
		return threeInSeq;
	}
	
	void findDiscardThreeSeq() {
		for(HashSet<Card> seq : sequences) {
			if (seq.size() == 3) {
				for (int i=0; i<cards.size(); i++) {
					if (!seq.contains(cards.get(i))) {
						toDiscard.add(cards.get(i).getId());
					}
				}
				break;
			}
		}
	}
	
	public boolean hasTwoPairs() {
		return (numPairs == 2);
	}
	
	
	public boolean hasPair() {
		return (numPairs == 1);
	}

	void findDiscardPair() {
		for(int i=0; i<cards.size(); i++) {
			for (HashSet<Card> c : repeats) {
				if (!c.contains(cards.get(i))){
					toDiscard.add(cards.get(i).getId());
				}
			}
		}
	}
	
	void findDiscardHighCard() {
		for (int i=0; i<3; i++) {
			toDiscard.add(cards.get(i).getId());
		}
	}
	public ArrayList<Card> getDiscarded(){
		return discard;
	}
	
	public ArrayList<Card> getRecieved(){
		return recieved;
	}
	
	public Suit getFlushSuit() {
		return flushSuit;
	}
}
