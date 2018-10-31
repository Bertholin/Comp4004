package Tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;

import core.Card;
import core.Hand;
import core.Player;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class StraightDefinition {
	Player player;
	
	@Given("^A user has five cards all in order$")
	public void a_user_has_five_cards_all_in_order(DataTable data) {
		System.out.println("------------------ Testing Straight ------------------ ");
		List<List<String>> d = data.raw();
		ArrayList<Card> cards = new ArrayList<Card>();

		for (int i = 0; i < 5; ++i) {
			cards.add(new Card(d.get(0).get(i)));
		}
		player = new Player(cards);
	}

	@Then("^A straight would be detected$")
	public void a_straight_would_be_detected() {
		for (int i = 0; i < 5; i++) {
			Collections.shuffle(player.cards);

			System.out.println("The players hand is " + player.cards);
			Assert.assertEquals(Hand.STRAIGHT, player.getHighestHand());
			System.out.println("The players hand was a Straight\n");
		}
	}
}
