package mantis.tests;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ViewIssueTest extends BaseTest {

    @Test
    public void getIssuesCountTest() {
        SoftAssertions softAssertions = new SoftAssertions();
        mantisLogin();
        mantisFacade.getMainPage().goToViewIssuesPage();

        softAssertions.assertThat(50).isEqualTo(mantisFacade.getViewIssuePage().getIssuesCount());
        softAssertions.assertAll();
    }

    @Test
    public void getIssuesTest() {
        mantisLogin();
        mantisFacade.getMainPage().goToViewIssuesPage();

        List<WebElement> issues = mantisFacade.getViewIssuePage().getIssues();
//        WebElement element = issues.get(0);
//        element.
        for (WebElement issue :
                issues) {
            WebElement element = issue.findElement(By.className("column-summary"));
            String text = element.getText();
            System.out.println(text);
        }
    }

    @Test
    public void viewingIssuesTitleTest() {
        mantisLogin();
        mantisFacade.getMainPage().goToViewIssuesPage();

        String viewingIssuesText = mantisFacade.getViewIssuePage().getViewingIssuesText();
        System.out.println(viewingIssuesText);
    }

    @Test
    public void scrollToBottomSelectElementTest() throws InterruptedException {
        mantisLogin();
        mantisFacade.getMainPage().goToViewIssuesPage();

        WebElement selectAll = driver.findElement(By.cssSelector(".inline"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", selectAll);
        Thread.sleep(2000);

        Assertions.assertTrue(driver.findElement(By.cssSelector("#bug_arr_all")).getAttribute("id").equals("bug_arr_all"));
        Thread.sleep(2000);
    }
}
