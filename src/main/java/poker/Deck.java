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
			 String [] cards = sc.nextLine().split(" ");
			 
			 for(String c : cards)
				 deck.add(c);
			return true;
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public String closeFile() {
		
		sc.close();
		return "Closed";
	}
	
	public String  draw() {
		String card = deck.get(0);
		deck.remove(0);
		return card;
	}
}
