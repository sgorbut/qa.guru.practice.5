package guru.qa.pages;

import guru.qa.components.Calendar;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PageForTest {

    private Calendar calendar = new Calendar();

    public PageForTest openPage() {
        open("/automation-practice-form");
        return this;
    }

    public PageForTest setFirstName(String firstName) {
        $("#firstName").setValue(firstName);
        return this;
    }

    public PageForTest setLastName(String lastName) {
        $("#lastName").setValue(lastName);
        return this;
    }

    public PageForTest setEmail(String email) {
        $("#userEmail").setValue(email);
        return this;
    }

    public PageForTest setGender(String gender) {
        $(byText(gender)).click();
        return this;
    }

    public PageForTest setMobile(String phone) {
        $("#userNumber").setValue(phone);
        return this;
    }

    public PageForTest setDateOfBirth(String day, String month, String year) {
        calendar.setDate(day, month, year);
        return this;
    }

    public PageForTest setSubjects(String subject) {
        $("#subjectsInput").setValue(subject).pressEnter();
        return this;
    }

    public PageForTest setHobbies(String hobby) {
        $("#hobbiesWrapper").$(byText(hobby)).click();
        return this;
    }

    public PageForTest uploadFile(String file) {
        $("#uploadPicture").uploadFile(new File(file));
        return this;
    }

    public PageForTest setAddress(String address) {
        $("#currentAddress").setValue(address);
        return this;
    }

    public PageForTest setStateAndCity(String state, String city) {
        $("#react-select-3-input").setValue(state).pressEnter();
        $("#react-select-4-input").setValue(city).pressEnter();
        return this;
    }

    public PageForTest clickSubmitButton() {
        $(byText("Submit")).scrollTo().click();
        return this;
    }

    public PageForTest pageAssert(String fieldForAssert) {
        $(".modal-body").shouldHave(text(fieldForAssert));
        return this;
    }

}
