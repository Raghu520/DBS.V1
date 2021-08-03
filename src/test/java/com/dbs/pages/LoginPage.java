package com.dbs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dbs.util.Baseclass;

public class LoginPage extends Baseclass {
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="uid")
	WebElement uid;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="btnLogin")
	WebElement Login;
	
	@FindBy(xpath="//h2[@class='barone']")
	WebElement title;
	
	public void login()
	{
		uid.sendKeys(Conr.datareader("UName"));
		password.sendKeys(Conr.datareader("password"));
		Login.click();
	}
	public String  gettitle()
	{
		String tit= title.getText();
		return tit;
	}

}
