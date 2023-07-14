package maps;

import org.openqa.selenium.By;

import utilities.BasePage;

public class RegistrationMap extends BasePage {

	public By validateRegisterPage() {
		return By.xpath("//h1[text()='Register Account']");
	}

	public By firstName() {
		return By.xpath("//input[@id='input-firstname']");
	}

	public By lastName() {
		return By.xpath("//input[@id='input-lastname']");
	}

	public By emailId() {
		return By.xpath("//input[@id='input-email']");
	}

	public By telephoneNumber() {
		return By.xpath("//input[@id='input-telephone']");
	}

	public By password() {
		return By.xpath("//input[@id='input-password']");
	}

	public By confirmPassword() {
		return By.xpath("//input[@id='input-confirm']");
	}

	public By clickOnCheckBox() {
		return By.xpath("//input[@name='agree']");
	}

	public By clickOnContinueButton() {
		return By.xpath("//input[@value='Continue']");
	}

	public By validateHomePage() {
		return By.xpath("//h1[text()='Your Account Has Been Created!']");
	}

	public By clickOnLogout() {
		return By.xpath("//aside[@id='column-right']//a[13]");
	}
}
