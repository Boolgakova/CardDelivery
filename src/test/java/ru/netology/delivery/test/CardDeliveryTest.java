package ru.netology.delivery.test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import ru.netology.delivery.data.DataGenerator;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class CardDeliveryTest {

    @BeforeEach
    public void setForm() {
        Configuration.headless = true;
        open("http://localhost:9999/");
        SelenideElement form = $("form");
    }

    @Test
    void shouldSendFormWithCityListAndOpenCalendar() {
        String myCity = "Абакан";
        $("[data-test-id=city] input").setValue("ка");
        $$(".menu-item__control").filter(exactText(myCity)).forEach(SelenideElement::click);
        $(".icon").click();
        if (DataGenerator.generateDate(7, "M").equals(DataGenerator.generateDate(0, "M"))) {
            ElementsCollection dates = $$(".calendar__day");
            for (SelenideElement element : dates) {
                if (element.getText().equals(DataGenerator.generateDate(7, "d"))) {
                    element.click();
                }
            }
        } else {
            $(By.cssSelector("[data-step=\"1\"]")).click();
            ElementsCollection dates = $$(".calendar__day");
            for (SelenideElement element : dates) {
                if (element.getText().equals(DataGenerator.generateDate(7, "d"))) {
                    element.click();
                }
            }
        }
        $("[data-test-id=name] input").setValue("Иван Иванов");
        $("[data-test-id=phone] input").setValue("+79031234567");
        $("[data-test-id=agreement]").click();
        $(By.className("button")).click();

        $(".notification__content")
                .shouldHave(Condition.text("Встреча успешно забронирована на " + DataGenerator.generateDate(7, "dd.MM.yyyy")), Duration.ofSeconds(15))
                .shouldBe(Condition.visible);
    }

    @Test
    void shouldSendFormPopularCity() {
        $("[data-test-id=city] input").setValue("Москва");
        $("[data-test-id=date] input").doubleClick().sendKeys(DataGenerator.generateDate(3, "dd.MM.yyyy"));
        $("[data-test-id=name] input").setValue("Иван Иванов");
        $("[data-test-id=phone] input").setValue("+79031234567");
        $("[data-test-id=agreement]").click();
        $(By.className("button")).click();

        $(".notification__content")
                .shouldHave(Condition.text("Встреча успешно забронирована на " + DataGenerator.generateDate(3, "dd.MM.yyyy")), Duration.ofSeconds(15))
                .shouldBe(Condition.visible);
    }

    @Test
    void shouldSendFormDoubleCity() {
        $("[data-test-id=city] input").setValue("Нижний Новгород");
        $("[data-test-id=date] input").doubleClick().sendKeys(DataGenerator.generateDate(3, "dd.MM.yyyy"));
        $("[data-test-id=name] input").setValue("Иван Иванов");
        $("[data-test-id=phone] input").setValue("+79031234567");
        $("[data-test-id=agreement]").click();
        $(By.className("button")).click();

        $(".notification__content")
                .shouldHave(Condition.text("Встреча успешно забронирована на " + DataGenerator.generateDate(3, "dd.MM.yyyy")), Duration.ofSeconds(15))
                .shouldBe(Condition.visible);
    }

    @Test
    void shouldSendFormCityWithDash() {
        $("[data-test-id=city] input").setValue("Йошкар-Ола");
        $("[data-test-id=date] input").doubleClick().sendKeys(DataGenerator.generateDate(3, "dd.MM.yyyy"));
        $("[data-test-id=name] input").setValue("Иван Иванов");
        $("[data-test-id=phone] input").setValue("+79031234567");
        $("[data-test-id=agreement]").click();
        $(By.className("button")).click();

        $(".notification__content")
                .shouldHave(Condition.text("Встреча успешно забронирована на " + DataGenerator.generateDate(3, "dd.MM.yyyy")), Duration.ofSeconds(15))
                .shouldBe(Condition.visible);
    }

    @Test
    void shouldSendFormCityWithDoubleDash() {
        $("[data-test-id=city] input").setValue("Ростов-на-Дону");
        $("[data-test-id=date] input").doubleClick().sendKeys(DataGenerator.generateDate(3, "dd.MM.yyyy"));
        $("[data-test-id=name] input").setValue("Иван Иванов");
        $("[data-test-id=phone] input").setValue("+79031234567");
        $("[data-test-id=agreement]").click();
        $(By.className("button")).click();

        $(".notification__content")
                .shouldHave(Condition.text("Встреча успешно забронирована на " + DataGenerator.generateDate(3, "dd.MM.yyyy")), Duration.ofSeconds(15))
                .shouldBe(Condition.visible);
    }

    @Test
    void shouldSendFormCityWithYo() {
        $("[data-test-id=city] input").setValue("Орёл");
        $("[data-test-id=date] input").doubleClick().sendKeys(DataGenerator.generateDate(3, "dd.MM.yyyy"));
        $("[data-test-id=name] input").setValue("Иван Иванов");
        $("[data-test-id=phone] input").setValue("+79031234567");
        $("[data-test-id=agreement]").click();
        $(By.className("button")).click();

        $(".notification__content")
                .shouldHave(Condition.text("Встреча успешно забронирована на " + DataGenerator.generateDate(3, "dd.MM.yyyy")), Duration.ofSeconds(15))
                .shouldBe(Condition.visible);
    }

    @Test
    void shouldSendFormFourDays() {
        $("[data-test-id=city] input").setValue("Москва");
        $("[data-test-id=date] input").doubleClick().sendKeys(DataGenerator.generateDate(4, "dd.MM.yyyy"));
        $("[data-test-id=name] input").setValue("Иван Иванов");
        $("[data-test-id=phone] input").setValue("+79031234567");
        $("[data-test-id=agreement]").click();
        $(By.className("button")).click();

        $(".notification__content")
                .shouldHave(Condition.text("Встреча успешно забронирована на " + DataGenerator.generateDate(4, "dd.MM.yyyy")), Duration.ofSeconds(15))
                .shouldBe(Condition.visible);
    }

    @Test
    void shouldSendFormNextYear() {
        $("[data-test-id=city] input").setValue("Москва");
        $("[data-test-id=date] input").doubleClick().sendKeys(DataGenerator.generateDate(365, "dd.MM.yyyy"));
        $("[data-test-id=name] input").setValue("Иван Иванов");
        $("[data-test-id=phone] input").setValue("+79031234567");
        $("[data-test-id=agreement]").click();
        $(By.className("button")).click();

        $(".notification__content")
                .shouldHave(Condition.text("Встреча успешно забронирована на " + DataGenerator.generateDate(365, "dd.MM.yyyy")), Duration.ofSeconds(15))
                .shouldBe(Condition.visible);
    }

    @Test
    void shouldSendFormDoubleName() {
        $("[data-test-id=city] input").setValue("Москва");
        $("[data-test-id=date] input").doubleClick().sendKeys(DataGenerator.generateDate(3, "dd.MM.yyyy"));
        $("[data-test-id=name] input").setValue("Анна Мария Иванова");
        $("[data-test-id=phone] input").setValue("+79031234567");
        $("[data-test-id=agreement]").click();
        $(By.className("button")).click();

        $(".notification__content")
                .shouldHave(Condition.text("Встреча успешно забронирована на " + DataGenerator.generateDate(3, "dd.MM.yyyy")), Duration.ofSeconds(15))
                .shouldBe(Condition.visible);
    }

    @Test
    void shouldSendFormNameWithDash() {
        $("[data-test-id=city] input").setValue("Москва");
        $("[data-test-id=date] input").doubleClick().sendKeys(DataGenerator.generateDate(3, "dd.MM.yyyy"));
        $("[data-test-id=name] input").setValue("Анна-Мария Иванова");
        $("[data-test-id=phone] input").setValue("+79031234567");
        $("[data-test-id=agreement]").click();
        $(By.className("button")).click();

        $(".notification__content")
                .shouldHave(Condition.text("Встреча успешно забронирована на " + DataGenerator.generateDate(3, "dd.MM.yyyy")), Duration.ofSeconds(15))
                .shouldBe(Condition.visible);
    }

    @Test
    void shouldSendFormNameWithDoubleDash() {
        $("[data-test-id=city] input").setValue("Москва");
        $("[data-test-id=date] input").doubleClick().sendKeys(DataGenerator.generateDate(3, "dd.MM.yyyy"));
        $("[data-test-id=name] input").setValue("Анна-Мария Иванова-Смоленская");
        $("[data-test-id=phone] input").setValue("+79031234567");
        $("[data-test-id=agreement]").click();
        $(By.className("button")).click();

        $(".notification__content")
                .shouldHave(Condition.text("Встреча успешно забронирована на " + DataGenerator.generateDate(3, "dd.MM.yyyy")), Duration.ofSeconds(15))
                .shouldBe(Condition.visible);
    }

    @Test
    void shouldSendFormNameWithYo() {
        $("[data-test-id=city] input").setValue("Москва");
        $("[data-test-id=date] input").doubleClick().sendKeys(DataGenerator.generateDate(3, "dd.MM.yyyy"));
        $("[data-test-id=name] input").setValue("Алёна Иванова");
        $("[data-test-id=phone] input").setValue("+79031234567");
        $("[data-test-id=agreement]").click();
        $(By.className("button")).click();

        $(".notification__content")
                .shouldHave(Condition.text("Встреча успешно забронирована на " + DataGenerator.generateDate(3, "dd.MM.yyyy")), Duration.ofSeconds(15))
                .shouldBe(Condition.visible);
    }

    @Test
    void shouldSendFormShortName() {
        $("[data-test-id=city] input").setValue("Москва");
        $("[data-test-id=date] input").doubleClick().sendKeys(DataGenerator.generateDate(3, "dd.MM.yyyy"));
        $("[data-test-id=name] input").setValue("Ян И");
        $("[data-test-id=phone] input").setValue("+79031234567");
        $("[data-test-id=agreement]").click();
        $(By.className("button")).click();

        $(".notification__content")
                .shouldHave(Condition.text("Встреча успешно забронирована на " + DataGenerator.generateDate(3, "dd.MM.yyyy")), Duration.ofSeconds(15))
                .shouldBe(Condition.visible);
    }

    @Test
    void shouldSendFormLongName() {
        $("[data-test-id=city] input").setValue("Москва");
        $("[data-test-id=date] input").doubleClick().sendKeys(DataGenerator.generateDate(3, "dd.MM.yyyy"));
        $("[data-test-id=name] input").setValue("Абдурахманганджи Христорождественский-Полонский");
        $("[data-test-id=phone] input").setValue("+79031234567");
        $("[data-test-id=agreement]").click();
        $(By.className("button")).click();

        $(".notification__content")
                .shouldHave(Condition.text("Встреча успешно забронирована на " + DataGenerator.generateDate(3, "dd.MM.yyyy")), Duration.ofSeconds(15))
                .shouldBe(Condition.visible);
    }

    @Test
    void shouldSendFormNameWithIch() {
        $("[data-test-id=city] input").setValue("Москва");
        $("[data-test-id=date] input").doubleClick().sendKeys(DataGenerator.generateDate(3, "dd.MM.yyyy"));
        $("[data-test-id=name] input").setValue("Сергей Иванович");
        $("[data-test-id=phone] input").setValue("+79031234567");
        $("[data-test-id=agreement]").click();
        $(By.className("button")).click();

        $(".notification__content")
                .shouldHave(Condition.text("Встреча успешно забронирована на " + DataGenerator.generateDate(3, "dd.MM.yyyy")), Duration.ofSeconds(15))
                .shouldBe(Condition.visible);
    }
}
