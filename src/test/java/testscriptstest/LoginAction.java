package testscriptstest;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LoginAction {

	@Test
	public void loginTest() throws InterruptedException {
		Playwright playwright=Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://demowebshop.tricentis.com/");
		System.out.println(page.title());
		page.locator("//a[text()='Log in']").click();
		page.locator("//input[@id='Email']").fill("manugowda123@gmail.com");
		page.locator("//input[@id='Password']").fill("12345678");
		page.locator("//input[@value='Log in']").click();
		
		Thread.sleep(3000);
		playwright.close();
	}
}
