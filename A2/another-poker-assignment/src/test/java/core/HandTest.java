package core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

import java.util.*;

public class HandTest {
	
	@Test
	void testWeights() {
		assertEquals(10, Hand.ROYAL_FLUSH.getWeight());
		assertEquals(9, Hand.STRAIGHT_FLUSH.getWeight());
		assertEquals(8, Hand.FOUR_OF_A_KIND.getWeight());
		assertEquals(7, Hand.FULL_HOUSE.getWeight());
		assertEquals(6, Hand.FLUSH.getWeight());
		assertEquals(5, Hand.STRAIGHT.getWeight());
		assertEquals(4, Hand.THREE_OF_A_KIND.getWeight());
		assertEquals(3, Hand.DOUBLE_PAIR.getWeight());
		assertEquals(2, Hand.PAIR.getWeight());
		assertEquals(1, Hand.HIGH_CARD.getWeight());
	}
	
	/*
	@Test
	void testCompareDiffHands() {
		
	}
	
	@Test
	void testCompareTwoRoyalFlush() {
		
	}
	
	@Test
	void testCompareTwoStraightFlush() {
		
	}
	
	@Test
	void testCompareTwo4Kind() {
		
	}
	
	@Test
	void testCompareTwofullHouse() {
		
	}
	
	
	@Test
	void testCompareTwo3Kind() {
		
	}
	
	@Test
	void testCompareTwoFlush() {
		
	}
	
	@Test
	void testCompareTwoStraights(){
	
	}
	
	@Test
	void testCompareTwoDoublePairs(){
	
	}
	
	@Test
	void testCompareTwoPairs(){
	
	}
	
	@Test
	void testCompareTwoHighCards(){
	
	}
	
	
    */
}
