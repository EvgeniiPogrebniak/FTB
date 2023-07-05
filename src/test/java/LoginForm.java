import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class LoginForm {
    // Test data
    String AllertMessage= "Invalid username and/or password.";
    String baseURL = "http://192.168.40.100:8046";
    String AgentUsername = "Mike";
    String AgentPassword = "mike123";
    String AdminUsername = "John";
    String AdminPassword = "john123";
    String WrongCasePassword = "MiKe123";
    private void OpenClearBaseURL() {
        open(baseURL);
        clearBrowserCookies();
        clearBrowserLocalStorage();
        refresh();
    }

    @Test
        void AgentLoginSuccessful() {
        /*
        Test Case:
        Check the possibility of authorization of a user with the Agent role when entering valid username and password fields.
        Steps:
        1. Open the main page of the FTB application;
        2. Go to the authorization page (click the "Login" button);
        3. Enter a valid Agent login in the "Username" field;
        4. Enter a valid Agent password in the "Password" field;
        5. Press the "Sign in" button.
        Expected result:
        Authorization completed successfully, the main page of the FTB application opens with the menu item "Book Flight".
        */
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

    @Test
    void AdminLoginSuccessful() {
        /*
        Test Case:
        Check the possibility of authorization of a user with the Admin role when entering valid username and password fields.
        Steps:
        1. Open the main page of the FTB application;
        2. Go to the authorization page (click the "Login" button);
        3. Enter a valid Admin login in the "Username" field;
        4. Enter a valid Admin password in the "Password" field;
        5. Press the "Sign in" button.
        Expected result:
        Authorization completed successfully, the main page of the FTB application opens with the menu item "Aircrafts".
        */
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
        /*
        Test Case:
        Check the case dependence of the "Password" field during authorization.
        Steps:
        1. Open the main page of the FTB application;
        2. Go to the authorization page (click the "Login" button);
        3. Enter a valid login in the "Username" field;
        4. Enter a valid password in the "Password" field, but in the wrong case;
        5. Press the "Sign in" button.
        Expected result:
        Authorization Error:
        Invalid username and/or password.
         */
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
        /*
        Test Case:
        Check the possibility of authorization when entering a valid login with a space in the "Username" field.
        Steps:
        1. Open the main page of the FTB application;
        2. Go to the authorization page (click the "Login" button);
        3. Enter a valid login with a space in the "Username" field;
        4. Enter a valid password in the "Password" field;
        5. Press the "Sign in" button.
        Expected result:
        Authorization Error:
        Invalid username and/or password.
         */
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