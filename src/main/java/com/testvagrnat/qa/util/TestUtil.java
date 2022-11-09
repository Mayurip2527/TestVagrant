package com.testvagrnat.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hslf.model.Sheet;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.testvagrnat.qa.base.TestBase;

public class TestUtil extends TestBase{
	
	public TestUtil() throws IOException, InterruptedException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static long PAGE_LOAD_TIMEOUT= 40;
	public static long IMPLICIT_WAIT = 40;
	public static String title = "";
	
	public static String screenshotName="";
	
	public static void scrollUpByPixel(int pixel){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 'pixel')");
	
	}
	
	public static void scrollUpAtEndOFPage(){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	
	}
	
	public static void scrollToWebElement(WebElement element){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	
	}
	public void explicitWaitForElementPresent(WebElement w) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(w));

	}
	
	public void switchToChildWindow() {
		Set<String>s=driver.getWindowHandles();
		ArrayList<String> child = new ArrayList<String>(s);
		driver.switchTo().window(child.get(1));
	}
	

	
	public void openNewTab() {
		((JavascriptExecutor) driver).executeScript("window.open()");

	}

	public void enterNewURL() {
		driver.get(prop.getProperty("wiki"));
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

	}
	
	public void verifyAssertTextConatins(String Actual, String Expected) {

		Assert.assertEquals(Actual.equalsIgnoreCase(Expected), Expected);

	}
	
	
	
}
