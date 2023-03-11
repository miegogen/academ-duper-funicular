package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumWebDriverManagerTest {

    @Test
    public void openDemoQATest() {
        WebDriver driver = null;
        String browser = System.getProperty("browser");

        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }if (browser.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        String url = "https://demoqa.com/";

        driver.get(url);
        driver.manage().window().maximize();

        driver.quit();
    }

    @Test
    public void simpleTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

//        driver.get("https://ya.ru");
        driver.navigate().to("https://ya.ru");
        driver.navigate().refresh();

        driver.quit();
    }
}
