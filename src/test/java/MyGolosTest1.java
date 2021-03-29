import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

public class MyGolosTest1 {
    @Test(timeout = 300000) //5 минут
    public void userCanSearch() {
        open("https://google.com/ncr");
    }
}
