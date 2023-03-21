package mantis.tests;

import mantis.pages.MantisSite;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTests extends BaseTest{
    private MantisSite mantisSite;

    // Так как перед каждым тестом автоматом сработает @BeforeEach из BaseTest, то сразу нужно приступать к делу без расшаркиваний

    @Test
    public void loginUrlTest() {
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals("https://academ-it.ru/mantisbt/login_page.php", currentUrl);
    }

}