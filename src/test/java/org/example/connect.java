package org.example;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import driver.Driver;
import driver.link;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

public class connect extends Driver {

    private static final Logger log = Logger.getLogger(String.valueOf(StepImplementation.class)); // Log4j logger

    public static WebElement baglanti (String istek1) throws Exception {
        Thread.sleep(500);


        WebElement donus = null;
        try {
            File input = new File("src/test/resources/package.json");
            JsonElement fileElement = JsonParser.parseReader(new FileReader(input));
            JsonObject fileObject = fileElement.getAsJsonObject();
            JsonArray element = fileObject.get("link").getAsJsonArray();
            for (JsonElement linkElement : element) {
                JsonObject linkJson = linkElement.getAsJsonObject();
                String key = linkJson.get("key").getAsString();
                String value = linkJson.get("value").getAsString();
                String type = linkJson.get("type").getAsString();
                if (key.equals(istek1)) {
                   donus = kontrol(By.xpath(value));
                   break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return donus;
    }

    public static WebElement kontrol(By by) {
        WebElement element = null;
        try {
            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofMillis(10000));
            element = null;
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
            element = webDriver.findElement(by);
        } catch (Exception e) {

            System.out.println("Element Bulunmadı : " + e);
        }
        return element;
    }
    public static boolean kontrolelement(String deger) throws Exception {

        try {
            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofMillis(10000));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(baglantiters(deger))));
            log.info(deger+ " elementi bulundu");

        }catch (Exception e){

            Assert.fail(deger+" Elementi sayfada bulunamadı");
        }


        return true;
    }


    public static String baglantiters (String istek1) throws Exception {

        String donus = null;
        try {
            File input = new File("src/test/resources/package.json");
            JsonElement fileElement = JsonParser.parseReader(new FileReader(input));
            JsonObject fileObject = fileElement.getAsJsonObject();
            JsonArray element = fileObject.get("link").getAsJsonArray();
            for (JsonElement linkElement : element) {
                JsonObject linkJson = linkElement.getAsJsonObject();
                String key = linkJson.get("key").getAsString();
                String value = linkJson.get("value").getAsString();
                String type = linkJson.get("type").getAsString();
                if (key.equals(istek1)) {
                    donus = value;
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return donus;
    }

    public static void favorikaydet() throws Exception {

        List<WebElement> elements = webDriver.findElements(By.xpath("//*[@class=\"products products--category js-ajax-category-products\"]/div"));
        Random rastgele = new Random();
        int x = 1 + elements.size();
        int sayi = rastgele.nextInt(x);
        webDriver.findElement(By.xpath("//*[@class=\"products products--category js-ajax-category-products\"]/div["+sayi+"]//*[@class=\"icon-favorite-border js-stop-productClick-event\"]")).click();
        link.setText(webDriver.findElement(By.xpath("//*[@class=\"products products--category js-ajax-category-products\"]/div["+sayi+"]//*[@class=\"products__item-title\"]")).getText());

    }
    public static void  urunkontrol(){
        int durum = 0;
        List<WebElement> elements = webDriver.findElements(By.xpath("//*[@class=\"products products--favorites\"]"));
        for (int i = 0; i < elements.size(); i++) {
            int b = i +1;

            String isim = String.valueOf(webDriver.findElements(By.xpath("//*[@class=\"products products--favorites\"]/div["+b+"]//*[@class=\"products__item-title\"]")));
            if (link.getText().equals(isim)) {
                log.info("favori ürün "+ link.getText()+ "bulundu");
                durum = 1;
                webDriver.findElement(By.xpath("//*[@class=\"products products--favorites\"]/div["+b+"]//*[@class=\"icon-favorite-border js-stop-productClick-event\"]")).click();
                break;
            }
        }

    }
}
