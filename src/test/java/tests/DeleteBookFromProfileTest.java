package tests;

import api.AuthorizationApi;
import api.BooksApi;
import helpers.WithSession;
import models.LoginResponseModel;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class DeleteBookFromProfileTest extends BaseTest {
    @Test
    @WithSession
    void deleteBookFromProfileTest() {
        LoginResponseModel authResponse = step("Add Authorization Request", () ->
                AuthorizationApi.authResponse()
        );

        step("Delete all books from Profile", () ->
                BooksApi.deleteAllBooks(authResponse.getToken(), authResponse.getUserId())
        );

        step("Add new book to Profile", () ->
                BooksApi.addBooks(authResponse.getToken(), authResponse.getUserId())
        );
        step("Accept cookies", () -> {
            if ($(".fc-consent-root").isDisplayed()) {
                $("button.fc-cta-consent").click();
            }
        });

        step("Open Profile", () ->
                open("/profile")
        );
        step("Accept cookies", () -> {
            if ($(".fc-consent-root").isDisplayed()) {
                $("button.fc-cta-consent").click();
            }
        });
        step("Click trash icon ", () -> {
            executeJavaScript("$('.fc-dialog-container').remove()");
            $("#delete-record-undefined").click();
        });


        step("Agree with the removal of book", () ->
                $("#closeSmallModal-ok").click()
        );

        step("Let's check that book has been deleted", () ->
                $(".rt-noData").shouldBe(visible).shouldHave(text("No rows found"))
        );
    }
}
