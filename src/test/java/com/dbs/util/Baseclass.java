package com.dbs.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Baseclass {
	public static WebDriver driver;
	
	public Baseclass()
	{
		
	}
	
	@BeforeClass
	@Parameters("Chrome")
	public void setup( String br)
	{
		if(br.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(br.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.edge.driver", "./Driver/msedgedriver.exe");
			driver=new EdgeDriver();
		}
		else if(br.equalsIgnoreCase("FireFox"))
		{
			System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else
			System.out.println("please provide Chrome or IE or FireFox");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/V1/index.php");
	}
	@AfterClass
	public void teardown()
	{
		driver.close();
	}

}
