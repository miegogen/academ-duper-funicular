package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SearchTests {

    WebDriver driver;

    @BeforeEach
    public void beforeEveryTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterEach
    public void afterEveryTest() {
        driver.quit();
    }

    @Test
    public void yaSearchTest() throws InterruptedException {
        driver.navigate().to("https://ya.ru/");

        driver.findElement(By.xpath("//*[@id='text']")).sendKeys("heroku");
        driver.findElement(By.xpath("//*[@id='text']")).sendKeys(Keys.RETURN);
        Thread.sleep(3000);
        Assertions.assertEquals("heroku.com",
                driver.findElement(By.xpath("//*[@id='search-result']/li[1]//a/b")).getText());
    }

    @Test
    public void s7ImplicitWaitTest() {
        driver.get("https://news.s7.ru/news?id=13441");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        WebElement input = driver.findElement(By.xpath("//*[@id='author']"));
        input.sendKeys("Victor Grigorovich");

        Assertions.assertEquals("Victor Grigorovich", input.getAttribute("value"));
    }

    @Test
    public void s7ExplicitWaitTest() {
        driver.get("https://news.s7.ru/news?id=13441");
        driver.manage().window().maximize();

        WebDriverWait driverWait = new WebDriverWait(driver, 1);
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".comments-block-wrapper")));

        WebElement input = driver.findElement(By.xpath("//*[@id='author']"));
        input.sendKeys("Victor Grigorovich");

        Assertions.assertEquals("Victor Grigorovich", input.getAttribute("value"));
    }
}
