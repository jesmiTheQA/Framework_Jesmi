package com.learning.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;

public class ConfigDataProvider {

	Properties pro;

	public ConfigDataProvider() {
		File src = new File("./Config/config.properities");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Not able to load Config file - " + e.toString());
		}
	}

	public String getStagingURL() {
		return pro.getProperty("qaURL");
	}

	public String getBrowser() {
		return pro.getProperty("Browser");
	}

	public String getDataFromConfig(String keyToSearch) {
		return pro.getProperty(keyToSearch);
	}
}
