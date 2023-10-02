package at.gui.ftb.pages;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    public LoginPage dataInput(String Username, String Password) {
        $(".btn-success").click();
        $("[name=username]").setValue(Username);
        $("[name=password]").setValue(Password);
        $(".btn-outline-success").click();
        return this;
    }
}
