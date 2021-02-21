package com.amzon.qa.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.base.TestBase;

public class SearchPage extends TestBase
{
	@FindBy(css = "input#twotabsearchtextbox")       WebElement searchBoxElement;
	@FindBy(css="input#nav-search-submit-button")    WebElement searchSbtBtnElement;
	//@FindBy(css="input#nav-search-n")    WebElement searchSbtBtnElement;
	// @FindBy(xpath = "//img[@class=\"s-image\" and @alt=\"New - Blue\"]") WebElement iphoneImgElement;
	@FindBy(xpath = "//img[@alt=\"New Apple iPhone 12 (128GB) - Blue\"]") WebElement iphoneImgElement;
	
	//Initializing the page Objects
	public SearchPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateSearchPageTitle()
	{
		 return driver.getTitle();
	}
	
	public boolean validateSearchBtn()
	{
		return searchSbtBtnElement.isDisplayed();
		
	}
	
	
	public String searchProduct(String data)
	{
	
		searchBoxElement.sendKeys(data);
		searchSbtBtnElement.click();
		return data;
	}
	
	public void clickOnSearchSbtBtn()
	{
		searchSbtBtnElement.click();
	}
	
	public AddToCartPage clickOnIphoneImg()
	{
		iphoneImgElement.click();
		Set<String> ids = driver.getWindowHandles();
        Iterator<String> it = ids.iterator();
        String parentId = it.next();
        String childId = it.next();
        driver.switchTo().window(childId);
 
		return new AddToCartPage();
	}
	public boolean validateIphoneImage()
	{
	    return 	iphoneImgElement.isDisplayed();
	}
	
	
}
