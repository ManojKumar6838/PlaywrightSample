package testscriptstest;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class Interactions {

	@Test
	public void interactions() throws InterruptedException {
		Playwright playwright=Playwright.create();
		Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://demowebshop.tricentis.com/");
		Locator textBox = page.locator("input#small-searchterms");
		textBox.fill("Hello Machha");
		String text = textBox.inputValue();
		System.out.println(text);
		String nameValue = textBox.getAttribute("name");
		System.out.println(nameValue);
		page.locator(".ico-login").click();
		Locator checkBox = page.locator("#RememberMe");
		System.out.println(checkBox.isChecked());
		PlaywrightAssertions.assertThat(checkBox).not().isChecked();
		checkBox.click();
		PlaywrightAssertions.assertThat(checkBox).isChecked();
		PlaywrightAssertions.assertThat(textBox).hasAttribute("value", "Search store");
		Thread.sleep(3000);
		playwright.close();
	}
}
