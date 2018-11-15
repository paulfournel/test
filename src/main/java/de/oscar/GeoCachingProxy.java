package de.oscar;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;

@Service
public class GeoCachingProxy {
    private final static HashMap<String, String> CODE = makeCodes();

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RemoteWebDriver driver;

    public Cache getCacheById(String cacheId) {
        driver.get("http://coord.info/" + cacheId);

        String cacheName = driver.findElementById("ctl00_ContentBody_CacheName").getText();
        String lonLat = driver.findElementById("uxLatLon").getText();
        String hint = decrypt(driver.findElementById("div_hint").getText());
        String user = driver.findElementById("ctl00_ContentBody_mcd1").findElement(By.tagName("a")).getText();
        String difficulty = getImageName("ctl00_ContentBody_uxLegendScale");
        String terrain = getImageName("ctl00_ContentBody_Localize12");
        String size = getImageName("ctl00_ContentBody_size");

        return new Cache(cacheName, user, lonLat, hint, difficulty, terrain, size);
    }

    private String getImageName(String id) {
        String[] difficulty = driver.findElementById(id).findElement(By.tagName("img")).getAttribute("src").split("/");
        return difficulty[difficulty.length - 1].replace(".gif", "").replace("stars", "").replace("_", ".");
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

    private static String decrypt(String converted) {
        String res = "";
        for (int i = 0; i < converted.length(); i++) {
            String c = Character.toString(converted.charAt(i));
            res += CODE.get(c.toUpperCase()).toLowerCase();
        }
        return res;
    }

    private static HashMap<String, String> makeCodes() {
        HashMap<String, String> codes = new HashMap<>();
        codes.put("A", "N");
        codes.put("B", "O");
        codes.put("C", "P");
        codes.put("D", "Q");
        codes.put("E", "R");
        codes.put("F", "S");
        codes.put("G", "T");
        codes.put("H", "U");
        codes.put("I", "V");
        codes.put("J", "W");
        codes.put("K", "X");
        codes.put("L", "Y");
        codes.put("M", "Z");
        codes.put("N", "A");
        codes.put("O", "B");
        codes.put("P", "C");
        codes.put("Q", "D");
        codes.put("R", "E");
        codes.put("S", "F");
        codes.put("T", "G");
        codes.put("U", "H");
        codes.put("V", "I");
        codes.put("W", "J");
        codes.put("X", "K");
        codes.put("Y", "L");
        codes.put("Z", "M");
        return codes;
    }
}