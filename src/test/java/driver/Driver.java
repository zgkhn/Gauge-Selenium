package driver;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {

    // Holds the WebDriver instance
    public static WebDriver webDriver;
    static final String HOST_URL = "http://localhost:4444/wd/hup";
    public static String platformdocker = "docker";
    @BeforeScenario
    public void initializeDriver() throws MalformedURLException {


               webDriver = DriverFactory.getDriver();




    }

    // Close the webDriver instance
    @AfterScenario
    public void closeDriver(){
        webDriver.quit();
    }

}