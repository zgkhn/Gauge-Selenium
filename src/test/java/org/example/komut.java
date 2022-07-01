package org.example;

import org.openqa.selenium.WebElement;
public class komut extends connect{



    public boolean clickkbot(String key) throws Exception {
        WebElement element=null;
        baglanti(key).click();
        return false;
    }
    public boolean clickkbot(String key,String key1) throws Exception {
        WebElement element=null;
        baglanti(key).sendKeys(key1);
        return false;
    }


}
