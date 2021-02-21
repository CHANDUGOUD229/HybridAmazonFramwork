package com.amazon.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.amazon.qa.util.Excel_Reader;
import com.amzon.qa.pages.AddToCartPage;
import com.amzon.qa.pages.ProceedToBuyPage;
import com.amzon.qa.pages.SearchPage;
import com.amzon.qa.pages.SignInPage;

public class SignInPageTest extends BaseTest
{
	public SignInPageTest()
	{
		super();
	}

	Excel_Reader excel_Reader;
	SearchPage searchPage;
	AddToCartPage addToCartPage;
	ProceedToBuyPage proceedToBuyPage;
	SignInPage signInPagen;
	
	@Test(priority = 1,description = "TC001")
	public void isDisplaySearchPage() throws Exception
	{
		excel_Reader=new Excel_Reader("C:\\Users\\chand\\eclipse-workspace\\AmazonIphone12\\Testdata\\Amazondata.xlsx");
		searchPage=new SearchPage();
		 String actualtitle=searchPage.validateSearchPageTitle();
		 String expectTitle=excel_Reader.getdata("Sheet1", 2, 1);
		// System.out.println(excel_Reader.getdata("Sheet1", 2, 1));
		 Assert.assertEquals(actualtitle, expectTitle);
	}
	
	
	@Test(priority = 2,description = "TC002")
	public void searchForProduct() throws Exception 
	{	
		searchPage.searchProduct(excel_Reader.getdata("Sheet1", 1, 1));
		System.out.println(excel_Reader.getdata("Sheet1", 1, 1));
		Assert.assertTrue(searchPage.validateSearchBtn());
	}
	
	@Test(priority = 3,description = "TC003")
	public void ClickOnSelectedProduct()
	{
		searchPage.clickOnIphoneImg();
		Assert.assertTrue(searchPage.validateIphoneImage());
	}
	
	@Test(priority = 4,description = "TC004")
	public void validateAddtoCartPage() throws Exception
	{
		addToCartPage=new AddToCartPage();
		String   actualTitle=addToCartPage.validateAddToCartPageTitle();
		String exptTitle=excel_Reader.getdata("Sheet1", 3, 1);
		System.out.println("new :"+excel_Reader.getdata("Sheet1", 3, 1));
		Assert.assertEquals(actualTitle, exptTitle);
		
	}
	
	@Test(priority = 5,description = "TC005")
	public void clickOnAddToCartBtn()
	{
		addToCartPage.clickOnAddToCart();
		Assert.assertTrue(addToCartPage.validateAddToCartBtn());
	}
	
	//cnt vali js
	@Test(priority = 6,description = "TC006")
	public void ClickOnCartButton()
	{ 
		addToCartPage.clickOnCartBtn();
		
	}
	@Test(priority = 7,description = "TC007")
	public void validateProceedToBuyPage() throws Exception
	{
		proceedToBuyPage=new ProceedToBuyPage();
		 proceedToBuyPage.validateProceedToBuyPage();
	}
	
	@Test(priority = 8,description = "TC008")
	public void clickOnProceedToByButton()
	{
		proceedToBuyPage.clickOnProceedToBuyBtn();
	}
	
	
	@Test(priority = 9,description = "TC009")
	public void validateSignInPage() throws Exception
	{
		signInPagen=new SignInPage();
	 String	actual=signInPagen.validateSignInPage();
	 
	 String expTitle=excel_Reader.getdata("Sheet1", 5, 1);
	 System.out.println(excel_Reader.getdata("Sheet1", 5, 1));
	 Assert.assertEquals(actual, expTitle);
	}
	


}
