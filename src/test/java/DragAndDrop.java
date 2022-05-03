import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDrop {
    @Test
    @DisplayName("Проверка работы DragAndDrop через метод Selenide")
    void dragAndDropDefaultTest() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));
        $("#column-a").dragAndDropTo("#column-b");
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }

    @Test
    @DisplayName("Проверка работы DragAndDrop через actions")
    /*
    Крч возможно где-то на виртуалке или удалённой машинке actions и работали бы нормально,
    но в локальной он цепляется к координатам физического курсора и срабатывает корректно,
    только если заранее подвести курсор туда, куда хочешь переместить объект.
    Поэтому воткнул sleep(), чтобы подвести курсор перед тестом
     */
    void dragAndDropActionsTest() {
        open("https://the-internet.herokuapp.com/drag_and_drop");

        sleep(5000);
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));
        actions().clickAndHold($("#column-a")).moveToElement($("#column-b")).release().perform();
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }
}
