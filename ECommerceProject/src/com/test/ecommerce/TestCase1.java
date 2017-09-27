package com.test.ecommerce;

import java.io.File;
import java.io.IOException;
//import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
/*  
Test Steps
Step 1. Goto http://live.guru99.com/
Step 2. Verify Title of the page
Step 3. Click on ‘MOBILE’ menu
Step 4. Verify Title of the page
Step 5. In the list of all mobile , select ‘SORT BY’ dropdown as ‘name’
Step 6. Verify all products are sorted by name
*/
public class TestCase1 {

	private WebDriver driver;
	private String baseURL;
	public int scc=0;
	
	private StringBuffer verificationErrors = new StringBuffer();
	
	//@BeforeMethod
	@BeforeTest
    public void setUp()throws Exception{
    	System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver_win32\\chromedriver.exe");
    	driver = new ChromeDriver();
    	//step 1: goto http://live.guru99.com/
    	baseURL = "http://live.guru99.com/";
    	driver.manage().window().maximize();
    	//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      }
	@Test
	public void testDay1TestCase1()throws Exception{
		driver.get(baseURL);
		//Step2: verify titiel of the page
		String demoSite=driver.getTitle();
		System.out.println(demoSite);
		try{
			Assert.assertEquals("THIS IS DEMO SITE FOR ", demoSite);
		}catch(Error e){
			verificationErrors.append(e.toString());
		}
		
		//step3: Click on MOBILE' menu
		driver.findElement(By.linkText("MOBILE")).click();
		//step4: in the list of all mobile, selct 'Sort by' down as 'name'
		new Select(driver.findElement(By.cssSelector("select[title=\"Sort By\"]"))).selectByVisibleText("Name");
		
		// Step 6. Verify all products are sorted by name
				// this will take a screen shot of the manager's page after a successful login
			    scc = (scc+1);
				File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				String png = ("screenshots" + scc + ".png");
				FileUtils.copyFile(scrFile, new File(png));
		//**************************************************************************************************************************
	}
	
	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();
	   
	  }
	
	
	
}
