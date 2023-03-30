package mantis.pages;

import org.openqa.selenium.WebDriver;

public class MantisFacade {
    private final WebDriver driver;
    private LoginPage loginPage;
    private PasswordPage passwordPage;
    private MainPage mainPage;
    private ViewIssuePage viewIssuePage;
    private BugReportPage bugReportPage;

    public MantisFacade(WebDriver driver) {
        this.driver = driver;

        loginPage = new LoginPage(driver);
        passwordPage = new PasswordPage(driver);
        mainPage = new MainPage(driver);
        viewIssuePage = new ViewIssuePage(driver);
        bugReportPage = new BugReportPage(driver);
    }

    public void login(String login, String password) {
        loginPage.login(login);
        passwordPage.login(password);
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public PasswordPage getPasswordPage() {
        return passwordPage;
    }

    public MainPage getMainPage() {
        return mainPage;
    }

    public ViewIssuePage getViewIssuePage() {
        return viewIssuePage;
    }

    public BugReportPage getBugReportPage() {
        return bugReportPage;
    }
}
