package Tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import core.AIPlayer;
import core.Card;
import core.Game;
import core.Hand;
import core.Player;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class AIP_StrategyDefinitions {
	Game game;
	
	@Given("^The AIP has a Almost Royal Flush and exchanges a card game \"([^\"]*)\"$")
	public void the_AIP_has_a_Almost_Royal_Flush_and_exchanges_a_card_game(String data) {
		System.out.println("------------------ AIP: Four of a Kind VS HTB: Full House ------------------ ");
		game = new Game();
		game.evaluate(data);
		System.out.println("The players hand is " + game.AIP.cards);
	}

	@Then("^the AIP changes a card$")
	public void the_AIP_changes_a_card() {
		System.out.println("The amount of cards exchanged was " + game.getNumExchanged());
		System.out.println("The Card that is being discarded is " + game.AIP.getDiscarded());
		game.exchange();
		System.out.println("The new hand is " + game.AIP.cards + "\n");
	}
}
