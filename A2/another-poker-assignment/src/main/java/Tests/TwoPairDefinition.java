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

public class TwoPairDefinition {
	Player player;

	@Given("^A user has five cards scrambled which contains a two pairs$")
	public void a_user_has_five_cards_scrambled_which_contains_a_two_pairs(DataTable data) {
		System.out.println("------------------ Testing Two Pair ------------------ ");
		List<List<String>> d = data.raw();
		ArrayList<Card> cards = new ArrayList<Card>();

		for (int i = 0; i < 5; ++i) {
			cards.add(new Card(d.get(0).get(i)));
		}
		player = new Player(cards);
	}

	@Then("^two pairs would be detected$")
	public void two_pairs_would_be_detected() {
		for (int i = 0; i < 5; i++) {
			Collections.shuffle(player.cards);

			System.out.println("The players hand is " + player.cards);
			Assert.assertEquals(Hand.DOUBLE_PAIR, player.getHighestHand());
			System.out.println("The players hand was a Two Pair\n");
		}
	}
}
