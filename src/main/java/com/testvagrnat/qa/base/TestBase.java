package com.testvagrnat.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.testvagrnat.qa.util.TestUtil;

import io.appium.java_client.android.AndroidDriver;


public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() throws IOException, InterruptedException{
		try{
			prop = new Properties();
		
			FileInputStream fis = new FileInputStream(".\\src\\main\\java\\com\\testvagrnat\\qa\\config\\config.properties");
		prop.load(fis);
		}catch(FileNotFoundException e){
			e.printStackTrace();		
			
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}
		
	public static void initialization() throws InterruptedException, MalformedURLException{
		
		String broweserName = prop.getProperty("browser");
		if(broweserName.equals("FF")){
			
			
			driver = new FirefoxDriver();
		
		}
		else if (broweserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver","./src/Chromedriver/chromedriver.exe");
			driver = new ChromeDriver();
		}	
		
		else if (broweserName.equals("IE")){
		//	WebDriverManager.chromedriver().setup();
			driver = new InternetExplorerDriver();		
		}
		
	
		if (broweserName.equals("mobileChrome")){
			
			System.out.println("Testing WebSite on Anddroid Emulator");
		}
		else{
			
			driver.manage().window().maximize();	
			
		}
			
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);		
        driver.get(prop.getProperty("imd"));
       // 	driver.get(prop.getProperty("url1"));
	}
	
		
	}
	
	
	
	


