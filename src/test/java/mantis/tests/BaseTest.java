package mantis.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import mantis.pages.MantisFacade;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    public WebDriver driver;
    protected MantisFacade mantisFacade;
    public Properties properties;

    void mantisLogin() {
        readConfig();
        mantisFacade = new MantisFacade(driver);
        mantisFacade.login(properties.getProperty("username"), properties.getProperty("password"));
    }

    @BeforeEach
    public void setUp() {
        readConfig();

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get(properties.getProperty("url"));
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    public void readConfig() {
        properties = new Properties();

        try (FileInputStream fileInputStream =
                     new FileInputStream("/Users/mac/IdeaProjects/academ/seleniumPageObj/src/main/resources/config.properties")) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
