package Tests;

import org.junit.Assert;

import core.Game;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class AIP_FourOfAKindDefinitions {
	Game game;

	@Given("^The AIP has a four of a Kind vs fullHouse \"([^\"]*)\"$")
	public void the_AIP_has_a_four_of_a_Kind_vs_fullHouse(String data) {
		System.out.println("------------------ AIP: Four of a Kind VS HTB: Full House ------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Given("^The AIP has a four of a Kind vs flush \"([^\"]*)\"$")
	public void the_AIP_has_a_four_of_a_Kind_vs_flush(String data) {
		System.out.println("------------------ AIP: Four of a Kind VS HTB: Flush ------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Given("^The AIP has a four of a Kind vs straight \"([^\"]*)\"$")
	public void the_AIP_has_a_four_of_a_Kind_vs_straight(String data) {
		System.out.println("------------------ AIP: Four of a Kind VS HTB: Straight ------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Given("^The AIP has a four of a Kind vs threeOfAKind \"([^\"]*)\"$")
	public void the_AIP_has_a_four_of_a_Kind_vs_threeOfAKind(String data) {
		System.out.println("------------------ AIP: Four of a Kind VS HTB: Three of a kind ------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Given("^The AIP has a four of a Kind vs twoPair \"([^\"]*)\"$")
	public void the_AIP_has_a_four_of_a_Kind_vs_twoPair(String data) {
		System.out.println("------------------ AIP: Four of a Kind VS HTB: Two Pair ------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Given("^The AIP has a four of a Kind vs pair \"([^\"]*)\"$")
	public void the_AIP_has_a_four_of_a_Kind_vs_pair(String data) {
		System.out.println("------------------ AIP: Four of a Kind VS HTB: Pair ------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Given("^The AIP has a four of a Kind vs highCard \"([^\"]*)\"$")
	public void the_AIP_has_a_four_of_a_Kind_vs_highCard(String data) {
		System.out.println("------------------ AIP: Four of a Kind VS HTB: High Card ------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Given("^the AIP holds the four of a Kind$")
	public void the_AIP_holds_the_four_of_a_Kind() {
		System.out.println("The AIP hand is " + game.AIP.cards);
		if (game.AIP.exchange() != 0) {
			Assert.fail("The AIP did not hold their cards");
		}
		System.out.println("The AIP Held their cards");
	}

	@Then("^the AIP \\(four of a Kind\\) beats the HTB$")
	public void the_AIP_four_of_a_Kind_beats_the_HTB() {
		game.findWinner();
		Assert.assertEquals(game.AIPWon(), true);
		System.out.println("The hand to beat is " + game.toBeat.cards);
		// System.out.println("The AIP hand is " + game.AIP.cards);
		System.out.println("AIP Won\n");
	}
}
