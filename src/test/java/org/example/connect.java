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
                //if(key.equals(istek1)){donus = key + "%%" + value + "%%" + type;}
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
                //if(key.equals(istek1)){donus = key + "%%" + value + "%%" + type;}
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

    public static void favorikaydet(String deger) throws Exception {
        String x =  webDriver.findElement(By.xpath(baglantiters(deger)+ baglantiters("isimal"))).getText();
        webDriver.findElement(By.xpath(baglantiters(deger)+ baglantiters("favoriyeal"))).click();

        link.setText(x);
    }

//    public static String veri(String istek){
//        String element = null;
//        try {
//            System.out.println("**************");
//                if(baglanti(istek) != null){
//                    System.out.println(baglanti(istek));
//                    System.out.println(baglanti(istek).split("%%")[0]);
//                    System.out.println(baglanti(istek).split("%%")[1]);
//                    System.out.println(baglanti(istek).split("%%")[2]);
//                }else {
//                    System.out.println("bulamadi");
//                }
//
//        }catch (Exception e){
//
//            System.out.println("hata : "+ e );
//
//        }
//        return element;
//    }


}
