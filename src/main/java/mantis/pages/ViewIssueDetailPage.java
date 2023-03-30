package mantis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewIssueDetailPage {
    private final WebDriver driver;

    @FindBy(css = "input[value='Delete']")
    private WebElement deleteIssueButton;

    @FindBy(css = "input[value='Delete Issues']")
    private WebElement confirmRequestDeleteIssue;

    public ViewIssueDetailPage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public void deleteIssue() {
        deleteIssueButton.click();
        confirmRequestDeleteIssue.click();
    }

}
