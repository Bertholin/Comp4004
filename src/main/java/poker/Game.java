package poker;

import java.io.*;
import java.util.*;

public class Game {

	Scanner sc = null;
	Hand hand = new Hand();
	Hand AIHand = new Hand();

	public void draw(int num) {

		try {
			sc = new Scanner(new File("cards.txt"));

			while (sc.hasNextLine()) {
				String card = sc.nextLine();
				System.out.println(card);
				//hand.add(card);

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		sc.close();
	}
}
