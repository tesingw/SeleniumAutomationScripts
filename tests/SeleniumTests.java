package tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.*;
import utilities.BaseTest;
import utilities.ReadExcelData;

public class SeleniumTests extends BaseTest {

	@Test(groups = { "ProductData" })
	protected void getTheProductData() throws Exception {
		LoginPage loginPageObj = new LoginPage();
		String path = System.getProperty("user.dir") + "\\" + "datafiles\\WriteDataToExcel.xlsx";
		ReadExcelData read = new ReadExcelData(path);
		ProductSelectionPage productSelection = new ProductSelectionPage();

		String applicationUrl = "https://tutorialsninja.com/demo/index.php?route=product/category&path=18";
		String selectProduct = "HP LP3065";
		List<String> writeData = new ArrayList<String>();

		loginPageObj.loginToApplication(applicationUrl);

		Assert.assertEquals("Qafox.com", productSelection.validateProductsPage());

		productSelection.selectTheProduct(selectProduct);

		String productName = productSelection.getTheProductName();
		writeData.add(productName);

		String productPrice = productSelection.getTheProductPrice();
		writeData.add(productPrice);

		String productDescription = productSelection.getTheProductDescrption();
		writeData.add(productDescription);

		String productBrand = productSelection.getTheProductBrand();
		writeData.add(productBrand);

		String productCode = productSelection.getTheProductCode();
		writeData.add(productCode);

		String productRewardPoints = productSelection.getTheProductRewardPoints();
		writeData.add(productRewardPoints);

		String productAvailability = productSelection.getTheProductAvailability();
		writeData.add(productAvailability);
		writeData.add(productSelection.getDateAndTime());
		read.writeDataInCell("CategoryData", writeData);

		test.log(LogStatus.PASS, "Product data extraction Successful");
	}

	@Test(groups = { "UserRegistration" })
	protected void userRegistration() throws Exception {
		LoginPage loginPageObj = new LoginPage();
		RegistrationPage registrationPage = new RegistrationPage();

		String applicationUrl = "https://tutorialsninja.com/demo/index.php?route=account/register";

		loginPageObj.loginToApplication(applicationUrl);

		Assert.assertEquals("Register Account", registrationPage.validateRegisterPage());

		int getRandomNumber = registrationPage.getRandomNumber();

		registrationPage.enterFirstName("test" + getRandomNumber);

		registrationPage.enterLastName("test123" + getRandomNumber);

		registrationPage.enterEmail("test" + getRandomNumber + "@gmail.com");

		registrationPage.enterTelephoneNumber("123456789" + getRandomNumber);

		registrationPage.enterPassword("tes@" + getRandomNumber);

		registrationPage.confirmPassword("tes@" + getRandomNumber);

		registrationPage.clickOnCheckBox();

		registrationPage.clickOnContinueButton();

		Assert.assertEquals("Your Account Has Been Created!", registrationPage.validateHomePage());

		registrationPage.clickOnLogout();

		test.log(LogStatus.PASS, "User Registration Successful");
	}
}