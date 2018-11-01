package Tests;

import org.junit.Assert;

import core.Game;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class HTB_Straight_AIP {
	Game game;
	
	@Given("^The HTB has a straight vs threeOfAKind \"([^\"]*)\"$")
	public void the_HTB_has_a_straight_vs_threeOfAKind(String data) {
		System.out.println("------------------ HTB: Straight VS AIP:Three of A Kind ------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Given("^The HTB has a straight vs twoPair \"([^\"]*)\"$")
	public void the_HTB_has_a_straight_vs_twoPair(String data) {
		System.out.println("------------------ HTB: Straight VS AIP:Two Pair ------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Given("^The HTB has a straight vs pair \"([^\"]*)\"$")
	public void the_HTB_has_a_straight_vs_pair(String data) {
		System.out.println("------------------ HTB: Straight VS AIP:Pair ------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Given("^The HTB has a straight vs highCard \"([^\"]*)\"$")
	public void the_HTB_has_a_straight_vs_highCard(String data) {
		System.out.println("------------------ HTB: Straight VS AIP: High Card ------------------ ");
		game = new Game();
		game.evaluate(data);
	}
	
	@Then("^the HTB \\(straight\\) beats the AIP$")
	public void the_HTB_straight_beats_the_AIP() {
		game.findWinner();
		Assert.assertEquals(game.AIPWon(), false);
		System.out.println("The hand to beat is " + game.toBeat.cards);
		System.out.println("The AIP hand is " + game.AIP.cards);
		System.out.println("HTB Won\n");
	}
}
