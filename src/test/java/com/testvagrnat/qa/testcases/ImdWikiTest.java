package com.testvagrnat.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.AssertJUnit;

import static com.testvagrnat.qa.util.TestUtil.title;

import java.io.IOException;
import java.text.ParseException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testvagrnat.qa.base.TestBase;
import com.testvagrnat.qa.pages.IMDPage;

import com.testvagrnat.qa.pages.WIKIPage;
import com.testvagrnat.qa.util.TestUtil;
@Listeners(com.testvagrnat.qa.listener.Listener.class)
public class ImdWikiTest extends TestBase{
	
	IMDPage imdPage;
	WIKIPage wikiPage;
	
	String releseDateIMD;
	String countryIMD;
		
	TestUtil ut = new TestUtil();	
	public ImdWikiTest() throws IOException, InterruptedException {
		super();
		
	}

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException{
		
		initialization();
		imdPage = new IMDPage();
		wikiPage = new WIKIPage();

		
	} 
	
	@Test(priority=1)
	public void verifyReleaseDateAndCountry() throws ParseException{

		releseDateIMD= imdPage.getRelaseDateFromIMD();
		countryIMD= imdPage.getCountryFromIMD();
		ut.openNewTab();
		ut.switchToChildWindow();
		ut.enterNewURL();
		wikiPage.getRelaseDateFromWIKI();
		wikiPage.getCountryFromWIKI();
		System.out.println("wikiPage.getRelaseDateFromWIKI(): " +wikiPage.getRelaseDateFromWIKI());
		System.out.println("releseDateIMD: " +releseDateIMD);
		Assert.assertEquals(countryIMD, wikiPage.getCountryFromWIKI(), "Country is not matched");
		Assert.assertEquals(releseDateIMD, wikiPage.getRelaseDateFromWIKI(), "Release date is not matched");


		 		
	}
	@AfterMethod
	public void quite() throws IOException, InterruptedException{
			driver.quit();
		
	} 


}
