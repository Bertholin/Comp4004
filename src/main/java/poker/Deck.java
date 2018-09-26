package poker;

import java.io.*;
import java.util.*;
import java.io.FileNotFoundException;

public class Deck {
	Scanner sc;

	public boolean openFile(String s) {
		File file = new File("src/main/resources/" + s);
		
		try {
			 sc = new Scanner(file);
			
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
		
		return sc.nextLine();
	}
}
