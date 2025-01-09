package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass 
{
    public static WebDriver driver;
    public Logger logger; // log4j
    public Properties p;

    @BeforeClass(groups = {"Sanity", "Master", "Regression", "datadriven"})
    @Parameters({"browser", "os"}) // RECEIVED BROWSER PARAMETER FROM THE XML FILE
    public void setup(String br, String os) throws InterruptedException, IOException 
    {
        // Initialize logger
        logger = LogManager.getLogger(this.getClass());

        // Load properties file
        FileReader file = new FileReader("./src/test/resources/config.properties");
        p = new Properties();
        p.load(file);
        logger.info("Properties file loaded successfully");

        /*
        // Setup driver based on environment
        if (p.getProperty("execution_env").equalsIgnoreCase("remote"))
        {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setPlatform(os.equalsIgnoreCase("windows") ? Platform.WIN10 : Platform.MAC);
            capabilities.setBrowserName(br.toLowerCase());
            logger.info("Setting up remote WebDriver with browser: " + br + " and OS: " + os);
            driver = new RemoteWebDriver(new URL("http://192.168.0.104:4444/wd/hub"), capabilities);
        } 
        else 
        {
            logger.info("Setting up local WebDriver with browser: " + br);
            switch (br.toLowerCase()) 
            {
                case "chrome": driver = new ChromeDriver(); break;
                case "firefox":driver = new FirefoxDriver(); break;
                case "edge": driver = new EdgeDriver(); break;
                default: System.out.println("Invalid browser name: " + br);
            }
        }

        if (driver == null) 
        {
            throw new IllegalStateException("WebDriver initialization failed!");
        }
*/
        logger.info("Setting up local WebDriver with browser: " + br);
        switch (br.toLowerCase()) 
        {
            case "chrome": driver = new ChromeDriver(); break;
            case "firefox":driver = new FirefoxDriver(); break;
            case "edge": driver = new EdgeDriver(); break;
            default: System.out.println("Invalid browser name: " + br);
        }
        
        // Configure WebDriver
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(p.getProperty("appurl"));
        driver.manage().window().maximize();
        Thread.sleep(5000);
        logger.info("WebDriver setup complete and application launched");
    }

        
    @AfterClass(groups = {"Sanity", "Master", "Regression", "datadriven"})
    public void close() {
        if (driver != null) {
            driver.quit();
            logger.info("WebDriver closed");
        }
    }

    // Generate random strings or numbers
    public String randomString() {
        return RandomStringUtils.randomAlphabetic(5);
    }

    public String randomNumber() {
        return RandomStringUtils.randomNumeric(10);
    }

    public String randomAlphanumeric() {
        return RandomStringUtils.randomAlphanumeric(10);
    }

    // Capture screenshot
    public String capturescreenshot(String tname) {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is not initialized. Cannot capture screenshot.");
        }
        if (!(driver instanceof TakesScreenshot)) {
            throw new UnsupportedOperationException("The WebDriver does not support taking screenshots.");
        }

        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String targetFilePath = System.getProperty("user.dir") + tname + "_" + timestamp + ".png";

        File targetFile = new File(targetFilePath);
        sourceFile.renameTo(targetFile);

        logger.info("Screenshot captured: " + targetFilePath);
        return targetFilePath;
    }
}
