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
public class Strategy2Tests extends AbstractSeleniumTest {

	@Autowired
	private IndexPage indexPage;

	@Test
	public void S2Test1() {
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

		// other 1 Straight Flush
		a = this.webDriver.switchTo().alert();
		a.sendKeys("rank-2 clubs, rank-3 clubs, rank-4 clubs, rank-5 clubs, rank-6 clubs");
		a.accept();

		// other 2 one Pair
		this.waitForAlert();
		a = this.webDriver.switchTo().alert();
		a.sendKeys("rank-3 clubs, rank-6 hearts, rank-9 clubs, rank-3 spades, rank-q diams");
		a.accept();

		// other 3 Three of it kind
		this.waitForAlert();
		a = this.webDriver.switchTo().alert();
		a.sendKeys("rank-j clubs, rank-j hearts, rank-j spades, rank-3 diams, rank-8 spades");
		a.accept();

		assertThat(this.indexPage.hasText("Setting all cards"), is(true));
		/****************************** check user options ************************/

		String[] players = this.indexPage.getUsetTexts();
		assertThat(this.indexPage.hasText(players[0] + " choose to STAY"), is(true));

		this.waitForAlert();
		a = this.webDriver.switchTo().alert();
		a.sendKeys("2:rank-a clubs, 3:rank-a hearts, 4:rank-a spades");
		a.accept();
		assertThat(this.indexPage.hasText(players[1] + " choose to HIT"), is(true));

		this.waitForAlert();
		a = this.webDriver.switchTo().alert();
		a.sendKeys("0:rank-6 clubs, 1:rank-4 spades");
		a.accept();
		assertThat(this.indexPage.hasText(players[2] + " choose to HIT"), is(true));

		this.delay(2);

		this.indexPage.stay.click();
		this.delay(4);
		
		assertThat(this.indexPage.hasText(players[0] + " won with a score of STRAIGHT_FLUSH, ranked 1!"), is(true));
		assertThat(this.indexPage.hasText(players[1] + " lost with a score of FULL_HOUSE, ranked 2!"), is(true));
		assertThat(this.indexPage.hasText(players[2] + " lost with a score of THREE_OF_A_KIND, ranked 3!"), is(true));
		assertThat(this.indexPage.hasText(players[3] + " lost with a score of HIGH_CARD, ranked 4!"), is(true));

		this.delay(4);
		this.indexPage.disconnect.click();
	}
}
