package com.amazon.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.amazon.qa.util.Excel_Reader;
import com.amzon.qa.pages.AddToCartPage;
import com.amzon.qa.pages.ProceedToBuyPage;
import com.amzon.qa.pages.SearchPage;

public class ProceedToBuyPageTest extends BaseTest
{
	public ProceedToBuyPageTest()
	{
		super();
	}

	Excel_Reader excel_Reader;
	SearchPage searchPage;
	AddToCartPage addToCartPage;
	ProceedToBuyPage proceedToBuyPage;
	
	
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
	
	@Test(priority = 4)
	public void validateAddtoCartPage() throws Exception
	{
		addToCartPage=new AddToCartPage();
		String   actualTitle=addToCartPage.validateAddToCartPageTitle();
		String exptTitle=excel_Reader.getdata("Sheet1", 3, 1);
		System.out.println("new :"+excel_Reader.getdata("Sheet1", 3, 1));
		Assert.assertEquals(actualTitle, exptTitle);
		
	}
	
	@Test(priority = 5)
	public void clickOnAddToCartBtn()
	{
		addToCartPage.clickOnAddToCart();
		Assert.assertTrue(addToCartPage.validateAddToCartBtn());
	}
	
	//cnt vali js
	@Test(priority = 6)
	public void ClickOnCartButton()
	{ 
		addToCartPage.clickOnCartBtn();
		
	}
	
	@Test(priority = 7)
	public void validateProceedToBuyPage() throws Exception
	{
		proceedToBuyPage=new ProceedToBuyPage();
		 proceedToBuyPage.validateProceedToBuyPage();
	}
	
	@Test(priority = 8)
	public void clickOnProceedToByButton()
	{
		proceedToBuyPage.clickOnProceedToBuyBtn();
	}
	

}
