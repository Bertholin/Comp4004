package Tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import core.Card;
import core.Game;
import core.Player;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class HTB_VS_AIP {

	Game game;

	@Given("^The HTB has a Royal Flush vs straightFlush \"([^\"]*)\"$")
	public void the_HTB_has_a_Royal_Flush_vs_straightFlush(String data) {
		System.out.println("------------------ HTB: Royal Flush VS AIP: Straight Flush ------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Given("^The HTB has a Royal Flush vs fourOfAKind \"([^\"]*)\"$")
	public void the_HTB_has_a_Royal_Flush_vs_fourOfAKind(String data) {
		System.out.println("------------------ HTB: Royal Flush VS AIP: Four Of A Kind ------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Given("^The HTB has a Royal Flush vs fullHouse \"([^\"]*)\"$")
	public void the_HTB_has_a_Royal_Flush_vs_fullHouse(String data) {
		System.out.println("------------------ HTB: Royal Flush VS AIP: Full House ------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Given("^The HTB has a Royal Flush vs flush \"([^\"]*)\"$")
	public void the_HTB_has_a_Royal_Flush_vs_flush(String data) {
		System.out.println("------------------ HTB: Royal Flush VS AIP: Flush ------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Given("^The HTB has a Royal Flush vs straight \"([^\"]*)\"$")
	public void the_HTB_has_a_Royal_Flush_vs_straight(String data) {
		System.out.println("------------------ HTB: Royal Flush VS AIP: Straight ------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Given("^The HTB has a Royal Flush vs threeOfAKind \"([^\"]*)\"$")
	public void the_HTB_has_a_Royal_Flush_vs_threeOfAKind(String data) {
		System.out.println("------------------ HTB: Royal Flush VS AIP: Three Of A Kind ------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Given("^The HTB has a Royal Flush vs twoPair \"([^\"]*)\"$")
	public void the_HTB_has_a_Royal_Flush_vs_twoPair(String data) {
		System.out.println("------------------ HTB: Royal Flush VS AIP: Two Pair ------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Given("^The HTB has a Royal Flush vs pair \"([^\"]*)\"$")
	public void the_HTB_has_a_Royal_Flush_vs_pair(String data) {
		System.out.println("------------------ HTB: Royal Flush VS AIP: Pair ------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Given("^The HTB has a Royal Flush vs highCard \"([^\"]*)\"$")
	public void the_HTB_has_a_Royal_Flush_vs_highCard(String data) {
		System.out.println("------------------ HTB: Royal Flush VS AIP: High Card ------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Then("^the HTB beats the AIP$")
	public void the_HTB_beats_the_AIP() {
		game.findWinner();
		Assert.assertEquals(game.AIPWon(), false);
		System.out.println("The hand to beat is " + game.toBeat.cards);
		System.out.println("The AIP hand is " + game.AIP.cards);
		System.out.println("HTB Won\n");
	}

}
