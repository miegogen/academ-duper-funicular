package mantis.homework;

import mantis.tests.BaseTest;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HW_Framework extends BaseForHomeWork {

    @Test
    public void reportAndDeleteIssueTest() {
        mantisLogin();

        mantisFacade.getMainPage().goToReportIssuePage();

        SoftAssertions reportIssueAssertion = new SoftAssertions();
        reportIssueAssertion.assertThat(mantisFacade.getBugReportPage().getReportIssueTitle())
                .isEqualTo("Enter Issue Details");
        reportIssueAssertion.assertAll();

        mantisFacade.getBugReportPage().fillUpSummaryInput(properties.getProperty("summaryStr"));
        mantisFacade.getBugReportPage().fillUpDescriptionInput(properties.getProperty("descriptionStr"));
        mantisFacade.getBugReportPage().submitIssue();

        List<WebElement> issueList = mantisFacade.getViewIssuePage().getIssues();

        SoftAssertions newIssueAddedAssertions = new SoftAssertions();
        String issueSummaryTextBefore = issueList.get(0).findElement(By.cssSelector(".column-summary")).getText();
        newIssueAddedAssertions.assertThat(issueSummaryTextBefore).isEqualTo(properties.getProperty("summaryStr"));
        newIssueAddedAssertions.assertAll();

        for (WebElement issue : issueList) {
            String summaryText = issue.findElement(By.cssSelector(".column-summary")).getText();
            if (summaryText.equals(properties.getProperty("summaryStr"))) {
                issue.findElement(By.cssSelector(".column-id a")).click();
                mantisFacade.getViewIssueDetailPage().deleteIssue();
                break;
            }
        }

        SoftAssertions issueDeletedAssertions = new SoftAssertions();
        String issueSummaryTextAfter = issueList.get(0).findElement(By.cssSelector(".column-summary")).getText();
        issueDeletedAssertions.assertThat(issueSummaryTextAfter).isNotEqualTo(properties.getProperty("summaryStr"));
        issueDeletedAssertions.assertAll();

    }

}
