package Tests;

import org.junit.Assert;

import core.Game;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class AIP_StraightFlushDefinitions {
	Game game;

	@Given("^The AIP has a Straight Flush vs fourOfAKind \"([^\"]*)\"$")
	public void the_AIP_has_a_Straight_Flush_vs_fourOfAKind(String data) {
		System.out.println("------------------ AIP: Straight Flush VS HTB: Four of a Kind ------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Given("^The AIP has a Straight Flush vs fullHouse \"([^\"]*)\"$")
	public void the_AIP_has_a_Straight_Flush_vs_fullHouse(String data) {
		System.out.println("------------------ AIP: Straight Flush VS HTB: Full House ------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Given("^The AIP has a Straight Flush vs flush \"([^\"]*)\"$")
	public void the_AIP_has_a_Straight_Flush_vs_flush(String data) {
		System.out.println("------------------ AIP: Straight Flush VS HTB: Flush ------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Given("^The AIP has a Straight Flush vs straight \"([^\"]*)\"$")
	public void the_AIP_has_a_Straight_Flush_vs_straight(String data) {
		System.out.println("------------------ AIP: Straight Flush VS HTB: Straight ------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Given("^The AIP has a Straight Flush vs threeOfAKind \"([^\"]*)\"$")
	public void the_AIP_has_a_Straight_Flush_vs_threeOfAKind(String data) {
		System.out.println("------------------ AIP: Straight Flush VS HTB: Three of a Kind ------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Given("^The AIP has a Straight Flush vs twoPair \"([^\"]*)\"$")
	public void the_AIP_has_a_Straight_Flush_vs_twoPair(String data) {
		System.out.println("------------------ AIP: Straight Flush VS HTB: Two Pair ------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Given("^The AIP has a Straight Flush vs pair \"([^\"]*)\"$")
	public void the_AIP_has_a_Straight_Flush_vs_pair(String data) {
		System.out.println("------------------ AIP: Straight Flush VS HTB: Pair ------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Given("^The AIP has a Straight Flush vs highCard \"([^\"]*)\"$")
	public void the_AIP_has_a_Straight_Flush_vs_highCard(String data) {
		System.out.println("------------------ AIP: Straight Flush VS HTB: High Card ------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Given("^the AIP holds the Straight Flush$")
	public void the_AIP_holds_the_Straight_Flush() {
		System.out.println("The AIP hand is " + game.AIP.cards);
		if (game.AIP.exchange() != 0) {
			Assert.fail("The AIP did not hold their cards");
		}
		System.out.println("The AIP Held their cards");
	}

	@Then("^the AIP \\(Straight Flush\\) beats the HTB$")
	public void the_AIP_Straight_Flush_beats_the_HTB() {
		game.findWinner();
		Assert.assertEquals(game.AIPWon(), true);
		System.out.println("The hand to beat is " + game.toBeat.cards);
		//System.out.println("The AIP hand is " + game.AIP.cards);
		System.out.println("AIP Won\n");
	}
}
