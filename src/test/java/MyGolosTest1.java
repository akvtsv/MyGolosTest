import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

public class MyGolosTest1 {
    @Test(timeout = 1000)
    public void userCanSearch() {
        open("https://google.com/ncr");
    }
}
