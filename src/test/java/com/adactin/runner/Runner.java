package com.adactin.runner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.adactin.baseclass.Base_Class;
import com.adactin.configuration.File_Reader_Manager;
import com.cucumber.listener.Reporter;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\java\\com\\adactin\\featureFile", glue = "com\\adactin\\stepDefinition", plugin = {
		"pretty","html:Reports/HTML_Report","json:Reports/JSON_Report.json"}, monochrome = true)

public class Runner {

	public static WebDriver driver;

	@BeforeClass
	public static void set_up() throws Throwable {
		String browser = File_Reader_Manager.getInstance().getInstanceCR().getBrowser();
		driver = Base_Class.browserLaunch(browser);

	}
//	@AfterClass
//	public static void writeExtentReport() throws Throwable {
//		Reporter.loadXMLConfig(new File(File_Reader_Manager.getInstance().getInstanceCR().getReportConfigPath()));
//	}

}
