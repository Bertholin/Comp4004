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

public class ThreeOfAKindDefinition {
	Player player;

	@Given("^A user has five cards scrambled which contains three of the same card$")
	public void a_user_has_five_cards_scrambled_which_contains_three_of_the_same_card(DataTable data) {
		System.out.println("------------------ Testing Three of a kind ------------------ ");
		List<List<String>> d = data.raw();
		ArrayList<Card> cards = new ArrayList<Card>();

		for (int i = 0; i < 5; ++i) {
			cards.add(new Card(d.get(0).get(i)));
		}
		player = new Player(cards);
	}

	@Then("^A three of a kind would be detected$")
	public void a_three_of_a_kind_would_be_detected() {
		for (int i = 0; i < 5; i++) {
			Collections.shuffle(player.cards);

			System.out.println("The players hand is " + player.cards);
			Assert.assertEquals(Hand.THREE_OF_A_KIND, player.getHighestHand());
			System.out.println("The players hand was a Three of a kind\n");
		}
	}
}
