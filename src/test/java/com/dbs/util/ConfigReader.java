package com.dbs.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	Properties pr=new Properties();
	public ConfigReader()
	{
		File src=new File("./Config/config.properties");
		
		try {
			FileInputStream fip=new FileInputStream(src);
			pr.load(fip);
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("File not Found");
		}
	}
	public String datareader(String key)
	{
		return pr.getProperty(key);
	}

}
