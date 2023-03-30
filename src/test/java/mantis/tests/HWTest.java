package mantis.tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HWTest extends BaseTest{
    private final String summaryStr = "Some summary for HW";
    private final String descriptionStr = "Some description for HW";

    @Test
    public void reportAndDeleteIssueTest() throws InterruptedException {
        mantisLogin();

        mantisFacade.getMainPage().goToReportIssuePage();

        mantisFacade.getBugReportPage().fillUpSummaryInput(summaryStr);
        mantisFacade.getBugReportPage().fillUpDescriptionInput(descriptionStr);
        mantisFacade.getBugReportPage().submitIssue();
        ;

        List<WebElement> issueList = mantisFacade.getBugReportPage().getIssueList();
        for (WebElement issue : issueList) {
            String summaryText = issue.findElement(By.cssSelector(".column-summary")).getText();
            if (summaryText.equals(summaryStr)) {
                issue.findElement(By.cssSelector(".column-id a")).click();
                mantisFacade.getBugReportPage().deleteIssue();
                break;
            }
        }
        

    }



}
