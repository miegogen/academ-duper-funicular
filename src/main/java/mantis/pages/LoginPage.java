package mantis.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(css = "#username")
    private WebElement loginFiled;

    public LoginPage(WebDriver driver) {
        this.driver = driver;

        // не совсем понял зачем здесь wait нужен, т.к. он не прописан в настройки driver как implicit и не применяется explicit
        wait = new WebDriverWait(driver, 30, 500);

        PageFactory.initElements(driver, this);
    }

    public void login(String login) {
        driver.get("https://academ-it.ru/mantisbt/login_page.php");

        loginFiled.sendKeys(login);
        loginFiled.sendKeys(Keys.ENTER);
    }
}
