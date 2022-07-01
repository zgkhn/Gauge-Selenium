package org.example;

import com.thoughtworks.gauge.Step;
import driver.Driver;


import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.assertThat;

public class StepImplementation extends komut {
    private static final Logger log = Logger.getLogger(String.valueOf(StepImplementation.class)); // Log4j logger

    @Step("<key> elementine tıkla")
    public void gotoGetStartedPage(String key) throws Exception {

        clickkbot(key);
        log.info(baglantiters(key)+ " Adresine Tıklandı");

    }
    @Step("<key> elementine <text> degerini gir")
    public void text(String key,String text) throws Exception {

        clickkbot(key,text);
        log.info(baglantiters(key)+ " Adresine " + text + " Degeri Girildi");

    }
    @Step("<key> elementi üzerinde dur")
    public void uzerindedur(String key) throws Exception {

        dur(key);
        log.info(baglantiters(key)+ " Üzerinden Duruldu");
    }

    @Step("Ensure installation instructions are available")
    public void ensureInstallationInstructionsAreAvailable() throws InterruptedException {

    }

    @Step("Open Site")
    public void implementation1() {
        String app_url = System.getenv("APP_URL");
        Driver.webDriver.get(app_url + "/");
        assertThat(Driver.webDriver.getTitle()).contains(System.getenv("NAME"));
    }
    @Step("Anasayfa test")
    public void anasayfatest() {
        assertThat(Driver.webDriver.getTitle()).contains(System.getenv("NAME"));
    }


}
