package poker;

import java.io.*;
import java.util.*;
import java.io.FileNotFoundException;

public class Deck {
	Scanner sc;

	public boolean openFile(String s) {
		File file = new File(s);
		
		try {
			Scanner sc = new Scanner(file);
			
			return true;
		}catch (FileNotFoundException e) {
			return false;
		}
	}
	
	public boolean closeFile() {
		sc.close();
		
	}
	
	public void  draw() {
		
	}
}
