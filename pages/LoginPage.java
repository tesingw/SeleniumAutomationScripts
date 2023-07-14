package pages;

import java.util.concurrent.TimeUnit;

import utilities.BasePage;

public class LoginPage extends BasePage {

	public void loginToApplication(String url) {
		getDriver().get(url);
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void navigateToApplication(String url) {
		getDriver().navigate().to(url);
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}	
}