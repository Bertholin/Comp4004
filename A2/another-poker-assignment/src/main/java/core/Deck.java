package core;

import java.util.*;

public class Deck {
	
	ArrayList<String> cards = new ArrayList<String>();
	int size = 0;
	Random rand = new Random();
	
	public Deck() {
		cards.add("C2");
		cards.add("C3");
		cards.add("C4");
		cards.add("C5");
		cards.add("C6");
		cards.add("C7");
		cards.add("C8");
		cards.add("C9");
		cards.add("C10");
		cards.add("CJ");
		cards.add("CQ");
		cards.add("CK");
		cards.add("CA");
		
		cards.add("D2");
		cards.add("D3");
		cards.add("D4");
		cards.add("D5");
		cards.add("D6");
		cards.add("D7");
		cards.add("D8");
		cards.add("D9");
		cards.add("D10");
		cards.add("DJ");
		cards.add("DQ");
		cards.add("DK");
		cards.add("DA");
		
		cards.add("H2");
		cards.add("H3");
		cards.add("H4");
		cards.add("H5");
		cards.add("H6");
		cards.add("H7");
		cards.add("H8");
		cards.add("H9");
		cards.add("H10");
		cards.add("HJ");
		cards.add("HQ");
		cards.add("HK");
		cards.add("HA");
		
		cards.add("S2");
		cards.add("S3");
		cards.add("S4");
		cards.add("S5");
		cards.add("S6");
		cards.add("S7");
		cards.add("S8");
		cards.add("S9");
		cards.add("S10");
		cards.add("SJ");
		cards.add("SQ");
		cards.add("SK");
		cards.add("SA");
		
		size = 52;
	}
	
	public boolean contains(String s) {
		return cards.contains(s);
	}
	
	public boolean contains(Card c) {
		return cards.contains(c.getId());
	}
	
	public int size() {
		return size;
	}
	
	public Card draw() {
		int index = rand.nextInt(size);
		String c = cards.get(index);
		Card ret = new Card(c);
		cards.remove(index);
		size -= 1;
		return ret;
	}
	
	public Card draw(String card) {
		cards.remove(card);
		Card ret = new Card(card);
		size -= 1;
		return ret;
	}
	
	public ArrayList<Card> drawMany(int num){
		ArrayList<Card> ret = new ArrayList<Card>();
		for(int i=0; i<num; i++) {
			ret.add(draw());
		}
		return ret;
	}
	
	public ArrayList<Card> drawMany(ArrayList<String> c){
		ArrayList<Card> ret = new ArrayList<Card>();
		for (String card : c){
			ret.add(draw(card));
		}
		return ret;
	}
	

}
