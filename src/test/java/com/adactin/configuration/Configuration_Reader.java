package com.adactin.configuration;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Configuration_Reader {

	public static Properties prop;
	

	public Configuration_Reader() throws Throwable {
		File file = new File(
				"C:\\Users\\Manimaran\\eclipse-workspace\\Hotel.Adactin\\src\\test\\java\\com\\adactin\\configuration\\configuration.properties");
		FileInputStream fis = new FileInputStream(file);
		prop = new Properties();
		prop.load(fis);
	}

	public String getBrowser() {
		String browser = prop.getProperty("browser");
		return browser;
	}

	public String getUrl() {
		String url = prop.getProperty("url");
		return url;
	}

	public String getCardNum() {
		String cardNO = prop.getProperty("cardNumber");
		return cardNO;
	}

	public String getCvv() {
		String cvvNO = prop.getProperty("cvv");
		return cvvNO;

	}

	public String getReportConfigPath() {
		String reportConfigPath = prop.getProperty(
				"C:\\Users\\Manimaran\\eclipse-workspace\\Hotel.Adactin\\src\\test\\java\\com\\adactin\\configuration\\extend-config.xml");
		if (reportConfigPath != null)
			return reportConfigPath;
		else
			throw new RuntimeException(
					"Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
	}

}
