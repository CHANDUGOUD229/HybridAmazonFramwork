package com.amzon.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.base.TestBase;

public class AddToCartPage extends TestBase
{
	@FindBy(id = "add-to-cart-button") WebElement addToCartBtn;
	@FindBy(xpath = "//span[@id=\"attach-sidesheet-view-cart-button\"]") WebElement cartBtn;

	public AddToCartPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public String validateAddToCartPageTitle() 
	{
		  return driver.getTitle();
	}
	
	
	public void clickOnAddToCart()
	{
		addToCartBtn.click();
	}
	public boolean validateAddToCartBtn()
	{
		 return addToCartBtn.isDisplayed();
	}
	

	
	public ProceedToBuyPage clickOnCartBtn()
	{ 
		
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",cartBtn);
		
		return new ProceedToBuyPage();
	}
	
}
