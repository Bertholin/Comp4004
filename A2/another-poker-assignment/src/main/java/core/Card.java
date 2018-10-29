package core;

public class Card {

	Suit suit;
	int rank;
	String id;
	
	public Card(String card) {
		this.id = card;
		this.rank = rankStringToInt(card.substring(1));
		
		switch (card.charAt(0)){
			case 'C': this.suit = Suit.CLUBS; break;
			case 'D': this.suit = Suit.DIAMONDS; break;
			case 'H': this.suit = Suit.HEARTS; break;
			case 'S': this.suit = Suit.SPADES; break;
		}
	}
	
	public int rankStringToInt(String r) {
		int ret = 0;
		switch (r){
			case "A": ret = 14; break;
			case "K": ret = 13; break;
			case "Q": ret = 12; break;
			case "J": ret = 11; break;
			default: ret = Integer.parseInt(r);
		}
		return ret;
	}

	public Suit getSuit() { return suit; }
	public int getRank() { return rank; }
	public String getId() { return id; }
	
	public boolean equals(Object object2) {
	    return ((object2 instanceof Card) 
	    	&& (suit == ((Card)object2).suit) 
	    	&& (rank == ((Card)object2).rank));
	}
	
	public String toString() {
		return id;
	}
	
}
