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
	ArrayList<Card> c;

	@Given("^The AIP has a Almost Royal Flush and exchanges a card win \"([^\"]*)\"$")
	public void the_AIP_has_a_Almost_Royal_Flush_and_exchanges_a_card_game(String data) {
		System.out.println("------------------ Almost Royal Flush and exchanges a card and wins ------------------ ");
		game = new Game();
		game.evaluate(data);
		System.out.println("The players hand is " + game.AIP.cards);
		c = new ArrayList<Card>();
		c.add(new Card("DJ"));
	}

	@Given("^The AIP has a Almost Royal Flush and exchanges a card lose \"([^\"]*)\"$")
	public void the_AIP_has_a_Almost_Royal_Flush_and_exchanges_a_card_lose(String data) {
		System.out.println("------------------ Almost Royal Flush and exchanges a card and loses ------------------ ");
		game = new Game();
		game.evaluate(data);
		System.out.println("The players hand is " + game.AIP.cards);
		c = new ArrayList<Card>();
		c.add(new Card("H3"));
	}

	@Given("^The AIP has a Almost Straight Flush and exchanges a card win \"([^\"]*)\"$")
	public void the_AIP_has_a_Almost_Straight_Flush_and_exchanges_a_card_win(String data) {
		System.out
				.println("------------------ Almost Straight Flush and exchanges a card and loses ------------------ ");
		game = new Game();
		game.evaluate(data);
		System.out.println("The players hand is " + game.AIP.cards);
		c = new ArrayList<Card>();
		c.add(new Card("S6"));
	}

	@Given("^The AIP has a Almost Straight Flush and exchanges a card lose \"([^\"]*)\"$")
	public void the_AIP_has_a_Almost_Straight_Flush_and_exchanges_a_card_lose(String data) {
		System.out
				.println("------------------ Almost Straight Flush and exchanges a card and loses ------------------ ");
		game = new Game();
		game.evaluate(data);
		System.out.println("The players hand is " + game.AIP.cards);
		c = new ArrayList<Card>();
		c.add(new Card("C5"));
	}

	@Given("^The AIP has three of a kind and exchanges a card win \"([^\"]*)\"$")
	public void the_AIP_has_three_of_a_kind_and_exchanges_a_card_win(String data) {
		System.out.println(
				"------------------ Three of a kind and exchanges a card and wins with Full house ------------------ ");
		game = new Game();
		game.evaluate(data);
		System.out.println("The players hand is " + game.AIP.cards);
		c = new ArrayList<Card>();
		c.add(new Card("D10"));
	}

	@Given("^The AIP has three of a kind and exchanges a card lose \"([^\"]*)\"$")
	public void the_AIP_has_three_of_a_kind_and_exchanges_a_card_lose(String data) {
		System.out.println(
				"------------------ Three of a kind and exchanges a card and loses with three of a kind ------------------ ");
		game = new Game();
		game.evaluate(data);
		System.out.println("The players hand is " + game.AIP.cards);
		c = new ArrayList<Card>();
		c.add(new Card("C5"));
	}

	@Given("^The AIP has two pair and exchanges a card win \"([^\"]*)\"$")
	public void the_AIP_has_two_pair_and_exchanges_a_card_win(String data) {
		System.out.println(
				"------------------ Two pair and exchanges a card and wins with Full house ------------------ ");
		game = new Game();
		game.evaluate(data);
		System.out.println("The players hand is " + game.AIP.cards);
		c = new ArrayList<Card>();
		c.add(new Card("C4"));
	}

	@Given("^The AIP has two pair and exchanges a card lose \"([^\"]*)\"$")
	public void the_AIP_has_two_pair_and_exchanges_a_card_lose(String data) {
		System.out.println(
				"------------------ Two pair and exchanges a card and loses with Two pair ------------------ ");
		game = new Game();
		game.evaluate(data);
		System.out.println("The players hand is " + game.AIP.cards);
		c = new ArrayList<Card>();
		c.add(new Card("C5"));
	}

	@Given("^The AIP has flush and exchanges a card win \"([^\"]*)\"$")
	public void the_AIP_has_flush_and_exchanges_a_card_win(String data) {
		System.out.println("------------------ flush and exchanges a card and wins with flush ------------------ ");
		game = new Game();
		game.evaluate(data);
		System.out.println("The players hand is " + game.AIP.cards);
		c = new ArrayList<Card>();
		c.add(new Card("C9"));
	}

	@Given("^The AIP has flush and exchanges a card lose \"([^\"]*)\"$")
	public void the_AIP_has_flush_and_exchanges_a_card_lose(String data) {
		System.out.println("------------------flush and exchanges a card and loses ------------------ ");
		game = new Game();
		game.evaluate(data);
		System.out.println("The players hand is " + game.AIP.cards);
		c = new ArrayList<Card>();
		c.add(new Card("D5"));
	}

	@Given("^The AIP has straight and exchanges a card win \"([^\"]*)\"$")
	public void the_AIP_has_straight_and_exchanges_a_card_win(String data) {
		System.out
				.println("------------------ Straight and exchanges a card and wins with straight ------------------ ");
		game = new Game();
		game.evaluate(data);
		System.out.println("The players hand is " + game.AIP.cards);
		c = new ArrayList<Card>();
		c.add(new Card("D5"));
	}

	@Given("^The AIP has straight and exchanges a card lose \"([^\"]*)\"$")
	public void the_AIP_has_straight_and_exchanges_a_card_lose(String data) {
		System.out.println("------------------Straight and exchanges a card and loses ------------------ ");
		game = new Game();
		game.evaluate(data);
		System.out.println("The players hand is " + game.AIP.cards);
		c = new ArrayList<Card>();
		c.add(new Card("D9"));
	}

	@Given("^The AIP has three of the same suit and exchanges two cards \"([^\"]*)\"$")
	public void the_AIP_has_three_of_the_same_suit_and_exchanges_two_cards(String data) {
		System.out.println("------------------ Three of the same suit and exchanges two cards ------------------ ");
		game = new Game();
		game.evaluate(data);
		System.out.println("The players hand is " + game.AIP.cards);
		c = new ArrayList<Card>();
		c.add(new Card("D9"));
		c.add(new Card("S2"));
	}

	@Given("^The AIP has three in a sequence and exchanges two cards \"([^\"]*)\"$")
	public void the_AIP_has_three_in_a_sequence_and_exchanges_a_cards(String data) {
		System.out.println("------------------ Three in a sequence and exchanges a cards ------------------ ");
		game = new Game();
		game.evaluate(data);
		System.out.println("The players hand is " + game.AIP.cards);
		c = new ArrayList<Card>();
		c.add(new Card("D9"));
		c.add(new Card("S2"));
	}
	
	@Given("^The AIP has one pair and exchanges three cards \"([^\"]*)\"$")
	public void the_AIP_has_one_pair_and_exchanges_three_cards(String data) {
		System.out.println("------------------ One pair and exchanges three cards ------------------ ");
		game = new Game();
		game.evaluate(data);
		System.out.println("The players hand is " + game.AIP.cards);
		c = new ArrayList<Card>();
		c.add(new Card("D9"));
		c.add(new Card("S2"));
		c.add(new Card("S8"));
	}
	
	@Given("^The AIP has No pair and Holds the two highest \"([^\"]*)\"$")
	public void the_AIP_has_No_pair_and_Holds_the_two_highest(String data) {
		System.out.println("------------------ No pair and Holds the two highest ------------------ ");
		game = new Game();
		game.evaluate(data);
		System.out.println("The players hand is " + game.AIP.cards);
		c = new ArrayList<Card>();
		c.add(new Card("D9"));
		c.add(new Card("S2"));
		c.add(new Card("S8"));
	}
	
	@Given("^The HTB and AIP both have Royal Flushes \"([^\"]*)\"$")
	public void the_HTB_and_AIP_both_have_Royal_Flushes(String data) {
		System.out.println("------------------ HTB and AIP both have Royal Flushes and highest suit wins ------------------ ");
		game = new Game();
		game.playWithoutExchange(data);
	}

	@Given("^The HTB and AIP both have Straight Flushes with distinct high card \"([^\"]*)\"$")
	public void the_HTB_and_AIP_both_have_Straight_Flushes_with_distinct_high_card(String data) {
		System.out.println("------------------ HTB and AIP both have Straight Flushes with distinct high card ------------------ ");
		game = new Game();
		game.playWithoutExchange(data);
	}
	
	@Given("^The HTB and AIP both have Straight Flushes with same high card \"([^\"]*)\"$")
	public void the_HTB_and_AIP_both_have_Straight_Flushes_with_same_high_card(String data) {
		System.out.println("------------------ HTB and AIP both have Straight Flushes with same high card  ------------------ ");
		game = new Game();
		game.playWithoutExchange(data);
	}

	@Given("^The HTB and AIP both have four of a kind \"([^\"]*)\"$")
	public void the_HTB_and_AIP_both_have_four_of_a_kind(String data) {
		System.out.println("------------------ HTB and AIP both have four of a kind and quad wins ------------------ ");
		game = new Game();
		game.playWithoutExchange(data);
	}

	@Given("^The HTB and AIP both have full house \"([^\"]*)\"$")
	public void the_HTB_and_AIP_both_have_full_house(String data) {
		System.out.println("------------------ HTB and AIP both have full house and highest tripple wins ------------------ ");
		game = new Game();
		game.playWithoutExchange(data);
	}

	@Given("^The HTB and AIP both have three of a kind \"([^\"]*)\"$")
	public void the_HTB_and_AIP_both_have_three_of_a_kind(String data) {
		System.out.println("------------------ HTB and AIP both have three of a kind and highest tripple wins ------------------ ");
		game = new Game();
		game.playWithoutExchange(data);
	}
	
	@Given("^The HTB and AIP both have Straight with same high card \"([^\"]*)\"$")
	public void the_HTB_and_AIP_both_have_Straight_with_same_high_card(String data) {
		System.out.println("------------------ HTB and AIP both have Straight with same number and highest suit wins ------------------ ");
		game = new Game();
		game.playWithoutExchange(data);
	}
	
	@Given("^The HTB and AIP both have Straight with distinct high card \"([^\"]*)\"$")
	public void the_HTB_and_AIP_both_have_Straight_with_distinct_high_card(String data) {
		System.out.println("------------------ HTB and AIP both have Straight with distinct high card wins ------------------ ");
		game = new Game();
		game.playWithoutExchange(data);
	}

	@Then("^the AIP changes a card and win$")
	public void the_AIP_changes_a_card() {
		game.exchange(c);
		c.clear();
		System.out.println("The amount of cards exchanged was " + game.getNumExchanged());
		System.out.println("The Card that is being discarded is " + game.AIP.getDiscarded());
		System.out.println("The new hand is " + game.AIP.cards);
		game.findWinner();
		Assert.assertEquals(game.AIPWon(), true);
		System.out.println("AIP Won\n");
	}

	@Then("^the AIP changes a card and loses$")
	public void the_AIP_changes_a_card_and_loses() {
		game.exchange(c);
		c.clear();
		System.out.println("The amount of cards exchanged was " + game.getNumExchanged());
		System.out.println("The Card that is being discarded is " + game.AIP.getDiscarded());
		System.out.println("The new hand is " + game.AIP.cards);
		game.findWinner();
		Assert.assertEquals(game.AIPWon(), false);
		System.out.println("AIP Lose\n");
	}

	@Then("^we dont care about the outcome$")
	public void we_dont_care_about_the_outcome() {
		game.exchange(c);
		c.clear();
		if(game.getNumExchanged() < 2)
			Assert.assertEquals(true,  false);
		
		System.out.println("The amount of cards exchanged was " + game.getNumExchanged());
		System.out.println("The Card that is being discarded is " + game.AIP.getDiscarded());
		System.out.println("The new hand is " + game.AIP.cards);
		System.out.println("Dont care who wins\n");
	}
	
	@Then("^the highest suit wins$")
	public void the_highest_suit_wins() {
		Assert.assertEquals(game.AIPWon(), false);
		System.out.println("HTB Won\n");
	}
}
