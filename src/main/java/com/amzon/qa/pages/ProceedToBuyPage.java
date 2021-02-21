package com.amzon.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.base.TestBase;

public class ProceedToBuyPage extends TestBase 
{
	
	@FindBy(xpath = "//input[@name=\"proceedToRetailCheckout\"]") WebElement proceedToBuyBtnElement;
	@FindBy(xpath="//span[@class=\"nav-cart-icon nav-sprite\"]") WebElement cartImgElement;
	public ProceedToBuyPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void validateProceedToBuyPage()
	{
		String myTitle=null;
		String title=  driver.getTitle();
		String extitleString="Amazon.in Shopping Cart";
		if(!title.equals(extitleString))
		{
			((JavascriptExecutor)driver).executeScript("arguments[0].click();",cartImgElement);
		}
		
	}
	

	
	
	public SignInPage clickOnProceedToBuyBtn()
	{
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",proceedToBuyBtnElement);
		
		return new SignInPage();
	}

	
}
