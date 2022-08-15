import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class CardDeliveryTest {

    @BeforeEach
    public void setForm() {
        open("http://localhost:9999/");
        SelenideElement form = $("form");
    }

    @Test
    void shouldSendFormPopularData() {
        String date = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        $("[data-test-id=city] input").setValue("Москва");
        $("[data-test-id=date] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=date] input").doubleClick().sendKeys(date);
        $("[data-test-id=name] input").setValue("Иван Иванов");
        $("[data-test-id=phone] input").setValue("+79031234567");
        $("[data-test-id=agreement]").click();
        $(By.className("button")).click();

        $("[data-test-id=notification").shouldBe(visible, Duration.ofSeconds(17));
    }

    @Test
    void shouldSendFormDoubleCity() {
        String date = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        $("[data-test-id=city] input").setValue("Нижний Новгород");
        $("[data-test-id=date] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=date] input").doubleClick().sendKeys(date);
        $("[data-test-id=name] input").setValue("Иван Иванов");
        $("[data-test-id=phone] input").setValue("+79031234567");
        $("[data-test-id=agreement]").click();
        $(By.className("button")).click();

        $("[data-test-id=notification").shouldBe(visible, Duration.ofSeconds(17));
    }

    @Test
    void shouldSendFormCityWithDash() {
        String date = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        $("[data-test-id=city] input").setValue("Йошкар-Ола");
        $("[data-test-id=date] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=date] input").doubleClick().sendKeys(date);
        $("[data-test-id=name] input").setValue("Иван Иванов");
        $("[data-test-id=phone] input").setValue("+79031234567");
        $("[data-test-id=agreement]").click();
        $(By.className("button")).click();

        $("[data-test-id=notification").shouldBe(visible, Duration.ofSeconds(17));
    }

    @Test
    void shouldSendFormCityWithDoubleDash() {
        String date = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        $("[data-test-id=city] input").setValue("Ростов-на-Дону");
        $("[data-test-id=date] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=date] input").doubleClick().sendKeys(date);
        $("[data-test-id=name] input").setValue("Иван Иванов");
        $("[data-test-id=phone] input").setValue("+79031234567");
        $("[data-test-id=agreement]").click();
        $(By.className("button")).click();

        $("[data-test-id=notification").shouldBe(visible, Duration.ofSeconds(17));
    }

    @Test
    void shouldSendFormCityWithYo() {
        String date = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        $("[data-test-id=city] input").setValue("Орёл");
        $("[data-test-id=date] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=date] input").doubleClick().sendKeys(date);
        $("[data-test-id=name] input").setValue("Иван Иванов");
        $("[data-test-id=phone] input").setValue("+79031234567");
        $("[data-test-id=agreement]").click();
        $(By.className("button")).click();

        $("[data-test-id=notification").shouldBe(visible, Duration.ofSeconds(17));
    }

    @Test
    void shouldSendFormFourDays() {
        String date = LocalDate.now().plusDays(4).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        $("[data-test-id=city] input").setValue("Москва");
        $("[data-test-id=date] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=date] input").doubleClick().sendKeys(date);
        $("[data-test-id=name] input").setValue("Иван Иванов");
        $("[data-test-id=phone] input").setValue("+79031234567");
        $("[data-test-id=agreement]").click();
        $(By.className("button")).click();

        $("[data-test-id=notification").shouldBe(visible, Duration.ofSeconds(17));
    }

    @Test
    void shouldSendFormNextMonth() {
        String date = LocalDate.now().plusDays(365).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        $("[data-test-id=city] input").setValue("Москва");
        $("[data-test-id=date] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=date] input").doubleClick().sendKeys(date);
        $("[data-test-id=name] input").setValue("Иван Иванов");
        $("[data-test-id=phone] input").setValue("+79031234567");
        $("[data-test-id=agreement]").click();
        $(By.className("button")).click();

        $("[data-test-id=notification").shouldBe(visible, Duration.ofSeconds(17));
    }

    @Test
    void shouldSendFormDoubleName() {
        String date = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        $("[data-test-id=city] input").setValue("Москва");
        $("[data-test-id=date] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=date] input").doubleClick().sendKeys(date);
        $("[data-test-id=name] input").setValue("Анна Мария Иванова");
        $("[data-test-id=phone] input").setValue("+79031234567");
        $("[data-test-id=agreement]").click();
        $(By.className("button")).click();

        $("[data-test-id=notification").shouldBe(visible, Duration.ofSeconds(17));
    }

    @Test
    void shouldSendFormNameWithDash() {
        String date = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        $("[data-test-id=city] input").setValue("Москва");
        $("[data-test-id=date] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=date] input").doubleClick().sendKeys(date);
        $("[data-test-id=name] input").setValue("Анна-Мария Иванова");
        $("[data-test-id=phone] input").setValue("+79031234567");
        $("[data-test-id=agreement]").click();
        $(By.className("button")).click();

        $("[data-test-id=notification").shouldBe(visible, Duration.ofSeconds(17));
    }

    @Test
    void shouldSendFormNameWithDoubleDash() {
        String date = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        $("[data-test-id=city] input").setValue("Москва");
        $("[data-test-id=date] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=date] input").doubleClick().sendKeys(date);
        $("[data-test-id=name] input").setValue("Анна-Мария Иванова-Смоленская");
        $("[data-test-id=phone] input").setValue("+79031234567");
        $("[data-test-id=agreement]").click();
        $(By.className("button")).click();

        $("[data-test-id=notification").shouldBe(visible, Duration.ofSeconds(17));
    }

    @Test
    void shouldSendFormNameWithYo() {
        String date = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        $("[data-test-id=city] input").setValue("Москва");
        $("[data-test-id=date] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=date] input").doubleClick().sendKeys(date);
        $("[data-test-id=name] input").setValue("Алена Иванова");
        $("[data-test-id=phone] input").setValue("+79031234567");
        $("[data-test-id=agreement]").click();
        $(By.className("button")).click();

        $("[data-test-id=notification").shouldBe(visible, Duration.ofSeconds(17));
    }

    @Test
    void shouldSendFormShortName() {
        String date = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        $("[data-test-id=city] input").setValue("Москва");
        $("[data-test-id=date] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=date] input").doubleClick().sendKeys(date);
        $("[data-test-id=name] input").setValue("Ян И");
        $("[data-test-id=phone] input").setValue("+79031234567");
        $("[data-test-id=agreement]").click();
        $(By.className("button")).click();

        $("[data-test-id=notification").shouldBe(visible, Duration.ofSeconds(17));
    }

    @Test
    void shouldSendFormLongName() {
        String date = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        $("[data-test-id=city] input").setValue("Москва");
        $("[data-test-id=date] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=date] input").doubleClick().sendKeys(date);
        $("[data-test-id=name] input").setValue("Абдурахманганджи Христорождественский-Полонский");
        $("[data-test-id=phone] input").setValue("+79031234567");
        $("[data-test-id=agreement]").click();
        $(By.className("button")).click();

        $("[data-test-id=notification").shouldBe(visible, Duration.ofSeconds(17));
    }

    @Test
    void shouldSendFormNameWithIch() {
        String date = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        $("[data-test-id=city] input").setValue("Москва");
        $("[data-test-id=date] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=date] input").doubleClick().sendKeys(date);
        $("[data-test-id=name] input").setValue("Сергей Иванович");
        $("[data-test-id=phone] input").setValue("+79031234567");
        $("[data-test-id=agreement]").click();
        $(By.className("button")).click();

        $("[data-test-id=notification").shouldBe(visible, Duration.ofSeconds(17));
    }

    @Test
    void shouldNotValidateEarlyDate() {
        String date = LocalDate.now().plusDays(2).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        $("[data-test-id=city] input").setValue("Москва");
        $("[data-test-id=date] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=date] input").doubleClick().sendKeys(date);
        $("[data-test-id=name] input").setValue("Сергей Иванов");
        $("[data-test-id=phone] input").setValue("+79031234567");
        $("[data-test-id=agreement]").click();
        $(By.className("button")).click();

        $x("//*[contains(text(),'невозможен')]").shouldBe(visible);
    }

    @Test
    void shouldNotValidateOrderForToday() {
        String date = LocalDate.now().plusDays(0).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        $("[data-test-id=city] input").setValue("Москва");
        $("[data-test-id=date] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=date] input").doubleClick().sendKeys(date);
        $("[data-test-id=name] input").setValue("Сергей Иванов");
        $("[data-test-id=phone] input").setValue("+79031234567");
        $("[data-test-id=agreement]").click();
        $(By.className("button")).click();

        $x("//*[contains(text(),'невозможен')]").shouldBe(visible);
    }

    @Test
    void shouldNotValidateEmptyDate() {
        String date = LocalDate.now().plusDays(0).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        $("[data-test-id=city] input").setValue("Москва");
        $("[data-test-id=date] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=name] input").setValue("Сергей Иванов");
        $("[data-test-id=phone] input").setValue("+79031234567");
        $("[data-test-id=agreement]").click();
        $(By.className("button")).click();

        $x("//*[contains(text(),'Неверно')]").shouldBe(visible);
    }

    @Test
    void shouldNotValidateCityInLatin() {
        String date = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        $("[data-test-id=city] input").setValue("Moscow");
        $("[data-test-id=date] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=date] input").doubleClick().sendKeys(date);
        $("[data-test-id=name] input").setValue("Сергей Иванов");
        $("[data-test-id=phone] input").setValue("+79031234567");
        $("[data-test-id=agreement]").click();
        $(By.className("button")).click();

        $x("//*[contains(text(),'недоступна')]").shouldBe(visible);
    }

    @Test
    void shouldNotValidateCityInNumbers() {
        String date = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        $("[data-test-id=city] input").setValue("123456");
        $("[data-test-id=date] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=date] input").doubleClick().sendKeys(date);
        $("[data-test-id=name] input").setValue("Сергей Иванов");
        $("[data-test-id=phone] input").setValue("+79031234567");
        $("[data-test-id=agreement]").click();
        $(By.className("button")).click();

        $x("//*[contains(text(),'недоступна')]").shouldBe(visible);
    }

//    @Test
//    void shouldNotValidateCityInSpecCharacters() {
//        String date = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
//        $("[data-test-id=city] input").setValue("!#$%^&*");
//        $("[data-test-id=date] input").doubleClick().sendKeys(Keys.BACK_SPACE);
//        $("[data-test-id=date] input").doubleClick().sendKeys(date);
//        $("[data-test-id=name] input").setValue("Сергей Иванов");
//        $("[data-test-id=phone] input").setValue("+79031234567");
//        $("[data-test-id=agreement]").click();
//        $(By.className("button")).click();
//
//        $x("//*[contains(text(),'недоступна')]").shouldBe(visible);
//    }

//    @Test
//    void shouldNotValidateCityWithNumbersAndSpecCharacters() {
//        String date = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
//        $("[data-test-id=city] input").setValue("12#$34&*");
//        $("[data-test-id=date] input").doubleClick().sendKeys(Keys.BACK_SPACE);
//        $("[data-test-id=date] input").doubleClick().sendKeys(date);
//        $("[data-test-id=name] input").setValue("Сергей Иванов");
//        $("[data-test-id=phone] input").setValue("+79031234567");
//        $("[data-test-id=agreement]").click();
//        $(By.className("button")).click();
//
//        $x("//*[contains(text(),'недоступна')]").shouldBe(visible);
//    }

    @Test
    void shouldNotValidateEmptyCity() {
        String date = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        $("[data-test-id=date] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=date] input").doubleClick().sendKeys(date);
        $("[data-test-id=name] input").setValue("Сергей Иванов");
        $("[data-test-id=phone] input").setValue("+79031234567");
        $("[data-test-id=agreement]").click();
        $(By.className("button")).click();

        $x("//*[contains(text(),'обязательно')]").shouldBe(visible);
    }

    @Test
    void shouldNotValidateEmptyForm() {
        $x("//*[contains(text(), 'Забронировать')]").click();
        $x("//*[contains(text(),'обязательно')]").shouldBe(visible);
    }

    @Test
    void shouldNotValidateEmptyName() {
        String date = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        $("[data-test-id=city] input").setValue("Москва");
        $("[data-test-id=date] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=date] input").doubleClick().sendKeys(date);
        $("[data-test-id=phone] input").setValue("+79031234567");
        $("[data-test-id=agreement]").click();
        $(By.className("button")).click();

        $x("//*[contains(text(),'обязательно')]").shouldBe(visible);
    }

    @Test
    void shouldNotValidateNameInLatin() {
        String date = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        $("[data-test-id=city] input").setValue("Москва");
        $("[data-test-id=date] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=date] input").doubleClick().sendKeys(date);
        $("[data-test-id=name] input").setValue("Ivan Ivanov");
        $("[data-test-id=phone] input").setValue("+79031234567");
        $("[data-test-id=agreement]").click();
        $(By.className("button")).click();

        $x("//*[contains(text(),'неверно')]").shouldBe(visible);
    }

    @Test
    void shouldNotValidateNameInCyrillicAndLatin() {
        String date = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        $("[data-test-id=city] input").setValue("Москва");
        $("[data-test-id=date] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=date] input").doubleClick().sendKeys(date);
        $("[data-test-id=name] input").setValue("Иван Ivanov");
        $("[data-test-id=phone] input").setValue("+79031234567");
        $("[data-test-id=agreement]").click();
        $(By.className("button")).click();

        $x("//*[contains(text(),'неверно')]").shouldBe(visible);
    }

    @Test
    void shouldNotValidateNumbersInName() {
        String date = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        $("[data-test-id=city] input").setValue("Москва");
        $("[data-test-id=date] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=date] input").doubleClick().sendKeys(date);
        $("[data-test-id=name] input").setValue("Иван 123");
        $("[data-test-id=phone] input").setValue("+79031234567");
        $("[data-test-id=agreement]").click();
        $(By.className("button")).click();

        $x("//*[contains(text(),'неверно')]").shouldBe(visible);
    }

    @Test
    void shouldNotValidateNumbersInsteadOfName() {
        String date = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        $("[data-test-id=city] input").setValue("Москва");
        $("[data-test-id=date] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=date] input").doubleClick().sendKeys(date);
        $("[data-test-id=name] input").setValue("1234567");
        $("[data-test-id=phone] input").setValue("+79031234567");
        $("[data-test-id=agreement]").click();
        $(By.className("button")).click();

        $x("//*[contains(text(),'неверно')]").shouldBe(visible);
    }

    @Test
    void shouldNotValidateNameWithSpecCharacters() {
        String date = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        $("[data-test-id=city] input").setValue("Москва");
        $("[data-test-id=date] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=date] input").doubleClick().sendKeys(date);
        $("[data-test-id=name] input").setValue("Иван !№%:,");
        $("[data-test-id=phone] input").setValue("+79031234567");
        $("[data-test-id=agreement]").click();
        $(By.className("button")).click();

        $x("//*[contains(text(),'неверно')]").shouldBe(visible);
    }

    @Test
    void shouldNotValidateSpecCharactersInsteadOfName() {
        String date = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        $("[data-test-id=city] input").setValue("Москва");
        $("[data-test-id=date] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=date] input").doubleClick().sendKeys(date);
        $("[data-test-id=name] input").setValue("!#$%^&*");
        $("[data-test-id=phone] input").setValue("+79031234567");
        $("[data-test-id=agreement]").click();
        $(By.className("button")).click();

        $x("//*[contains(text(),'неверно')]").shouldBe(visible);
    }

    @Test
    void shouldNotValidateSpacesInsteadOfName() {
        String date = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        $("[data-test-id=city] input").setValue("Москва");
        $("[data-test-id=date] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=date] input").doubleClick().sendKeys(date);
        $("[data-test-id=name] input").setValue("             ");
        $("[data-test-id=phone] input").setValue("+79031234567");
        $("[data-test-id=agreement]").click();
        $(By.className("button")).click();

        $x("//*[contains(text(),'обязательно')]").shouldBe(visible);
    }

    @Test
    void shouldNotValidateEmptyPhone() {
        String date = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        $("[data-test-id=city] input").setValue("Москва");
        $("[data-test-id=date] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=date] input").doubleClick().sendKeys(date);
        $("[data-test-id=name] input").setValue("Иван Иванов");
        $("[data-test-id=agreement]").click();
        $(By.className("button")).click();

        $x("//*[contains(text(),'обязательно')]").shouldBe(visible);
    }

    @Test
    void shouldNotValidatePhoneWithoutPlus() {
        String date = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        $("[data-test-id=city] input").setValue("Москва");
        $("[data-test-id=date] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=date] input").doubleClick().sendKeys(date);
        $("[data-test-id=name] input").setValue("Сергей Иванов");
        $("[data-test-id=phone] input").setValue("89031234567");
        $("[data-test-id=agreement]").click();
        $(By.className("button")).click();

        $x("//*[contains(text(),'неверно')]").shouldBe(visible);
    }

    @Test
    void shouldNotValidatePhoneWithLetters() {
        String date = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        $("[data-test-id=city] input").setValue("Москва");
        $("[data-test-id=date] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=date] input").doubleClick().sendKeys(date);
        $("[data-test-id=name] input").setValue("Сергей Иванов");
        $("[data-test-id=phone] input").setValue("Phone number");
        $("[data-test-id=agreement]").click();
        $(By.className("button")).click();

        $x("//*[contains(text(),'неверно')]").shouldBe(visible);
    }

    @Test
    void shouldNotValidateShortPhone() {
        String date = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        $("[data-test-id=city] input").setValue("Москва");
        $("[data-test-id=date] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=date] input").doubleClick().sendKeys(date);
        $("[data-test-id=name] input").setValue("Сергей Иванов");
        $("[data-test-id=phone] input").setValue("+7031234567");
        $("[data-test-id=agreement]").click();
        $(By.className("button")).click();

        $x("//*[contains(text(),'неверно')]").shouldBe(visible);
    }

    @Test
    void shouldNotValidateSpacesInPhone() {
        String date = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        $("[data-test-id=city] input").setValue("Москва");
        $("[data-test-id=date] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=date] input").doubleClick().sendKeys(date);
        $("[data-test-id=name] input").setValue("Сергей Иванов");
        $("[data-test-id=phone] input").setValue("               ");
        $("[data-test-id=agreement]").click();
        $(By.className("button")).click();

        $x("//*[contains(text(),'обязательно')]").shouldBe(visible);
    }

    @Test
    void shouldNotValidateEmptyCheckbox() {
        String date = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        $("[data-test-id=city] input").setValue("Москва");
        $("[data-test-id=date] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=date] input").doubleClick().sendKeys(date);
        $("[data-test-id=name] input").setValue("Сергей Иванов");
        $("[data-test-id=phone] input").setValue("+79031234567");
        $(By.className("button")).click();

        $("[data-test-id=agreement].input_invalid").shouldBe(visible);
    }
}
