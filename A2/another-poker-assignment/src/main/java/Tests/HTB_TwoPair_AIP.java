package Tests;

import org.junit.Assert;

import core.Game;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class HTB_TwoPair_AIP {
	Game game;
	
	@Given("^The HTB has a two pair vs pair \"([^\"]*)\"$")
	public void the_HTB_has_a_two_pair_vs_pair(String data) {
		System.out.println("------------------ HTB: Two Pair VS AIP: Pair ------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Given("^The HTB has a two pair vs highCard \"([^\"]*)\"$")
	public void the_HTB_has_a_two_pair_vs_highCard(String data) {
		System.out.println("------------------ HTB: Two Pair VS AIP: High Card ------------------ ");
		game = new Game();
		game.evaluate(data);
	}
	
	@Then("^the HTB \\(two pair\\) beats the AIP$")
	public void the_HTB_two_pair_beats_the_AIP() throws Throwable {
		game.findWinner();
		Assert.assertEquals(game.AIPWon(), false);
		System.out.println("The hand to beat is " + game.toBeat.cards);
		System.out.println("The AIP hand is " + game.AIP.cards);
		System.out.println("HTB Won\n");;
	}
}
