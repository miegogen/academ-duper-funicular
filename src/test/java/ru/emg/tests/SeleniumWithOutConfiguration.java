package ru.emg.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SeleniumWithOutConfiguration {
    WebDriver driver;

    @Test
    public void yaSearchTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.navigate().to("http://htmlbook.ru/html/select");

        WebElement element = driver.findElement(By.name("select"));
        Select multipleSelect = new Select(element);
        multipleSelect.selectByIndex(1);
        multipleSelect.selectByIndex(3);

        List<WebElement> list = multipleSelect.getAllSelectedOptions();
        for (WebElement el: list) {
            System.out.println(el.getText());
        }

        driver.quit();
    }

    @Test
    public void singleSelectTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.navigate().to("http://htmlbook.ru/html/select");

        WebElement element = driver.findElement(By.name("select2"));
        Select singleSelect = new Select(element);
        singleSelect.selectByIndex(2);

        List<WebElement> list = singleSelect.getAllSelectedOptions();
        for (WebElement el: list) {
            System.out.println(el.getText());
        }

        List<WebElement> listAll = singleSelect.getOptions();
        for (WebElement el :
                listAll) {
            System.out.println(el.getText());
        }

        driver.quit();
    }

    @Test
    public void practiceFormTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.navigate().to("https://demoqa.com/automation-practice-form");
        WebElement element = driver.findElement(By.xpath("//*[@id='subjectsInput']"));
        element.sendKeys("Social Studies");
        element.sendKeys(Keys.RETURN);
        element.sendKeys("biol");
        element.sendKeys(Keys.TAB);
        Thread.sleep(1000);

//        WebElement chekSport = driver.findElement(By.xpath("//*[@for='hobbies-checkbox-1']"));
//        chekSport.click();
//        chekSport.submit();

        driver.findElement(By.xpath("//*[@for='hobbies-checkbox-2']")).click();
        driver.findElement(By.xpath("//*[@for='hobbies-checkbox-3']")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("uploadPicture")).sendKeys("pictureForSending.jpg");
//        driver.get("pictureForSending.jpg");

        Thread.sleep(2000);
//div[contains(@class, 'container--is-multi')]

        driver.quit();
    }
}
