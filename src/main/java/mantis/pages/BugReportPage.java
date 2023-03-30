package mantis.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BugReportPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(id = "summary")
    private WebElement summaryInput;

    @FindBy(id = "description")
    private WebElement descriptionInput;

    @FindBy(css = "input[value='Submit Issue']")
    private WebElement submitIssueButton;

    @FindBy(css = "#buglist tbody tr")
    private List<WebElement> issueList;

    @FindBy(css = "input[value='Delete']")
    private WebElement deleteIssueButton;

    @FindBy(css = "input[value='Delete Issues']")
    private WebElement confirmRequestDeleteIssue;

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

    public List<WebElement> getIssueList() {
        return issueList;
    }

    public void deleteIssue() {
        deleteIssueButton.click();
        confirmRequestDeleteIssue.click();
    }

}
