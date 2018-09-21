package poker;

import junit.framework.TestCase;

public class HandTest extends TestCase{
	
	public void testDrawing() {
		Hand p1 = new Hand();
		Hand ai = new Hand();
		
		assertEquals(0, p1.size());
		assertEquals(0, ai.size());
		
		p1.draw(5);
		assertEquals(5, p1.size());
		
		for(int i = 0; i < 5; ++i) {
			ai.draw(1);
		}
		assertEquals(5, ai.size());
		
	}
	
	
	
}
