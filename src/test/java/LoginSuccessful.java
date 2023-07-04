import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginSuccessful {
    @Test
        void AgentLoginSuccessful() {
        Configuration.holdBrowserOpen = true;
        open("http://192.168.40.100:8046");

        $(".btn-success").click();
        $("[name=username]").setValue("Mike") ;
        $("[name=password]").setValue("mike123") ;
        $(".btn-outline-success").click();
    }
}
