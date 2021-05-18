import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.junit.TextReport;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) //тесты запускаются

public class MyGolosAdministratorTest {

    @Rule
    public TextReport report = new TextReport();

    @Before
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }

    @Test
    public void A_LoginManage() {
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
    public void B_SozdanieZakritogoVoprosa() {
      /* *//* 1.2	Нажать кнопку "Создать опрос…"
        Открыто окно "Создать новый опрос" с полем "Введите название для нового опроса"*//*
        $(By.xpath("//button[text()='Создать опрос...']")).click();

       *//* 1.3	В поле "Введите название для нового опроса" ввести: Опрос Тест
        Поле "Введите название для нового опроса" успешно заполнено*//*
        $(By.xpath("//input")).click();
        $(By.xpath("//input")).sendKeys("Опрос Тест");
       *//* 1.4	Нажать кнопку "Создать"
        Опрос успешно создан.
        Открыта страница добавления вопросов в опрос."*//*
        $(By.xpath("//button[text() = 'Создать ']")).click();
        $(".alert").shouldHave(Condition.text("Опрос успешно сохранен"));
        sleep(6000);//ждем 6 секунд пока пропадет алерт

        /*  1.5	Нажать кнопку "Назад к опросам"
        Открыта страница создания опроса*//*
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
        $(By.xpath("//div[label[text()='Заголовок вопроса']]//iframe")).click();
        switchTo().frame($x("//div[label[text()='Заголовок вопроса']]//iframe"));
        $(By.xpath("//*[@id='tinymce']/p")).sendKeys("Закрытый вопрос Тест АФТ");
        switchTo().parentFrame();

        /*1.12	Нажать кнопку "Создать"
        Закрытый вопрос создан.
        Окно ""Добавление вопроса"" закрыто."*/
        $(By.xpath("//button[text() = 'Создать ']")).click();
        $(By.xpath("//a[@title='<p>Закрытый вопрос Тест АФТ</p>']")).click();

        /*1.13	Нажать кнопку "Добавить ответ…"
        Открыто окно "Добавление ответа"*/
        $(By.xpath("//span[text()='Добавить ответ ...']")).click();

        /*1.14	В поле "Ответ" ввести: Закрытый ответ 001 Тест АФТ
        Поле "Ответ" успешно заполнено*/
        $(By.xpath("//div[div[text()='Добавление ответа']]//iframe")).click();
        switchTo().frame($x("//div[div[text()='Добавление ответа']]//iframe"));
        $(By.xpath("//*[@id='tinymce']/p")).sendKeys("Закрытый ответ 001 Тест АФТ");
        switchTo().parentFrame();

        /*1.15	Нажать кнопку "Создать"	"" +
        Ответ успешно создан.
        Окно ""Добавление ответа"" закрыто."*/
        $(By.xpath("//button[text() = 'Создать ']")).click();

        /*1.16	Нажать кнопку "Добавить ответ…"
        Открыто окно "Добавление ответа"*/
        $(By.xpath("//span[text()='Добавить ответ ...']")).click();

        /*1.17	В поле "Ответ" ввести: Закрытый ответ 002 Тест АФТ
        Поле "Ответ" успешно заполнено*/
        $(By.xpath("//div[div[text()='Добавление ответа']]//iframe")).click();
        switchTo().frame($x("//div[div[text()='Добавление ответа']]//iframe"));
        $(By.xpath("//*[@id='tinymce']/p")).sendKeys("Закрытый ответ 002 Тест АФТ");
        switchTo().parentFrame();

        /*1.18	Нажать кнопку "Создать"
        Ответ успешно создан
        Окно ""Добавление ответа"" закрыто."*/
        $(By.xpath("//button[text() = 'Создать ']")).click();

        /*1.19	Нажать кнопку "Добавить ответ…"
        Открыто окно "Добавление ответа"*/
        $(By.xpath("//span[text()='Добавить ответ ...']")).click();

        /*1.20	В поле "Ответ" ввести: Закрытый ответ 003 Тест АФТ
        Поле "Ответ" успешно заполнено*/
        $(By.xpath("//div[div[text()='Добавление ответа']]//iframe")).click();
        switchTo().frame($x("//div[div[text()='Добавление ответа']]//iframe"));
        $(By.xpath("//*[@id='tinymce']/p")).sendKeys("Закрытый ответ 003 Тест АФТ");
        switchTo().parentFrame();

        /*1.21	Нажать кнопку "Создать"
        Ответ успешно создан.
        Окно ""Добавление ответа"" закрыто."*/
        $(By.xpath("//button[text() = 'Создать ']")).click();

        /*1.22	Нажать кнопку "Добавить ответ…"
        Открыто окно "Добавление ответа"*/
        $(By.xpath("//span[text()='Добавить ответ ...']")).click();

        /*1.23	В поле "Ответ" ввести: Закрытый ответ 004 Тест АФТ
        Поле "Ответ" успешно заполнено*/
        $(By.xpath("//div[div[text()='Добавление ответа']]//iframe")).click();
        switchTo().frame($x("//div[div[text()='Добавление ответа']]//iframe"));
        $(By.xpath("//*[@id='tinymce']/p")).sendKeys("Закрытый ответ 004 Тест АФТ");
        switchTo().parentFrame();

        /*1.24	Нажать кнопку "Создать"
        Ответ успешно создан.
        Окно ""Добавление ответа"" закрыто."*/
        $(By.xpath("//button[text() = 'Создать ']")).click();

        /*1.25	Нажать кнопку "Добавить ответ…"
        Открыто окно "Добавление ответа"*/
        $(By.xpath("//span[text()='Добавить ответ ...']")).click();

        /*1.26	В поле "Ответ" ввести: Закрытый ответ 005 Тест АФТ
        Поле "Ответ" успешно заполнено*/
        $(By.xpath("//div[div[text()='Добавление ответа']]//iframe")).click();
        switchTo().frame($x("//div[div[text()='Добавление ответа']]//iframe"));
        $(By.xpath("//*[@id='tinymce']/p")).sendKeys("Закрытый ответ 005 Тест АФТ");
        switchTo().parentFrame();

        /*1.27	Нажать кнопку "Создать"
        Ответ успешно создан.
        Окно ""Добавление ответа"" закрыто."*/
        $(By.xpath("//button[text() = 'Создать ']")).click();


    }

    @Test
    public void C_SozdanieOtkritogoVoprosa() {
        /*2.1	Нажать кнопку "Добавить вопрос…"
        Открыто окно "Добавление вопроса"*/
        $(By.xpath("//div[@title='Добавить вопрос']/span")).click();
        $(By.xpath("//div[text()='Добавление вопроса']")).should(Condition.exist);

        /*2.2	В поле "Заголовок вопроса" ввести: Открытый вопрос Тест АФТ
        Поле "Заголовок вопроса" успешно заполнено*/
        $(By.xpath("//div[label[text()='Заголовок вопроса']]//iframe")).click();
        switchTo().frame($x("//div[label[text()='Заголовок вопроса']]//iframe"));
        $(By.xpath("//*[@id='tinymce']/p")).sendKeys("Открытый вопрос Тест АФТ");
        $(By.xpath("//p[text()='Открытый вопрос Тест АФТ']")).shouldBe(Condition.exist);
        switchTo().parentFrame();

       /* 2.3	В поле "Тип вопроса" из выпадающего списка выбрать: Открытый вопрос
        Поле "Тип вопроса" успешно заполнено значением "Открытый вопрос"*/
        $(By.id("question-type-select")).click();
        $(By.xpath("//option[@value='WORD_CLOUD']")).click();
        $(By.xpath("//option[@value='WORD_CLOUD']")).should(Condition.exist);

       /* 2.4	Нажать кнопку "Создать"
        Открытый вопрос создан.
        Окно ""Добавление вопроса"" закрыто."*/
        $(By.xpath("//button[text() = 'Создать ']")).click();
        $(By.xpath("//p[text()='Открытый вопрос Тест АФТ']")).should(Condition.exist);
    }
    @Test
    public void D_DobavlenieTimeraKOprosu(){
        /*9.1	В настройках опроса установить чекбокс "Добавить таймер для каждого вопроса"
        1. Чекбокс успешно установлен.
        2. Открыто поле ""мм:сс""."*/
        $(By.xpath("//div[text()=' Добавить таймер для каждого вопроса ']/input")).click();
        $(By.xpath("//div[text()=' Добавить таймер для каждого вопроса ']/input[@placeholder='мм:сс']")).should(Condition.exist);
        /*9.2	В поле "мм:сс" ввести: 05:00	Поле "мм:сс"
        Успешно заполнено*/
        $(By.xpath("//div[text()=' Добавить таймер для каждого вопроса ']/input[@placeholder='мм:сс']")).sendKeys("0500");
        $(By.xpath("//div[text()=' Добавить таймер для каждого вопроса ']/input[@placeholder='мм:сс']")).should(Condition.exist);

        /*9.3	Нажать на созданный ранее вопрос "Закрытый вопрос Тест АФТ"
        Открыты настройки созданного вопроса*/
        $(By.xpath("//a[@title='<p>Закрытый вопрос Тест АФТ</p>']")).click();
        $(By.xpath("//div[text()=' Вопрос 1 (Закрытый) ']")).should(Condition.exist);

        /*9.4	Снять чекбокс "Добавить таймер - Да" в настройках вопроса
        Чекбокс успешно удален, таймер удален для выбранного вопроса*/
        $(By.xpath("//div[div[text()='Добавить таймер:']]//input")).click();
        $(By.xpath("//div[div[text()='Добавить таймер:']]//div/input[@placeholder='мм:сс']")).shouldNot(Condition.exist);

       /* 9.5	Нажать на созданный ранее вопрос "Открытый вопрос Тест АФТ"
        Открыты настройки созданного вопроса*/
        $(By.xpath("//a[@title='<p>Открытый вопрос Тест АФТ</p>']//span[text()='2']")).click();
        $(By.xpath("//div[text()=' Вопрос 2 (Открытый) ']")).should(Condition.exist);

        /*9.6	Снять чекбокс "Добавить таймер - Да" в настройках вопроса
        Чекбокс успешно удален, таймер удален для выбранного вопроса*/
        $(By.xpath("//div[div[text()='Добавить таймер:']]//input")).click();
        $(By.xpath("//div[div[text()='Добавить таймер:']]//div/input[@placeholder='мм:сс']")).shouldNot(Condition.exist);
    }

    @Test
    public void E_ZapuskOprosa() {
        //11.1	Нажать кнопку "Сохранить опрос"	Появляется сообщение "Опрос успешно сохранен"
        $(By.xpath("//button[text()=' Сохранить опрос ']")).click();
        sleep(6000);//ждем 6 секунд пока пропадет алерт

        //11.2	Нажать кнопку "Назад к опросам"	Открыта страница создания опроса
        $(By.xpath("//span[text()='Назад к опросам']")).click();
        $(By.xpath("//tr[@class='ng-star-inserted']")).should(Condition.exist);

        //11.3	Сохранить код опроса, указанный под названием созданного опроса	Код опроса успешно сохранен
        String key = $(By.xpath("//tr[@class='ng-star-inserted']/td/div//span")).text();
        key = key.substring(12);
        $(By.xpath("//button[text()='Создать опрос...']")).click();
        $(By.xpath("//input")).click();
        $(By.xpath("//input")).sendKeys(key);
        //11.4	Нажать кнопку "Запустить"	Опрос успешно запущен

   }

    @Test
    public void F_LogoutManage() {
       //$(new Selectors.ByText("aft@greenatom.ru")).click();
       //$(new Selectors.ByText("Выход")).click();
    }

}
