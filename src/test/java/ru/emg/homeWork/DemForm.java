package ru.emg.homeWork;

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
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class DemForm {
    WebDriver driver;
    WebDriverWait wait;

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

        wait = new WebDriverWait(driver,3,1000);
    }

    @AfterEach
    public void endingPage() {
        driver.quit();
    }

    @Test
    public void openForm() throws InterruptedException {
        driver.navigate().to("https://demoqa.com/automation-practice-form");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h5[text()='Student Registration Form']")));

        // Input first, last name and e-mail, phone
        driver.findElement(By.id("firstName")).sendKeys("Victor");
        driver.findElement(By.id("lastName")).sendKeys("Hasselblad");
        driver.findElement(By.id("userEmail")).sendKeys("apac@hasselblad.com");
        driver.findElement(By.id("userNumber")).sendKeys("1234567890");

        // Radio gender
        driver.findElement(By.xpath("//*[@value='Male']/following::label")).click();

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

        // Subjects
        WebElement element = driver.findElement(By.xpath("//*[@id='subjectsInput']"));
        element.sendKeys("Social Studies");
        element.sendKeys(Keys.RETURN);
        element.sendKeys("Biology");
        element.sendKeys(Keys.TAB);

        // Hobbies
        driver.findElement(By.xpath("//*[@for='hobbies-checkbox-2']")).click();
        driver.findElement(By.xpath("//*[@for='hobbies-checkbox-3']")).click();

        // Attach picture
        String absolutePath = new File("pict.png").getAbsolutePath();
        driver.findElement(By.id("uploadPicture")).sendKeys(absolutePath);

        // Address
        driver.findElement(By.id("currentAddress")).sendKeys("Tomsk, Russia");

        // State and City
        driver.findElement(By.id("react-select-3-input")).sendKeys("Haryana" + Keys.RETURN);
        driver.findElement(By.id("react-select-4-input")).sendKeys("Karnal" + Keys.RETURN);

        driver.findElement(By.id("submit")).click();

        // Wait until popup
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Thanks for submitting the form']")));

        Assertions.assertEquals("Victor Hasselblad", driver.findElement(By.xpath("//tbody/tr[1]/td[2]")).getText());
        Assertions.assertEquals("apac@hasselblad.com", driver.findElement(By.xpath("//tbody/tr[2]/td[2]")).getText());
        Assertions.assertEquals("Male", driver.findElement(By.xpath("//tbody/tr[3]/td[2]")).getText());
        Assertions.assertEquals("1234567890", driver.findElement(By.xpath("//tbody/tr[4]/td[2]")).getText());
        Assertions.assertEquals("20 November,1974", driver.findElement(By.xpath("//tbody/tr[5]/td[2]")).getText());
        Assertions.assertEquals("Social Studies, Biology", driver.findElement(By.xpath("//tbody/tr[6]/td[2]")).getText());
        Assertions.assertEquals("Reading, Music", driver.findElement(By.xpath("//tbody/tr[7]/td[2]")).getText());
        Assertions.assertEquals("pict.png", driver.findElement(By.xpath("//tbody/tr[8]/td[2]")).getText());
        Assertions.assertEquals("Tomsk, Russia", driver.findElement(By.xpath("//tbody/tr[9]/td[2]")).getText());
        Assertions.assertEquals("Haryana Karnal", driver.findElement(By.xpath("//tbody/tr[10]/td[2]")).getText());

        driver.quit();
    }
}
