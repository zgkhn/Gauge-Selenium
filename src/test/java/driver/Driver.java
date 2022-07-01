package driver;

import com.thoughtworks.gauge.AfterSuite;
import com.thoughtworks.gauge.BeforeSuite;
import com.thoughtworks.gauge.Logger;
import org.openqa.selenium.WebDriver;

public class Driver {

    // Holds the WebDriver instance
    public static WebDriver webDriver;

    // Gerekli tarayıcının bir webDriver örneğini başlat
    // Bunun uygulamanın iş etki alanında bir önemi olmadığından, webDriver'ı başlatmak için BeforeSuite kancası kullanılır
    @BeforeSuite
    public void initializeDriver(){webDriver = DriverFactory.getDriver();}

    // Close the webDriver instance
    @AfterSuite
    public void closeDriver(){
       // webDriver.quit();
    }

}
