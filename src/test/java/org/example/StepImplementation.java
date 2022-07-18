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

    }
    @Step("<key> elementine <text> degerini gir")
    public void text(String key,String text) throws Exception {

        clickkbot(key,text);

    }
    @Step("<key> elementi üzerinde dur")
    public void uzerindedur(String key) throws Exception {
        dur(key);
    }

    @Step("<key> elementini kontrol et")
    public void kontrol(String key) throws Exception {


            kontrolelement(key);



    }
    @Step("rasgele bir ürünü favoriye al kaydet")
    public void kaydet() throws Exception {
        favorikaydet();
    }
    @Step("favori ürünü kontrol et ve sil")
    public void kontrolet() throws Exception {
        urunkontrol();
    }

    @Step("Open Site")
    public void implementation1() throws InterruptedException {
        String app_url = System.getenv("APP_URL");
        Driver.webDriver.get(app_url + "/");

    }
    @Step("Anasayfa test")
    public void anasayfatest() {
        assertThat(Driver.webDriver.getTitle()).contains(System.getenv("NAME"));
    }
    @Step("bekle")
    public void bekle() throws InterruptedException {
        Thread.sleep(2000);

    }
    @Step("test")
    public void beklse() throws InterruptedException {
        System.out.println("************************************************");
        webDriver.navigate().refresh();
        Thread.sleep(5000);
    }
}