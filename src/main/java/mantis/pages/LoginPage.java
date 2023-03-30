package mantis.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private final WebDriver driver;

    @FindBy(css = "#username")
    private WebElement loginFiled;

    public LoginPage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public void login(String login) {
        driver.get("https://academ-it.ru/mantisbt/login_page.php");

        loginFiled.sendKeys(login);
        loginFiled.sendKeys(Keys.ENTER);
    }
}
