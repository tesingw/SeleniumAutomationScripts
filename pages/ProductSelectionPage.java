package pages;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import maps.ProductSelectionMap;
import utilities.BasePage;

public class ProductSelectionPage extends BasePage {
	ProductSelectionMap objProduct = new ProductSelectionMap();

	public String validateProductsPage() {
		return getElementText(getElement(objProduct.validateProductPage()));
	}

	public void selectTheProduct(String productText) {
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		getElement(objProduct.selectTheProduct(productText)).click();
	}

	public String getTheProductName() {
		return getElementText(getElement(objProduct.getTheProductName()));
	}

	public String getTheProductPrice() {
		return getElementText(getElement(objProduct.getTheProductPrice()));
	}

	public String getTheProductDescrption() {
		return getElementText(getElement(objProduct.getTheShortDescription()));
	}

	public String getTheProductBrand() {
		return getElementText(getElement(objProduct.getTheBrand()));
	}

	public String getTheProductCode() {
		return getElementText(getElement(objProduct.getTheProductCode()));
	}

	public String getTheProductRewardPoints() {
		return getElementText(getElement(objProduct.getTheProductRewardPoints()));
	}

	public String getTheProductAvailability() {
		takesScreenshot("Screenshot taken for product data");
		return getElementText(getElement(objProduct.getTheProductAvailability()));
	}

	public String getDateAndTime() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}
}
