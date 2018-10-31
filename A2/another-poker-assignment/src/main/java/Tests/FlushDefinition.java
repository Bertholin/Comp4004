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

public class FlushDefinition {
	Player player;

	@Given("^A user has five cards with the same suit$")
	public void a_user_has_five_cards_with_the_same_suit(DataTable data) {
		System.out.println("------------------ Testing  Flush ------------------ ");
		List<List<String>> d = data.raw();
		ArrayList<Card> cards = new ArrayList<Card>();

		for (int i = 0; i < 5; ++i) {
			cards.add(new Card(d.get(0).get(i)));
		}
		player = new Player(cards);
	}

	@Then("^A flush would be detected$")
	public void a_flush_would_be_detected() {
		for (int i = 0; i < 5; i++) {
			Collections.shuffle(player.cards);

			System.out.println("The players hand is " + player.cards);
			Assert.assertEquals(Hand.FLUSH, player.getHighestHand());
			System.out.println("The players hand was a flush\n");
		}
	}
}
