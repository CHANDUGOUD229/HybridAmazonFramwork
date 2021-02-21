package com.amazon.qa.testcases;

import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.amazon.base.TestBase;
import com.amazon.qa.util.Excel_Reader;
import com.amzon.qa.pages.SearchPage;
import com.qa.ExtentReportListener.CustomListener;

@Listeners(CustomListener.class)
public class BaseTest extends TestBase
{

	
	public BaseTest() 
	{
		super();
	}
	
	@BeforeTest
	public void setUp() throws Exception
	{
		initialzation();
			
	}
	//ITestResult result
	@AfterTest
	public void tearDown()
	{
		
		
		driver.quit();
	}

}
