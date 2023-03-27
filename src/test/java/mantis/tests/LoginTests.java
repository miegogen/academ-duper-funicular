package mantis.tests;

import mantis.pages.MantisFacade;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTests extends BaseTest{

    // Так как перед каждым тестом автоматом сработает @BeforeEach из BaseTest, то сразу нужно приступать к делу без расшаркиваний

    @Test
    public void loginUrlTest() {
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals("https://academ-it.ru/mantisbt/login_page.php", currentUrl);
    }

    @Test
    public void loginTitleTest() {
        String currentTitle = driver.getTitle();
        Assertions.assertEquals("MantisBT", currentTitle);
    }

    @Test
    public void successfulLoginTest() {
        mantisFacade = new MantisFacade(driver);
        mantisFacade.login("admin", "admin20");

        String currentUserName = mantisFacade.getMainPage().getUserName();
        Assertions.assertEquals("admin", currentUserName);
    }

    @Test
    public void mainPageAssignedBlockTitleTest() {
        mantisLogin();

        Assertions.assertTrue(mantisFacade.getMainPage().getTitleAssignedToMeBlock()
                .contains("Assigned to Me (Unresolved)"));
        Assertions.assertTrue(mantisFacade.getMainPage().isAssignedToMeBlockDisplayed());
        Assertions.assertTrue(mantisFacade.getMainPage().isUnassignedToMeBlockDisplayed());
    }

    @Test
    public void mainPageAssignedBlockTitleSoftAssertionTest() {
        mantisLogin();

        String currentAssignedBlockTitle = mantisFacade.getMainPage().getTitleAssignedToMeBlock();

        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThat(currentAssignedBlockTitle).isEqualTo("Assigned @to Me (Unresolved)");
        softAssertions.assertThat(mantisFacade.getMainPage().isAssignedToMeBlockDisplayed()).isEqualTo(false);
        softAssertions.assertThat(mantisFacade.getMainPage().isUnassignedToMeBlockDisplayed()).isEqualTo(true);

        softAssertions.assertAll();
    }
}