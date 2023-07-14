package maps;

import org.openqa.selenium.By;

public class ProductSelectionMap {

	public By validateProductPage() {
		return By.xpath("//a[text()='Qafox.com']");
	}

	public By selectTheProduct(String productText) {
		return By.xpath("//a[text()='" + productText + "']");
	}

	public By getTheProductName() {
		return By.xpath("//div[@class='btn-group']//following-sibling::h1");
	}

	public By getTheProductPrice() {
		return By.xpath("//div[@class='btn-group']//following-sibling::h1//following::ul//h2");
	}

	public By getTheShortDescription() {
		return By.xpath("//div[@id='tab-description']//p");
	}

	public By getTheBrand() {
		return By.xpath("//div[@class='btn-group']//following-sibling::h1//following::ul//li//following-sibling::a");
	}

	public By getTheProductCode() {
		return By.xpath("// div[@class='btn-group']//following-sibling::h1//following-sibling::ul[1]//li[2]");
	}

	public By getTheProductRewardPoints() {
		return By.xpath("// div[@class='btn-group']//following-sibling::h1//following-sibling::ul[1]//li[3]");
	}

	public By getTheProductAvailability() {
		return By.xpath("// div[@class='btn-group']//following-sibling::h1//following-sibling::ul[1]//li[4]");
	}
}
