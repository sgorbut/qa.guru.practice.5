import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Lesson02HomeWork {

    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.startMaximized = true;
    }

    @Test
    void positiveFillTest() {
        open("/automation-practice-form");                             // page url
        $("#firstName").setValue("John");                                     // firstName
        $("#lastName").setValue("Doe");                                       // lastName
        $("#userEmail").setValue("any_email@test.mm");                        // email
        $(byText("Male")).click();                                           // gender
        $("#userNumber").setValue("1234567890");                              // mobile
        $("#dateOfBirthInput").clear();                                       // date of birth
        $(".react-datepicker__month-select").selectOption("January");   // month
        $(".react-datepicker__year-select").selectOption("2000");       // year
        $(".react-datepicker__day--001").click();                             // day
        $("#subjectsInput").setValue("Art").pressEnter();                     // subjects
        $("#hobbiesWrapper").$(byText("Sports")).click();          // hobbies
        $("#uploadPicture").uploadFile(new File("src/test/resources/ExamplePicture.png")); // file
        $("#currentAddress").setValue("currentAddress");                      // address
        $("#react-select-3-input").setValue("Haryana").pressEnter();          // State and City
        $("#react-select-4-input").setValue("Karnal").pressEnter();           // State and City
        $(byText("Submit")).scrollTo().click();                              // scroll and click Submit

        // popup assertions
        $(".modal-body").shouldHave(text("John"));
        $(".modal-body").shouldHave(text("Doe"));
        $(".modal-body").shouldHave(text("Male"));
        $(".modal-body").shouldHave(text("any_email@test.mm"));
        $(".modal-body").shouldHave(text("1234567890"));
        $(".modal-body").shouldHave(text("01 January,2000"));
        $(".modal-body").shouldHave(text("Arts"));
        $(".modal-body").shouldHave(text("Sports"));
        $(".modal-body").shouldHave(text("ExamplePicture.png"));
        $(".modal-body").shouldHave(text("currentAddress"));
        $(".modal-body").shouldHave(text("Haryana"));
        $(".modal-body").shouldHave(text("Karnal"));

        $(".modal-body").shouldHave(text("John"), text("Doe"), text("Male"));
    }
}
