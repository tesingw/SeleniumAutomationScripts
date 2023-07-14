package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class BasePage {

	protected WebDriver getDriver() {
		return BaseTest.initializeDriver();
	}

	private final WebDriverWait webdriverWait = new WebDriverWait(getDriver(), 5);
	private final Actions action = new Actions(getDriver());

	public WebElement getElement(By locator) {
		return getDriver().findElement(locator);
	}

	public List<WebElement> getElements(By locator) {
		return getDriver().findElements(locator);
	}

	protected void waitForElementToBeVisible(By locator) {
		try {
			webdriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (NoSuchElementException exception) {
			exception.printStackTrace();
		}
	}

	protected void waitForElementIsNotVisible(By locator) {
		try {
			webdriverWait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void takesScreenshot(String name) {
		try {
			File file = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file,
					new File(System.getProperty("user.dir") + "\\" + "TestScreenshots" + "\\" + name + ".png"));
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	public void takeFullPageScreenshot(String name) {
		try {
			Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
					.takeScreenshot(getDriver());
			ImageIO.write(screenshot.getImage(), "jpg", new File(System.getProperty("user.dir") + "\\"
					+ "SeleniumRestAssuredProject" + "\\" + "TestScreenshots" + "\\" + name + ".jpg"));
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	public void mouseHoverAndClickElement(WebElement element) {
		try {
			action.moveToElement(element).perform();
		} catch (NoSuchElementException exception) {
			exception.printStackTrace();
		}
	}

	public void elementDragAndDrop(WebElement source, WebElement target) {
		try {
			action.dragAndDrop(source, target).build().perform();
		} catch (ElementNotVisibleException exception) {
			exception.printStackTrace();
		}
	}

	public void clickOnElement(WebElement element) {
		try {
			element.click();
		} catch (ElementClickInterceptedException exception) {
			exception.printStackTrace();
		}
	}

	public void enterTextOnField(WebElement element, String text) {
		try {
			element.sendKeys(text);
		} catch (ElementNotVisibleException exception) {
			exception.printStackTrace();
		}
	}

	public String acceptAndGetTextOfSimpleAlertPopup() {
		Alert alert = getDriver().switchTo().alert();
		String getText = alert.getText();
		alert.accept();
		return getText;
	}

	public void switchToChildWindow(String parentWindow) {
		Set<String> getWindows = getDriver().getWindowHandles();
		for (String windows : getWindows) {
			if (!windows.equalsIgnoreCase(parentWindow)) {
				getDriver().switchTo().window(windows);
			}
		}
		getDriver().manage().window().maximize();
	}

	public String getElementText(WebElement element) {
		return element.getText();
	}

	public void switchToChildWindowOnIterator(String parentWindow) {
		Set<String> allWindowHandles = getDriver().getWindowHandles();
		Iterator<String> iterator = allWindowHandles.iterator();
		while (iterator.hasNext()) {
			String ChildWindow = iterator.next();
			if (!parentWindow.equalsIgnoreCase(ChildWindow)) {
				getDriver().switchTo().window(ChildWindow);
			}
		}
	}

	public void clickElementOnJavaScriptExecutor(WebElement element) {
		try {
			JavascriptExecutor jScriptExecutor = (JavascriptExecutor) getDriver();
			jScriptExecutor.executeScript("arguments[0].click();", element);
		} catch (ElementClickInterceptedException exception) {
			exception.printStackTrace();
		}
	}

	public static void clickOnControlShift(WebDriver driver) {
		Actions action = new Actions(driver);
		action.keyDown(Keys.SHIFT).keyDown(Keys.CONTROL).sendKeys("i").build().perform();
	}

}