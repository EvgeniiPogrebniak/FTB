package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.LoginPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestBase {
    LoginPage LoginPage = new LoginPage();
    static String baseURL;

    @BeforeAll
    static void BeforeAll() {
        Configuration.baseUrl = "http://192.168.40.100:8046";
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