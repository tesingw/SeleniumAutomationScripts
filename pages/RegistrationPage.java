package pages;

import java.util.concurrent.TimeUnit;

import maps.RegistrationMap;
import utilities.BasePage;

public class RegistrationPage extends BasePage {
	RegistrationMap objRegister = new RegistrationMap();

	public String validateRegisterPage() {
		return getElementText(getElement(objRegister.validateRegisterPage()));
	}

	public void enterFirstName(String firstName) {
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		enterTextOnField(getElement(objRegister.firstName()), firstName);
	}

	public void enterLastName(String lastName) {
		enterTextOnField(getElement(objRegister.lastName()), lastName);
	}

	public void enterEmail(String emailId) {
		enterTextOnField(getElement(objRegister.emailId()), emailId);
	}

	public void enterTelephoneNumber(String telephoneNumber) {
		enterTextOnField(getElement(objRegister.telephoneNumber()), telephoneNumber);
	}

	public void enterPassword(String password) {
		enterTextOnField(getElement(objRegister.password()), password);
	}

	public void confirmPassword(String confirmPassword) {
		enterTextOnField(getElement(objRegister.confirmPassword()), confirmPassword);
	}

	public void clickOnCheckBox() {
		clickOnElement(getElement(objRegister.clickOnCheckBox()));
	}

	public void clickOnContinueButton() {
		clickOnElement(getElement(objRegister.clickOnContinueButton()));
	}

	public String validateHomePage() {
		takesScreenshot("Screenshot taken for successfull registration");
		return getElementText(getElement(objRegister.validateHomePage()));
	}

	public void clickOnLogout() {
		clickOnElement(getElement(objRegister.clickOnLogout()));
	}

	public int getRandomNumber() {
		int randomNumber = (int) (Math.random() * 9999);
		if (randomNumber <= 1000) {
			randomNumber = randomNumber + 1000;
		}
		return randomNumber;
	}
}
