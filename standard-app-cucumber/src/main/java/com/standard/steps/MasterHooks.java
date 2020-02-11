package com.standard.steps;

import com.standard.factory.DriverFactory;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class MasterHooks extends DriverFactory {

    @Before
    public void setup() {
        driver = getDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        try {
            scenario.embed(extractBytes("img.png"), "image/png");
            if (driver != null) {
                driver.manage().deleteAllCookies();
                driver.quit();
                driver = null;
            }
        } catch (Exception e) {
            System.out.println(e+"PLUS");
        }
    }

    public byte[] extractBytes (String imageName) throws IOException {
        return Files.readAllBytes(new File(imageName).toPath());
    }
}
