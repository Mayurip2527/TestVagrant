package com.testvagrnat.qa.pages;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testvagrnat.qa.base.TestBase;
import com.testvagrnat.qa.util.TestUtil;

public class IMDPage extends TestBase{

	TestUtil ut = new TestUtil();	
	
	public IMDPage() throws IOException , InterruptedException {
		PageFactory.initElements(driver, this);
		
	}
	

	@FindBy(xpath = "//a[contains(text(),'Release date')]/following::a[1]")
	private WebElement relaseDate;

	@FindBy(xpath = "//span[contains(text(),'Country of origin')]/following::a[1]")
	private WebElement country;
		
	public String getRelaseDateFromIMD() throws ParseException {
		ut.scrollToWebElement(relaseDate);
		ut.explicitWaitForElementPresent(relaseDate);	
		String d[] = relaseDate.getText().substring(0, relaseDate.getText().indexOf("(")).trim().replaceAll(",", "").split(" ");
		String finalDate = d[1]+" "+d[0]+" "+d[2];
		return finalDate;
	}

	
	public String getCountryFromIMD() {
		System.out.println("country.getText()" +country.getText());
		return country.getText().trim();
	}

	
	
	
}
