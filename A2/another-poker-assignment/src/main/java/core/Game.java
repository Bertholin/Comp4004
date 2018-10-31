package core;

import java.util.*;
import java.io.*;

public class Game {
	
	public Player toBeat;
	public AIPlayer AIP;
	Deck deck;
	int num = 0;
	int numExchanged = 0;
	
	ArrayList<Card> drawnCards = new ArrayList<Card>();
	ArrayList<Card> initialHand = new ArrayList<Card>();
	
	boolean AIPWin = false;
	
	public Game() {
		deck = new Deck();
	}
	
	public void evaluate(String s) {
		String[] output = s.split(" ");
		
		ArrayList<String> beat = new ArrayList<String>(Arrays.asList(Arrays.copyOfRange(output, 0, 5)));
		ArrayList<Card> hand1 = new ArrayList<Card>(deck.drawMany(beat));
		toBeat = new Player(hand1);
		
		ArrayList<String> AICards = new ArrayList<String>(Arrays.asList(Arrays.copyOfRange(output, 5, 10)));
		ArrayList<Card> cards = new ArrayList<Card>(deck.drawMany(AICards));
		AIP = new AIPlayer(cards);
		initialHand = cards;
		
	}
	
	public ArrayList<Card> getAICards(){
		return AIP.getCards();
	}
	
	public ArrayList<Card> getCardsToBeat(){
		return toBeat.getCards();
	}
	
	public ArrayList<Card> getDiscarded(){
		return AIP.getDiscarded();
	}
	
	public ArrayList<Card> getDrawnCards(){
		return drawnCards;
	}
	
	public int getNumExchanged() {
		return numExchanged;
	}
	
	public AIPlayer getAIP() {
		return AIP;
	}
	
	public boolean AIPWon() {
		return AIPWin;
	}
	
	public Player getHandToBeat() {
		return toBeat;
	}
	
	public void findWinner() {
		Hand Opponent = toBeat.getHighestHand();
		Hand AIPHand = AIP.getHighestHand();
		AIPWin = false;
		if (AIPHand.getWeight() > Opponent.getWeight()) {
			AIPWin = true;
		}
		else if (AIPHand.getWeight() == Opponent.getWeight()) {
			if (AIP.getHighestHand() == Hand.ROYAL_FLUSH) {
				if (AIP.getFlushSuit().getWeight() > toBeat.getCards().get(0).getSuit().getWeight()) {
					AIPWin = true;
				}
			}
		}
	}
	
	public void printGame() {
		System.out.println("------ GAME "+num+" ------");
		System.out.println("Hand to beat: " + toBeat.getCards());
		System.out.println("AIP Initial hand: " + initialHand);
		System.out.println("AIP Exchanged " + numExchanged + " card(s).");
		System.out.println("Discarded: " + AIP.getDiscarded());
		System.out.println("Recieved: " + drawnCards);
		System.out.println("AIP Final Hand: "+ AIP.getCards());
		System.out.println("\nAIP has: " + AIP.getHighestHand());
		System.out.println("Hand to beat has: " + toBeat.getHighestHand());
		if (AIPWin) {
			System.out.println("\nWINNER: AIP\n");
		}else {
			System.out.println("\nWINNER: OPPONENT\n");
		}
	}
	
	public void exchange() {
		numExchanged = AIP.exchange();
		drawnCards = new ArrayList<Card>(deck.drawMany(numExchanged));
		AIP.addCards(drawnCards);
	}
	
	public void play(String line) {
		deck = new Deck();
		evaluate(line);
		exchange();
		findWinner();
		printGame();
	}
	
	public void playWithoutExchange(String line) {
		deck = new Deck();
		evaluate(line);
		findWinner();
		printGame();
	}
	
	public void init() {
		toBeat = null;
		AIP = null;
		deck = new Deck();
		
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("input.txt"));
			String line = reader.readLine();
			while (line != null) {
				num += 1;
				play(line);
				line = reader.readLine();
			}
			reader.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		game.init();
	}

}
