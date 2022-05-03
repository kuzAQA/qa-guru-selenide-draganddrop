package com.github;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class GithubTest {
    @Test
    @DisplayName("Проверка наличия Junit5 на страницу SoftAssertions")
    void wikisCheckInSelenide() {
        open("https://github.com/");
        $(byName("q")).setValue("selenide").pressEnter();
        $("ul.repo-list li").$(byLinkText("selenide/selenide")).click();
        $("#repository-container-header").shouldHave(text("selenide / selenide"));

        $("#wiki-tab").click();

        $("#wiki-pages-box ul li button").scrollTo().click();
        $("#wiki-pages-box").$(byLinkText("SoftAssertions")).click();
        $("#wiki-wrapper h1").shouldHave(text("SoftAssertions"));

        $("#wiki-body h4 a#user-content-3-using-junit5-extend-test-class")
                .scrollTo()
                .shouldBe(visible)
                .ancestor("h4")
                .shouldHave(text("Junit5"));
    }
}
