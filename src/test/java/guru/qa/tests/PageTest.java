package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import guru.qa.pages.PageForTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class PageTest {

    PageForTest registrationPage = new PageForTest();


    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String gender = "Male";
    String phone = faker.numerify("##########");
    String day = "28";
    String month = "January";
    String year = "2001";
    String subject = "Art";
    String hobby = "Sports";
    String file = "src/test/resources/ExamplePicture.png";
    String address = faker.address().fullAddress();
    String state = "Haryana";
    String city = "Karnal";

    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.startMaximized = true;
    }

    @Test
    void positiveFillTest() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setMobile(phone)
                .setDateOfBirth(day, month, year)
                .setSubjects(subject)
                .setHobbies(hobby)
                .uploadFile(file)
                .setAddress(address)
                .setStateAndCity(state, city)
                .clickSubmitButton();
        // popup assertions
        registrationPage.pageAssert(firstName)
                .pageAssert(lastName)
                .pageAssert(email)
                .pageAssert(phone)
                .pageAssert(address);
    }

}
