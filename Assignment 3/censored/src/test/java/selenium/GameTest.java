package selenium;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Autowired;

import config.SeleniumTest;
import selenium.page.IndexPage;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import java.util.concurrent.TimeUnit;

/**
 * 
 */
@SeleniumTest
public class GameTest extends AbstractSeleniumTest {

	@Autowired
	private IndexPage indexPage;

	@Test
	public void processAI() {
		// connect
		this.indexPage.connect.click();
		this.delay(3);
		this.indexPage.open.click();
		this.delay(3);
		// 9: missing code including check all AI players have made their choices
		this.indexPage.start.click();
		this.delay(3);
		assertThat(this.indexPage.hasText("All AI players have made their choices."), is(true));
		
		this.indexPage.disconnect.click();
		
	}

	@Test
	public void canUseStayOption() {
		// 10: missing code for connect then selecting stay then disconnect
		this.indexPage.connect.click();
		this.delay(3);
		this.indexPage.open.click();
		this.delay(3);
		this.indexPage.start.click();
		
		this.indexPage.stay.click();
		this.delay(3);
		assertThat(this.indexPage.hasText("You decided to STAY. Sending to server"), is(true));
		this.indexPage.disconnect.click();
	}

	@Test
	public void canUseHitOption() {
		// 11: missing code similar to 11
		this.indexPage.connect.click();
		this.delay(3);
		this.indexPage.open.click();
		this.delay(3);
		this.indexPage.start.click();
		
		this.indexPage.hit.click();
		this.delay(3);
		assertThat(this.indexPage.hasText("You decided to HIT. Sending to server"), is(true));
		this.indexPage.disconnect.click();
	}

	@Test
	public void canImproveCards() {
		// 12: missing code for connect, improve and disconnect
		this.indexPage.connect.click();
		this.delay(3);
		this.indexPage.open.click();
		this.delay(3);
		this.indexPage.start.click();
		this.delay(3);
		this.indexPage.hit.click();
		this.delay(3);
		this.indexPage.playerHandCards.findElement(By.id("PlayerCard1")).findElement(By.tagName("input")).click();
		this.indexPage.playerHandCards.findElement(By.id("PlayerCard2")).findElement(By.tagName("input")).click();
		this.delay(3);
		this.indexPage.done.click();
		assertThat(this.indexPage.hasText("You decided to improve card"), is(true));
		this.delay(10);
		this.indexPage.disconnect.click();
		
	}

}
