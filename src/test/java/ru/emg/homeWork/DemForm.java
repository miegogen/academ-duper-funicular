package ru.emg.homeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DemForm {
    WebDriver driver;

    @BeforeEach
    public void startingPage() {
        String browser = System.getProperty("browser");

        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } if (browser.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver();
            driver = new FirefoxDriver();
        }
    }

    @AfterEach
    public void endingPage() {
        driver.quit();
    }

    @Test
    public void openForm() {
        driver.navigate().to("https://demoqa.com/automation-practice-form");
    }
}
