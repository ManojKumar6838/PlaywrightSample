package testscriptstest;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class CodeGenClass {

	public static void main(String[] args) throws Throwable {
		try (Playwright playwright = Playwright.create()) {
			Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			BrowserContext context = browser.newContext();
			Page page = context.newPage();
			page.navigate("https://demowebshop.tricentis.com/");
			page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Log in")).click();
			page.getByLabel("Email:").fill("manugowda123@gmail.com");
			page.getByLabel("Password:").fill("12345678");
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Log in")).click();
			Thread.sleep(5000);
		}
	}
}
