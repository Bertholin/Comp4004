package Tests;

import org.junit.Assert;

import core.Game;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class HTB_Flush_AIP {
	Game game;

	@Given("^The HTB has a flush vs straight \"([^\"]*)\"$")
	public void the_HTB_has_a_flush_vs_straight(String data) {
		System.out.println("------------------ HTB: Flush VS AIP: Striaght ------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Given("^The HTB has a flush vs threeOfAKind \"([^\"]*)\"$")
	public void the_HTB_has_a_flush_vs_threeOfAKind(String data) {
		System.out.println("------------------ HTB: Flush VS AIP: Three of A Kind ------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Given("^The HTB has a flush vs twoPair \"([^\"]*)\"$")
	public void the_HTB_has_a_flush_vs_twoPair(String data) {
		System.out.println("------------------ HTB: Flush VS AIP: Two Pair ------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Given("^The HTB has a flush vs pair \"([^\"]*)\"$")
	public void the_HTB_has_a_flush_vs_pair(String data) {
		System.out.println("------------------ HTB: Flush VS AIP: Pair ------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Given("^The HTB has a flush vs highCard \"([^\"]*)\"$")
	public void the_HTB_has_a_flush_vs_highCard(String data) {
		System.out.println("------------------ HTB: Flush VS AIP: High Card ------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Then("^the HTB \\(flush\\) beats the AIP$")
	public void the_HTB_flush_beats_the_AIP() {
		game.findWinner();
		Assert.assertEquals(game.AIPWon(), false);
		System.out.println("The hand to beat is " + game.toBeat.cards);
		System.out.println("The AIP hand is " + game.AIP.cards);
		System.out.println("HTB Won\n");
	}
}
