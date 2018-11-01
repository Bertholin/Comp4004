package Tests;

import org.junit.Assert;

import core.Game;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class AIP_FullHouseDefinitions {
	Game game;

	@Given("^The AIP has a fullHouse vs flush \"([^\"]*)\"$")
	public void the_AIP_has_a_fullHouse_vs_flush(String data) {
		System.out.println("------------------ AIP: Full House VS HTB: Flush ------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Given("^The AIP has a fullHouse vs straight \"([^\"]*)\"$")
	public void the_AIP_has_a_fullHouse_vs_straight(String data) {
		System.out.println("------------------ AIP: Full House VS HTB: Straight ------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Given("^The AIP has a fullHouse vs threeOfAKind \"([^\"]*)\"$")
	public void the_AIP_has_a_fullHouse_vs_threeOfAKind(String data) {
		System.out.println("------------------ AIP: Full House VS HTB: Three off a kind ------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Given("^The AIP has a fullHouse vs twoPair \"([^\"]*)\"$")
	public void the_AIP_has_a_fullHouse_vs_twoPair(String data) {
		System.out.println("------------------ AIP: Full House VS HTB: Two Pair ------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Given("^The AIP has a fullHouse vs pair \"([^\"]*)\"$")
	public void the_AIP_has_a_fullHouse_vs_pair(String data) {
		System.out.println("------------------ AIP: Full House VS HTB: Pair ------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Given("^The AIP has a fullHouse vs highCard \"([^\"]*)\"$")
	public void the_AIP_has_a_fullHouse_vs_highCard(String data) {
		System.out.println("------------------ AIP: Full House VS HTB: High Card ------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Given("^the AIP holds the fullHouse$")
	public void the_AIP_holds_the_fullHouse() {
		System.out.println("The AIP hand is " + game.AIP.cards);
		if (game.AIP.exchange() != 0) {
			Assert.fail("The AIP did not hold their cards");
		}
		System.out.println("The AIP Held their cards");
	}

	@Then("^the AIP \\(fullHouse\\) beats the HTB$")
	public void the_AIP_fullHouse_beats_the_HTB() {
		game.findWinner();
		Assert.assertEquals(game.AIPWon(), true);
		System.out.println("The hand to beat is " + game.toBeat.cards);
		// System.out.println("The AIP hand is " + game.AIP.cards);
		System.out.println("AIP Won\n");
	}
}
