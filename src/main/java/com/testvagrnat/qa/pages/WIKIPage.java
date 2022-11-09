package com.testvagrnat.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testvagrnat.qa.base.TestBase;
import com.testvagrnat.qa.util.TestUtil;

public class WIKIPage extends TestBase{

	TestUtil ut = new TestUtil();	
	public WIKIPage() throws IOException , InterruptedException {
		PageFactory.initElements(driver, this);
		
	}
		

	@FindBy(xpath = "//div[contains(text(),'Release date')]/following::li[1]")
	private WebElement relaseDate;

	@FindBy(xpath = "//th[contains(text(),'Country')]/following::td[1]")
	private WebElement country;


	
	public String getRelaseDateFromWIKI() {
		ut.scrollToWebElement(relaseDate);
		ut.explicitWaitForElementPresent(relaseDate);
		System.out.println("relaseDate.getText()" +relaseDate.getText());
		return relaseDate.getText().trim();
	}

	
	public String getCountryFromWIKI() {
		System.out.println("country.getText()" +country.getText());
		return country.getText().trim();
	}
	
	
	
}
