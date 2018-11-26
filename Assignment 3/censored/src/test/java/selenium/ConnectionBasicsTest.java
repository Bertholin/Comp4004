package selenium;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;

import config.SeleniumTest;
import selenium.page.IndexPage;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.concurrent.TimeUnit;

/**
 * Test the ability to connect and disconnect to the game.
 * 
 */
@SeleniumTest
public class ConnectionBasicsTest extends AbstractSeleniumTest {

	@Autowired
	private IndexPage indexPage;

	@Test
	public void canConnect() {

		this.indexPage.connect.click();
		this.delay(3);
		assertThat(this.indexPage.hasText("Successfully connected to the game with unique "), is(true));
		assertThat(this.indexPage.hasText("You have been designated the admin for this game."), is(true));

		this.indexPage.disconnect.click();
		assertThat(this.indexPage.hasText("Connection closed"), is(true));

	}

	@Test
	public void canOpenLobby() {
		this.indexPage.connect.click();
		this.delay(3);
		this.indexPage.open.click();
		this.delay(3);
		// 1: missing assertThat lobby is open
		assertThat(this.indexPage.hasText("The game is now ready to begin."), is(true));
		this.indexPage.disconnect.click();
	}

	@Test
	public void canConenctTwoPlayers() {
		// connect
		// 2: missing code
		this.indexPage.connect.click();
		this.delay(3);
		this.indexPage.setNumberPlayers(2);
		this.indexPage.open.click();
		this.delay(3);
		assertThat(
				this.indexPage
						.hasText("Successfully connected to the game with unique id " + this.indexPage.getPlayerUID()),
				is(true));
		// second connect
		// 3: missing code
		ChromeDriver p2 = quickConnectAnotherUser();
		this.indexPage.start.click();
		this.delay(3);
		
		String[] players = this.indexPage.getUsetTexts();
		int count = 0;
		for (int i = 0; i < players.length; ++i) {
			if (!players[i].contains("AI"))
				++count;
		}
		// check to see that two players are in game
		assertThat(count, is(2));

		// quit
		// 4: missing code
		this.indexPage.disconnect.click();
		assertThat(this.indexPage.hasText("Connection closed"), is(true));
	}

	@Test
	public void canConenctMultiplePlayers() {
		// connect
		// 5: missing code
		this.indexPage.connect.click();
		this.delay(3);
		this.indexPage.setNumberPlayers(3);
		this.indexPage.open.click();
		this.delay(3);
		assertThat(
				this.indexPage
						.hasText("Successfully connected to the game with unique id " + this.indexPage.getPlayerUID()),
				is(true));
		// connect second
		// 6: missing code
		ChromeDriver p2 = quickConnectAnotherUser();
		// connect third then disconnect
		// 7: missing code
		ChromeDriver p3 = quickConnectAnotherUser();
		this.indexPage.start.click();
		this.delay(3);

		String[] players = this.indexPage.getUsetTexts();
		int count = 0;
		for (int i = 0; i < players.length; ++i) {
			if (!players[i].contains("AI"))
				++count;
		}
		// check to see that two players are in game
		assertThat(count, is(3));

		this.indexPage.disconnect.click();
		assertThat(this.indexPage.hasText("Connection closed"), is(true));
	}

	@Test
	public void canStartGame() {
		this.indexPage.connect.click();
		this.delay(3);
		this.indexPage.open.click();
		this.delay(3);
		this.indexPage.start.click();
		this.delay(3);
		// 8: missing assertThat the game has started
		assertThat(this.indexPage.hasText("The game has started!"), is(true));
		this.indexPage.disconnect.click();
	}

}
