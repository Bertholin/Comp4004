package Tests;

import org.junit.Assert;

import core.Game;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class AIP_RoyalFlushDefinitions {
	Game game;
	@Given("^The AIP has a Royal Flush vs straightFlush \"([^\"]*)\"$")
	public void the_AIP_has_a_Royal_Flush_vs_straightFlush(String data) {
		System.out.println("------------------ AIP: Royal Flush VS HTB: Straight Flush ------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Given("^The AIP has a Royal Flush vs fourOfAKind \"([^\"]*)\"$")
	public void the_AIP_has_a_Royal_Flush_vs_fourOfAKind(String data) {
		System.out.println("------------------ AIP: Royal Flush VS HTB: Four of a kind------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Given("^The AIP has a Royal Flush vs fullHouse \"([^\"]*)\"$")
	public void the_AIP_has_a_Royal_Flush_vs_fullHouse(String data) {
		System.out.println("------------------ AIP: Royal Flush VS HTB: Full House ------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Given("^The AIP has a Royal Flush vs flush \"([^\"]*)\"$")
	public void the_AIP_has_a_Royal_Flush_vs_flush(String data) {
		System.out.println("------------------ AIP: Royal Flush VS HTB: Flush ------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Given("^The AIP has a Royal Flush vs straight \"([^\"]*)\"$")
	public void the_AIP_has_a_Royal_Flush_vs_straight(String data) {
		System.out.println("------------------ AIP: Royal Flush VS HTB: Straight ------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Given("^The AIP has a Royal Flush vs threeOfAKind \"([^\"]*)\"$")
	public void the_AIP_has_a_Royal_Flush_vs_threeOfAKind(String data) {
		System.out.println("------------------ AIP: Royal Flush VS HTB: Three of a kind ------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Given("^The AIP has a Royal Flush vs twoPair \"([^\"]*)\"$")
	public void the_AIP_has_a_Royal_Flush_vs_twoPair(String data) {
		System.out.println("------------------ AIP: Royal Flush VS HTB: Two Pair ------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Given("^The AIP has a Royal Flush vs pair \"([^\"]*)\"$")
	public void the_AIP_has_a_Royal_Flush_vs_pair(String data) {
		System.out.println("------------------ AIP: Royal Flush VS HTB: Pair ------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Given("^The AIP has a Royal Flush vs highCard \"([^\"]*)\"$")
	public void the_AIP_has_a_Royal_Flush_vs_highCard(String data) {
		System.out.println("------------------ AIP: Royal Flush VS HTB: High Card ------------------ ");
		game = new Game();
		game.evaluate(data);
	}
	
	@Given("^the AIP holds the Royal Flush$")
	public void the_AIP_holds() throws Throwable {
		System.out.println("The AIP hand is " + game.AIP.cards);
	    if(game.AIP.exchange() != 0) {
	    	Assert.fail("The AIP did not hold their cards");
	    }
	    System.out.println("The AIP Held their cards");
	}

	@Then("^the AIP \\(Royal Flush\\) beats the HTB$")
	public void the_AIP_Royal_Flush_beats_the_HTB() throws Throwable {
		game.findWinner();
		Assert.assertEquals(game.AIPWon(), true);
		System.out.println("The hand to beat is " + game.toBeat.cards);
		//System.out.println("The AIP hand is " + game.AIP.cards);
		System.out.println("AIP Won\n");
	}
}
