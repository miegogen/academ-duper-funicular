package ru.emg.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
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
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 3, 1000);

        driver.navigate().to("https://demoqa.com/automation-practice-form");

        // Input first, last name and e-mail, phone
        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys("Victor");
        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.sendKeys("Hasselblad");
        WebElement userEmail = driver.findElement(By.id("userEmail"));
        userEmail.sendKeys("apac@hasselblad.com");
        WebElement phoneNumber = driver.findElement(By.id("userNumber"));
        phoneNumber.sendKeys("1234567890");

        // Radio gender
        WebElement gender = driver.findElement(By.xpath("//*[@value='Male']/following::label"));
        gender.click();

        // Date of Birth
        driver.findElement(By.id("dateOfBirthInput")).click();
        WebElement year = driver.findElement(By.cssSelector(".react-datepicker__year-select"));
        Select selectYear = new Select(year);
        selectYear.selectByValue("1974");
        WebElement month = driver.findElement(By.cssSelector(".react-datepicker__month-select"));
        Select selectMonth = new Select(month);
        selectMonth.selectByValue("10");
        driver.findElement(By.xpath("//div[contains(@aria-label,'November 20')]")).click();
        WebElement brtDay = driver.findElement(By.id("dateOfBirthInput"));
        String birthDay = brtDay.getAttribute("value");


        Thread.sleep(3000);
    }
}
