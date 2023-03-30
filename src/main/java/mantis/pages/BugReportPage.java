package mantis.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BugReportPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(id = "summary")
    private WebElement summaryInput;

    @FindBy(id = "description")
    private WebElement descriptionInput;

    @FindBy(css = "input[value='Submit Issue']")
    private WebElement submitIssueButton;

    @FindBy(css = ".widget-title")
    private WebElement reportIssueTitle;

    public BugReportPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30, 500);

        PageFactory.initElements(driver, this);
    }

    public void fillUpSummaryInput(String summaryStr) {
        summaryInput.sendKeys(summaryStr);
    }

    public void fillUpDescriptionInput(String descriptionStr) {
        descriptionInput.sendKeys(descriptionStr);
    }

    public void submitIssue() {
        submitIssueButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#buglist tbody tr .column-id a")));
    }

    public String getReportIssueTitle() {
        return reportIssueTitle.getText();
    }

}
