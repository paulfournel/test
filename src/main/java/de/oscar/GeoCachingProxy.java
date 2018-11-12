package de.oscar;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class GeoCachingProxy {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RemoteWebDriver driver;

    public Cache getCacheById(String cacheId) {
        driver.get("http://coord.info/" + cacheId);

        String lonLat = driver.findElementById("uxLatLon").getText();
        String hint = driver.findElementById("ctl00_ContentBody_EncryptionKey").getText();
        String[] difficulty = driver.findElementByClassName("CacheStarLabels").findElement(By.tagName("img")).getAttribute("src").split("/");

        return new Cache(lonLat, hint, difficulty[difficulty.length - 1]);
    }

    @Scheduled(fixedDelay = 1500000)
    private void init() {
        try {
            login();
        } catch (Exception e) {
            logger.info("No need to login.");
        }

    }

    @PostConstruct
    private void login() {
        logger.info("Starting login");
        driver.get("https://www.geocaching.com/account/signin");

        driver.findElement(new By.ById("UsernameOrEmail")).click();
        driver.getKeyboard().pressKey("misssa");
        driver.findElement(new By.ById("Password")).click();
        driver.getKeyboard().pressKey("310598");
        driver.findElement(new By.ById("SignIn")).click();
        logger.info("Finished login");
    }
}