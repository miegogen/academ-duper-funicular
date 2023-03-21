package mantis.pages;

import org.openqa.selenium.WebDriver;

public class MantisSite {
    private final WebDriver driver;
    private LoginPage loginPage;
    private PasswordPage passwordPage;
    private MainPage mainPage;

    public MantisSite(WebDriver driver) {
        this.driver = driver;

        loginPage = new LoginPage(driver);
        passwordPage = new PasswordPage(driver);
        mainPage = new MainPage(driver);
    }

    public void login(String login, String password) {
        loginPage.login(login);
        passwordPage.login(password);
    }

    // пока не понял зачем нужен getLoginPage, ведь просто login и так открывает страницу логина
    public LoginPage getLoginPage() {
        return loginPage;
    }

    // то же самое
    public PasswordPage getPasswordPage() {
        return passwordPage;
    }

    //кажется начинаю понимать :D
    public MainPage getMainPage() {
        return mainPage;
    }


}
