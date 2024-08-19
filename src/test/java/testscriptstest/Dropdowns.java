package testscriptstest;

import java.util.List;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class Dropdowns {

	@Test
	public void dropdowns() throws InterruptedException {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://selenium08.blogspot.com/2019/11/dropdown.html");
//		Locator countryDropdown = page.locator("[name='country']");
//		page.selectOption("[name='country']", "India");
//		countryDropdown.selectOption(new SelectOption().setIndex(3));
//		List<String> allOpts = countryDropdown.allInnerTexts();
//		System.out.println(allOpts);
		Locator monthDropdown = page.locator("[name='Month']");
		List<String> abc = monthDropdown.selectOption(new String[] {"May", "March"});
		System.out.println(abc);
		Thread.sleep(3000);
		playwright.close();
	}
	
}
