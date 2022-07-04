package driver;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.AfterSuite;
import com.thoughtworks.gauge.BeforeScenario;
import com.thoughtworks.gauge.BeforeSuite;
import org.openqa.selenium.WebDriver;

public class Driver {

    // Holds the WebDriver instance
    public static WebDriver webDriver;

    // Gerekli tarayıcının bir webDriver örneğini başlat
    // Bunun uygulamanın iş etki alanında bir önemi olmadığından, webDriver'ı başlatmak için BeforeSuite kancası kullanılır
    @BeforeScenario
    public void initializeDriver(){webDriver = DriverFactory.getDriver();}

    // Close the webDriver instance
    @AfterScenario
    public void closeDriver(){
        webDriver.quit();
    }

}
