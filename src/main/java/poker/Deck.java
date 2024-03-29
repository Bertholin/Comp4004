package poker;

import java.io.*;
import java.util.*;
import java.io.FileNotFoundException;

public class Deck {
	Scanner sc;
	ArrayList<String> deck = new ArrayList<String>();

	public boolean openFile(String s) {
		File file = new File("src/main/resources/" + s);
		try {
			sc = new Scanner(file);
			String[] cards = sc.nextLine().split(" ");

			for (String c : cards)
				deck.add(c);
			sc.close();
			return true;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}
	}

	public String draw() {
		String card = null;
		if (deck.size() != 0) {
			card = deck.get(0);
			deck.remove(0);
		}
		return card;
	}

	public boolean openJustFile(String s) {
		File file = new File("src/main/resources/" + s);
		try {
			sc = new Scanner(file);
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean getNextLine() {
		if (sc.hasNextLine()) {
			String[] cards = sc.nextLine().split(" ");
			for (String c : cards) {
				deck.add(c);
			}
			return true;
		}
		return false;
	}
}
