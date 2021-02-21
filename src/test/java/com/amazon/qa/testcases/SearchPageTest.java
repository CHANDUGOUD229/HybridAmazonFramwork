package com.amazon.qa.testcases;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.amazon.qa.util.Excel_Reader;

import com.amzon.qa.pages.SearchPage;

public class SearchPageTest extends BaseTest
{
	
	Excel_Reader excel_Reader;
	SearchPage searchPage;
	
	
	public SearchPageTest()
	{
		super();
	}
	
	
	@Test(priority = 1)
	public void isDisplaySearchPage() throws Exception
	{
		excel_Reader=new Excel_Reader("C:\\Users\\chand\\eclipse-workspace\\AmazonIphone12\\Testdata\\Amazondata.xlsx");
		searchPage=new SearchPage();
		 String actualtitle=searchPage.validateSearchPageTitle();
		 String expectTitle=excel_Reader.getdata("Sheet1", 2, 1);
		// System.out.println(excel_Reader.getdata("Sheet1", 2, 1));
		 Assert.assertEquals(actualtitle, expectTitle);
	}
	
	
	@Test(priority = 2)
	public void searchForProduct() throws Exception 
	{	
		searchPage.searchProduct(excel_Reader.getdata("Sheet1", 1, 1));
		System.out.println(excel_Reader.getdata("Sheet1", 1, 1));
		Assert.assertTrue(searchPage.validateSearchBtn());
	}
	
	@Test(priority = 3)
	public void ClickOnSelectedProduct()
	{
		searchPage.clickOnIphoneImg();
		Assert.assertTrue(searchPage.validateIphoneImage());
	}
	

	
	

}
