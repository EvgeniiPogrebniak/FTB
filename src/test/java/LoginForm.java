import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class LoginForm {
    // test data
    String AllertMessage= "Invalid username and/or password.";
    String baseURL = "http://192.168.40.100:8046";
    String AgentUsername = "Mike";
    String AgentPassword = "mike123";
    String AdminUsername = "John";
    String AdminPassword = "john123";
    String WrongCasePassword = "MiKe123";
    @Test
        void AgentLoginSuccessful() {
// Arrange
        OpenClearBaseURL();
// Act
        $(".btn-success").click();
        $("[name=username]").setValue(AgentUsername) ;
        $("[name=password]").setValue(AgentPassword) ;
        $(".btn-outline-success").click();
// Assert
        $("#spUsername").shouldHave(text(AgentUsername));
        $("#aBooking").shouldBe(visible);
    }

    private void OpenClearBaseURL() {
        open(baseURL);
        clearBrowserCookies();
        clearBrowserLocalStorage();
        refresh();
    }

    @Test
    void AdminLoginSuccessful() {
// Arrange
        OpenClearBaseURL();
// Act
        $(".btn-success").click();
        $("[name=username]").setValue(AdminUsername) ;
        $("[name=password]").setValue(AdminPassword) ;
        $(".btn-outline-success").click();
// Assert
        $("#spUsername").shouldHave(text(AdminUsername));
        $("#aAircrafts").shouldBe(visible);
    }
    @Test
    void PasswordWrongCase() {
// Arrange
        OpenClearBaseURL();
// Act
        $(".btn-success").click();
        $("[name=username]").setValue(AgentUsername) ;
        $("[name=password]").setValue(WrongCasePassword) ;
        $(".btn-outline-success").click();
// Assert
        $(".alert-dismissible").shouldBe(visible).shouldHave(text(AllertMessage));
        $("#btnLogout").shouldNotBe(visible);
        $("#spUsername").shouldNotBe(visible);
    }
    @Test
    void UserNameSpace() {
// Arrange
        OpenClearBaseURL();
// Act
        $(".btn-success").click();
        $("[name=username]").setValue(AgentUsername).append(" ") ;
        $("[name=password]").setValue(AgentPassword) ;
        $(".btn-outline-success").click();
// Assert
        $(".alert-dismissible").shouldBe(visible).shouldHave(text(AllertMessage));
        $("#btnLogout").shouldNotBe(visible);
        $("#spUsername").shouldNotBe(visible);
    }
}