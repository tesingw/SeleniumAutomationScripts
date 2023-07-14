package listeners;

import com.relevantcodes.extentreports.LogStatus;

import utilities.BaseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGWebDriverListeners extends BaseTest implements
        ITestListener, WebDriverEventListener {

    public void onTestStart(ITestResult result) {
        logger.info("Test Started " + result.getName());
        test = report.startTest(result.getMethod().getMethodName());
        //test = report.startTest(result.getInstanceName().replaceAll("selenium.tests.", "")
        //      .concat(result.getMethod().getMethodName()));
        test.log(LogStatus.INFO, result.getMethod().getMethodName() + "test is started");
    }

    public void onTestSuccess(ITestResult result) {
        test.log(LogStatus.PASS, result.getMethod().getMethodName() + "test is passed");
        logger.info("Test Success " + result.getName());
    }

    public void onTestFailure(ITestResult result) {
        test.log(LogStatus.FAIL, result.getMethod().getMethodName() + "test is failed");
        logger.info("Test Failure " + result.getName());
    }

    public void onTestSkipped(ITestResult result) {
        test.log(LogStatus.SKIP, result.getMethod().getMethodName() + "test is skipped");
        logger.info("Test Skipped " + result.getName());
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        logger.info("Test Failed with Success Percentage " + result.getName());
    }

    public void onTestFailedWithTimeout(ITestResult result) {
        this.onTestFailure(result);
    }

    public void onStart(ITestContext context) {
        logger.info("On Start " + context.getName());
    }

    public void onFinish(ITestContext context) {
        logger.info("On Finish " + context.getName());
    }

    public void beforeAlertAccept(WebDriver webDriver) {
        logger.info("Before Alert Accept" + webDriver.toString());
    }

    public void afterAlertAccept(WebDriver webDriver) {
        logger.info("After Alert Accept" + webDriver);
    }

    public void afterAlertDismiss(WebDriver webDriver) {
        logger.info("After Alert Dismiss" + webDriver);
    }

    public void beforeAlertDismiss(WebDriver webDriver) {
        logger.info("Before Alert Dismiss" + webDriver);
    }

    public void beforeNavigateTo(String s, WebDriver webDriver) {
        logger.info("Before Navigate To" + webDriver);
    }

    public void afterNavigateTo(String s, WebDriver webDriver) {
        logger.info("After Navigate To" + webDriver);
    }

    public void beforeNavigateBack(WebDriver webDriver) {
        logger.info("Before Navigate Back" + webDriver);
    }

    public void afterNavigateBack(WebDriver webDriver) {
        logger.info("After Navigate Back" + webDriver);
    }

    public void beforeNavigateForward(WebDriver webDriver) {
        logger.info("Before Navigate Forward" + webDriver);
    }

    public void afterNavigateForward(WebDriver webDriver) {
        logger.info("After Navigate Forward" + webDriver);
    }

    public void beforeNavigateRefresh(WebDriver webDriver) {
        logger.info("Before Navigate Refresh" + webDriver);
    }

    public void afterNavigateRefresh(WebDriver webDriver) {
        logger.info("After Navigate Refresh" + webDriver);
    }

    public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {
        logger.info("Before Find By" + webElement);
    }

    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {
        logger.info("After Find By" + webElement);
    }

    public void beforeClickOn(WebElement webElement, WebDriver webDriver) {
        logger.info("Before Click On" + webElement);
    }

    public void afterClickOn(WebElement webElement, WebDriver webDriver) {
        logger.info("After Click On" + webElement);
    }

    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        logger.info("Before Change Value Of" + webElement);
    }

    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        logger.info("After Change Value Of" + webElement);
    }

    public void beforeScript(String s, WebDriver webDriver) {
        logger.info("Before Script" + s);
    }

    public void afterScript(String s, WebDriver webDriver) {
        logger.info("After Script" + s);
    }

    public void beforeSwitchToWindow(String s, WebDriver webDriver) {
        logger.info("Before Switch To Window" + s);
    }

    public void afterSwitchToWindow(String s, WebDriver webDriver) {
        logger.info("After Switch To Window" + s);
    }

    public void onException(Throwable throwable, WebDriver webDriver) {
        logger.info("On Exception" + webDriver);
    }

    public <X> void beforeGetScreenshotAs(OutputType<X> outputType) {
        logger.info("Before Get Screenshot As" + outputType);
    }

    public <X> void afterGetScreenshotAs(OutputType<X> outputType, X x) {
        logger.info("After Get Screenshot As" + outputType);
    }

    public void beforeGetText(WebElement webElement, WebDriver webDriver) {
        logger.info("Before Get Text " + webElement);
    }

    public void afterGetText(WebElement webElement, WebDriver webDriver, String s) {
        logger.info("After Get Text " + webElement);
    }
}