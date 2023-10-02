package at.gui.ftb.tests;

import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

// Тут у меня тесты

public class LoginFormTest extends TestBase {
    @Test
    void agentLoginSuccessful() {
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
       // openClearBaseURL();
// Act
        LoginPage.dataInput(agentUsername, agentPassword);
// Assert
        $("#spUsername").shouldHave(text(agentUsername));
        $("#aBooking").shouldBe(visible);
    }

    @Test
    void adminLoginSuccessful() {
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
        //openClearBaseURL();
// Act
        LoginPage.dataInput(adminUsername, adminPassword);
// Assert
        $("#spUsername").shouldHave(text(adminUsername));
        $("#aAircrafts").shouldBe(visible);
        $("#aAirports").shouldBe(visible);
    }

    @Test
    void passwordWrongCase() {
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
       // openClearBaseURL();
// Act
        LoginPage.dataInput(agentUsername, wrongCasePassword);
// Assert
        $(".alert-dismissible").shouldBe(visible).shouldHave(text(allertMessage));
        $("#btnLogout").shouldNotBe(visible);
        $("#spUsername").shouldNotBe(visible);
    }

    @Test
    void userNameSpace() {
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
       // openClearBaseURL();
// Act
        LoginPage.dataInput(agentUsernameSpace, agentPassword);
// Assert
        $(".alert-dismissible").shouldBe(visible).shouldHave(text(allertMessage));
        $("#btnLogout").shouldNotBe(visible);
        $("#spUsername").shouldNotBe(visible);
    }
}

