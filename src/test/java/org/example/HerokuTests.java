package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;


import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class HerokuTests {
    private WebDriver driver;

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.navigate().to("https://the-internet.herokuapp.com/");
//        driver.manage().window().maximize();
    }

    @Test
    public void checkDropDownTitleTest() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/dropdown");

        WebElement title = driver.findElement(By.xpath("//*[@id='dropdown']/../h3"));

//        Thread.sleep(3000);
        Assertions.assertTrue(title.isDisplayed());
        Assertions.assertEquals("Dropdown List", title.getText());
    }

    @Test
    public void checkCheckboxesListTest() throws InterruptedException {
//        driver.get("https://the-internet.herokuapp.com/checkboxes");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[text()='Checkboxes']")).click();
        Thread.sleep(1000);
        WebElement form = driver.findElement(By.xpath("//*[@id='checkboxes']"));
        List<WebElement> checkboxes = form.findElements(By.cssSelector("input"));
        Assertions.assertEquals(2, checkboxes.size());

        for (WebElement input : checkboxes) {
            Assertions.assertEquals("checkbox", input.getAttribute("type"));
        }
    }

//    @Test
//    public void checkUrlHerokuTest() {
//        Assertions.assertEquals("https://the-internet.herokuapp.com/", driver.getCurrentUrl());
//    }
}
