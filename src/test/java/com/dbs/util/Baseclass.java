package com.dbs.util;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Baseclass {
	public static WebDriver driver;
	public ConfigReader Conr;
	public static Logger logger;
	
	
	public Baseclass()
	{
		 Conr=new ConfigReader();
	}
	
	@BeforeClass
	@Parameters("Browser")
	public void setup( String br)
	{
		logger = Logger.getLogger("DBS Banking");
		PropertyConfigurator.configure("./Config/Log4j.properties");
		
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
		driver.get(Conr.datareader("URL"));
	}
	@AfterClass
	public void teardown()
	{
		driver.close();
	}

}
