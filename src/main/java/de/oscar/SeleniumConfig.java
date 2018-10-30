package de.oscar;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PreDestroy;
import java.net.URL;

@Configuration
public class SeleniumConfig {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Bean
    public RemoteWebDriver remoteWebDriver(){
        logger.info("Starting to create webdriver");
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("name", "Chrome");
        caps.setCapability("browserName", "chrome");
        try {
            RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);
            driver.manage().window().setSize(new Dimension(1024, 768));
            logger.info("Finished creating webdriver");
            return driver;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }



}
