package com.qa.utils;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;

public class CapabilitiesManager {
    CommonUtils utils = new CommonUtils();

    public DesiredCapabilities getCaps() throws IOException {
        GlobalParams params = new GlobalParams();
        try{
            utils.log().info("getting capabilities");
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platformName", params.getPlatformName());
            caps.setCapability("udid", params.getUDID());
            caps.setCapability("deviceName", params.getDeviceName());

            switch (params.getPlatformName()) {
                case "Android" -> {
                    caps.setCapability("automationName", PropertyManager.getProperty("androidAutomationName"));
                    caps.setCapability("appPackage", PropertyManager.getProperty("androidAppPackage"));
                    caps.setCapability("appActivity", PropertyManager.getProperty("androidAppActivity"));
                    caps.setCapability("systemPort", params.getSystemPort());
                    caps.setCapability("chromeDriverPort", params.getChromeDriverPort());
                    //String androidAppUrl = getClass().getResource(PropertyManager.getProperty("androidAppLocation")).getFile();
                    String androidAppUrl = PropertyManager.getProperty("androidAppUrl");
//                    String androidAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
//                            + File.separator + "resources" + File.separator + "apps" + File.separator + "eatOS.Staging.apk";
                    utils.log().info("appUrl is" + androidAppUrl);
                    caps.setCapability("app", androidAppUrl);
                    caps.setCapability("autoGrantPermissions", true);
                }
            }
            return caps;
        } catch(Exception e){
            e.printStackTrace();
            utils.log().fatal("Failed to load capabilities. ABORT!!" + e.toString());
            throw e;
        }
    }
}
