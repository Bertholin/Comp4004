package selenium;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Autowired;

import ca.carleton.poker.game.entity.card.Card;
import ca.carleton.poker.game.entity.card.Hand;
import ca.carleton.poker.game.entity.card.Rank;
import ca.carleton.poker.game.entity.card.Suit;
import config.SeleniumTest;
import selenium.page.IndexPage;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import java.util.concurrent.TimeUnit;

/**
 * 
 */
@SeleniumTest
public class Strategy1Tests extends AbstractSeleniumTest {

	@Autowired
	private IndexPage indexPage;

	@Test
	public void S1Test1() {
		this.indexPage.connect.click();
		this.waitForDisplayed(this.indexPage.open).isEnabled();
		this.delay(2);
		this.indexPage.open.click(); // defaults is 1 player
		this.waitForDisplayed(this.indexPage.rig).isEnabled();
		this.indexPage.rig.click();

		/************************* Set initial hands ************************/
		// Player highcard
		this.waitForAlert();
		Alert a = this.webDriver.switchTo().alert();
		a.sendKeys("rank-2 hearts, rank-3 spades, rank-4 clubs, rank-9 spades, rank-k clubs");
		a.accept();

		// other 1 Royal Flush
		a = this.webDriver.switchTo().alert();
		a.sendKeys("rank-10 hearts, rank-j hearts, rank-q hearts, rank-k hearts, rank-a hearts");
		a.accept();

		// other 2 Two Pair change 0,3,4
		this.waitForAlert();
		a = this.webDriver.switchTo().alert();
		a.sendKeys("rank-2 clubs, rank-6 hearts, rank-6 clubs, rank-q spades, rank-q diams");
		a.accept();

		// other 3 Flush
		this.waitForAlert();
		a = this.webDriver.switchTo().alert();
		a.sendKeys("rank-7 diams, rank-2 diams, rank-4 diams, rank-10 diams, rank-j diams");
		a.accept();

		assertThat(this.indexPage.hasText("Setting all cards"), is(true));

		// gets the user ids
		String[] players = this.indexPage.getUsetTexts();

		// checks to make sure the first AI stays with ROYAL_Flush
		assertThat(this.indexPage.hasText(players[0] + " choose to STAY"), is(true));

		// the second AI should hit and wait for a prompt to get new cards
		this.waitForAlert();
		a = this.webDriver.switchTo().alert();
		a.sendKeys("0:rank-6 spades");
		a.accept();
		assertThat(this.indexPage.hasText(players[1] + " choose to HIT"), is(true));

		// the third AI should hit and wait for a prompt to get new cards
		assertThat(this.indexPage.hasText(players[2] + " choose to STAY"), is(true));

		// player choose to stay
		this.delay(3);
		this.indexPage.stay.click();

		// results
		assertThat(this.indexPage.hasText(players[0] + " won with a score of ROYAL_FLUSH, ranked 1!"), is(true));
		assertThat(this.indexPage.hasText(players[1] + " lost with a score of FULL_HOUSE, ranked 2!"), is(true));
		assertThat(this.indexPage.hasText(players[2] + " lost with a score of FLUSH, ranked 3!"), is(true));
		assertThat(this.indexPage.hasText(players[3] + " lost with a score of HIGH_CARD, ranked 4!"), is(true));
		this.indexPage.disconnect.click();
	}

	@Test
	public void S1Test2() {
		this.indexPage.connect.click();
		this.waitForDisplayed(this.indexPage.open).isEnabled();
		this.delay(2);
		this.indexPage.open.click(); // defaults is 1 player
		this.waitForDisplayed(this.indexPage.rig).isEnabled();
		this.indexPage.rig.click();

		// Player highcard
		this.waitForAlert();
		Alert a = this.webDriver.switchTo().alert();
		a.sendKeys("rank-2 hearts, rank-3 spades, rank-4 clubs, rank-9 spades, rank-k clubs");
		a.accept();

		// other 1 Straight
		a = this.webDriver.switchTo().alert();
		a.sendKeys("rank-2 diams, rank-3 spades, rank-4 diams, rank-5 clubs, rank-6 diams");
		a.accept();

		// other 2 Four of a kind
		this.waitForAlert();
		a = this.webDriver.switchTo().alert();
		a.sendKeys("rank-2 clubs, rank-6 hearts, rank-6 clubs, rank-6 spades, rank-6 diams");
		a.accept();

		// other 3 Three Pair change 2,4
		this.waitForAlert();
		a = this.webDriver.switchTo().alert();
		a.sendKeys("rank-7 diams, rank-7 spades, rank-4 diams, rank-7 clubs, rank-6 diams");
		a.accept();

		// gets the user ids
		String[] players = this.indexPage.getUsetTexts();
		// the second AI should hit
		assertThat(this.indexPage.hasText(players[0] + " choose to STAY"), is(true));

		// the second AI should hit
		assertThat(this.indexPage.hasText(players[1] + " choose to STAY"), is(true));

		// the third AI should hit and wait for a prompt to get new cards
		this.waitForAlert();
		a = this.webDriver.switchTo().alert();
		a.sendKeys("2:rank-a clubs, 4:rank-a hearts");
		a.accept();
		assertThat(this.indexPage.hasText(players[2] + " choose to HIT"), is(true));

		// player choose to stay
		this.delay(3);
		this.indexPage.stay.click();

		// results
		assertThat(this.indexPage.hasText(players[1] + " won with a score of FOUR_OF_A_KIND, ranked 1!"), is(true));
		assertThat(this.indexPage.hasText(players[0] + " lost with a score of STRAIGHT, ranked 2!"), is(true));
		assertThat(this.indexPage.hasText(players[2] + " lost with a score of ONE_PAIR, ranked 3!"), is(true));
		assertThat(this.indexPage.hasText(players[3] + " lost with a score of HIGH_CARD, ranked 4!"), is(true));

		this.indexPage.disconnect.click();
	}

	// more tests

}
