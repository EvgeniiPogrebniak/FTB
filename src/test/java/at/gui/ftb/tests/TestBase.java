package at.gui.ftb.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import at.gui.ftb.pages.LoginPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

// Это у меня тестовые данные

public class TestBase {
    LoginPage LoginPage = new LoginPage();
    static String baseUrl = "http://192.168.40.100:8046";
    String agentUsername = "Mike";
    String agentPassword = "mike123";
    String adminUsername = "John";
    String adminPassword = "john123";
    String wrongCasePassword = "MiKe123";
    String agentUsernameSpace = "Mike ";
    String allertMessage = "Invalid username and/or password.";
    @BeforeAll
    static void BeforeAll() {
        Configuration.baseUrl = baseUrl;
    }

    @BeforeEach
    void openClearBaseURL() {
        open("/");
       $(byText("Welcome to Aero Travel website!")).shouldBe(visible);
        clearBrowserCookies();
        clearBrowserLocalStorage();
        refresh();
    }
}