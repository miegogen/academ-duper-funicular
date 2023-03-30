package mantis.homework;

import mantis.tests.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HW_Framework extends BaseForHomeWork {

    @Test
    public void reportAndDeleteIssueTest() {
        mantisLogin();

        mantisFacade.getMainPage().goToReportIssuePage();

        mantisFacade.getBugReportPage().fillUpSummaryInput(properties.getProperty("summaryStr"));
        mantisFacade.getBugReportPage().fillUpDescriptionInput(properties.getProperty("descriptionStr"));
        mantisFacade.getBugReportPage().submitIssue();

        List<WebElement> issueList = mantisFacade.getBugReportPage().getIssueList();
        for (WebElement issue : issueList) {
            String summaryText = issue.findElement(By.cssSelector(".column-summary")).getText();
            if (summaryText.equals(properties.getProperty("summaryStr"))) {
                issue.findElement(By.cssSelector(".column-id a")).click();
                mantisFacade.getBugReportPage().deleteIssue();
                break;
            }
        }
    }

}
