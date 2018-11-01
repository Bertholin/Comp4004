package Tests;

import org.junit.Assert;

import core.Game;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class AIP_StraightDefinitions {
	Game game;
	@Given("^The AIP has a straight vs threeOfAKind \"([^\"]*)\"$")
	public void the_AIP_has_a_straight_vs_threeOfAKind(String data) {
		System.out.println("------------------ AIP: Straight VS HTB: Thrree of a kind------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Given("^The AIP has a straight vs twoPair \"([^\"]*)\"$")
	public void the_AIP_has_a_straight_vs_twoPair(String data) {
		System.out.println("------------------ AIP: Straight VS HTB: Two Pair ------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Given("^The AIP has a straight vs pair \"([^\"]*)\"$")
	public void the_AIP_has_a_straight_vs_pair(String data) {
		System.out.println("------------------ AIP: Straight VS HTB: Pair ------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Given("^The AIP has a straight vs highCard \"([^\"]*)\"$")
	public void the_AIP_has_a_straight_vs_highCard(String data) {
		System.out.println("------------------ AIP: Straight VS HTB: High Card ------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Given("^the AIP holds the straight$")
	public void the_AIP_holds_the_straight() {
		System.out.println("The AIP hand is " + game.AIP.cards);
		if (game.AIP.exchange() != 0) {
			Assert.fail("The AIP did not hold their cards");
		}
		System.out.println("The AIP Held their cards");
	}

	@Then("^the AIP \\(straight\\) beats the HTB$")
	public void the_AIP_straight_beats_the_HTB() {
		game.findWinner();
		Assert.assertEquals(game.AIPWon(), true);
		System.out.println("The hand to beat is " + game.toBeat.cards);
		// System.out.println("The AIP hand is " + game.AIP.cards);
		System.out.println("AIP Won\n");
	}
}
