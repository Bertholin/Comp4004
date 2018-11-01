package Tests;

import org.junit.Assert;

import core.Game;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class AIP_FlushDefinitions {
	Game game;
	
	@Given("^The AIP has a flush vs straight \"([^\"]*)\"$")
	public void the_AIP_has_a_flush_vs_straight(String data) {
		System.out.println("------------------ AIP: Flush VS HTB: Straight------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Given("^The AIP has a flush vs threeOfAKind \"([^\"]*)\"$")
	public void the_AIP_has_a_flush_vs_threeOfAKind(String data) {
		System.out.println("------------------ AIP: Flush VS HTB: Three of a kind ------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Given("^The AIP has a flush vs twoPair \"([^\"]*)\"$")
	public void the_AIP_has_a_flush_vs_twoPair(String data) {
		System.out.println("------------------ AIP: Flush VS HTB: Two Pair ------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Given("^The AIP has a flush vs pair \"([^\"]*)\"$")
	public void the_AIP_has_a_flush_vs_pair(String data) {
		System.out.println("------------------ AIP: Flush VS HTB: Pair ------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Given("^The AIP has a flush vs highCard \"([^\"]*)\"$")
	public void the_AIP_has_a_flush_vs_highCard(String data) {
		System.out.println("------------------ AIP: Flush VS HTB: High Card ------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Given("^the AIP holds the flush$")
	public void the_AIP_holds_the_flush(){
		System.out.println("The AIP hand is " + game.AIP.cards);
		if (game.AIP.exchange() != 0) {
			Assert.fail("The AIP did not hold their cards");
		}
		System.out.println("The AIP Held their cards");
	}

	@Then("^the AIP \\(flush\\) beats the HTB$")
	public void the_AIP_flush_beats_the_HTB() {
		game.findWinner();
		Assert.assertEquals(game.AIPWon(), true);
		System.out.println("The hand to beat is " + game.toBeat.cards);
		// System.out.println("The AIP hand is " + game.AIP.cards);
		System.out.println("AIP Won\n");
	}
}
