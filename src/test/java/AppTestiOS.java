import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppTestiOS {
    AppiumDriver driver;
    DesiredCapabilities capabilities = new DesiredCapabilities();

    @BeforeClass()
    public void init() throws MalformedURLException {
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("deviceName", "iPhone 5s");
        //capabilities.setCapability("app", "/Users/SunKa/Development/Java Training/Mobile automation/UICatalog.app.zip");
        capabilities.setCapability(MobileCapabilityType.APP, new File("src/test/java/resources/UICatalog.app.zip").getAbsolutePath());

        driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void googleTest() {
        driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]")).click();
        driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[1]")).click();
        driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]")).isDisplayed();
    }
}

