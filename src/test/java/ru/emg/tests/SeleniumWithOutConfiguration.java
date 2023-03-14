package ru.emg.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumWithOutConfiguration {
    WebDriver driver;

    @Test
    public void yaSearchTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.navigate().to("https://ya.ru/");

        driver.quit();
    }
}
