package org.example;

import org.openqa.selenium.interactions.Actions;

import java.util.logging.Logger;

public class komut extends connect{

    private static final Logger log = Logger.getLogger(String.valueOf(StepImplementation.class)); // Log4j logger


    public void clickkbot(String key) throws Exception {
        baglanti(key).click();
        log.info(key+ " Adresine Tıklandı");

    }
    public void clickkbot(String key,String key1) throws Exception {
        baglanti(key).sendKeys(key1);
        log.info(key+ " Adresine " + key1 + " Degeri Girildi");
    }

    public void dur(String key) throws Exception {
        Actions action = new Actions(webDriver);
        action.moveToElement(baglanti(key)).build().perform();
        log.info(key+ " Üzerinden Duruldu");

    }

}
