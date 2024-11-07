package com.adactin.baseclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.support.ui.Select;

public class Base_Class {

	public static WebDriver driver;
	public static Select select;
	public static Alert alert;
	// public static TargetLocator switchTo;
	public static Actions actions;
	public static Navigation navigate;
	public static Robot robot;

	// **BROWSER LAUNCH**//
	public static WebDriver browserLaunch(String browsername) {
		try {
			if (browsername.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + ("\\Driver\\chromedriver.exe"));
				driver = new ChromeDriver();
			} else if (browsername.equalsIgnoreCase("edge")) {
				System.setProperty("webdriver.edge.driver",
						System.getProperty("user.dir") + ("\\Driver\\msedgedriver.exe"));
				driver = new EdgeDriver();
			} else {
				System.out.println("Invalid Browser");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.manage().window().maximize();
		return driver;
	}

	// GET URL//
	public static void getUrl(String url) {
		try {
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// SENDKEYS//
	public static void sendKeys(WebElement element, String value) {
		try {
			element.sendKeys(value);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// ***CLICK***//
	public static void click(WebElement element) {
		try {
		  element.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ***DropDown***//
	public static void dropDown(WebElement element, String options, String Value) {
		select = new Select(element);
		try {
			if (options.equalsIgnoreCase("byIndex")) {
				int parseInt = Integer.parseInt(Value);
				select.selectByIndex(parseInt);
			} else if (options.equalsIgnoreCase("byValue")) {
				select.selectByValue(Value);
			} else if (options.equalsIgnoreCase("byVisibleText")) {
				select.selectByVisibleText(Value);
			} else {
				System.out.println("Invalid election");
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

	}

	// ***Close***//
	public static void close() {
		try {
			driver.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// **GET FIRST SELECTED OPTION**//
	public static void getFirstSelectedOption() {
		try {
			WebElement firstSelectedOption = select.getFirstSelectedOption();
			System.out.println(firstSelectedOption.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// **IS MULTIPLE**//
	public static void isMultiple() {
		try {
			boolean multiple = select.isMultiple();
			System.out.println("Is Multiple :" + multiple);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// **GET ALL SELECTED OPTION**//
	public static void getAllSelectedOption() {
		try {
			List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
			for (WebElement items : allSelectedOptions) {
				System.out.println(items.getText());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// **GET OPTIONS**//
	public static void getOptions() {
		try {
			List<WebElement> options = select.getOptions();
			for (WebElement allOption : options) {
				System.out.println(allOption.getText());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// GET TITLE**//
	public static void getTitle() {
		try {
			String title = driver.getTitle();
			System.out.println("Title :" + title);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// **ALERT 0R POP-UP**//

	// --Simple Alert--//
	public static void simpleAlert() {
		try {
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// --Confirm Alert--//
	public static void confirmAlert(boolean ok) {
		alert = driver.switchTo().alert();
		try {

			if (ok) {
				alert.accept();
			} else {
				alert.dismiss();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// --Prompt Alert--//
	public static void promptAlert(String value, boolean ok) {
		Alert prompt = driver.switchTo().alert();

		try {
			if (ok) {
				prompt.sendKeys(value);
				prompt.accept();
			} else {
				prompt.dismiss();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// **SCREENSHOT**//
	public static void takescreenShot(String path) throws IOException {

		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File srcFile = ts.getScreenshotAs(OutputType.FILE);
			File desFile = new File(path);
			FileUtils.copyFileToDirectory(srcFile, desFile);
		} catch (WebDriverException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// ***GET TEXT***//
	public static void getText(WebElement element) {
		try {
			System.out.println(element.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

// **GET CURRENT URL**//
	public static WebDriver getCurrentUrl() {
		try {
			System.out.println(driver.getCurrentUrl());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return driver;
	}

	// ***IS ENABLE***//
	public static void isEnable(WebElement element) {
		System.out.println(element.isEnabled());

	}

	// ***IS SELECTED***//
	public static void isSeleted(WebElement element) {
		System.out.println(element.isSelected());

	}

	// ***IS DISPLAYED***//
	public static void isDisplayed(WebElement element) {
		System.out.println(element.isDisplayed());

	}

	// **QUIT**//
	public static void quit() {
		try {
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ==========FRAME==============//

	// ***FRAME BY INDEX***//
	public static void frameInt(int value) {
		try {
			driver.switchTo().frame(value);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// ***FRAME BY WEB-ELEMENT***//
	public static void frameWebelement(WebElement element) {
		try {
			driver.switchTo().frame(element);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// ***FRAME BY STRING***//
	public static void frameString(String value) {
		try {
			driver.switchTo().frame(value);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// ***WINDOW HANDLING***//
	public static void windowHandles() {
		Set<String> windowHandles = driver.getWindowHandles();
		for (String allWindow : windowHandles) {
			String title = driver.switchTo().window(allWindow).getTitle();
			System.out.println("Title : " + title);
		}

	}

	// ***CONTEXT CLICK OR RIGHT CLICK***//
	public static void rightClick(WebElement element) {
		actions = new Actions(driver);
		actions.contextClick(element).perform();

	}

	// ***ROBOT***//
	public static void robot(int press, int release) {
		try {
			robot = new Robot();

			robot.keyPress(press);

			robot.keyRelease(release);

		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	//**ACTION**//
	public static void actionMoveTo(WebElement element) {
		actions = new Actions(driver);
		actions.moveToElement(element).perform();
         
	}
	
	public static void actionClick(WebElement element) {
		actions = new Actions(driver);
        actions.click(element).perform();
	}
	
	

	// ============END==========//

}
