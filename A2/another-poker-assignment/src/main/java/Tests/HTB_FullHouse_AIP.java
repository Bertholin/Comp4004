package Tests;

import org.junit.Assert;

import core.Game;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class HTB_FullHouse_AIP {
	Game game;
	
	@Given("^The HTB has a full house vs flush \"([^\"]*)\"$")
	public void the_HTB_has_a_full_house_vs_flush(String data) {
		System.out.println("------------------ HTB: Full House VS AIP: Flush ------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Given("^The HTB has a full house vs straight \"([^\"]*)\"$")
	public void the_HTB_has_a_full_house_vs_straight(String data) {
		System.out.println("------------------ HTB: Full House VS AIP: Straight ------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Given("^The HTB has a full house vs threeOfAKind \"([^\"]*)\"$")
	public void the_HTB_has_a_full_house_vs_threeOfAKind(String data) {
		System.out.println("------------------ HTB: Full House VS AIP: Three of A Kind ------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Given("^The HTB has a full house vs twoPair \"([^\"]*)\"$")
	public void the_HTB_has_a_full_house_vs_twoPair(String data) {
		System.out.println("------------------ HTB: Full House VS AIP: Two Pair ------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Given("^The HTB has a full house vs pair \"([^\"]*)\"$")
	public void the_HTB_has_a_full_house_vs_pair(String data) {
		System.out.println("------------------ HTB: Full House VS AIP: Pair------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Given("^The HTB has a full house vs highCard \"([^\"]*)\"$")
	public void the_HTB_has_a_full_house_vs_highCard(String data) {
		System.out.println("------------------ HTB: Full House VS AIP: High Card ------------------ ");
		game = new Game();
		game.evaluate(data);
	}
	
	@Then("^the HTB \\(full house\\) beats the AIP$")
	public void the_HTB_full_house_beats_the_AIP() {
		game.findWinner();
		Assert.assertEquals(game.AIPWon(), false);
		System.out.println("The hand to beat is " + game.toBeat.cards);
		System.out.println("The AIP hand is " + game.AIP.cards);
		System.out.println("HTB Won\n");
	}
}
