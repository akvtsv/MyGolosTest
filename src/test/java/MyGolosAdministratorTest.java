import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.junit.TextReport;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class MyGolosAdministratorTest {

    @Rule
    public TextReport report = new TextReport();

    @Before
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }

    @Test
    public void LoginManage() {
        /*Войти в систему под логином aft@greenatom.ru
        Вход в систему осуществлен*/
        Configuration.startMaximized=true;
        Configuration.holdBrowserOpen = true;
        open("https://golos-temp.rosatom.ru/manage");
        $(By.id("login")).setValue("aft@greenatom.ru");
        $(By.id("password")).setValue("Greenatom");
        $(new Selectors.ByText("Войти")).click();
        }

    @Test
    public void SozdanieZakritogoVoprosa() throws InterruptedException {
       /* 1.2	Нажать кнопку "Создать опрос…"
        Открыто окно "Создать новый опрос" с полем "Введите название для нового опроса"*/
        $(By.xpath("//button[text()='Создать опрос...']")).click();

       /* 1.3	В поле "Введите название для нового опроса" ввести: Опрос Тест
        Поле "Введите название для нового опроса" успешно заполнено*/
        $(By.xpath("//input")).click();
        $(By.xpath("//input")).sendKeys("Опрос Тест");
       /* 1.4	Нажать кнопку "Создать"
        Опрос успешно создан.
        Открыта страница добавления вопросов в опрос."*/
        $(By.xpath("//button[text() = 'Создать ']")).click();
        $(".alert").shouldHave(Condition.text("Опрос успешно сохранен"));
        sleep(6000);//ждем 6 секунд пока пропадет алерт

        /*  1.5	Нажать кнопку "Назад к опросам"
        Открыта страница создания опроса*/
        $(By.xpath("//span[text()='Назад к опросам']")).click();

        /*1.6	Нажать кнопку "Создать опрос…"
        Открыто окно "Создать новый опрос" с полем "Введите название для нового опроса"*/
        $(By.xpath("//button[text()='Создать опрос...']")).click();

        /*1.7	В поле "Введите название для нового опроса" ввести: Опрос АФТ
        Поле "Введите название для нового опроса" успешно заполнено*/
        $(By.xpath("//input")).click();
        $(By.xpath("//input")).sendKeys("Опрос АФТ");

        /*1.8	Нажать кнопку "Создать"
        Опрос успешно создан.
        Открыта страница добавления вопросов в опрос."*/
        $(By.xpath("//button[text() = 'Создать ']")).click();
        $(".alert").shouldHave(Condition.text("Опрос успешно сохранен"));
        sleep(6000);//ждем 6 секунд пока пропадет алерт

        /*1.9	Поставить чекбокс "Классический опрос"
        Чекбокс успешно установлен*/
        $(By.xpath("//div[text() = ' Классический опрос ']/input")).click();

        /*1.10	Нажать кнопку "Добавить вопрос…"
        Открыто окно "Добавление вопроса"*/
        $(By.xpath("//div[@title='Добавить вопрос']/span")).click();

        /*1.11	В поле "Заголовок вопроса" ввести: Закрытый вопрос Тест АФТ
        Поле "Заголовок вопроса" успешно заполнено*/
        $(By.xpath("//div[label[text()='Заголовок вопроса']]//p")).sendKeys("Закрытый вопрос Тест АФТ");

        /*1.12	Нажать кнопку "Создать"
        Закрытый вопрос создан.
        Окно ""Добавление вопроса"" закрыто."*/
        $(By.xpath("//button[text() = 'Создать ']")).click();

        /*1.13	Нажать кнопку "Добавить ответ…"
        Открыто окно "Добавление ответа"*/
        $(By.xpath("//span[text()='Добавить ответ ...']")).click();

        /*1.14	В поле "Ответ" ввести: Закрытый ответ 001 Тест АФТ
        Поле "Ответ" успешно заполнено*/
        $(By.xpath("//div[div[text()='Добавление ответа']]//p")).click();
        $(By.xpath("//div[div[text()='Добавление ответа']]//p")).sendKeys("Закрытый ответ 001 Тест АФТ");


        /*1.15	Нажать кнопку "Создать"	"" +
        Ответ успешно создан.
        Окно ""Добавление ответа"" закрыто."*/
        $(By.xpath("//button[text() = 'Создать ']")).click();

        /*1.16	Нажать кнопку "Добавить ответ…"
        Открыто окно "Добавление ответа"*/
        $(By.xpath("//span[text()='Добавить ответ ...']")).click();

        /*1.17	В поле "Ответ" ввести: Закрытый ответ 002 Тест АФТ
        Поле "Ответ" успешно заполнено*/
        $(By.xpath("//div[div[text()='Добавление ответа']]//p")).sendKeys("Закрытый ответ 002 Тест АФТ");

        /*1.18	Нажать кнопку "Создать"
        Ответ успешно создан
        Окно ""Добавление ответа"" закрыто."*/
        $(By.xpath("//button[text() = 'Создать ']")).click();

        /*1.19	Нажать кнопку "Добавить ответ…"
        Открыто окно "Добавление ответа"*/
        $(By.xpath("//span[text()='Добавить ответ ...']")).click();

        /*1.20	В поле "Ответ" ввести: Закрытый ответ 003 Тест АФТ
        Поле "Ответ" успешно заполнено*/
        $(By.xpath("//div[div[text()='Добавление ответа']]//p")).sendKeys("Закрытый ответ 003 Тест АФТ");


        /*1.21	Нажать кнопку "Создать"
        Ответ успешно создан.
        Окно ""Добавление ответа"" закрыто."*/
        $(By.xpath("//button[text() = 'Создать ']")).click();

        /*1.22	Нажать кнопку "Добавить ответ…"
        Открыто окно "Добавление ответа"*/
        $(By.xpath("//span[text()='Добавить ответ ...']")).click();

        /*1.23	В поле "Ответ" ввести: Закрытый ответ 004 Тест АФТ
        Поле "Ответ" успешно заполнено*/
        $(By.xpath("//div[div[text()='Добавление ответа']]//p")).sendKeys("Закрытый ответ 004 Тест АФТ");

        /*1.24	Нажать кнопку "Создать"
        Ответ успешно создан.
        Окно ""Добавление ответа"" закрыто."*/
        $(By.xpath("//button[text() = 'Создать ']")).click();

        /*1.25	Нажать кнопку "Добавить ответ…"
        Открыто окно "Добавление ответа"*/
        $(By.xpath("//span[text()='Добавить ответ ...']")).click();

        /*1.26	В поле "Ответ" ввести: Закрытый ответ 005 Тест АФТ
        Поле "Ответ" успешно заполнено*/
        $(By.xpath("//div[div[text()='Добавление ответа']]//p")).sendKeys("Закрытый ответ 005 Тест АФТ");

        /*1.27	Нажать кнопку "Создать"
        Ответ успешно создан.
        Окно ""Добавление ответа"" закрыто."*/
        $(By.xpath("//button[text() = 'Создать ']")).click();

        //$(By.xpath("//button[text() = 'Отмена ']")).click();
        //$(By.xpath("//span[text()='Назад к опросам']")).click();
    }

    @Test
    public void LogoutManage(){
        $(new Selectors.ByText("aft@greenatom.ru")).click();
        $(new Selectors.ByText("Выход")).click();
    }

}
