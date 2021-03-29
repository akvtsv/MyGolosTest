import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class MyGolosTest1 {
    @Test(timeout = 300000) //5 минут
     public void userCanSearch() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
        open("https://google.com/ncr");
        closeWebDriver();
    }
}
