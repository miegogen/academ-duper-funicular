package mantis.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import mantis.pages.MantisFacade;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    public WebDriver driver;
    protected MantisFacade mantisFacade;

    void mantisLogin() {
        mantisFacade = new MantisFacade(driver);
        mantisFacade.login("admin", "admin20");
    }

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://academ-it.ru/mantisbt/login_page.php");
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
