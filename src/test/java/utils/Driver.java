package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {

//    static WebDriver driver;
//
//    public static  WebDriver getDriver() {
//
//
//        // if driver object already exists, then we just return it
//
//    if (driver != null) {
//
//        return null;
//
//
//    }
//    String browser = Config.getProperty("browser");
//    switch (browser) {
//        case "firefox":
//            driver = new FirefoxDriver();
//            break;
//        case "safari":
//            driver = new SafariDriver();
//            break;
//        default:
//            driver = new ChromeDriver();
//    }
//
//
//
//
//        driver.manage().window().maximize();
//    // these are implicit waits applied to the driver
//    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
//    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
//
//
//    return driver;
//
//
//    }
static WebDriver driver;
    private static final String browserType = Config.getProperty("browser");

    public static WebDriver getDriver() {
        if (driver == null) {
            switch (browserType) {
                case "firefox" -> driver = new FirefoxDriver();
                case "edge" -> driver = new EdgeDriver();
                default -> driver = new ChromeDriver();
            }

            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(12));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
            driver.manage().window().fullscreen();

        }
        return driver;
    }

    public static void quit(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }





}
