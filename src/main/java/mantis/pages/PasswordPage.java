package mantis.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasswordPage {
    private final WebDriver driver;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(css = ".alert-danger p")
    private WebElement errorMessage;

    public PasswordPage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public void login(String password) {
        passwordField.sendKeys(password);
        passwordField.sendKeys(Keys.ENTER);
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }
}
