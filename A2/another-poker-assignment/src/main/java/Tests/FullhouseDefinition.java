package Tests;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import java.util.List;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Collections;

import cucumber.api.DataTable;
import core.*;

public class FullhouseDefinition {

	Player player;

	@Given("^A user has five cards scrambled which contains a pair and triple$")
	public void a_user_has_five_cards_scrambled_which_contains_a_pair_and_triple(DataTable data) {
		System.out.println("------------------ Testing Full house ------------------ ");
		List<List<String>> d = data.raw();
		ArrayList<Card> cards = new ArrayList<Card>();

		for (int i = 0; i < 5; ++i) {
			cards.add(new Card(d.get(0).get(i)));
		}
		player = new Player(cards);
	}

	@Then("^A Fullhouse would be detected$")
	public void a_Fullhouse_would_be_detected() {

		for (int i = 0; i < 5; i++) {
			Collections.shuffle(player.cards);

			System.out.println("The players hand is " + player.cards);
			Assert.assertEquals(Hand.FULL_HOUSE, player.getHighestHand());
			System.out.println("The players hand was a full house\n");
		}
	}

}
