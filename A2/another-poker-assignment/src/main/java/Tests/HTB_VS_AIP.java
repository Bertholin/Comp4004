package Tests;

import java.util.ArrayList;
import java.util.List;

import core.Card;
import core.Game;
import core.Player;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class HTB_VS_AIP {

	Game game;

	@Given("^The HTB has a Royal Flush \"([^\"]*)\"$")
	public void the_HTB_has_a_Royal_Flush(String data) {
		System.out.println("------------------ HTB: Royal Flush VS AIP: Straight Flush ------------------ ");
		game = new Game();
		game.evaluate(data);
	}

	@Then("^the HTB beats the AIP$")
	public void the_HTB_beats_the_AIP() {
		System.out.println("The hand to beat is " + game.toBeat.cards);
		System.out.println("The AIP hand is " + game.AIP.cards);

		game.findWinner();
		if (game.AIPWon() == false)
			System.out.println("HTB Won");
		else
			System.out.println("AIP Won");
	}
}
