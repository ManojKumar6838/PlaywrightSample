package testscriptstest;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright; 


public class DummyClass {

	@Test
	public void simpleTest() throws InterruptedException {
		Playwright playwright=Playwright.create();
		Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://letcode.in/frame");
		//Normal Frame
		FrameLocator frame = page.frameLocator("#firstFr");
		Locator textBox = frame.getByPlaceholder("Enter name");
		textBox.fill("Hello");
		
		//Nested Frame
		FrameLocator frame2 = frame.frameLocator("iframe.has-background-white");
		frame2.locator("//input[@name='email']").fill("Manoj");
		
		Locator koushik = page.locator("//a[@title='Koushik Chatterjee']").first();
		
		System.out.println(koushik.getAttribute("title"));
		Thread.sleep(3000);
		playwright.close();
	}
}
