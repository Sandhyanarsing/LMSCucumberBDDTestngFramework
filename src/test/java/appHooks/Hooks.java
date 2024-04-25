package appHooks;

import java.io.ByteArrayInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import driverFactory.DriverFactory;
import utilities.ConfigReader;
import utilities.Constant;
import utilities.LoggerLoad;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;

public class Hooks {

	// these variables are private as they are specific to this class only

	private WebDriver driver;
	private DriverFactory dFactory;
	private Properties prop;

	@Before
	public void setUp() {
		//Get Browser type from config file
		prop = ConfigReader.getPropertyObject();
		String browseName = prop.getProperty("browser");		
		//Initialize driver from driver factory class
		dFactory = new DriverFactory();
		driver = dFactory.initializeDriver(browseName);
		LoggerLoad.info("@BeforeHook:-Initializing driver for browser :"+browseName);
		driver.get(prop.getProperty("url"));
		//this time will help to stabilize code in parallel execution
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constant.IMPLICIT_PAGE_LOAD));
		LoggerLoad.info("@BeforeHook:-Login pagr url opened successfully");
	}

	@After
	public void tearDown(Scenario scenario) {		
		if(driver!=null && scenario.isFailed())
		{			
			byte[] screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			Allure.addAttachment("Failed Scenario Screenshot", new ByteArrayInputStream(screenShot));
		}
		LoggerLoad.info("Closing driver from hook's teardown method...");		
		if(driver!=null)
		driver.quit();
	}
}
