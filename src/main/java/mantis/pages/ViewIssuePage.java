package mantis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ViewIssuePage {
    private final WebDriver driver;
//    private final WebDriverWait wait;

    @FindBy(xpath = "(//h4[@class='widget-title lighter'])[2]")
    private WebElement viewingIssuesTitle;

    public ViewIssuePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getViewingIssuesTitle() {

        return viewingIssuesTitle.getText();
    }

}
