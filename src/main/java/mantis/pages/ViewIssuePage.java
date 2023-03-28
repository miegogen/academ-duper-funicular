package mantis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ViewIssuePage {
    private final WebDriver driver;
//    private final WebDriverWait wait;

    @FindBy(css = "#buglist tbody tr")
    private List<WebElement> issues;

//    //*[normalize-space()="Viewing Issues 1 - 50 / 22953"]
    @FindBy(xpath = "(//h4[@class='widget-title lighter'])[2]")
    private WebElement viewingIssues;

    public ViewIssuePage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public int getIssuesCount() {
        return issues.size();
    }

    public List<WebElement> getIssues() {
        return issues;
    }

    public String getViewingIssuesText() {
        return viewingIssues.getText();
    }
}
