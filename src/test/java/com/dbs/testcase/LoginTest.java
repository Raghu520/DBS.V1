package com.dbs.testcase;

import org.testng.annotations.Test;

import com.dbs.pages.LoginPage;
import com.dbs.util.Baseclass;

public class LoginTest extends Baseclass {
	
	@Test
	public void loginverfication()
	{
		LoginPage lp=new LoginPage();
		lp.login();
		String tit=lp.gettitle();
		if(tit.equals("Gtpl Bank"))
		{
			System.out.println("Welcome to home Page");
		}
		else 
			System.out.println("please enter valid Credintal");
	}

}
