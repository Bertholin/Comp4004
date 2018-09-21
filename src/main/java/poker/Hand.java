package poker;

import java.util.*;
import java.io.*;

public class Hand {
	ArrayList<String> hand = new ArrayList<String>();
	Scanner sc = null;
	public int size() {
		return hand.size();
	}

	public void draw(int num) {
		
		try {
			sc = new Scanner(new File("cards.txt"));

			while (sc.hasNextLine()) {
				String card = sc.nextLine();
				System.out.println(card);
				hand.add(card);

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		sc.close();
	}
}
