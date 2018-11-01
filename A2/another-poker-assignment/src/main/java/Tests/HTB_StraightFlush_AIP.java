package Tests;

import org.junit.Assert;

import core.Game;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class HTB_StraightFlush_AIP {
	Game game;

	@Given("^The HTB has a Straight Flush vs fourOfAKind \"([^\"]*)\"$")
	public void the_HTB_has_a_Straight_Flush_vs_fourOfAKind(String data) {
		System.out.println("------------------ HTB: Straight Flush VS AIP: 4 of a kind ------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Given("^The HTB has a Straight Flush vs fullHouse \"([^\"]*)\"$")
	public void the_HTB_has_a_Straight_Flush_vs_fullHouse(String data) {
		System.out.println("------------------ HTB: Straight Flush VS AIP: Full house ------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Given("^The HTB has a Straight Flush vs flush \"([^\"]*)\"$")
	public void the_HTB_has_a_Straight_Flush_vs_flush(String data) {
		System.out.println("------------------ HTB: Straight Flush VS AIP: Flush ------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Given("^The HTB has a Straight Flush vs straight \"([^\"]*)\"$")
	public void the_HTB_has_a_Straight_Flush_vs_straight(String data) {
		System.out.println("------------------ HTB: Straight Flush VS AIP: Straight ------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Given("^The HTB has a Straight Flush vs threeOfAKind \"([^\"]*)\"$")
	public void the_HTB_has_a_RStraight_Flush_vs_threeOfAKind(String data) {
		System.out.println("------------------ HTB: Straight Flush VS AIP: 3 of a kind ------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Given("^The HTB has a Straight Flush vs twoPair \"([^\"]*)\"$")
	public void the_HTB_has_a_Straight_Flush_vs_twoPair(String data) {
		System.out.println("------------------ HTB: Straight Flush VS AIP: Two Pair ------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Given("^The HTB has a Straight Flush vs pair \"([^\"]*)\"$")
	public void the_HTB_has_a_Straight_Flush_vs_pair(String data) {
		System.out.println("------------------ HTB: Straight Flush VS AIP: Pair ------------------ ");
		game = new Game();
		game.evaluate(data);
	}
	
	@Given("^The HTB has a Straight Flush vs highCard \"([^\"]*)\"$")
	public void the_HTB_has_a_Straight_Flush_vs_highCard(String data) {
		System.out.println("------------------ HTB: Straight Flush VS AIP: High Card ------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Then("^the HTB \\(Straight Flush\\) beats the AIP$")
	public void the_HTB_beats_the_AIP() {
		game.findWinner();
		Assert.assertEquals(game.AIPWon(), false);
		System.out.println("The hand to beat is " + game.toBeat.cards);
		System.out.println("The AIP hand is " + game.AIP.cards);
		System.out.println("HTB Won\n");
	}

}
