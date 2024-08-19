package testscriptstest;

import java.nio.file.Paths;
import java.util.Arrays;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Page.ScreenshotOptions;

public class Screenshots {

	@Test
	public void screenshots() throws Throwable {
		Playwright playwright=Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://demowebshop.tricentis.com/login");
		//Take Screenshot
//		ScreenshotOptions scrnopts=new ScreenshotOptions();
//		page.screenshot(scrnopts.setPath(Paths.get("./snaps/dws.png")));
		
		//Full Page Screenshot
		//page.screenshot(new ScreenshotOptions().setPath(Paths.get("./snaps/fullPage.png")).setFullPage(true));
	
		//Single WE
//		Locator logo = page.locator("//img[@alt='Tricentis Demo Web Shop']");
//		logo.screenshot(new Locator.ScreenshotOptions().setPath(Paths.get("./snaps/logo.png")));
		Locator email = page.locator("#Email");
		email.fill("manugowda");
		page.screenshot(new ScreenshotOptions().setPath(Paths.get("./snaps/Demo.png")).setMask(Arrays.asList(email)));
		Thread.sleep(3000);
		playwright.close();
	}
}
