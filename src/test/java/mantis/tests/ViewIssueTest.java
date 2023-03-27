package mantis.tests;

import org.junit.jupiter.api.Test;

public class ViewIssueTest extends BaseTest{

    @Test
    public void viewIssuePageTitleBlockTest() {
        mantisLogin();

        String viewingIssuesTitle = mantisFacade.getViewIssuePage().getViewingIssuesTitle();
        System.out.println(viewingIssuesTitle);
    }
}
