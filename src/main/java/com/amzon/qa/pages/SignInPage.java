package com.amzon.qa.pages;

import org.openqa.selenium.support.PageFactory;

import com.amazon.base.TestBase;

public class SignInPage extends TestBase
{
	
	public SignInPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateSignInPage()
	{
		return driver.getTitle();
	}
	
	

}
