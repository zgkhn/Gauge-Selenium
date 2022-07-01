package org.example;

import com.thoughtworks.gauge.Step;
import driver.Driver;


import static org.assertj.core.api.Assertions.assertThat;

public class StepImplementation extends komut {

    @Step("<key> elementine tıkla")
    public void gotoGetStartedPage(String key) throws Exception {

        clickkbot(key);
    }
    @Step("<key> elementine <text> degerini gir")
    public void text(String key,String text) throws Exception {

        clickkbot(key,text);

    }

    @Step("Ensure installation instructions are available")
    public void ensureInstallationInstructionsAreAvailable() throws InterruptedException {

    }

    @Step("Open Site")
    public void implementation1() {
        String app_url = System.getenv("APP_URL");
        Driver.webDriver.get(app_url + "/");
        assertThat(Driver.webDriver.getTitle()).contains("YouTube");
    }


}
