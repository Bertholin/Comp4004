package Tests;

import org.junit.Assert;

import core.Game;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class HTB_FourOfAKindDefinitions {
	Game game;

	@Given("^The HTB has a four of a Kind vs fullHouse \"([^\"]*)\"$")
	public void the_HTB_has_a_four_of_a_Kind_vs_fullHouse(String data) {
		System.out.println("------------------ HTB: four of a Kind VS AIP: fullHouse ------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Given("^The HTB has a four of a Kind vs flush \"([^\"]*)\"$")
	public void the_HTB_has_a_four_of_a_Kind_vs_flush(String data) {
		System.out.println("------------------ HTB: four of a Kind VS AIP: Flush ------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Given("^The HTB has a four of a Kind vs straight \"([^\"]*)\"$")
	public void the_HTB_has_a_four_of_a_Kind_vs_straight(String data) {
		System.out.println("------------------ HTB: four of a Kind VS AIP: Straight ------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Given("^The HTB has a four of a Kind vs threeOfAKind \"([^\"]*)\"$")
	public void the_HTB_has_a_four_of_a_Kind_vs_threeOfAKind(String data) {
		System.out.println("------------------ HTB: four of a Kind VS AIP: three Of A Kind ------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Given("^The HTB has a four of a Kind vs twoPair \"([^\"]*)\"$")
	public void the_HTB_has_a_four_of_a_Kind_vs_twoPair(String data) {
		System.out.println("------------------ HTB: four of a Kind VS AIP: two Pair ------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Given("^The HTB has a four of a Kind vs pair \"([^\"]*)\"$")
	public void the_HTB_has_a_four_of_a_Kind_vs_pair(String data) {
		System.out.println("------------------ HTB: four of a Kind VS AIP: Pair ------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Given("^The HTB has a four of a Kind vs highCard \"([^\"]*)\"$")
	public void the_HTB_has_a_four_of_a_Kind_vs_highCard(String data) {
		System.out.println("------------------ HTB: four of a Kind VS AIP: High Card ------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Then("^the HTB \\(four of a Kind\\) beats the AIP$")
	public void the_HTB_four_of_a_Kind_beats_the_AIP() {
		game.findWinner();
		Assert.assertEquals(game.AIPWon(), false);
		System.out.println("The hand to beat is " + game.toBeat.cards);
		System.out.println("The AIP hand is " + game.AIP.cards);
		System.out.println("HTB Won\n");
	}
}
