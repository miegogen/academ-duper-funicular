package ru.emg.homeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

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
    public void openForm() throws InterruptedException {
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
