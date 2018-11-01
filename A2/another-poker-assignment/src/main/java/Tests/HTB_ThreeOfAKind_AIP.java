package Tests;

import org.junit.Assert;

import core.Game;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class HTB_ThreeOfAKind_AIP {
	Game game;
	
	@Given("^The HTB has a three of a kind vs twoPair \"([^\"]*)\"$")
	public void the_HTB_has_a_three_of_a_kind_vs_twoPair(String data) {
		System.out.println("------------------ HTB: Three of A Kind VS AIP: Two Pair ------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Given("^The HTB has a three of a kind vs pair \"([^\"]*)\"$")
	public void the_HTB_has_a_three_of_a_kind_vs_pair(String data) {
		System.out.println("------------------ HTB: Three of A Kind VS AIP: Pair ------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Given("^The HTB has a three of a kind vs highCard \"([^\"]*)\"$")
	public void the_HTB_has_a_three_of_a_kind_vs_highCard(String data) {
		System.out.println("------------------ HTB: Three of A Kind VS AIP: High Card ------------------ ");
		game = new Game();
		game.evaluate(data);
	}
	
	@Then("^the HTB \\(three of a kind\\) beats the AIP$")
	public void the_HTB_three_of_a_kind_beats_the_AIP() throws Throwable {
		game.findWinner();
		Assert.assertEquals(game.AIPWon(), false);
		System.out.println("The hand to beat is " + game.toBeat.cards);
		System.out.println("The AIP hand is " + game.AIP.cards);
		System.out.println("HTB Won\n");
	}
}
